package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class auo
  extends com.tencent.mm.bv.a
{
  public int nrS;
  public b wuq;
  public b wus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11772);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wus != null) {
        paramVarArgs.c(1, this.wus);
      }
      if (this.wuq != null) {
        paramVarArgs.c(2, this.wuq);
      }
      paramVarArgs.aO(3, this.nrS);
      AppMethodBeat.o(11772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wus == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.b(1, this.wus) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wuq != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.wuq);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.nrS);
      AppMethodBeat.o(11772);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11772);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11772);
          return -1;
        case 1: 
          localauo.wus = locala.CLY.eqS();
          AppMethodBeat.o(11772);
          return 0;
        case 2: 
          localauo.wuq = locala.CLY.eqS();
          AppMethodBeat.o(11772);
          return 0;
        }
        localauo.nrS = locala.CLY.sl();
        AppMethodBeat.o(11772);
        return 0;
      }
      AppMethodBeat.o(11772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */