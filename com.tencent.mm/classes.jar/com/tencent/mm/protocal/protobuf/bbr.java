package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbr
  extends com.tencent.mm.bx.a
{
  public int ZMk;
  public int ZMl;
  public String ZMm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259519);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZMk);
      paramVarArgs.bS(2, this.ZMl);
      if (this.ZMm != null) {
        paramVarArgs.g(3, this.ZMm);
      }
      AppMethodBeat.o(259519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZMk) + 0 + i.a.a.b.b.a.cJ(2, this.ZMl);
      paramInt = i;
      if (this.ZMm != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZMm);
      }
      AppMethodBeat.o(259519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259519);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bbr localbbr = (bbr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259519);
        return -1;
      case 1: 
        localbbr.ZMk = locala.ajGk.aar();
        AppMethodBeat.o(259519);
        return 0;
      case 2: 
        localbbr.ZMl = locala.ajGk.aar();
        AppMethodBeat.o(259519);
        return 0;
      }
      localbbr.ZMm = locala.ajGk.readString();
      AppMethodBeat.o(259519);
      return 0;
    }
    AppMethodBeat.o(259519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbr
 * JD-Core Version:    0.7.0.1
 */