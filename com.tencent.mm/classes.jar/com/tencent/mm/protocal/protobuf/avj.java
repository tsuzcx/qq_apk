package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avj
  extends com.tencent.mm.bv.a
{
  public String xkP;
  public String xkQ;
  public int xkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58908);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xkP != null) {
        paramVarArgs.e(1, this.xkP);
      }
      if (this.xkQ != null) {
        paramVarArgs.e(2, this.xkQ);
      }
      paramVarArgs.aO(3, this.xkR);
      AppMethodBeat.o(58908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.xkP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xkQ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xkQ);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xkR);
      AppMethodBeat.o(58908);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58908);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avj localavj = (avj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(58908);
          return -1;
        case 1: 
          localavj.xkP = locala.CLY.readString();
          AppMethodBeat.o(58908);
          return 0;
        case 2: 
          localavj.xkQ = locala.CLY.readString();
          AppMethodBeat.o(58908);
          return 0;
        }
        localavj.xkR = locala.CLY.sl();
        AppMethodBeat.o(58908);
        return 0;
      }
      AppMethodBeat.o(58908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avj
 * JD-Core Version:    0.7.0.1
 */