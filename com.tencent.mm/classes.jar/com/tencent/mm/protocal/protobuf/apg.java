package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class apg
  extends com.tencent.mm.bw.a
{
  public b LBp;
  public int cmdId;
  public String qwG;
  public int retCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.cmdId);
      paramVarArgs.aM(2, this.retCode);
      if (this.qwG != null) {
        paramVarArgs.e(3, this.qwG);
      }
      if (this.LBp != null) {
        paramVarArgs.c(4, this.LBp);
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.cmdId) + 0 + g.a.a.b.b.a.bu(2, this.retCode);
      paramInt = i;
      if (this.qwG != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwG);
      }
      i = paramInt;
      if (this.LBp != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.LBp);
      }
      AppMethodBeat.o(168939);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apg localapg = (apg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168939);
        return -1;
      case 1: 
        localapg.cmdId = locala.UbS.zi();
        AppMethodBeat.o(168939);
        return 0;
      case 2: 
        localapg.retCode = locala.UbS.zi();
        AppMethodBeat.o(168939);
        return 0;
      case 3: 
        localapg.qwG = locala.UbS.readString();
        AppMethodBeat.o(168939);
        return 0;
      }
      localapg.LBp = locala.UbS.hPo();
      AppMethodBeat.o(168939);
      return 0;
    }
    AppMethodBeat.o(168939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apg
 * JD-Core Version:    0.7.0.1
 */