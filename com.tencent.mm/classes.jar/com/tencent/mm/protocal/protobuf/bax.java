package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bax
  extends com.tencent.mm.bw.a
{
  public float LKC;
  public long feedId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184208);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.feedId);
      paramVarArgs.E(2, this.LKC);
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.feedId);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(184208);
      return paramInt + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bax localbax = (bax)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184208);
        return -1;
      case 1: 
        localbax.feedId = locala.UbS.zl();
        AppMethodBeat.o(184208);
        return 0;
      }
      localbax.LKC = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(184208);
      return 0;
    }
    AppMethodBeat.o(184208);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bax
 * JD-Core Version:    0.7.0.1
 */