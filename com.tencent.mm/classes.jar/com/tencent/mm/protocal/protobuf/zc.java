package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zc
  extends com.tencent.mm.bv.a
{
  public boolean wPY;
  public boolean wPZ;
  public String wQa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89065);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wPY);
      paramVarArgs.aS(2, this.wPZ);
      if (this.wQa != null) {
        paramVarArgs.e(3, this.wQa);
      }
      AppMethodBeat.o(89065);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0 + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.wQa != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wQa);
      }
      AppMethodBeat.o(89065);
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
      AppMethodBeat.o(89065);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      zc localzc = (zc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89065);
        return -1;
      case 1: 
        localzc.wPY = locala.CLY.emu();
        AppMethodBeat.o(89065);
        return 0;
      case 2: 
        localzc.wPZ = locala.CLY.emu();
        AppMethodBeat.o(89065);
        return 0;
      }
      localzc.wQa = locala.CLY.readString();
      AppMethodBeat.o(89065);
      return 0;
    }
    AppMethodBeat.o(89065);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zc
 * JD-Core Version:    0.7.0.1
 */