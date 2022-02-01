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
    AppMethodBeat.i(2737);
    int i = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
    if (i != 0) {}
    for (sCursorWindowSize = Resources.getSystem().getInteger(i) * 1024;; sCursorWindowSize = 2097152)
    {
      CREATOR = new Parcelable.Creator()
      {
        public final CursorWindow createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(2702);
          paramAnonymousParcel = new CursorWindow(paramAnonymousParcel, null);
          AppMethodBeat.o(2702);
          return paramAnonymousParcel;
        }
        
        public final CursorWindow[] newArray(int paramAnonymousInt)
        {
          return new CursorWindow[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(2737);
      return;
    }
  }
  
  private CursorWindow(Parcel paramParcel)
  {
    AppMethodBeat.i(2706);
    paramParcel = new UnsupportedOperationException();
    AppMethodBeat.o(2706);
    throw paramParcel;
  }
  
  public CursorWindow(String paramString)
  {
    AppMethodBeat.i(2705);
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
      AppMethodBeat.o(2705);
      throw paramString;
      paramString = "<unnamed>";
    }
    AppMethodBeat.o(2705);
  }
  
  @Deprecated
  public CursorWindow(boolean paramBoolean)
  {
    this(null);
  }
  
  private void dispose()
  {
    AppMethodBeat.i(2708);
    if (this.mWindowPtr != 0L)
    {
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0L;
    }
    AppMethodBeat.o(2708);
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
    AppMethodBeat.i(2733);
    paramParcel = (CursorWindow)CREATOR.createFromParcel(paramParcel);
    AppMethodBeat.o(2733);
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
    AppMethodBeat.i(2712);
    acquireReference();
    try
    {
      boolean bool = nativeAllocRow(this.mWindowPtr);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2712);
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(2709);
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
      AppMethodBeat.o(2709);
    }
  }
  
  public void copyStringToBuffer(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(2722);
    if (paramCharArrayBuffer == null)
    {
      paramCharArrayBuffer = new IllegalArgumentException("CharArrayBuffer should not be null");
      AppMethodBeat.o(2722);
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
      AppMethodBeat.o(2722);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(2707);
    try
    {
      dispose();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(2707);
    }
  }
  
  public void freeLastRow()
  {
    AppMethodBeat.i(2713);
    acquireReference();
    try
    {
      nativeFreeLastRow(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2713);
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2720);
    acquireReference();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2720);
    }
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2724);
    acquireReference();
    try
    {
      double d = nativeGetDouble(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return d;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2724);
    }
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2727);
    float f = (float)getDouble(paramInt1, paramInt2);
    AppMethodBeat.o(2727);
    return f;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2726);
    paramInt1 = (int)getLong(paramInt1, paramInt2);
    AppMethodBeat.o(2726);
    return paramInt1;
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2723);
    acquireReference();
    try
    {
      long l = nativeGetLong(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return l;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2723);
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getNumRows()
  {
    AppMethodBeat.i(2710);
    acquireReference();
    try
    {
      int i = nativeGetNumRows(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2710);
    }
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2725);
    short s = (short)(int)getLong(paramInt1, paramInt2);
    AppMethodBeat.o(2725);
    return s;
  }
  
  public int getStartPosition()
  {
    return this.mStartPos;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2721);
    acquireReference();
    try
    {
      String str = nativeGetString(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return str;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2721);
    }
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2719);
    acquireReference();
    try
    {
      paramInt1 = nativeGetType(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return paramInt1;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2719);
    }
  }
  
  @Deprecated
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2715);
    paramInt1 = getType(paramInt1, paramInt2);
    if ((paramInt1 == 4) || (paramInt1 == 0))
    {
      AppMethodBeat.o(2715);
      return true;
    }
    AppMethodBeat.o(2715);
    return false;
  }
  
  @Deprecated
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2717);
    if (getType(paramInt1, paramInt2) == 2)
    {
      AppMethodBeat.o(2717);
      return true;
    }
    AppMethodBeat.o(2717);
    return false;
  }
  
  @Deprecated
  public boolean isLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2716);
    if (getType(paramInt1, paramInt2) == 1)
    {
      AppMethodBeat.o(2716);
      return true;
    }
    AppMethodBeat.o(2716);
    return false;
  }
  
  @Deprecated
  public boolean isNull(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2714);
    if (getType(paramInt1, paramInt2) == 0)
    {
      AppMethodBeat.o(2714);
      return true;
    }
    AppMethodBeat.o(2714);
    return false;
  }
  
  @Deprecated
  public boolean isString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2718);
    paramInt1 = getType(paramInt1, paramInt2);
    if ((paramInt1 == 3) || (paramInt1 == 0))
    {
      AppMethodBeat.o(2718);
      return true;
    }
    AppMethodBeat.o(2718);
    return false;
  }
  
  public void onAllReferencesReleased()
  {
    AppMethodBeat.i(2735);
    dispose();
    AppMethodBeat.o(2735);
  }
  
  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2728);
    acquireReference();
    try
    {
      boolean bool = nativePutBlob(this.mWindowPtr, paramArrayOfByte, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2728);
    }
  }
  
  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2731);
    acquireReference();
    try
    {
      boolean bool = nativePutDouble(this.mWindowPtr, paramDouble, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2731);
    }
  }
  
  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2730);
    acquireReference();
    try
    {
      boolean bool = nativePutLong(this.mWindowPtr, paramLong, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2730);
    }
  }
  
  public boolean putNull(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2732);
    acquireReference();
    try
    {
      boolean bool = nativePutNull(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2732);
    }
  }
  
  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2729);
    acquireReference();
    try
    {
      boolean bool = nativePutString(this.mWindowPtr, paramString, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2729);
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    AppMethodBeat.i(2711);
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2711);
    }
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(2736);
    String str = getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    AppMethodBeat.o(2736);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(2734);
    paramParcel = new UnsupportedOperationException();
    AppMethodBeat.o(2734);
    throw paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow
 * JD-Core Version:    0.7.0.1
 */