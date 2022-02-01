package com.tencent.tbs.one;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TBSOneEventEmitter$UnloadedBehavior
{
  static
  {
    AppMethodBeat.i(53732);
    IGNORE = new UnloadedBehavior("IGNORE", 0);
    LOAD = new UnloadedBehavior("LOAD", 1);
    INSTALL = new UnloadedBehavior("INSTALL", 2);
    a = new UnloadedBehavior[] { IGNORE, LOAD, INSTALL };
    AppMethodBeat.o(53732);
  }
  
  private TBSOneEventEmitter$UnloadedBehavior() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneEventEmitter.UnloadedBehavior
 * JD-Core Version:    0.7.0.1
 */