package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorIndexOutOfBoundsException
  extends IndexOutOfBoundsException
{
  public CursorIndexOutOfBoundsException(int paramInt1, int paramInt2)
  {
    super("Index " + paramInt1 + " requested, with a size of " + paramInt2);
    AppMethodBeat.i(11989);
    AppMethodBeat.o(11989);
  }
  
  public CursorIndexOutOfBoundsException(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorIndexOutOfBoundsException
 * JD-Core Version:    0.7.0.1
 */