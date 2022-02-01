package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aks
  extends com.tencent.mm.cd.a
{
  public int IfZ;
  public String Iga;
  public String Igb;
  public int Igc;
  public String lmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.IfZ);
      if (this.Iga != null) {
        paramVarArgs.f(2, this.Iga);
      }
      if (this.Igb != null) {
        paramVarArgs.f(3, this.Igb);
      }
      paramVarArgs.aY(4, this.Igc);
      if (this.lmL != null) {
        paramVarArgs.f(5, this.lmL);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.IfZ) + 0;
      paramInt = i;
      if (this.Iga != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Iga);
      }
      i = paramInt;
      if (this.Igb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Igb);
      }
      i += g.a.a.b.b.a.bM(4, this.Igc);
      paramInt = i;
      if (this.lmL != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.lmL);
      }
      AppMethodBeat.o(72474);
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
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aks localaks = (aks)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localaks.IfZ = locala.abFh.AK();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localaks.Iga = locala.abFh.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localaks.Igb = locala.abFh.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localaks.Igc = locala.abFh.AK();
        AppMethodBeat.o(72474);
        return 0;
      }
      localaks.lmL = locala.abFh.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aks
 * JD-Core Version:    0.7.0.1
 */