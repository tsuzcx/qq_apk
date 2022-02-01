package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glb
  extends com.tencent.mm.bx.a
{
  public int YFv;
  public int aaQX;
  public int acgK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123703);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaQX);
      paramVarArgs.bS(2, this.YFv);
      paramVarArgs.bS(3, this.acgK);
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaQX);
      int i = i.a.a.b.b.a.cJ(2, this.YFv);
      int j = i.a.a.b.b.a.cJ(3, this.acgK);
      AppMethodBeat.o(123703);
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
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glb localglb = (glb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123703);
        return -1;
      case 1: 
        localglb.aaQX = locala.ajGk.aar();
        AppMethodBeat.o(123703);
        return 0;
      case 2: 
        localglb.YFv = locala.ajGk.aar();
        AppMethodBeat.o(123703);
        return 0;
      }
      localglb.acgK = locala.ajGk.aar();
      AppMethodBeat.o(123703);
      return 0;
    }
    AppMethodBeat.o(123703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glb
 * JD-Core Version:    0.7.0.1
 */