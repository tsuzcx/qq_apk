package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byg
  extends com.tencent.mm.bx.a
{
  public int hJx;
  public long hKN;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257988);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.hKN);
      if (this.objectNonceId != null) {
        paramVarArgs.g(2, this.objectNonceId);
      }
      paramVarArgs.bS(3, this.hJx);
      if (this.sessionBuffer != null) {
        paramVarArgs.g(4, this.sessionBuffer);
      }
      AppMethodBeat.o(257988);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.hKN) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.hJx);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.sessionBuffer);
      }
      AppMethodBeat.o(257988);
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
      AppMethodBeat.o(257988);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      byg localbyg = (byg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257988);
        return -1;
      case 1: 
        localbyg.hKN = locala.ajGk.aaw();
        AppMethodBeat.o(257988);
        return 0;
      case 2: 
        localbyg.objectNonceId = locala.ajGk.readString();
        AppMethodBeat.o(257988);
        return 0;
      case 3: 
        localbyg.hJx = locala.ajGk.aar();
        AppMethodBeat.o(257988);
        return 0;
      }
      localbyg.sessionBuffer = locala.ajGk.readString();
      AppMethodBeat.o(257988);
      return 0;
    }
    AppMethodBeat.o(257988);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byg
 * JD-Core Version:    0.7.0.1
 */