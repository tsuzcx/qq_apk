package com.tencent.wcdb.extension.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;

public final class MMFtsTokenizer
  implements SQLiteExtension
{
  public static final SQLiteExtension EXTENSION;
  
  static
  {
    AppMethodBeat.i(3327);
    EXTENSION = new MMFtsTokenizer();
    AppMethodBeat.o(3327);
  }
  
  private static native void nativeInitialize(long paramLong1, long paramLong2);
  
  public final void initialize(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(3326);
    nativeInitialize(paramLong1, paramLong2);
    AppMethodBeat.o(3326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.extension.fts.MMFtsTokenizer
 * JD-Core Version:    0.7.0.1
 */