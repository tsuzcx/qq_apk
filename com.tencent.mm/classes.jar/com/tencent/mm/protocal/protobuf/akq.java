package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akq
  extends com.tencent.mm.bx.a
{
  public float Dmm;
  public long feedId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.feedId);
      paramVarArgs.x(2, this.Dmm);
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.feedId);
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(184208);
      return paramInt + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akq localakq = (akq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184208);
        return -1;
      case 1: 
        localakq.feedId = locala.KhF.xT();
        AppMethodBeat.o(184208);
        return 0;
      }
      localakq.Dmm = Float.intBitsToFloat(locala.KhF.fHx());
      AppMethodBeat.o(184208);
      return 0;
    }
    AppMethodBeat.o(184208);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akq
 * JD-Core Version:    0.7.0.1
 */