package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RepairKit
  implements CancellationSignal.OnCancelListener
{
  public static final int FLAG_ALL_TABLES = 2;
  public static final int FLAG_NO_CREATE_TABLES = 1;
  private static final int INTEGRITY_DATA = 2;
  private static final int INTEGRITY_HEADER = 1;
  private static final int INTEGRITY_KDF_SALT = 4;
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_IGNORE = 2;
  public static final int RESULT_OK = 0;
  private Callback mCallback;
  private RepairCursor mCurrentCursor;
  private int mIntegrityFlags;
  private MasterInfo mMasterInfo;
  private long mNativePtr;
  
  public RepairKit(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, MasterInfo paramMasterInfo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (paramMasterInfo == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = paramMasterInfo.mKDFSalt)
    {
      this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramSQLiteCipherSpec, arrayOfByte);
      if (this.mNativePtr != 0L) {
        break;
      }
      throw new SQLiteException("Failed initialize RepairKit.");
    }
    this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
    this.mMasterInfo = paramMasterInfo;
  }
  
  public static String lastError()
  {
    return nativeLastError();
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFini(long paramLong);
  
  private static native void nativeFreeMaster(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte1, SQLiteCipherSpec paramSQLiteCipherSpec, byte[] paramArrayOfByte2);
  
  private static native int nativeIntegrityFlags(long paramLong);
  
  private static native String nativeLastError();
  
  private static native long nativeLoadMaster(String paramString, byte[] paramArrayOfByte1, String[] paramArrayOfString, byte[] paramArrayOfByte2);
  
  private static native long nativeMakeMaster(String[] paramArrayOfString);
  
  private native int nativeOutput(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  private static native boolean nativeSaveMaster(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private int onProgress(String paramString, int paramInt, long paramLong)
  {
    if (this.mCallback == null) {
      return 0;
    }
    if (this.mCurrentCursor == null) {
      this.mCurrentCursor = new RepairCursor(null);
    }
    this.mCurrentCursor.mPtr = paramLong;
    return this.mCallback.onProgress(paramString, paramInt, this.mCurrentCursor);
  }
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public Callback getCallback()
  {
    return this.mCallback;
  }
  
  public boolean isDataCorrupted()
  {
    return (this.mIntegrityFlags & 0x2) == 0;
  }
  
  public boolean isHeaderCorrupted()
  {
    return (this.mIntegrityFlags & 0x1) == 0;
  }
  
  public boolean isSaltCorrupted()
  {
    return (this.mIntegrityFlags & 0x4) == 0;
  }
  
  public void onCancel()
  {
    if (this.mNativePtr == 0L) {
      return;
    }
    nativeCancel(this.mNativePtr);
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    long l1 = 0L;
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException();
    }
    if (this.mMasterInfo == null) {}
    for (;;)
    {
      long l2 = paramSQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
      paramInt = nativeOutput(this.mNativePtr, l2, l1, paramInt);
      paramSQLiteDatabase.releaseNativeConnection(l2, null);
      this.mCurrentCursor = null;
      this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
      return paramInt;
      l1 = this.mMasterInfo.mMasterPtr;
    }
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal.isCanceled()) {
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    paramInt = output(paramSQLiteDatabase, paramInt);
    paramCancellationSignal.setOnCancelListener(null);
    return paramInt;
  }
  
  public void release()
  {
    if (this.mMasterInfo != null)
    {
      this.mMasterInfo.release();
      this.mMasterInfo = null;
    }
    if (this.mNativePtr != 0L)
    {
      nativeFini(this.mNativePtr);
      this.mNativePtr = 0L;
    }
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public static abstract interface Callback
  {
    public abstract int onProgress(String paramString, int paramInt, Cursor paramCursor);
  }
  
  public static class MasterInfo
  {
    private byte[] mKDFSalt;
    private long mMasterPtr;
    
    private MasterInfo(long paramLong, byte[] paramArrayOfByte)
    {
      this.mMasterPtr = paramLong;
      this.mKDFSalt = paramArrayOfByte;
    }
    
    public static MasterInfo load(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString)
    {
      if (paramString == null) {
        return make(paramArrayOfString);
      }
      byte[] arrayOfByte = new byte[16];
      long l = RepairKit.nativeLoadMaster(paramString, paramArrayOfByte, paramArrayOfString, arrayOfByte);
      if (l == 0L) {
        throw new SQLiteException("Cannot create MasterInfo.");
      }
      return new MasterInfo(l, arrayOfByte);
    }
    
    public static MasterInfo make(String[] paramArrayOfString)
    {
      long l = RepairKit.nativeMakeMaster(paramArrayOfString);
      if (l == 0L) {
        throw new SQLiteException("Cannot create MasterInfo.");
      }
      return new MasterInfo(l, null);
    }
    
    public static boolean save(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
    {
      long l = paramSQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
      boolean bool = RepairKit.nativeSaveMaster(l, paramString, paramArrayOfByte);
      paramSQLiteDatabase.releaseNativeConnection(l, null);
      return bool;
    }
    
    protected void finalize()
    {
      release();
      super.finalize();
    }
    
    public void release()
    {
      if (this.mMasterPtr == 0L) {
        return;
      }
      RepairKit.nativeFreeMaster(this.mMasterPtr);
      this.mMasterPtr = 0L;
    }
  }
  
  private static class RepairCursor
    extends AbstractCursor
  {
    long mPtr;
    
    private static native byte[] nativeGetBlob(long paramLong, int paramInt);
    
    private static native int nativeGetColumnCount(long paramLong);
    
    private static native double nativeGetDouble(long paramLong, int paramInt);
    
    private static native long nativeGetLong(long paramLong, int paramInt);
    
    private static native String nativeGetString(long paramLong, int paramInt);
    
    private static native int nativeGetType(long paramLong, int paramInt);
    
    public byte[] getBlob(int paramInt)
    {
      return nativeGetBlob(this.mPtr, paramInt);
    }
    
    public int getColumnCount()
    {
      return nativeGetColumnCount(this.mPtr);
    }
    
    public String[] getColumnNames()
    {
      throw new UnsupportedOperationException();
    }
    
    public int getCount()
    {
      throw new UnsupportedOperationException();
    }
    
    public double getDouble(int paramInt)
    {
      return nativeGetDouble(this.mPtr, paramInt);
    }
    
    public float getFloat(int paramInt)
    {
      return (float)getDouble(paramInt);
    }
    
    public int getInt(int paramInt)
    {
      return (int)getLong(paramInt);
    }
    
    public long getLong(int paramInt)
    {
      return nativeGetLong(this.mPtr, paramInt);
    }
    
    public short getShort(int paramInt)
    {
      return (short)(int)getLong(paramInt);
    }
    
    public String getString(int paramInt)
    {
      return nativeGetString(this.mPtr, paramInt);
    }
    
    public int getType(int paramInt)
    {
      return nativeGetType(this.mPtr, paramInt);
    }
    
    public boolean isNull(int paramInt)
    {
      return getType(paramInt) == 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit
 * JD-Core Version:    0.7.0.1
 */