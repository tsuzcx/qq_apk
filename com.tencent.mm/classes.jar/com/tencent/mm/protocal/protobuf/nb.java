package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nb
  extends com.tencent.mm.bw.a
{
  public String FZq;
  public String FZr;
  public int FZs;
  public int FZt;
  public String FZu;
  public String FZv;
  public int FZw;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZq != null) {
        paramVarArgs.d(1, this.FZq);
      }
      paramVarArgs.aS(2, this.type);
      if (this.FZr != null) {
        paramVarArgs.d(3, this.FZr);
      }
      if (this.name != null) {
        paramVarArgs.d(4, this.name);
      }
      paramVarArgs.aS(5, this.ver);
      paramVarArgs.aS(6, this.FZs);
      paramVarArgs.aS(7, this.FZt);
      if (this.FZu != null) {
        paramVarArgs.d(8, this.FZu);
      }
      if (this.FZv != null) {
        paramVarArgs.d(9, this.FZv);
      }
      paramVarArgs.aS(10, this.FZw);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZq == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZq) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.FZr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FZr);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.name);
      }
      i = i + f.a.a.b.b.a.bz(5, this.ver) + f.a.a.b.b.a.bz(6, this.FZs) + f.a.a.b.b.a.bz(7, this.FZt);
      paramInt = i;
      if (this.FZu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FZu);
      }
      i = paramInt;
      if (this.FZv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FZv);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FZw);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nb localnb = (nb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localnb.FZq = locala.OmT.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localnb.type = locala.OmT.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localnb.FZr = locala.OmT.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localnb.name = locala.OmT.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localnb.ver = locala.OmT.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localnb.FZs = locala.OmT.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localnb.FZt = locala.OmT.zc();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localnb.FZu = locala.OmT.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localnb.FZv = locala.OmT.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localnb.FZw = locala.OmT.zc();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nb
 * JD-Core Version:    0.7.0.1
 */