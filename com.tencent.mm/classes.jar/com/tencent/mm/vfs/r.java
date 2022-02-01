package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class r<Base extends d<State>, State>
{
  final Base agzC;
  State agzD;
  
  r(Base paramBase)
  {
    this.agzC = paramBase;
  }
  
  r(r<Base, State> paramr)
  {
    this.agzC = paramr.agzC;
    this.agzD = null;
  }
  
  final State cV(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238323);
    if (this.agzD == null) {
      this.agzD = this.agzC.cN(paramMap);
    }
    paramMap = this.agzD;
    AppMethodBeat.o(238323);
    return paramMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238330);
    if (this.agzC == null)
    {
      AppMethodBeat.o(238330);
      return "[NULL]";
    }
    String str = this.agzC.toString();
    AppMethodBeat.o(238330);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.r
 * JD-Core Version:    0.7.0.1
 */