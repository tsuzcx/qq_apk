package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class CursorJoiner
  implements Iterable<Result>, Iterator<Result>
{
  private int[] mColumnsLeft;
  private int[] mColumnsRight;
  private Result mCompareResult;
  private boolean mCompareResultIsValid;
  private Cursor mCursorLeft;
  private Cursor mCursorRight;
  private String[] mValues;
  
  public CursorJoiner(Cursor paramCursor1, String[] paramArrayOfString1, Cursor paramCursor2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(2675);
    if (paramArrayOfString1.length != paramArrayOfString2.length)
    {
      paramCursor1 = new IllegalArgumentException("you must have the same number of columns on the left and right, " + paramArrayOfString1.length + " != " + paramArrayOfString2.length);
      AppMethodBeat.o(2675);
      throw paramCursor1;
    }
    this.mCursorLeft = paramCursor1;
    this.mCursorRight = paramCursor2;
    this.mCursorLeft.moveToFirst();
    this.mCursorRight.moveToFirst();
    this.mCompareResultIsValid = false;
    this.mColumnsLeft = buildColumnIndiciesArray(paramCursor1, paramArrayOfString1);
    this.mColumnsRight = buildColumnIndiciesArray(paramCursor2, paramArrayOfString2);
    this.mValues = new String[this.mColumnsLeft.length * 2];
    AppMethodBeat.o(2675);
  }
  
  private int[] buildColumnIndiciesArray(Cursor paramCursor, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2676);
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfInt[i] = paramCursor.getColumnIndexOrThrow(paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(2676);
    return arrayOfInt;
  }
  
  private static int compareStrings(String... paramVarArgs)
  {
    AppMethodBeat.i(2682);
    if (paramVarArgs.length % 2 != 0)
    {
      paramVarArgs = new IllegalArgumentException("you must specify an even number of values");
      AppMethodBeat.o(2682);
      throw paramVarArgs;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null)
      {
        if (paramVarArgs[(i + 1)] != null)
        {
          AppMethodBeat.o(2682);
          return -1;
        }
      }
      else
      {
        if (paramVarArgs[(i + 1)] == null)
        {
          AppMethodBeat.o(2682);
          return 1;
        }
        int j = paramVarArgs[i].compareTo(paramVarArgs[(i + 1)]);
        if (j != 0)
        {
          if (j < 0)
          {
            AppMethodBeat.o(2682);
            return -1;
          }
          AppMethodBeat.o(2682);
          return 1;
        }
      }
      i += 2;
    }
    AppMethodBeat.o(2682);
    return 0;
  }
  
  private void incrementCursors()
  {
    AppMethodBeat.i(2681);
    if (this.mCompareResultIsValid) {
      switch (1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.mCompareResultIsValid = false;
      AppMethodBeat.o(2681);
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
    AppMethodBeat.i(2680);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfString[(i * 2 + paramInt)] = paramCursor.getString(paramArrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(2680);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(2677);
    if (this.mCompareResultIsValid)
    {
      switch (1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()])
      {
      default: 
        IllegalStateException localIllegalStateException = new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
        AppMethodBeat.o(2677);
        throw localIllegalStateException;
      case 1: 
        if ((!this.mCursorLeft.isLast()) || (!this.mCursorRight.isLast()))
        {
          AppMethodBeat.o(2677);
          return true;
        }
        AppMethodBeat.o(2677);
        return false;
      case 2: 
        if ((!this.mCursorLeft.isLast()) || (!this.mCursorRight.isAfterLast()))
        {
          AppMethodBeat.o(2677);
          return true;
        }
        AppMethodBeat.o(2677);
        return false;
      }
      if ((!this.mCursorLeft.isAfterLast()) || (!this.mCursorRight.isLast()))
      {
        AppMethodBeat.o(2677);
        return true;
      }
      AppMethodBeat.o(2677);
      return false;
    }
    if ((!this.mCursorLeft.isAfterLast()) || (!this.mCursorRight.isAfterLast()))
    {
      AppMethodBeat.o(2677);
      return true;
    }
    AppMethodBeat.o(2677);
    return false;
  }
  
  public final Iterator<Result> iterator()
  {
    return this;
  }
  
  public final Result next()
  {
    AppMethodBeat.i(2678);
    Object localObject;
    if (!hasNext())
    {
      localObject = new IllegalStateException("you must only call next() when hasNext() is true");
      AppMethodBeat.o(2678);
      throw ((Throwable)localObject);
    }
    incrementCursors();
    int i;
    int j;
    if (!this.mCursorLeft.isAfterLast())
    {
      i = 1;
      if (this.mCursorRight.isAfterLast()) {
        break label159;
      }
      j = 1;
      label63:
      if ((i == 0) || (j == 0)) {
        break label194;
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
      localObject = this.mCompareResult;
      AppMethodBeat.o(2678);
      return localObject;
      i = 0;
      break;
      label159:
      j = 0;
      break label63;
      this.mCompareResult = Result.LEFT;
      continue;
      this.mCompareResult = Result.BOTH;
      continue;
      this.mCompareResult = Result.RIGHT;
      continue;
      label194:
      if (i != 0) {
        this.mCompareResult = Result.LEFT;
      } else {
        this.mCompareResult = Result.RIGHT;
      }
    }
  }
  
  public final void remove()
  {
    AppMethodBeat.i(2679);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("not implemented");
    AppMethodBeat.o(2679);
    throw localUnsupportedOperationException;
  }
  
  public static enum Result
  {
    static
    {
      AppMethodBeat.i(2674);
      RIGHT = new Result("RIGHT", 0);
      LEFT = new Result("LEFT", 1);
      BOTH = new Result("BOTH", 2);
      $VALUES = new Result[] { RIGHT, LEFT, BOTH };
      AppMethodBeat.o(2674);
    }
    
    private Result() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.CursorJoiner
 * JD-Core Version:    0.7.0.1
 */