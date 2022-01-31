package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dav
  extends com.tencent.mm.bv.a
{
  public float wDh;
  public float wDi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151932);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.wDh);
      paramVarArgs.q(2, this.wDi);
      AppMethodBeat.o(151932);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(151932);
      return paramInt + 4 + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151932);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dav localdav = (dav)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151932);
        return -1;
      case 1: 
        localdav.wDh = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(151932);
        return 0;
      }
      localdav.wDi = Float.intBitsToFloat(locala.CLY.emx());
      AppMethodBeat.o(151932);
      return 0;
    }
    AppMethodBeat.o(151932);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dav
 * JD-Core Version:    0.7.0.1
 */