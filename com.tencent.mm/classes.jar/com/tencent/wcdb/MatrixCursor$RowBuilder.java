package com.tencent.wcdb;

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
    if (this.index == this.endIndex) {
      throw new CursorIndexOutOfBoundsException("No more columns left.");
    }
    Object[] arrayOfObject = MatrixCursor.access$000(this.this$0);
    int i = this.index;
    this.index = (i + 1);
    arrayOfObject[i] = paramObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wcdb.MatrixCursor.RowBuilder
 * JD-Core Version:    0.7.0.1
 */