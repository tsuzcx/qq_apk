package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class apf
  extends com.tencent.mm.bw.a
{
  public b LBo;
  public int cmdId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168938);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.cmdId);
      if (this.LBo != null) {
        paramVarArgs.c(2, this.LBo);
      }
      AppMethodBeat.o(168938);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.cmdId) + 0;
      paramInt = i;
      if (this.LBo != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.LBo);
      }
      AppMethodBeat.o(168938);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168938);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apf localapf = (apf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168938);
        return -1;
      case 1: 
        localapf.cmdId = locala.UbS.zi();
        AppMethodBeat.o(168938);
        return 0;
      }
      localapf.LBo = locala.UbS.hPo();
      AppMethodBeat.o(168938);
      return 0;
    }
    AppMethodBeat.o(168938);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apf
 * JD-Core Version:    0.7.0.1
 */