package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class emx
  extends com.tencent.mm.cd.a
{
  public int Svi;
  public int UpE;
  public int UpF;
  public int UpG;
  public int UpH;
  public int UpI;
  public int UpJ;
  public String jUb;
  public int rWs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWs);
      paramVarArgs.aY(2, this.Svi);
      paramVarArgs.aY(3, this.UpE);
      paramVarArgs.aY(4, this.UpF);
      paramVarArgs.aY(5, this.UpG);
      paramVarArgs.aY(6, this.UpH);
      paramVarArgs.aY(7, this.UpI);
      paramVarArgs.aY(8, this.UpJ);
      if (this.jUb != null) {
        paramVarArgs.f(9, this.jUb);
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWs) + 0 + g.a.a.b.b.a.bM(2, this.Svi) + g.a.a.b.b.a.bM(3, this.UpE) + g.a.a.b.b.a.bM(4, this.UpF) + g.a.a.b.b.a.bM(5, this.UpG) + g.a.a.b.b.a.bM(6, this.UpH) + g.a.a.b.b.a.bM(7, this.UpI) + g.a.a.b.b.a.bM(8, this.UpJ);
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.jUb);
      }
      AppMethodBeat.o(32457);
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
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      emx localemx = (emx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localemx.rWs = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localemx.Svi = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localemx.UpE = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localemx.UpF = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localemx.UpG = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localemx.UpH = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localemx.UpI = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      case 8: 
        localemx.UpJ = locala.abFh.AK();
        AppMethodBeat.o(32457);
        return 0;
      }
      localemx.jUb = locala.abFh.readString();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emx
 * JD-Core Version:    0.7.0.1
 */