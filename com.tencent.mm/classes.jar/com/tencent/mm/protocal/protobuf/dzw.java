package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzw
  extends com.tencent.mm.bx.a
{
  public int DjY;
  public long LyD;
  public String LyE;
  public int LyF;
  public int LyG;
  public String coverUrl;
  public String dqA;
  public int followFlag;
  public int friendFollowCount;
  public int qSS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203884);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dqA != null) {
        paramVarArgs.d(1, this.dqA);
      }
      paramVarArgs.aG(2, this.LyD);
      paramVarArgs.aR(3, this.DjY);
      if (this.LyE != null) {
        paramVarArgs.d(4, this.LyE);
      }
      paramVarArgs.aR(5, this.qSS);
      paramVarArgs.aR(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.d(7, this.coverUrl);
      }
      paramVarArgs.aR(8, this.friendFollowCount);
      paramVarArgs.aR(9, this.LyF);
      paramVarArgs.aR(10, this.LyG);
      AppMethodBeat.o(203884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dqA == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.dqA) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.LyD) + f.a.a.b.b.a.bA(3, this.DjY);
      paramInt = i;
      if (this.LyE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LyE);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.qSS) + f.a.a.b.b.a.bA(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.coverUrl);
      }
      i = f.a.a.b.b.a.bA(8, this.friendFollowCount);
      int j = f.a.a.b.b.a.bA(9, this.LyF);
      int k = f.a.a.b.b.a.bA(10, this.LyG);
      AppMethodBeat.o(203884);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203884);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzw localdzw = (dzw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203884);
          return -1;
        case 1: 
          localdzw.dqA = locala.KhF.readString();
          AppMethodBeat.o(203884);
          return 0;
        case 2: 
          localdzw.LyD = locala.KhF.xT();
          AppMethodBeat.o(203884);
          return 0;
        case 3: 
          localdzw.DjY = locala.KhF.xS();
          AppMethodBeat.o(203884);
          return 0;
        case 4: 
          localdzw.LyE = locala.KhF.readString();
          AppMethodBeat.o(203884);
          return 0;
        case 5: 
          localdzw.qSS = locala.KhF.xS();
          AppMethodBeat.o(203884);
          return 0;
        case 6: 
          localdzw.followFlag = locala.KhF.xS();
          AppMethodBeat.o(203884);
          return 0;
        case 7: 
          localdzw.coverUrl = locala.KhF.readString();
          AppMethodBeat.o(203884);
          return 0;
        case 8: 
          localdzw.friendFollowCount = locala.KhF.xS();
          AppMethodBeat.o(203884);
          return 0;
        case 9: 
          localdzw.LyF = locala.KhF.xS();
          AppMethodBeat.o(203884);
          return 0;
        }
        localdzw.LyG = locala.KhF.xS();
        AppMethodBeat.o(203884);
        return 0;
      }
      AppMethodBeat.o(203884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzw
 * JD-Core Version:    0.7.0.1
 */