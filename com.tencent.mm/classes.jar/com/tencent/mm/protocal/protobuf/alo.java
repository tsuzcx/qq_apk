package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alo
  extends com.tencent.mm.cd.a
{
  public int SvO;
  public int SvP;
  public int SvQ;
  public String SvR;
  public int SvS;
  public String SvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvO);
      paramVarArgs.aY(2, this.SvP);
      paramVarArgs.aY(3, this.SvQ);
      if (this.SvR != null) {
        paramVarArgs.f(4, this.SvR);
      }
      paramVarArgs.aY(5, this.SvS);
      if (this.SvT != null) {
        paramVarArgs.f(6, this.SvT);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SvO) + 0 + g.a.a.b.b.a.bM(2, this.SvP) + g.a.a.b.b.a.bM(3, this.SvQ);
      paramInt = i;
      if (this.SvR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SvR);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SvS);
      paramInt = i;
      if (this.SvT != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SvT);
      }
      AppMethodBeat.o(122488);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      alo localalo = (alo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localalo.SvO = locala.abFh.AK();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localalo.SvP = locala.abFh.AK();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localalo.SvQ = locala.abFh.AK();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localalo.SvR = locala.abFh.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localalo.SvS = locala.abFh.AK();
        AppMethodBeat.o(122488);
        return 0;
      }
      localalo.SvT = locala.abFh.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alo
 * JD-Core Version:    0.7.0.1
 */