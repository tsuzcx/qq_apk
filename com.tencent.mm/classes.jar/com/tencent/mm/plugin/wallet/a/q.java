package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String CYy;
  public String CZd;
  public String CZe;
  public String CZf = "0";
  public String CZg = "0";
  public int CZh = 0;
  public int CZi;
  public String CZj;
  public String desc;
  public String hGk;
  public String id;
  public String name;
  public int status;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91303);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aS(4, this.status);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.type);
      if (this.CZd != null) {
        paramVarArgs.d(7, this.CZd);
      }
      if (this.CZe != null) {
        paramVarArgs.d(8, this.CZe);
      }
      if (this.CZf != null) {
        paramVarArgs.d(9, this.CZf);
      }
      if (this.CZg != null) {
        paramVarArgs.d(10, this.CZg);
      }
      paramVarArgs.aS(11, this.CZh);
      if (this.CYy != null) {
        paramVarArgs.d(12, this.CYy);
      }
      if (this.hGk != null) {
        paramVarArgs.d(13, this.hGk);
      }
      paramVarArgs.aS(14, this.CZi);
      if (this.CZj != null) {
        paramVarArgs.d(15, this.CZj);
      }
      AppMethodBeat.o(91303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1010;
      }
    }
    label1010:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      i += f.a.a.b.b.a.bz(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.CZd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CZd);
      }
      i = paramInt;
      if (this.CZe != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CZe);
      }
      paramInt = i;
      if (this.CZf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CZf);
      }
      i = paramInt;
      if (this.CZg != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CZg);
      }
      i += f.a.a.b.b.a.bz(11, this.CZh);
      paramInt = i;
      if (this.CYy != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CYy);
      }
      i = paramInt;
      if (this.hGk != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hGk);
      }
      i += f.a.a.b.b.a.bz(14, this.CZi);
      paramInt = i;
      if (this.CZj != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CZj);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91303);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91303);
          return -1;
        case 1: 
          localq.id = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.OmT.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.OmT.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.CZd = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.CZe = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.CZf = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.CZg = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.CZh = locala.OmT.zc();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.CYy = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.hGk = locala.OmT.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.CZi = locala.OmT.zc();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.CZj = locala.OmT.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */