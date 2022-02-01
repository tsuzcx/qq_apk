package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pt
  extends com.tencent.mm.bw.a
{
  public int Gdl;
  public int Gdm;
  public int Gdn;
  public String Gdo;
  public int Gdp;
  public int Gdq;
  public int Gdr;
  public String Gds;
  public String dwb;
  public String prK;
  public int zjj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      paramVarArgs.aS(2, this.Gdl);
      paramVarArgs.aS(3, this.Gdm);
      if (this.prK != null) {
        paramVarArgs.d(4, this.prK);
      }
      paramVarArgs.aS(5, this.Gdn);
      if (this.Gdo != null) {
        paramVarArgs.d(6, this.Gdo);
      }
      paramVarArgs.aS(7, this.Gdp);
      paramVarArgs.aS(8, this.Gdq);
      paramVarArgs.aS(9, this.Gdr);
      if (this.Gds != null) {
        paramVarArgs.d(10, this.Gds);
      }
      paramVarArgs.aS(15, this.zjj);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gdl) + f.a.a.b.b.a.bz(3, this.Gdm);
      paramInt = i;
      if (this.prK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.prK);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gdn);
      paramInt = i;
      if (this.Gdo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gdo);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gdp) + f.a.a.b.b.a.bz(8, this.Gdq) + f.a.a.b.b.a.bz(9, this.Gdr);
      paramInt = i;
      if (this.Gds != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gds);
      }
      i = f.a.a.b.b.a.bz(15, this.zjj);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pt localpt = (pt)paramVarArgs[1];
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
          localpt.dwb = locala.OmT.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localpt.Gdl = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localpt.Gdm = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localpt.prK = locala.OmT.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localpt.Gdn = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localpt.Gdo = locala.OmT.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localpt.Gdp = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localpt.Gdq = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localpt.Gdr = locala.OmT.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localpt.Gds = locala.OmT.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localpt.zjj = locala.OmT.zc();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pt
 * JD-Core Version:    0.7.0.1
 */