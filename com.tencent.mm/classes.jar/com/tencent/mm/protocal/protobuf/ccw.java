package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccw
  extends com.tencent.mm.bx.a
{
  public long aaml;
  public int aamm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257677);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaml);
      paramVarArgs.bS(2, this.aamm);
      AppMethodBeat.o(257677);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaml);
      int i = i.a.a.b.b.a.cJ(2, this.aamm);
      AppMethodBeat.o(257677);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257677);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ccw localccw = (ccw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257677);
        return -1;
      case 1: 
        localccw.aaml = locala.ajGk.aaw();
        AppMethodBeat.o(257677);
        return 0;
      }
      localccw.aamm = locala.ajGk.aar();
      AppMethodBeat.o(257677);
      return 0;
    }
    AppMethodBeat.o(257677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccw
 * JD-Core Version:    0.7.0.1
 */