package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aat
  extends com.tencent.mm.bv.a
{
  public int wRl;
  public String wRm;
  public String wRn;
  public String wRo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28395);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wRl);
      if (this.wRm != null) {
        paramVarArgs.e(2, this.wRm);
      }
      if (this.wRn != null) {
        paramVarArgs.e(3, this.wRn);
      }
      if (this.wRo != null) {
        paramVarArgs.e(4, this.wRo);
      }
      AppMethodBeat.o(28395);
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
      if (this.wRn != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wRn);
      }
      paramInt = i;
      if (this.wRo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wRo);
      }
      AppMethodBeat.o(28395);
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
      AppMethodBeat.o(28395);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aat localaat = (aat)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28395);
        return -1;
      case 1: 
        localaat.wRl = locala.CLY.sl();
        AppMethodBeat.o(28395);
        return 0;
      case 2: 
        localaat.wRm = locala.CLY.readString();
        AppMethodBeat.o(28395);
        return 0;
      case 3: 
        localaat.wRn = locala.CLY.readString();
        AppMethodBeat.o(28395);
        return 0;
      }
      localaat.wRo = locala.CLY.readString();
      AppMethodBeat.o(28395);
      return 0;
    }
    AppMethodBeat.o(28395);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aat
 * JD-Core Version:    0.7.0.1
 */