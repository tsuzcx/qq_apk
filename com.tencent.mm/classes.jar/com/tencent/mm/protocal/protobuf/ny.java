package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ny
  extends com.tencent.mm.bx.a
{
  public String CHL;
  public int CJH;
  public int CJI;
  public int CLA;
  public String CLB;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CJH);
      paramVarArgs.aR(2, this.CJI);
      paramVarArgs.aR(3, this.CLA);
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.CLB != null) {
        paramVarArgs.d(5, this.CLB);
      }
      if (this.CHL != null) {
        paramVarArgs.d(6, this.CHL);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CJH) + 0 + f.a.a.b.b.a.bA(2, this.CJI) + f.a.a.b.b.a.bA(3, this.CLA);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.CLB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CLB);
      }
      paramInt = i;
      if (this.CHL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CHL);
      }
      AppMethodBeat.o(124464);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ny localny = (ny)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localny.CJH = locala.KhF.xS();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localny.CJI = locala.KhF.xS();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localny.CLA = locala.KhF.xS();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localny.Title = locala.KhF.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localny.CLB = locala.KhF.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localny.CHL = locala.KhF.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ny
 * JD-Core Version:    0.7.0.1
 */