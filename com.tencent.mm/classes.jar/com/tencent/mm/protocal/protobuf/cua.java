package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cua
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int RTb;
  public int TBF;
  public int TBG;
  public String TBH;
  public int TBI;
  public int TuP;
  public String appid;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.aY(3, this.TuP);
      paramVarArgs.aY(4, this.RTb);
      paramVarArgs.aY(5, this.CPw);
      paramVarArgs.aY(6, this.TBF);
      paramVarArgs.aY(7, this.TBG);
      if (this.TBH != null) {
        paramVarArgs.f(8, this.TBH);
      }
      paramVarArgs.aY(9, this.TBI);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TuP) + g.a.a.b.b.a.bM(4, this.RTb) + g.a.a.b.b.a.bM(5, this.CPw) + g.a.a.b.b.a.bM(6, this.TBF) + g.a.a.b.b.a.bM(7, this.TBG);
      paramInt = i;
      if (this.TBH != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TBH);
      }
      i = g.a.a.b.b.a.bM(9, this.TBI);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cua localcua = (cua)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localcua.appid = locala.abFh.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localcua.username = locala.abFh.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localcua.TuP = locala.abFh.AK();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localcua.RTb = locala.abFh.AK();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localcua.CPw = locala.abFh.AK();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localcua.TBF = locala.abFh.AK();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localcua.TBG = locala.abFh.AK();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localcua.TBH = locala.abFh.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localcua.TBI = locala.abFh.AK();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cua
 * JD-Core Version:    0.7.0.1
 */