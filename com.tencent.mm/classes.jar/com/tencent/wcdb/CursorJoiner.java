package com.tencent.wcdb;

import java.util.Iterator;

public final class CursorJoiner
  implements Iterable<CursorJoiner.Result>, Iterator<CursorJoiner.Result>
{
  private int[] mColumnsLeft;
  private int[] mColumnsRight;
  private CursorJoiner.Result mCompareResult;
  private boolean mCompareResultIsValid;
  private Cursor mCursorLeft;
  private Cursor mCursorRight;
  private String[] mValues;
  
  public CursorJoiner(Cursor paramCursor1, String[] paramArrayOfString1, Cursor paramCursor2, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1.length != paramArrayOfString2.length) {
      throw new IllegalArgumentException("you must have the same number of columns on the left and right, " + paramArrayOfString1.length + " != " + paramArrayOfString2.length);
    }
    this.mCursorLeft = paramCursor1;
    this.mCursorRight = paramCursor2;
    this.mCursorLeft.moveToFirst();
    this.mCursorRight.moveToFirst();
    this.mCompareResultIsValid = false;
    this.mColumnsLeft = buildColumnIndiciesArray(paramCursor1, paramArrayOfString1);
    this.mColumnsRight = buildColumnIndiciesArray(paramCursor2, paramArrayOfString2);
    this.mValues = new String[this.mColumnsLeft.length * 2];
  }
  
  private int[] buildColumnIndiciesArray(Cursor paramCursor, String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfInt[i] = paramCursor.getColumnIndexOrThrow(paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int compareStrings(String... paramVarArgs)
  {
    int k = 0;
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("you must specify an even number of values");
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] == null)
        {
          if (paramVarArgs[(i + 1)] == null) {
            break label81;
          }
          j = -1;
        }
      }
      else {
        return j;
      }
      if (paramVarArgs[(i + 1)] == null) {
        return 1;
      }
      j = paramVarArgs[i].compareTo(paramVarArgs[(i + 1)]);
      if (j != 0)
      {
        if (j < 0) {
          return -1;
        }
        return 1;
      }
      label81:
      i += 2;
    }
  }
  
  private void incrementCursors()
  {
    if (this.mCompareResultIsValid) {
      switch (1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.mCompareResultIsValid = false;
      return;
      this.mCursorLeft.moveToNext();
      continue;
      this.mCursorRight.moveToNext();
      continue;
      this.mCursorLeft.moveToNext();
      this.mCursorRight.moveToNext();
    }
  }
  
  private static void populateValues(String[] paramArrayOfString, Cursor paramCursor, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfString[(i * 2 + paramInt)] = paramCursor.getString(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public final boolean hasNext()
  {
    boolean bool = false;
    if (this.mCompareResultIsValid) {
      switch (1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()])
      {
      default: 
        throw new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
      case 1: 
        if ((!this.mCursorLeft.isLast()) || (!this.mCursorRight.isLast())) {
          bool = true;
        }
        break;
      }
    }
    while ((this.mCursorLeft.isAfterLast()) && (this.mCursorRight.isAfterLast()))
    {
      do
      {
        do
        {
          return bool;
        } while ((this.mCursorLeft.isLast()) && (this.mCursorRight.isAfterLast()));
        return true;
      } while ((this.mCursorLeft.isAfterLast()) && (this.mCursorRight.isLast()));
      return true;
    }
    return true;
  }
  
  public final Iterator<CursorJoiner.Result> iterator()
  {
    return this;
  }
  
  public final CursorJoiner.Result next()
  {
    if (!hasNext()) {
      throw new IllegalStateException("you must only call next() when hasNext() is true");
    }
    incrementCursors();
    int i;
    int j;
    if (!this.mCursorLeft.isAfterLast())
    {
      i = 1;
      if (this.mCursorRight.isAfterLast()) {
        break label139;
      }
      j = 1;
      label49:
      if ((i == 0) || (j == 0)) {
        break label174;
      }
      populateValues(this.mValues, this.mCursorLeft, this.mColumnsLeft, 0);
      populateValues(this.mValues, this.mCursorRight, this.mColumnsRight, 1);
      switch (compareStrings(this.mValues))
      {
      }
    }
    for (;;)
    {
      this.mCompareResultIsValid = true;
      return this.mCompareResult;
      i = 0;
      break;
      label139:
      j = 0;
      break label49;
      this.mCompareResult = CursorJoiner.Result.LEFT;
      continue;
      this.mCompareResult = CursorJoiner.Result.BOTH;
      continue;
      this.mCompareResult = CursorJoiner.Result.RIGHT;
      continue;
      label174:
      if (i != 0) {
        this.mCompareResult = CursorJoiner.Result.LEFT;
      } else {
        this.mCompareResult = CursorJoiner.Result.RIGHT;
      }
    }
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("not implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.CursorJoiner
 * JD-Core Version:    0.7.0.1
 */