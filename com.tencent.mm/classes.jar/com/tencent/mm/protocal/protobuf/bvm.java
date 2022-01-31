package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvm
  extends com.tencent.mm.bv.a
{
  public String npR;
  public int nrS;
  public String xJd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124344);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xJd != null) {
        paramVarArgs.e(1, this.xJd);
      }
      paramVarArgs.aO(2, this.nrS);
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      AppMethodBeat.o(124344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJd == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.xJd) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nrS);
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.npR);
      }
      AppMethodBeat.o(124344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124344);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bvm localbvm = (bvm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124344);
          return -1;
        case 1: 
          localbvm.xJd = locala.CLY.readString();
          AppMethodBeat.o(124344);
          return 0;
        case 2: 
          localbvm.nrS = locala.CLY.sl();
          AppMethodBeat.o(124344);
          return 0;
        }
        localbvm.npR = locala.CLY.readString();
        AppMethodBeat.o(124344);
        return 0;
      }
      AppMethodBeat.o(124344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvm
 * JD-Core Version:    0.7.0.1
 */