package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MatrixCursor$RowBuilder
{
  private final int endIndex;
  private int index;
  
  MatrixCursor$RowBuilder(MatrixCursor paramMatrixCursor, int paramInt1, int paramInt2)
  {
    this.index = paramInt1;
    this.endIndex = paramInt2;
  }
  
  public RowBuilder add(Object paramObject)
  {
    AppMethodBeat.i(2855);
    if (this.index == this.endIndex)
    {
      paramObject = new CursorIndexOutOfBoundsException("No more columns left.");
      AppMethodBeat.o(2855);
      throw paramObject;
    }
    Object[] arrayOfObject = MatrixCursor.access$000(this.this$0);
    int i = this.index;
    this.index = (i + 1);
    arrayOfObject[i] = paramObject;
    AppMethodBeat.o(2855);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wcdb.MatrixCursor.RowBuilder
 * JD-Core Version:    0.7.0.1
 */