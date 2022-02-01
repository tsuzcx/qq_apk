package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuq
  extends com.tencent.mm.cd.a
{
  public String Sas;
  public long TCr;
  public long TCs;
  public String Tkw;
  public int rWu;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.scene);
      if (this.Tkw != null) {
        paramVarArgs.f(2, this.Tkw);
      }
      paramVarArgs.bm(3, this.TCr);
      paramVarArgs.bm(4, this.TCs);
      if (this.Sas != null) {
        paramVarArgs.f(5, this.Sas);
      }
      paramVarArgs.aY(6, this.rWu);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.scene) + 0;
      paramInt = i;
      if (this.Tkw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tkw);
      }
      i = paramInt + g.a.a.b.b.a.p(3, this.TCr) + g.a.a.b.b.a.p(4, this.TCs);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sas);
      }
      i = g.a.a.b.b.a.bM(6, this.rWu);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cuq localcuq = (cuq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localcuq.scene = locala.abFh.AK();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localcuq.Tkw = locala.abFh.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localcuq.TCr = locala.abFh.AN();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localcuq.TCs = locala.abFh.AN();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localcuq.Sas = locala.abFh.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localcuq.rWu = locala.abFh.AK();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuq
 * JD-Core Version:    0.7.0.1
 */