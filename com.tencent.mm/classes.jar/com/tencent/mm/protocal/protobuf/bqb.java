package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqb
  extends com.tencent.mm.bx.a
{
  public long ZXZ;
  public int hYl;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257787);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZXZ);
      paramVarArgs.bS(2, this.hYl);
      if (this.objectNonceId != null) {
        paramVarArgs.g(3, this.objectNonceId);
      }
      AppMethodBeat.o(257787);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZXZ) + 0 + i.a.a.b.b.a.cJ(2, this.hYl);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.objectNonceId);
      }
      AppMethodBeat.o(257787);
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
      AppMethodBeat.o(257787);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bqb localbqb = (bqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257787);
        return -1;
      case 1: 
        localbqb.ZXZ = locala.ajGk.aaw();
        AppMethodBeat.o(257787);
        return 0;
      case 2: 
        localbqb.hYl = locala.ajGk.aar();
        AppMethodBeat.o(257787);
        return 0;
      }
      localbqb.objectNonceId = locala.ajGk.readString();
      AppMethodBeat.o(257787);
      return 0;
    }
    AppMethodBeat.o(257787);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqb
 * JD-Core Version:    0.7.0.1
 */