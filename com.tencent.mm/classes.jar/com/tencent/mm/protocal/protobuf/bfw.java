package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfw
  extends com.tencent.mm.bv.a
{
  public int nqW;
  public String nul;
  public String num;
  public int pIE;
  public long pIG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60052);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.num != null) {
        paramVarArgs.e(1, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(2, this.nul);
      }
      paramVarArgs.aO(3, this.pIE);
      paramVarArgs.aO(4, this.nqW);
      paramVarArgs.am(5, this.pIG);
      AppMethodBeat.o(60052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.num == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = e.a.a.b.b.a.f(1, this.num) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nul);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.pIE);
      int j = e.a.a.b.b.a.bl(4, this.nqW);
      int k = e.a.a.b.b.a.p(5, this.pIG);
      AppMethodBeat.o(60052);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60052);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfw localbfw = (bfw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60052);
          return -1;
        case 1: 
          localbfw.num = locala.CLY.readString();
          AppMethodBeat.o(60052);
          return 0;
        case 2: 
          localbfw.nul = locala.CLY.readString();
          AppMethodBeat.o(60052);
          return 0;
        case 3: 
          localbfw.pIE = locala.CLY.sl();
          AppMethodBeat.o(60052);
          return 0;
        case 4: 
          localbfw.nqW = locala.CLY.sl();
          AppMethodBeat.o(60052);
          return 0;
        }
        localbfw.pIG = locala.CLY.sm();
        AppMethodBeat.o(60052);
        return 0;
      }
      AppMethodBeat.o(60052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfw
 * JD-Core Version:    0.7.0.1
 */