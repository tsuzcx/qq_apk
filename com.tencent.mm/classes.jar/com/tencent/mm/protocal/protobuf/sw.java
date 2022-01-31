package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sw
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> wLo;
  public String wLp;
  
  public sw()
  {
    AppMethodBeat.i(151636);
    this.wLo = new LinkedList();
    AppMethodBeat.o(151636);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151637);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.wLo);
      if (this.wLp != null) {
        paramVarArgs.e(2, this.wLp);
      }
      AppMethodBeat.o(151637);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.a.c(1, 1, this.wLo) + 0;
      paramInt = i;
      if (this.wLp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wLp);
      }
      AppMethodBeat.o(151637);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wLo.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151637);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      sw localsw = (sw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151637);
        return -1;
      case 1: 
        localsw.wLo.add(locala.CLY.readString());
        AppMethodBeat.o(151637);
        return 0;
      }
      localsw.wLp = locala.CLY.readString();
      AppMethodBeat.o(151637);
      return 0;
    }
    AppMethodBeat.o(151637);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sw
 * JD-Core Version:    0.7.0.1
 */