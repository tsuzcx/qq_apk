package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qh
  extends com.tencent.mm.cd.a
{
  public String RTk;
  public int RVC;
  public int RVD;
  public int RYC;
  public String RYD;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RVC);
      paramVarArgs.aY(2, this.RVD);
      paramVarArgs.aY(3, this.RYC);
      if (this.fwr != null) {
        paramVarArgs.f(4, this.fwr);
      }
      if (this.RYD != null) {
        paramVarArgs.f(5, this.RYD);
      }
      if (this.RTk != null) {
        paramVarArgs.f(6, this.RTk);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RVC) + 0 + g.a.a.b.b.a.bM(2, this.RVD) + g.a.a.b.b.a.bM(3, this.RYC);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fwr);
      }
      i = paramInt;
      if (this.RYD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RYD);
      }
      paramInt = i;
      if (this.RTk != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RTk);
      }
      AppMethodBeat.o(124464);
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
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      qh localqh = (qh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localqh.RVC = locala.abFh.AK();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localqh.RVD = locala.abFh.AK();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localqh.RYC = locala.abFh.AK();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localqh.fwr = locala.abFh.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localqh.RYD = locala.abFh.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localqh.RTk = locala.abFh.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qh
 * JD-Core Version:    0.7.0.1
 */