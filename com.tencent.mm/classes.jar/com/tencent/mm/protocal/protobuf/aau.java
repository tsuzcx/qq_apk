package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aau
  extends com.tencent.mm.bv.a
{
  public int wRl;
  public String wRm;
  public String wRn;
  public String wRo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28396);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wRl);
      if (this.wRm != null) {
        paramVarArgs.e(2, this.wRm);
      }
      if (this.wRo != null) {
        paramVarArgs.e(3, this.wRo);
      }
      if (this.wRn != null) {
        paramVarArgs.e(4, this.wRn);
      }
      AppMethodBeat.o(28396);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wRl) + 0;
      paramInt = i;
      if (this.wRm != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wRm);
      }
      i = paramInt;
      if (this.wRo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wRo);
      }
      paramInt = i;
      if (this.wRn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wRn);
      }
      AppMethodBeat.o(28396);
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
      AppMethodBeat.o(28396);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aau localaau = (aau)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28396);
        return -1;
      case 1: 
        localaau.wRl = locala.CLY.sl();
        AppMethodBeat.o(28396);
        return 0;
      case 2: 
        localaau.wRm = locala.CLY.readString();
        AppMethodBeat.o(28396);
        return 0;
      case 3: 
        localaau.wRo = locala.CLY.readString();
        AppMethodBeat.o(28396);
        return 0;
      }
      localaau.wRn = locala.CLY.readString();
      AppMethodBeat.o(28396);
      return 0;
    }
    AppMethodBeat.o(28396);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */