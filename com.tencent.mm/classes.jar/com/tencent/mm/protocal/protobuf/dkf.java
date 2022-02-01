package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkf
  extends com.tencent.mm.cd.a
{
  public int TRE;
  public String TRF;
  public String lpr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TRE);
      if (this.TRF != null) {
        paramVarArgs.f(2, this.TRF);
      }
      if (this.lpr != null) {
        paramVarArgs.f(3, this.lpr);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TRE) + 0;
      paramInt = i;
      if (this.TRF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TRF);
      }
      i = paramInt;
      if (this.lpr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpr);
      }
      AppMethodBeat.o(124538);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dkf localdkf = (dkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localdkf.TRE = locala.abFh.AK();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localdkf.TRF = locala.abFh.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localdkf.lpr = locala.abFh.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */