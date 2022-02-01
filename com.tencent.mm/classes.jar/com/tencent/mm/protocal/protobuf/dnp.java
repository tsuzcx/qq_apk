package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnp
  extends com.tencent.mm.bx.a
{
  public float aaaZ;
  public long feedId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258583);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.feedId);
      paramVarArgs.l(2, this.aaaZ);
      AppMethodBeat.o(258583);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.feedId);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(258583);
      return paramInt + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258583);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dnp localdnp = (dnp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258583);
        return -1;
      case 1: 
        localdnp.feedId = locala.ajGk.aaw();
        AppMethodBeat.o(258583);
        return 0;
      }
      localdnp.aaaZ = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(258583);
      return 0;
    }
    AppMethodBeat.o(258583);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnp
 * JD-Core Version:    0.7.0.1
 */