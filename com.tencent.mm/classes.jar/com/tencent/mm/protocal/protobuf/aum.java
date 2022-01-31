package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class aum
  extends com.tencent.mm.bv.a
{
  public b wuq;
  public b wus;
  public b xjB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28521);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wus != null) {
        paramVarArgs.c(1, this.wus);
      }
      if (this.wuq != null) {
        paramVarArgs.c(2, this.wuq);
      }
      if (this.xjB != null) {
        paramVarArgs.c(3, this.xjB);
      }
      AppMethodBeat.o(28521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wus == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.b(1, this.wus) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wuq != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wuq);
      }
      i = paramInt;
      if (this.xjB != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.xjB);
      }
      AppMethodBeat.o(28521);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28521);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aum localaum = (aum)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28521);
          return -1;
        case 1: 
          localaum.wus = locala.CLY.eqS();
          AppMethodBeat.o(28521);
          return 0;
        case 2: 
          localaum.wuq = locala.CLY.eqS();
          AppMethodBeat.o(28521);
          return 0;
        }
        localaum.xjB = locala.CLY.eqS();
        AppMethodBeat.o(28521);
        return 0;
      }
      AppMethodBeat.o(28521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aum
 * JD-Core Version:    0.7.0.1
 */