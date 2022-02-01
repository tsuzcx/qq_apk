package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow
  extends SQLiteClosable
{
  public static final long CHUNK_NOT_FOUND = -1L;
  private int mNumColumns;
  long mWindowPtr;
  
  public ChunkedCursorWindow(int paramInt)
  {
    AppMethodBeat.i(2892);
    this.mNumColumns = 0;
    this.mWindowPtr = nativeCreate(paramInt);
    if (this.mWindowPtr == 0L)
    {
      CursorWindowAllocationException localCursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation failed.");
      AppMethodBeat.o(2892);
      throw localCursorWindowAllocationException;
    }
    AppMethodBeat.o(2892);
  }
  
  private void dispose()
  {
    AppMethodBeat.i(2893);
    if (this.mWindowPtr != 0L)
    {
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0L;
    }
    AppMethodBeat.o(2893);
  }
  
  private static native void nativeClear(long paramLong);
  
  private static native long nativeCreate(int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeEndRow(long paramLong1, long paramLong2);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native int nativeGetNumChunks(long paramLong);
  
  private static native long nativeGetRow(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native long nativeRemoveChunk(long paramLong, int paramInt);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  public void clear()
  {
    AppMethodBeat.i(2896);
    acquireReference();
    try
    {
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2896);
    }
  }
  
  void endRowUnsafe(long paramLong)
  {
    AppMethodBeat.i(2901);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(2901);
      return;
    }
    nativeEndRow(this.mWindowPtr, paramLong);
    releaseReference();
    AppMethodBeat.o(2901);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(2894);
    try
    {
      dispose();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(2894);
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2908);
    long l = getRowUnsafe(paramInt1);
    Object localObject1;
    if (l == 0L)
    {
      localObject1 = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(2908);
      throw ((Throwable)localObject1);
    }
    try
    {
      localObject1 = nativeGetBlob(l, paramInt2);
      return localObject1;
    }
    finally
    {
      endRowUnsafe(l);
      AppMethodBeat.o(2908);
    }
  }
  
  byte[] getBlobUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(2903);
    byte[] arrayOfByte = nativeGetBlob(paramLong, paramInt);
    AppMethodBeat.o(2903);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2911);
    long l = getRowUnsafe(paramInt1);
    if (l == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(2911);
      throw localIllegalStateException;
    }
    try
    {
      double d = nativeGetDouble(l, paramInt2);
      return d;
    }
    finally
    {
      endRowUnsafe(l);
      AppMethodBeat.o(2911);
    }
  }
  
  double getDoubleUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(2906);
    double d = nativeGetDouble(paramLong, paramInt);
    AppMethodBeat.o(2906);
    return d;
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2910);
    long l1 = getRowUnsafe(paramInt1);
    if (l1 == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(2910);
      throw localIllegalStateException;
    }
    try
    {
      long l2 = nativeGetLong(l1, paramInt2);
      return l2;
    }
    finally
    {
      endRowUnsafe(l1);
      AppMethodBeat.o(2910);
    }
  }
  
  long getLongUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(2905);
    paramLong = nativeGetLong(paramLong, paramInt);
    AppMethodBeat.o(2905);
    return paramLong;
  }
  
  public int getNumChunks()
  {
    AppMethodBeat.i(2898);
    acquireReference();
    try
    {
      int i = nativeGetNumChunks(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2898);
    }
  }
  
  public int getNumColumns()
  {
    return this.mNumColumns;
  }
  
  long getRowUnsafe(int paramInt)
  {
    AppMethodBeat.i(2900);
    acquireReference();
    long l = nativeGetRow(this.mWindowPtr, paramInt);
    if (l == 0L) {
      releaseReference();
    }
    AppMethodBeat.o(2900);
    return l;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2909);
    long l = getRowUnsafe(paramInt1);
    Object localObject1;
    if (l == 0L)
    {
      localObject1 = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(2909);
      throw ((Throwable)localObject1);
    }
    try
    {
      localObject1 = nativeGetString(l, paramInt2);
      return localObject1;
    }
    finally
    {
      endRowUnsafe(l);
      AppMethodBeat.o(2909);
    }
  }
  
  String getStringUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(2904);
    String str = nativeGetString(paramLong, paramInt);
    AppMethodBeat.o(2904);
    return str;
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2907);
    long l = getRowUnsafe(paramInt1);
    if (l == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(2907);
      throw localIllegalStateException;
    }
    try
    {
      paramInt1 = nativeGetType(l, paramInt2);
      return paramInt1;
    }
    finally
    {
      endRowUnsafe(l);
      AppMethodBeat.o(2907);
    }
  }
  
  int getTypeUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(2902);
    paramInt = nativeGetType(paramLong, paramInt);
    AppMethodBeat.o(2902);
    return paramInt;
  }
  
  protected void onAllReferencesReleased()
  {
    AppMethodBeat.i(2895);
    dispose();
    AppMethodBeat.o(2895);
  }
  
  public long removeChunk(int paramInt)
  {
    AppMethodBeat.i(2897);
    acquireReference();
    try
    {
      long l = nativeRemoveChunk(this.mWindowPtr, paramInt);
      return l;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2897);
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    AppMethodBeat.i(2899);
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      if (bool) {
        this.mNumColumns = paramInt;
      }
      return bool;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(2899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wcdb.database.ChunkedCursorWindow
 * JD-Core Version:    0.7.0.1
 */