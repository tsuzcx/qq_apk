package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqn
  extends com.tencent.mm.cd.a
{
  public long RMZ;
  public long RNc;
  public int UsY;
  public String UsZ;
  public int Uta;
  public int Utb;
  public int Utc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RNc);
      paramVarArgs.aY(2, this.UsY);
      if (this.UsZ != null) {
        paramVarArgs.f(3, this.UsZ);
      }
      paramVarArgs.bm(4, this.RMZ);
      paramVarArgs.aY(5, this.Uta);
      paramVarArgs.aY(6, this.Utb);
      paramVarArgs.aY(7, this.Utc);
      AppMethodBeat.o(233939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.RNc) + 0 + g.a.a.b.b.a.bM(2, this.UsY);
      paramInt = i;
      if (this.UsZ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UsZ);
      }
      i = g.a.a.b.b.a.p(4, this.RMZ);
      int j = g.a.a.b.b.a.bM(5, this.Uta);
      int k = g.a.a.b.b.a.bM(6, this.Utb);
      int m = g.a.a.b.b.a.bM(7, this.Utc);
      AppMethodBeat.o(233939);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(233939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqn localeqn = (eqn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(233939);
        return -1;
      case 1: 
        localeqn.RNc = locala.abFh.AN();
        AppMethodBeat.o(233939);
        return 0;
      case 2: 
        localeqn.UsY = locala.abFh.AK();
        AppMethodBeat.o(233939);
        return 0;
      case 3: 
        localeqn.UsZ = locala.abFh.readString();
        AppMethodBeat.o(233939);
        return 0;
      case 4: 
        localeqn.RMZ = locala.abFh.AN();
        AppMethodBeat.o(233939);
        return 0;
      case 5: 
        localeqn.Uta = locala.abFh.AK();
        AppMethodBeat.o(233939);
        return 0;
      case 6: 
        localeqn.Utb = locala.abFh.AK();
        AppMethodBeat.o(233939);
        return 0;
      }
      localeqn.Utc = locala.abFh.AK();
      AppMethodBeat.o(233939);
      return 0;
    }
    AppMethodBeat.o(233939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqn
 * JD-Core Version:    0.7.0.1
 */