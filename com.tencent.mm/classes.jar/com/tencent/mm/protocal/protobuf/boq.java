package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boq
  extends com.tencent.mm.bv.a
{
  public int lGK;
  public String lGL;
  public int nNf;
  public String nNg;
  public int xCK;
  public int xCL;
  public int xCM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28595);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xCL);
      paramVarArgs.aO(2, this.xCM);
      paramVarArgs.aO(3, this.xCK);
      paramVarArgs.aO(4, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(5, this.lGL);
      }
      paramVarArgs.aO(6, this.nNf);
      if (this.nNg != null) {
        paramVarArgs.e(7, this.nNg);
      }
      AppMethodBeat.o(28595);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xCL) + 0 + e.a.a.b.b.a.bl(2, this.xCM) + e.a.a.b.b.a.bl(3, this.xCK) + e.a.a.b.b.a.bl(4, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.lGL);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.nNf);
      paramInt = i;
      if (this.nNg != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nNg);
      }
      AppMethodBeat.o(28595);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28595);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      boq localboq = (boq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28595);
        return -1;
      case 1: 
        localboq.xCL = locala.CLY.sl();
        AppMethodBeat.o(28595);
        return 0;
      case 2: 
        localboq.xCM = locala.CLY.sl();
        AppMethodBeat.o(28595);
        return 0;
      case 3: 
        localboq.xCK = locala.CLY.sl();
        AppMethodBeat.o(28595);
        return 0;
      case 4: 
        localboq.lGK = locala.CLY.sl();
        AppMethodBeat.o(28595);
        return 0;
      case 5: 
        localboq.lGL = locala.CLY.readString();
        AppMethodBeat.o(28595);
        return 0;
      case 6: 
        localboq.nNf = locala.CLY.sl();
        AppMethodBeat.o(28595);
        return 0;
      }
      localboq.nNg = locala.CLY.readString();
      AppMethodBeat.o(28595);
      return 0;
    }
    AppMethodBeat.o(28595);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */