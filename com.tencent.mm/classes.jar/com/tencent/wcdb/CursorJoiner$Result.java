package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CursorJoiner$Result
{
  static
  {
    AppMethodBeat.i(11993);
    RIGHT = new Result("RIGHT", 0);
    LEFT = new Result("LEFT", 1);
    BOTH = new Result("BOTH", 2);
    $VALUES = new Result[] { RIGHT, LEFT, BOTH };
    AppMethodBeat.o(11993);
  }
  
  private CursorJoiner$Result() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorJoiner.Result
 * JD-Core Version:    0.7.0.1
 */