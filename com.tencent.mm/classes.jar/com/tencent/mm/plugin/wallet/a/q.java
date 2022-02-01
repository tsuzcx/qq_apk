package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String BgE;
  public String Bhj;
  public String Bhk;
  public String Bhl = "0";
  public String Bhm = "0";
  public int Bhn = 0;
  public int Bho;
  public String Bhp;
  public String desc;
  public String hlj;
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
      paramVarArgs.aR(4, this.status);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.type);
      if (this.Bhj != null) {
        paramVarArgs.d(7, this.Bhj);
      }
      if (this.Bhk != null) {
        paramVarArgs.d(8, this.Bhk);
      }
      if (this.Bhl != null) {
        paramVarArgs.d(9, this.Bhl);
      }
      if (this.Bhm != null) {
        paramVarArgs.d(10, this.Bhm);
      }
      paramVarArgs.aR(11, this.Bhn);
      if (this.BgE != null) {
        paramVarArgs.d(12, this.BgE);
      }
      if (this.hlj != null) {
        paramVarArgs.d(13, this.hlj);
      }
      paramVarArgs.aR(14, this.Bho);
      if (this.Bhp != null) {
        paramVarArgs.d(15, this.Bhp);
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
      i += f.a.a.b.b.a.bx(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.type);
      paramInt = i;
      if (this.Bhj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Bhj);
      }
      i = paramInt;
      if (this.Bhk != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Bhk);
      }
      paramInt = i;
      if (this.Bhl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Bhl);
      }
      i = paramInt;
      if (this.Bhm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Bhm);
      }
      i += f.a.a.b.b.a.bx(11, this.Bhn);
      paramInt = i;
      if (this.BgE != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.BgE);
      }
      i = paramInt;
      if (this.hlj != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hlj);
      }
      i += f.a.a.b.b.a.bx(14, this.Bho);
      paramInt = i;
      if (this.Bhp != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Bhp);
      }
      AppMethodBeat.o(91303);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localq.id = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 2: 
          localq.name = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 3: 
          localq.desc = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 4: 
          localq.status = locala.LVo.xF();
          AppMethodBeat.o(91303);
          return 0;
        case 5: 
          localq.url = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 6: 
          localq.type = locala.LVo.xF();
          AppMethodBeat.o(91303);
          return 0;
        case 7: 
          localq.Bhj = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 8: 
          localq.Bhk = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 9: 
          localq.Bhl = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 10: 
          localq.Bhm = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 11: 
          localq.Bhn = locala.LVo.xF();
          AppMethodBeat.o(91303);
          return 0;
        case 12: 
          localq.BgE = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 13: 
          localq.hlj = locala.LVo.readString();
          AppMethodBeat.o(91303);
          return 0;
        case 14: 
          localq.Bho = locala.LVo.xF();
          AppMethodBeat.o(91303);
          return 0;
        }
        localq.Bhp = locala.LVo.readString();
        AppMethodBeat.o(91303);
        return 0;
      }
      AppMethodBeat.o(91303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */