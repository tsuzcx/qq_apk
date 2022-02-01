package com.tencent.tbs.one;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface TBSOneEventEmitter
{
  public abstract void emit(UnloadedBehavior paramUnloadedBehavior, String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap);
  
  public abstract void emit(String paramString, Map<String, Object> paramMap);
  
  public static enum UnloadedBehavior
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
    
    private UnloadedBehavior() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneEventEmitter
 * JD-Core Version:    0.7.0.1
 */