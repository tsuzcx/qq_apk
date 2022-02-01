package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asv
  extends com.tencent.mm.bw.a
{
  public int GDA;
  public long GJQ;
  public String GJR;
  public int GJS;
  public int GJT;
  public String coverUrl;
  public String dBe;
  public int followFlag;
  public int friendFollowCount;
  public int sXu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dBe != null) {
        paramVarArgs.d(1, this.dBe);
      }
      paramVarArgs.aZ(2, this.GJQ);
      paramVarArgs.aS(3, this.GDA);
      if (this.GJR != null) {
        paramVarArgs.d(4, this.GJR);
      }
      paramVarArgs.aS(5, this.sXu);
      paramVarArgs.aS(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.d(7, this.coverUrl);
      }
      paramVarArgs.aS(8, this.friendFollowCount);
      paramVarArgs.aS(9, this.GJS);
      paramVarArgs.aS(10, this.GJT);
      AppMethodBeat.o(189414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dBe == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.dBe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GJQ) + f.a.a.b.b.a.bz(3, this.GDA);
      paramInt = i;
      if (this.GJR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GJR);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.sXu) + f.a.a.b.b.a.bz(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.coverUrl);
      }
      i = f.a.a.b.b.a.bz(8, this.friendFollowCount);
      int j = f.a.a.b.b.a.bz(9, this.GJS);
      int k = f.a.a.b.b.a.bz(10, this.GJT);
      AppMethodBeat.o(189414);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189414);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        asv localasv = (asv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189414);
          return -1;
        case 1: 
          localasv.dBe = locala.OmT.readString();
          AppMethodBeat.o(189414);
          return 0;
        case 2: 
          localasv.GJQ = locala.OmT.zd();
          AppMethodBeat.o(189414);
          return 0;
        case 3: 
          localasv.GDA = locala.OmT.zc();
          AppMethodBeat.o(189414);
          return 0;
        case 4: 
          localasv.GJR = locala.OmT.readString();
          AppMethodBeat.o(189414);
          return 0;
        case 5: 
          localasv.sXu = locala.OmT.zc();
          AppMethodBeat.o(189414);
          return 0;
        case 6: 
          localasv.followFlag = locala.OmT.zc();
          AppMethodBeat.o(189414);
          return 0;
        case 7: 
          localasv.coverUrl = locala.OmT.readString();
          AppMethodBeat.o(189414);
          return 0;
        case 8: 
          localasv.friendFollowCount = locala.OmT.zc();
          AppMethodBeat.o(189414);
          return 0;
        case 9: 
          localasv.GJS = locala.OmT.zc();
          AppMethodBeat.o(189414);
          return 0;
        }
        localasv.GJT = locala.OmT.zc();
        AppMethodBeat.o(189414);
        return 0;
      }
      AppMethodBeat.o(189414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asv
 * JD-Core Version:    0.7.0.1
 */