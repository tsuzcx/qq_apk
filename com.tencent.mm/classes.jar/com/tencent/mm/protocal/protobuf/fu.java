package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fu
  extends com.tencent.mm.cd.a
{
  public long RKR;
  public String Url;
  public String lps;
  public int lpw;
  public int lpx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lps != null) {
        paramVarArgs.f(1, this.lps);
      }
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      paramVarArgs.aY(3, this.lpw);
      paramVarArgs.aY(4, this.lpx);
      paramVarArgs.bm(5, this.RKR);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lps == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.g(1, this.lps) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Url);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.lpw);
      int j = g.a.a.b.b.a.bM(4, this.lpx);
      int k = g.a.a.b.b.a.p(5, this.RKR);
      AppMethodBeat.o(124391);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localfu.lps = locala.abFh.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localfu.Url = locala.abFh.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localfu.lpw = locala.abFh.AK();
          AppMethodBeat.o(124391);
          return 0;
        case 4: 
          localfu.lpx = locala.abFh.AK();
          AppMethodBeat.o(124391);
          return 0;
        }
        localfu.RKR = locala.abFh.AN();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */