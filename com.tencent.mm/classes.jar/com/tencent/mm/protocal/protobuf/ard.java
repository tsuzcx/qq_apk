package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ard
  extends com.tencent.mm.bw.a
{
  public float GHX;
  public long duw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.duw);
      paramVarArgs.y(2, this.GHX);
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.duw);
      int i = f.a.a.b.b.a.amE(2);
      AppMethodBeat.o(184208);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ard localard = (ard)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184208);
        return -1;
      case 1: 
        localard.duw = locala.OmT.zd();
        AppMethodBeat.o(184208);
        return 0;
      }
      localard.GHX = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(184208);
      return 0;
    }
    AppMethodBeat.o(184208);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ard
 * JD-Core Version:    0.7.0.1
 */