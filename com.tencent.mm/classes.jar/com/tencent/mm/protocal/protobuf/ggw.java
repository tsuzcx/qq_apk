package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggw
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public int YJz;
  public long YKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32561);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      paramVarArgs.bS(2, this.YJz);
      paramVarArgs.bv(3, this.YKx);
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Idd);
      int i = i.a.a.b.b.a.cJ(2, this.YJz);
      int j = i.a.a.b.b.a.q(3, this.YKx);
      AppMethodBeat.o(32561);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ggw localggw = (ggw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32561);
        return -1;
      case 1: 
        localggw.Idd = locala.ajGk.aar();
        AppMethodBeat.o(32561);
        return 0;
      case 2: 
        localggw.YJz = locala.ajGk.aar();
        AppMethodBeat.o(32561);
        return 0;
      }
      localggw.YKx = locala.ajGk.aaw();
      AppMethodBeat.o(32561);
      return 0;
    }
    AppMethodBeat.o(32561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggw
 * JD-Core Version:    0.7.0.1
 */