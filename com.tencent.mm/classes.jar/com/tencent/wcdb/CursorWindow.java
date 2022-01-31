package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteClosable;

public class CursorWindow
  extends SQLiteClosable
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR;
  private static final String STATS_TAG = "WCDB.CursorWindowStats";
  private static int sCursorWindowSize;
  private final String mName;
  private int mStartPos;
  public long mWindowPtr;
  
  static
  {
    AppMethodBeat.i(12056);
    int i = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
    if (i != 0) {}
    for (sCursorWindowSize = Resources.getSystem().getInteger(i) * 1024;; sCursorWindowSize = 2097152)
    {
      CREATOR = new Parcelable.Creator()
      {
        public final CursorWindow createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(12021);
          paramAnonymousParcel = new CursorWindow(paramAnonymousParcel, null);
          AppMethodBeat.o(12021);
          return paramAnonymousParcel;
        }
        
        public final CursorWindow[] newArray(int paramAnonymousInt)
        {
          return new CursorWindow[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(12056);
      return;
    }
  }
  
  private CursorWindow(Parcel paramParcel)
  {
    AppMethodBeat.i(12025);
    paramParcel = new UnsupportedOperationException();
    AppMethodBeat.o(12025);
    throw paramParcel;
  }
  
  public CursorWindow(String paramString)
  {
    AppMethodBeat.i(12024);
    this.mStartPos = 0;
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (;;)
    {
      this.mName = paramString;
      this.mWindowPtr = nativeCreate(this.mName, sCursorWindowSize);
      if (this.mWindowPtr != 0L) {
        break;
      }
      paramString = new CursorWindowAllocationException("Cursor window allocation of " + sCursorWindowSize / 1024 + " kb failed. ");
      AppMethodBeat.o(12024);
      throw paramString;
      paramString = "<unnamed>";
    }
    AppMethodBeat.o(12024);
  }
  
  @Deprecated
  public CursorWindow(boolean paramBoolean)
  {
    this(null);
  }
  
  private void dispose()
  {
    AppMethodBeat.i(12027);
    if (this.mWindowPtr != 0L)
    {
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0L;
    }
    AppMethodBeat.o(12027);
  }
  
  private static native boolean nativeAllocRow(long paramLong);
  
  private static native void nativeClear(long paramLong);
  
  private static native void nativeCopyStringToBuffer(long paramLong, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer);
  
  private static native long nativeCreate(String paramString, int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeFreeLastRow(long paramLong);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt1, int paramInt2);
  
  private static native double nativeGetDouble(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nativeGetLong(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetNumRows(long paramLong);
  
  private static native String nativeGetString(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetType(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutBlob(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native boolean nativePutDouble(long paramLong, double paramDouble, int paramInt1, int paramInt2);
  
  private static native boolean nativePutLong(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native boolean nativePutNull(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutString(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  public static CursorWindow newFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12052);
    paramParcel = (CursorWindow)CREATOR.createFromParcel(paramParcel);
    AppMethodBeat.o(12052);
    return paramParcel;
  }
  
  public static int windowSize(int paramInt)
  {
    int i = sCursorWindowSize;
    if (paramInt > 0) {
      sCursorWindowSize = paramInt;
    }
    return i;
  }
  
  public boolean allocRow()
  {
    AppMethodBeat.i(12031);
    acquireReference();
    try
    {
      boolean bool = nativeAllocRow(this.mWindowPtr);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12031);
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(12028);
    acquireReference();
    try
    {
      this.mStartPos = 0;
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12028);
    }
  }
  
  public void copyStringToBuffer(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(12041);
    if (paramCharArrayBuffer == null)
    {
      paramCharArrayBuffer = new IllegalArgumentException("CharArrayBuffer should not be null");
      AppMethodBeat.o(12041);
      throw paramCharArrayBuffer;
    }
    acquireReference();
    try
    {
      nativeCopyStringToBuffer(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2, paramCharArrayBuffer);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12041);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(12026);
    try
    {
      dispose();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(12026);
    }
  }
  
  public void freeLastRow()
  {
    AppMethodBeat.i(12032);
    acquireReference();
    try
    {
      nativeFreeLastRow(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12032);
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12039);
    acquireReference();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12039);
    }
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12043);
    acquireReference();
    try
    {
      double d = nativeGetDouble(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return d;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12043);
    }
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12046);
    float f = (float)getDouble(paramInt1, paramInt2);
    AppMethodBeat.o(12046);
    return f;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12045);
    paramInt1 = (int)getLong(paramInt1, paramInt2);
    AppMethodBeat.o(12045);
    return paramInt1;
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12042);
    acquireReference();
    try
    {
      long l = nativeGetLong(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return l;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12042);
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getNumRows()
  {
    AppMethodBeat.i(12029);
    acquireReference();
    try
    {
      int i = nativeGetNumRows(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12029);
    }
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12044);
    short s = (short)(int)getLong(paramInt1, paramInt2);
    AppMethodBeat.o(12044);
    return s;
  }
  
  public int getStartPosition()
  {
    return this.mStartPos;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12040);
    acquireReference();
    try
    {
      String str = nativeGetString(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return str;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12040);
    }
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12038);
    acquireReference();
    try
    {
      paramInt1 = nativeGetType(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return paramInt1;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12038);
    }
  }
  
  @Deprecated
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12034);
    paramInt1 = getType(paramInt1, paramInt2);
    if ((paramInt1 == 4) || (paramInt1 == 0))
    {
      AppMethodBeat.o(12034);
      return true;
    }
    AppMethodBeat.o(12034);
    return false;
  }
  
  @Deprecated
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12036);
    if (getType(paramInt1, paramInt2) == 2)
    {
      AppMethodBeat.o(12036);
      return true;
    }
    AppMethodBeat.o(12036);
    return false;
  }
  
  @Deprecated
  public boolean isLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12035);
    if (getType(paramInt1, paramInt2) == 1)
    {
      AppMethodBeat.o(12035);
      return true;
    }
    AppMethodBeat.o(12035);
    return false;
  }
  
  @Deprecated
  public boolean isNull(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12033);
    if (getType(paramInt1, paramInt2) == 0)
    {
      AppMethodBeat.o(12033);
      return true;
    }
    AppMethodBeat.o(12033);
    return false;
  }
  
  @Deprecated
  public boolean isString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12037);
    paramInt1 = getType(paramInt1, paramInt2);
    if ((paramInt1 == 3) || (paramInt1 == 0))
    {
      AppMethodBeat.o(12037);
      return true;
    }
    AppMethodBeat.o(12037);
    return false;
  }
  
  public void onAllReferencesReleased()
  {
    AppMethodBeat.i(12054);
    dispose();
    AppMethodBeat.o(12054);
  }
  
  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12047);
    acquireReference();
    try
    {
      boolean bool = nativePutBlob(this.mWindowPtr, paramArrayOfByte, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12047);
    }
  }
  
  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12050);
    acquireReference();
    try
    {
      boolean bool = nativePutDouble(this.mWindowPtr, paramDouble, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12050);
    }
  }
  
  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12049);
    acquireReference();
    try
    {
      boolean bool = nativePutLong(this.mWindowPtr, paramLong, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12049);
    }
  }
  
  public boolean putNull(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12051);
    acquireReference();
    try
    {
      boolean bool = nativePutNull(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12051);
    }
  }
  
  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12048);
    acquireReference();
    try
    {
      boolean bool = nativePutString(this.mWindowPtr, paramString, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12048);
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    AppMethodBeat.i(12030);
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12030);
    }
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(12055);
    String str = getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    AppMethodBeat.o(12055);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12053);
    paramParcel = new UnsupportedOperationException();
    AppMethodBeat.o(12053);
    throw paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow
 * JD-Core Version:    0.7.0.1
 */