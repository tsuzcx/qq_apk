package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static final int FLAG_CHECK_TABLE_COLUMNS = 4;
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
    AppMethodBeat.i(3363);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(3363);
      throw paramString;
    }
    if (paramMasterInfo == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = paramMasterInfo.mKDFSalt)
    {
      this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramSQLiteCipherSpec, arrayOfByte);
      if (this.mNativePtr != 0L) {
        break;
      }
      paramString = new SQLiteException("Failed initialize RepairKit.");
      AppMethodBeat.o(3363);
      throw paramString;
    }
    this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
    this.mMasterInfo = paramMasterInfo;
    AppMethodBeat.o(3363);
  }
  
  public static String lastError()
  {
    AppMethodBeat.i(3369);
    String str = nativeLastError();
    AppMethodBeat.o(3369);
    return str;
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
    AppMethodBeat.i(3368);
    if (this.mCallback == null)
    {
      AppMethodBeat.o(3368);
      return 0;
    }
    if (this.mCurrentCursor == null) {
      this.mCurrentCursor = new RepairCursor(null);
    }
    this.mCurrentCursor.mPtr = paramLong;
    paramInt = this.mCallback.onProgress(paramString, paramInt, this.mCurrentCursor);
    AppMethodBeat.o(3368);
    return paramInt;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(3370);
    release();
    super.finalize();
    AppMethodBeat.o(3370);
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
    AppMethodBeat.i(3367);
    if (this.mNativePtr == 0L)
    {
      AppMethodBeat.o(3367);
      return;
    }
    nativeCancel(this.mNativePtr);
    AppMethodBeat.o(3367);
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(3365);
    if (this.mNativePtr == 0L)
    {
      paramSQLiteDatabase = new IllegalArgumentException();
      AppMethodBeat.o(3365);
      throw paramSQLiteDatabase;
    }
    if (this.mMasterInfo == null) {}
    for (;;)
    {
      long l2 = paramSQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
      paramInt = nativeOutput(this.mNativePtr, l2, l1, paramInt);
      paramSQLiteDatabase.releaseNativeConnection(l2, null);
      this.mCurrentCursor = null;
      this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
      AppMethodBeat.o(3365);
      return paramInt;
      l1 = this.mMasterInfo.mMasterPtr;
    }
  }
  
  public int output(SQLiteDatabase paramSQLiteDatabase, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3366);
    if (paramCancellationSignal.isCanceled())
    {
      AppMethodBeat.o(3366);
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    paramInt = output(paramSQLiteDatabase, paramInt);
    paramCancellationSignal.setOnCancelListener(null);
    AppMethodBeat.o(3366);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(3364);
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
    AppMethodBeat.o(3364);
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
      AppMethodBeat.i(3347);
      if (paramString == null)
      {
        paramString = make(paramArrayOfString);
        AppMethodBeat.o(3347);
        return paramString;
      }
      byte[] arrayOfByte = new byte[16];
      long l = RepairKit.access$400(paramString, paramArrayOfByte, paramArrayOfString, arrayOfByte);
      if (l == 0L)
      {
        paramString = new SQLiteException("Cannot create MasterInfo.");
        AppMethodBeat.o(3347);
        throw paramString;
      }
      paramString = new MasterInfo(l, arrayOfByte);
      AppMethodBeat.o(3347);
      return paramString;
    }
    
    public static MasterInfo make(String[] paramArrayOfString)
    {
      AppMethodBeat.i(3346);
      long l = RepairKit.access$300(paramArrayOfString);
      if (l == 0L)
      {
        paramArrayOfString = new SQLiteException("Cannot create MasterInfo.");
        AppMethodBeat.o(3346);
        throw paramArrayOfString;
      }
      paramArrayOfString = new MasterInfo(l, null);
      AppMethodBeat.o(3346);
      return paramArrayOfString;
    }
    
    public static boolean save(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(3348);
      long l = paramSQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
      boolean bool = RepairKit.access$500(l, paramString, paramArrayOfByte);
      paramSQLiteDatabase.releaseNativeConnection(l, null);
      AppMethodBeat.o(3348);
      return bool;
    }
    
    protected void finalize()
    {
      AppMethodBeat.i(3350);
      release();
      super.finalize();
      AppMethodBeat.o(3350);
    }
    
    public void release()
    {
      AppMethodBeat.i(3349);
      if (this.mMasterPtr == 0L)
      {
        AppMethodBeat.o(3349);
        return;
      }
      RepairKit.access$600(this.mMasterPtr);
      this.mMasterPtr = 0L;
      AppMethodBeat.o(3349);
    }
  }
  
  static class RepairCursor
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
      AppMethodBeat.i(3361);
      byte[] arrayOfByte = nativeGetBlob(this.mPtr, paramInt);
      AppMethodBeat.o(3361);
      return arrayOfByte;
    }
    
    public int getColumnCount()
    {
      AppMethodBeat.i(3353);
      int i = nativeGetColumnCount(this.mPtr);
      AppMethodBeat.o(3353);
      return i;
    }
    
    public String[] getColumnNames()
    {
      AppMethodBeat.i(3352);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(3352);
      throw localUnsupportedOperationException;
    }
    
    public int getCount()
    {
      AppMethodBeat.i(3351);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(3351);
      throw localUnsupportedOperationException;
    }
    
    public double getDouble(int paramInt)
    {
      AppMethodBeat.i(3360);
      double d = nativeGetDouble(this.mPtr, paramInt);
      AppMethodBeat.o(3360);
      return d;
    }
    
    public float getFloat(int paramInt)
    {
      AppMethodBeat.i(3359);
      float f = (float)getDouble(paramInt);
      AppMethodBeat.o(3359);
      return f;
    }
    
    public int getInt(int paramInt)
    {
      AppMethodBeat.i(3357);
      paramInt = (int)getLong(paramInt);
      AppMethodBeat.o(3357);
      return paramInt;
    }
    
    public long getLong(int paramInt)
    {
      AppMethodBeat.i(3358);
      long l = nativeGetLong(this.mPtr, paramInt);
      AppMethodBeat.o(3358);
      return l;
    }
    
    public short getShort(int paramInt)
    {
      AppMethodBeat.i(3356);
      short s = (short)(int)getLong(paramInt);
      AppMethodBeat.o(3356);
      return s;
    }
    
    public String getString(int paramInt)
    {
      AppMethodBeat.i(3355);
      String str = nativeGetString(this.mPtr, paramInt);
      AppMethodBeat.o(3355);
      return str;
    }
    
    public int getType(int paramInt)
    {
      AppMethodBeat.i(3354);
      paramInt = nativeGetType(this.mPtr, paramInt);
      AppMethodBeat.o(3354);
      return paramInt;
    }
    
    public boolean isNull(int paramInt)
    {
      AppMethodBeat.i(3362);
      if (getType(paramInt) == 0)
      {
        AppMethodBeat.o(3362);
        return true;
      }
      AppMethodBeat.o(3362);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit
 * JD-Core Version:    0.7.0.1
 */