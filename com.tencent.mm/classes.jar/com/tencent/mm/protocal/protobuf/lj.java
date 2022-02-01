package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lj
  extends com.tencent.mm.bx.a
{
  public int CGR;
  public String CGS;
  public int CGT;
  public int CGU;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aR(2, this.CGR);
      if (this.CGS != null) {
        paramVarArgs.d(3, this.CGS);
      }
      paramVarArgs.aR(4, this.CGT);
      paramVarArgs.aR(5, this.CGU);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CGR);
      paramInt = i;
      if (this.CGS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CGS);
      }
      i = f.a.a.b.b.a.bA(4, this.CGT);
      int j = f.a.a.b.b.a.bA(5, this.CGU);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        lj locallj = (lj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          locallj.mAQ = locala.KhF.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          locallj.CGR = locala.KhF.xS();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          locallj.CGS = locala.KhF.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          locallj.CGT = locala.KhF.xS();
          AppMethodBeat.o(124393);
          return 0;
        }
        locallj.CGU = locala.KhF.xS();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lj
 * JD-Core Version:    0.7.0.1
 */