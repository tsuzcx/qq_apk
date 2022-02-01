package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fes
  extends com.tencent.mm.cd.a
{
  public int NMJ;
  public int NMK;
  public String fJS;
  public int rZU;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rZU);
      paramVarArgs.aY(2, this.NMK);
      paramVarArgs.aY(3, this.NMJ);
      if (this.userName != null) {
        paramVarArgs.f(4, this.userName);
      }
      if (this.fJS != null) {
        paramVarArgs.f(5, this.fJS);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rZU) + 0 + g.a.a.b.b.a.bM(2, this.NMK) + g.a.a.b.b.a.bM(3, this.NMJ);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.userName);
      }
      i = paramInt;
      if (this.fJS != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fJS);
      }
      AppMethodBeat.o(115904);
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
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fes localfes = (fes)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localfes.rZU = locala.abFh.AK();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localfes.NMK = locala.abFh.AK();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localfes.NMJ = locala.abFh.AK();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localfes.userName = locala.abFh.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localfes.fJS = locala.abFh.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fes
 * JD-Core Version:    0.7.0.1
 */