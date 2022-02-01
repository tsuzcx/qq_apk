package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxc
  extends com.tencent.mm.bx.a
{
  public long DVk;
  public String ZRn;
  public int aafR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258385);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DVk);
      if (this.ZRn != null) {
        paramVarArgs.g(2, this.ZRn);
      }
      paramVarArgs.bS(3, this.aafR);
      AppMethodBeat.o(258385);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.DVk) + 0;
      paramInt = i;
      if (this.ZRn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZRn);
      }
      i = i.a.a.b.b.a.cJ(3, this.aafR);
      AppMethodBeat.o(258385);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258385);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bxc localbxc = (bxc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258385);
        return -1;
      case 1: 
        localbxc.DVk = locala.ajGk.aaw();
        AppMethodBeat.o(258385);
        return 0;
      case 2: 
        localbxc.ZRn = locala.ajGk.readString();
        AppMethodBeat.o(258385);
        return 0;
      }
      localbxc.aafR = locala.ajGk.aar();
      AppMethodBeat.o(258385);
      return 0;
    }
    AppMethodBeat.o(258385);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxc
 * JD-Core Version:    0.7.0.1
 */