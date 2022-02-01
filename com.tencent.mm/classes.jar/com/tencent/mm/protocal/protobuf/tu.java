package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tu
  extends com.tencent.mm.bx.a
{
  public int RIb;
  public int RIc;
  public int YZo;
  public int YZp;
  public int YZq;
  public int YZr;
  public int YZs;
  public int YZt;
  public int YZu;
  public int YZv;
  public int YZw;
  public int YZx;
  public int YZy;
  public String aeskey;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259755);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aeskey != null) {
        paramVarArgs.g(1, this.aeskey);
      }
      paramVarArgs.bS(2, this.YZo);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      paramVarArgs.bS(4, this.YZp);
      paramVarArgs.bS(5, this.YZq);
      paramVarArgs.bS(6, this.YZr);
      paramVarArgs.bS(7, this.RIc);
      paramVarArgs.bS(8, this.RIb);
      if (this.md5 != null) {
        paramVarArgs.g(9, this.md5);
      }
      paramVarArgs.bS(10, this.YZs);
      paramVarArgs.bS(11, this.YZt);
      paramVarArgs.bS(12, this.YZu);
      paramVarArgs.bS(13, this.YZv);
      paramVarArgs.bS(14, this.YZw);
      paramVarArgs.bS(15, this.YZx);
      paramVarArgs.bS(16, this.YZy);
      AppMethodBeat.o(259755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = i.a.a.b.b.a.h(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YZo);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.YZp) + i.a.a.b.b.a.cJ(5, this.YZq) + i.a.a.b.b.a.cJ(6, this.YZr) + i.a.a.b.b.a.cJ(7, this.RIc) + i.a.a.b.b.a.cJ(8, this.RIb);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.md5);
      }
      i = i.a.a.b.b.a.cJ(10, this.YZs);
      int j = i.a.a.b.b.a.cJ(11, this.YZt);
      int k = i.a.a.b.b.a.cJ(12, this.YZu);
      int m = i.a.a.b.b.a.cJ(13, this.YZv);
      int n = i.a.a.b.b.a.cJ(14, this.YZw);
      int i1 = i.a.a.b.b.a.cJ(15, this.YZx);
      int i2 = i.a.a.b.b.a.cJ(16, this.YZy);
      AppMethodBeat.o(259755);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259755);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        tu localtu = (tu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259755);
          return -1;
        case 1: 
          localtu.aeskey = locala.ajGk.readString();
          AppMethodBeat.o(259755);
          return 0;
        case 2: 
          localtu.YZo = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 3: 
          localtu.url = locala.ajGk.readString();
          AppMethodBeat.o(259755);
          return 0;
        case 4: 
          localtu.YZp = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 5: 
          localtu.YZq = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 6: 
          localtu.YZr = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 7: 
          localtu.RIc = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 8: 
          localtu.RIb = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 9: 
          localtu.md5 = locala.ajGk.readString();
          AppMethodBeat.o(259755);
          return 0;
        case 10: 
          localtu.YZs = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 11: 
          localtu.YZt = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 12: 
          localtu.YZu = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 13: 
          localtu.YZv = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 14: 
          localtu.YZw = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        case 15: 
          localtu.YZx = locala.ajGk.aar();
          AppMethodBeat.o(259755);
          return 0;
        }
        localtu.YZy = locala.ajGk.aar();
        AppMethodBeat.o(259755);
        return 0;
      }
      AppMethodBeat.o(259755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tu
 * JD-Core Version:    0.7.0.1
 */