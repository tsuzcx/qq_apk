package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxy
  extends com.tencent.mm.cd.a
{
  public int Iza;
  public String RIi;
  public int TGd;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIi != null) {
        paramVarArgs.f(1, this.RIi);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.TGd);
      paramVarArgs.aY(4, this.Iza);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIi == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.RIi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TGd);
      int j = g.a.a.b.b.a.bM(4, this.Iza);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxy localcxy = (cxy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localcxy.RIi = locala.abFh.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localcxy.UserName = locala.abFh.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localcxy.TGd = locala.abFh.AK();
          AppMethodBeat.o(101826);
          return 0;
        }
        localcxy.Iza = locala.abFh.AK();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxy
 * JD-Core Version:    0.7.0.1
 */