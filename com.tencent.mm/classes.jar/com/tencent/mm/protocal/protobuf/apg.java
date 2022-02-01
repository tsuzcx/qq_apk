package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apg
  extends com.tencent.mm.bw.a
{
  public int GGt;
  public long GGu;
  public String bVF;
  public String dvq;
  public String hGI;
  public int likeFlag;
  public long rPT;
  public int unreadFlag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189366);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.bVF != null) {
        paramVarArgs.d(1, this.bVF);
      }
      if (this.hGI != null) {
        paramVarArgs.d(2, this.hGI);
      }
      paramVarArgs.aZ(3, this.rPT);
      paramVarArgs.aS(4, this.likeFlag);
      paramVarArgs.aS(5, this.GGt);
      if (this.dvq != null) {
        paramVarArgs.d(6, this.dvq);
      }
      paramVarArgs.aZ(7, this.GGu);
      paramVarArgs.aS(8, this.unreadFlag);
      AppMethodBeat.o(189366);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bVF == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.b.b.a.e(1, this.bVF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hGI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hGI);
      }
      i = i + f.a.a.b.b.a.p(3, this.rPT) + f.a.a.b.b.a.bz(4, this.likeFlag) + f.a.a.b.b.a.bz(5, this.GGt);
      paramInt = i;
      if (this.dvq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dvq);
      }
      i = f.a.a.b.b.a.p(7, this.GGu);
      int j = f.a.a.b.b.a.bz(8, this.unreadFlag);
      AppMethodBeat.o(189366);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189366);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apg localapg = (apg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189366);
          return -1;
        case 1: 
          localapg.bVF = locala.OmT.readString();
          AppMethodBeat.o(189366);
          return 0;
        case 2: 
          localapg.hGI = locala.OmT.readString();
          AppMethodBeat.o(189366);
          return 0;
        case 3: 
          localapg.rPT = locala.OmT.zd();
          AppMethodBeat.o(189366);
          return 0;
        case 4: 
          localapg.likeFlag = locala.OmT.zc();
          AppMethodBeat.o(189366);
          return 0;
        case 5: 
          localapg.GGt = locala.OmT.zc();
          AppMethodBeat.o(189366);
          return 0;
        case 6: 
          localapg.dvq = locala.OmT.readString();
          AppMethodBeat.o(189366);
          return 0;
        case 7: 
          localapg.GGu = locala.OmT.zd();
          AppMethodBeat.o(189366);
          return 0;
        }
        localapg.unreadFlag = locala.OmT.zc();
        AppMethodBeat.o(189366);
        return 0;
      }
      AppMethodBeat.o(189366);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apg
 * JD-Core Version:    0.7.0.1
 */