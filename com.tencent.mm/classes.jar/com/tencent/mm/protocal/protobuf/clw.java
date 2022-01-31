package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clw
  extends com.tencent.mm.bv.a
{
  public String xVS;
  public String xVT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94636);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xVS != null) {
        paramVarArgs.e(1, this.xVS);
      }
      if (this.xVT != null) {
        paramVarArgs.e(2, this.xVT);
      }
      AppMethodBeat.o(94636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xVS == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.xVS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xVT != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xVT);
      }
      AppMethodBeat.o(94636);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94636);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        clw localclw = (clw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94636);
          return -1;
        case 1: 
          localclw.xVS = locala.CLY.readString();
          AppMethodBeat.o(94636);
          return 0;
        }
        localclw.xVT = locala.CLY.readString();
        AppMethodBeat.o(94636);
        return 0;
      }
      AppMethodBeat.o(94636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clw
 * JD-Core Version:    0.7.0.1
 */