package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvj
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public String TDk;
  public String TDl;
  public String appid;
  public String ueW;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252765);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.ufC != null) {
        paramVarArgs.f(2, this.ufC);
      }
      if (this.TDk != null) {
        paramVarArgs.f(3, this.TDk);
      }
      if (this.TDl != null) {
        paramVarArgs.f(4, this.TDl);
      }
      paramVarArgs.aY(5, this.RYL);
      if (this.ueW != null) {
        paramVarArgs.f(6, this.ueW);
      }
      AppMethodBeat.o(252765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufC);
      }
      i = paramInt;
      if (this.TDk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TDk);
      }
      paramInt = i;
      if (this.TDl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TDl);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RYL);
      paramInt = i;
      if (this.ueW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ueW);
      }
      AppMethodBeat.o(252765);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(252765);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvj localcvj = (cvj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(252765);
          return -1;
        case 1: 
          localcvj.appid = locala.abFh.readString();
          AppMethodBeat.o(252765);
          return 0;
        case 2: 
          localcvj.ufC = locala.abFh.readString();
          AppMethodBeat.o(252765);
          return 0;
        case 3: 
          localcvj.TDk = locala.abFh.readString();
          AppMethodBeat.o(252765);
          return 0;
        case 4: 
          localcvj.TDl = locala.abFh.readString();
          AppMethodBeat.o(252765);
          return 0;
        case 5: 
          localcvj.RYL = locala.abFh.AK();
          AppMethodBeat.o(252765);
          return 0;
        }
        localcvj.ueW = locala.abFh.readString();
        AppMethodBeat.o(252765);
        return 0;
      }
      AppMethodBeat.o(252765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvj
 * JD-Core Version:    0.7.0.1
 */