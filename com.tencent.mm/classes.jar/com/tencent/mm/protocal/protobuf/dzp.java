package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzp
  extends com.tencent.mm.bx.a
{
  public String KHW;
  public long LiJ;
  public String LiK;
  public int LiL;
  public int LiM;
  public int LiN;
  public String LiO;
  public int qqE;
  public int qvB;
  public String qwV;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.qwV != null) {
        paramVarArgs.d(2, this.qwV);
      }
      if (this.KHW != null) {
        paramVarArgs.d(3, this.KHW);
      }
      if (this.LiK != null) {
        paramVarArgs.d(4, this.LiK);
      }
      paramVarArgs.aR(5, this.qvB);
      paramVarArgs.aR(6, this.qqE);
      paramVarArgs.aG(7, this.LiJ);
      paramVarArgs.aR(8, this.LiL);
      paramVarArgs.aR(9, this.LiM);
      if (this.LiO != null) {
        paramVarArgs.d(10, this.LiO);
      }
      paramVarArgs.aR(11, this.LiN);
      AppMethodBeat.o(203876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.b.b.a.e(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qwV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qwV);
      }
      i = paramInt;
      if (this.KHW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.KHW);
      }
      paramInt = i;
      if (this.LiK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LiK);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.qvB) + f.a.a.b.b.a.bA(6, this.qqE) + f.a.a.b.b.a.q(7, this.LiJ) + f.a.a.b.b.a.bA(8, this.LiL) + f.a.a.b.b.a.bA(9, this.LiM);
      paramInt = i;
      if (this.LiO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.LiO);
      }
      i = f.a.a.b.b.a.bA(11, this.LiN);
      AppMethodBeat.o(203876);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203876);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzp localdzp = (dzp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203876);
          return -1;
        case 1: 
          localdzp.sessionId = locala.KhF.readString();
          AppMethodBeat.o(203876);
          return 0;
        case 2: 
          localdzp.qwV = locala.KhF.readString();
          AppMethodBeat.o(203876);
          return 0;
        case 3: 
          localdzp.KHW = locala.KhF.readString();
          AppMethodBeat.o(203876);
          return 0;
        case 4: 
          localdzp.LiK = locala.KhF.readString();
          AppMethodBeat.o(203876);
          return 0;
        case 5: 
          localdzp.qvB = locala.KhF.xS();
          AppMethodBeat.o(203876);
          return 0;
        case 6: 
          localdzp.qqE = locala.KhF.xS();
          AppMethodBeat.o(203876);
          return 0;
        case 7: 
          localdzp.LiJ = locala.KhF.xT();
          AppMethodBeat.o(203876);
          return 0;
        case 8: 
          localdzp.LiL = locala.KhF.xS();
          AppMethodBeat.o(203876);
          return 0;
        case 9: 
          localdzp.LiM = locala.KhF.xS();
          AppMethodBeat.o(203876);
          return 0;
        case 10: 
          localdzp.LiO = locala.KhF.readString();
          AppMethodBeat.o(203876);
          return 0;
        }
        localdzp.LiN = locala.KhF.xS();
        AppMethodBeat.o(203876);
        return 0;
      }
      AppMethodBeat.o(203876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */