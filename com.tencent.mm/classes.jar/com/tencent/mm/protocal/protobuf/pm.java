package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pm
  extends com.tencent.mm.bw.a
{
  public String FYs;
  public int GaB;
  public int GaC;
  public int Gdb;
  public String Gdc;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GaB);
      paramVarArgs.aS(2, this.GaC);
      paramVarArgs.aS(3, this.Gdb);
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Gdc != null) {
        paramVarArgs.d(5, this.Gdc);
      }
      if (this.FYs != null) {
        paramVarArgs.d(6, this.FYs);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GaB) + 0 + f.a.a.b.b.a.bz(2, this.GaC) + f.a.a.b.b.a.bz(3, this.Gdb);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Gdc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gdc);
      }
      paramInt = i;
      if (this.FYs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FYs);
      }
      AppMethodBeat.o(124464);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pm localpm = (pm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localpm.GaB = locala.OmT.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localpm.GaC = locala.OmT.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localpm.Gdb = locala.OmT.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localpm.Title = locala.OmT.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localpm.Gdc = locala.OmT.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localpm.FYs = locala.OmT.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pm
 * JD-Core Version:    0.7.0.1
 */