package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmr
  extends com.tencent.mm.bv.a
{
  public int nuk;
  public String wxP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58924);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wxP != null) {
        paramVarArgs.e(1, this.wxP);
      }
      paramVarArgs.aO(2, this.nuk);
      AppMethodBeat.o(58924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wxP == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.wxP) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.nuk);
      AppMethodBeat.o(58924);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58924);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmr localbmr = (bmr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(58924);
          return -1;
        case 1: 
          localbmr.wxP = locala.CLY.readString();
          AppMethodBeat.o(58924);
          return 0;
        }
        localbmr.nuk = locala.CLY.sl();
        AppMethodBeat.o(58924);
        return 0;
      }
      AppMethodBeat.o(58924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmr
 * JD-Core Version:    0.7.0.1
 */