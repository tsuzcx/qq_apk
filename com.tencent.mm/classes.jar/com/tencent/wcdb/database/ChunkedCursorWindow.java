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
    AppMethodBeat.i(12211);
    this.mNumColumns = 0;
    this.mWindowPtr = nativeCreate(paramInt);
    if (this.mWindowPtr == 0L)
    {
      CursorWindowAllocationException localCursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation failed.");
      AppMethodBeat.o(12211);
      throw localCursorWindowAllocationException;
    }
    AppMethodBeat.o(12211);
  }
  
  private void dispose()
  {
    AppMethodBeat.i(12212);
    if (this.mWindowPtr != 0L)
    {
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0L;
    }
    AppMethodBeat.o(12212);
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
    AppMethodBeat.i(12215);
    acquireReference();
    try
    {
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12215);
    }
  }
  
  void endRowUnsafe(long paramLong)
  {
    AppMethodBeat.i(12220);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(12220);
      return;
    }
    nativeEndRow(this.mWindowPtr, paramLong);
    releaseReference();
    AppMethodBeat.o(12220);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(12213);
    try
    {
      dispose();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(12213);
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12227);
    long l = getRowUnsafe(paramInt1);
    Object localObject1;
    if (l == 0L)
    {
      localObject1 = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(12227);
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
      AppMethodBeat.o(12227);
    }
  }
  
  byte[] getBlobUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(12222);
    byte[] arrayOfByte = nativeGetBlob(paramLong, paramInt);
    AppMethodBeat.o(12222);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12230);
    long l = getRowUnsafe(paramInt1);
    if (l == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(12230);
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
      AppMethodBeat.o(12230);
    }
  }
  
  double getDoubleUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(12225);
    double d = nativeGetDouble(paramLong, paramInt);
    AppMethodBeat.o(12225);
    return d;
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12229);
    long l1 = getRowUnsafe(paramInt1);
    if (l1 == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(12229);
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
      AppMethodBeat.o(12229);
    }
  }
  
  long getLongUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(12224);
    paramLong = nativeGetLong(paramLong, paramInt);
    AppMethodBeat.o(12224);
    return paramLong;
  }
  
  public int getNumChunks()
  {
    AppMethodBeat.i(12217);
    acquireReference();
    try
    {
      int i = nativeGetNumChunks(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12217);
    }
  }
  
  public int getNumColumns()
  {
    return this.mNumColumns;
  }
  
  long getRowUnsafe(int paramInt)
  {
    AppMethodBeat.i(12219);
    acquireReference();
    long l = nativeGetRow(this.mWindowPtr, paramInt);
    if (l == 0L) {
      releaseReference();
    }
    AppMethodBeat.o(12219);
    return l;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12228);
    long l = getRowUnsafe(paramInt1);
    Object localObject1;
    if (l == 0L)
    {
      localObject1 = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(12228);
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
      AppMethodBeat.o(12228);
    }
  }
  
  String getStringUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(12223);
    String str = nativeGetString(paramLong, paramInt);
    AppMethodBeat.o(12223);
    return str;
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12226);
    long l = getRowUnsafe(paramInt1);
    if (l == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Couldn't read row " + paramInt1 + ", column " + paramInt2 + " from ChunkedCursorWindow.");
      AppMethodBeat.o(12226);
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
      AppMethodBeat.o(12226);
    }
  }
  
  int getTypeUnsafe(long paramLong, int paramInt)
  {
    AppMethodBeat.i(12221);
    paramInt = nativeGetType(paramLong, paramInt);
    AppMethodBeat.o(12221);
    return paramInt;
  }
  
  protected void onAllReferencesReleased()
  {
    AppMethodBeat.i(12214);
    dispose();
    AppMethodBeat.o(12214);
  }
  
  public long removeChunk(int paramInt)
  {
    AppMethodBeat.i(12216);
    acquireReference();
    try
    {
      long l = nativeRemoveChunk(this.mWindowPtr, paramInt);
      return l;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12216);
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    AppMethodBeat.i(12218);
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
      AppMethodBeat.o(12218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.ChunkedCursorWindow
 * JD-Core Version:    0.7.0.1
 */