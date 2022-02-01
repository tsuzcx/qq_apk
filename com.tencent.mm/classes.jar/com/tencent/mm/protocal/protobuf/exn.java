package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exn
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public int HmZ;
  public int Hna;
  public String MD5;
  public String TdZ;
  public boolean UxR;
  public boolean UxS = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      paramVarArgs.aY(2, this.Hna);
      paramVarArgs.aY(3, this.HmZ);
      if (this.MD5 != null) {
        paramVarArgs.f(4, this.MD5);
      }
      paramVarArgs.co(5, this.UxR);
      if (this.TdZ != null) {
        paramVarArgs.f(6, this.TdZ);
      }
      paramVarArgs.co(7, this.UxS);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CqV) + 0 + g.a.a.b.b.a.bM(2, this.Hna) + g.a.a.b.b.a.bM(3, this.HmZ);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.MD5);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.TdZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TdZ);
      }
      i = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(104841);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      exn localexn = (exn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localexn.CqV = locala.abFh.AK();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localexn.Hna = locala.abFh.AK();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localexn.HmZ = locala.abFh.AK();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localexn.MD5 = locala.abFh.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localexn.UxR = locala.abFh.AB();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localexn.TdZ = locala.abFh.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localexn.UxS = locala.abFh.AB();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exn
 * JD-Core Version:    0.7.0.1
 */