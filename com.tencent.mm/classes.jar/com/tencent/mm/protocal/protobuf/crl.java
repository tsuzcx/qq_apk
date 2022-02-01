package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crl
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public String Srb;
  public String Tyw;
  public String Tyx;
  public long klE;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189300);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.klE);
      if (this.Tyw != null) {
        paramVarArgs.f(2, this.Tyw);
      }
      paramVarArgs.aY(3, this.rotation);
      if (this.Srb != null) {
        paramVarArgs.f(4, this.Srb);
      }
      paramVarArgs.aY(5, this.ChC);
      if (this.Tyx != null) {
        paramVarArgs.f(6, this.Tyx);
      }
      AppMethodBeat.o(189300);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.klE) + 0;
      paramInt = i;
      if (this.Tyw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tyw);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.rotation);
      paramInt = i;
      if (this.Srb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Srb);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.ChC);
      paramInt = i;
      if (this.Tyx != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tyx);
      }
      AppMethodBeat.o(189300);
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
      AppMethodBeat.o(189300);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crl localcrl = (crl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189300);
        return -1;
      case 1: 
        localcrl.klE = locala.abFh.AN();
        AppMethodBeat.o(189300);
        return 0;
      case 2: 
        localcrl.Tyw = locala.abFh.readString();
        AppMethodBeat.o(189300);
        return 0;
      case 3: 
        localcrl.rotation = locala.abFh.AK();
        AppMethodBeat.o(189300);
        return 0;
      case 4: 
        localcrl.Srb = locala.abFh.readString();
        AppMethodBeat.o(189300);
        return 0;
      case 5: 
        localcrl.ChC = locala.abFh.AK();
        AppMethodBeat.o(189300);
        return 0;
      }
      localcrl.Tyx = locala.abFh.readString();
      AppMethodBeat.o(189300);
      return 0;
    }
    AppMethodBeat.o(189300);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crl
 * JD-Core Version:    0.7.0.1
 */