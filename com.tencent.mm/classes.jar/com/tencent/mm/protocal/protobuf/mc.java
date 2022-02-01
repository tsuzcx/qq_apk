package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
  extends com.tencent.mm.bx.a
{
  public String CIE;
  public int CIF;
  public String CIG;
  public int CIH;
  public int CII;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIE != null) {
        paramVarArgs.d(1, this.CIE);
      }
      paramVarArgs.aR(2, this.CIF);
      if (this.CIG != null) {
        paramVarArgs.d(3, this.CIG);
      }
      paramVarArgs.aR(4, this.CIH);
      paramVarArgs.aR(5, this.CII);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIE == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CIF);
      paramInt = i;
      if (this.CIG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CIG);
      }
      i = f.a.a.b.b.a.bA(4, this.CIH);
      int j = f.a.a.b.b.a.bA(5, this.CII);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mc localmc = (mc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localmc.CIE = locala.KhF.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localmc.CIF = locala.KhF.xS();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localmc.CIG = locala.KhF.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localmc.CIH = locala.KhF.xS();
          AppMethodBeat.o(124415);
          return 0;
        }
        localmc.CII = locala.KhF.xS();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mc
 * JD-Core Version:    0.7.0.1
 */