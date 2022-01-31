package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class btj
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int lGW;
  public b wPb;
  public int xCa;
  public String xGT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118282);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xGT != null) {
        paramVarArgs.e(1, this.xGT);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.lGW);
      paramVarArgs.aO(4, this.xCa);
      if (this.wPb != null) {
        paramVarArgs.c(5, this.wPb);
      }
      AppMethodBeat.o(118282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xGT == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = e.a.a.b.b.a.f(1, this.xGT) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.lGW) + e.a.a.b.b.a.bl(4, this.xCa);
      paramInt = i;
      if (this.wPb != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.wPb);
      }
      AppMethodBeat.o(118282);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(118282);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        btj localbtj = (btj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118282);
          return -1;
        case 1: 
          localbtj.xGT = locala.CLY.readString();
          AppMethodBeat.o(118282);
          return 0;
        case 2: 
          localbtj.jKs = locala.CLY.sl();
          AppMethodBeat.o(118282);
          return 0;
        case 3: 
          localbtj.lGW = locala.CLY.sl();
          AppMethodBeat.o(118282);
          return 0;
        case 4: 
          localbtj.xCa = locala.CLY.sl();
          AppMethodBeat.o(118282);
          return 0;
        }
        localbtj.wPb = locala.CLY.eqS();
        AppMethodBeat.o(118282);
        return 0;
      }
      AppMethodBeat.o(118282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */