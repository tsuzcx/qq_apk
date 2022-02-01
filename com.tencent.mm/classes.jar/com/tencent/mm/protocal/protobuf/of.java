package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class of
  extends com.tencent.mm.bx.a
{
  public int CLK;
  public int CLL;
  public int CLM;
  public String CLN;
  public int CLO;
  public int CLP;
  public int CLQ;
  public String CLS;
  public String dlB;
  public String oec;
  public int wsZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      paramVarArgs.aR(2, this.CLK);
      paramVarArgs.aR(3, this.CLL);
      if (this.oec != null) {
        paramVarArgs.d(4, this.oec);
      }
      paramVarArgs.aR(5, this.CLM);
      if (this.CLN != null) {
        paramVarArgs.d(6, this.CLN);
      }
      paramVarArgs.aR(7, this.CLO);
      paramVarArgs.aR(8, this.CLP);
      paramVarArgs.aR(9, this.CLQ);
      if (this.CLS != null) {
        paramVarArgs.d(10, this.CLS);
      }
      paramVarArgs.aR(15, this.wsZ);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CLK) + f.a.a.b.b.a.bA(3, this.CLL);
      paramInt = i;
      if (this.oec != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oec);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CLM);
      paramInt = i;
      if (this.CLN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CLN);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CLO) + f.a.a.b.b.a.bA(8, this.CLP) + f.a.a.b.b.a.bA(9, this.CLQ);
      paramInt = i;
      if (this.CLS != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CLS);
      }
      i = f.a.a.b.b.a.bA(15, this.wsZ);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        of localof = (of)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(117838);
          return -1;
        case 1: 
          localof.dlB = locala.KhF.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localof.CLK = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localof.CLL = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localof.oec = locala.KhF.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localof.CLM = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localof.CLN = locala.KhF.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localof.CLO = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localof.CLP = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localof.CLQ = locala.KhF.xS();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localof.CLS = locala.KhF.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localof.wsZ = locala.KhF.xS();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.of
 * JD-Core Version:    0.7.0.1
 */