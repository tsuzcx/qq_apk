package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmh
  extends com.tencent.mm.cd.a
{
  public float GtO;
  public float TTJ;
  public float TTK;
  public float TTL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.GtO);
      paramVarArgs.i(2, this.TTJ);
      paramVarArgs.i(3, this.TTK);
      paramVarArgs.i(4, this.TTL);
      AppMethodBeat.o(200433);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(200433);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200433);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dmh localdmh = (dmh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200433);
        return -1;
      case 1: 
        localdmh.GtO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(200433);
        return 0;
      case 2: 
        localdmh.TTJ = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(200433);
        return 0;
      case 3: 
        localdmh.TTK = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(200433);
        return 0;
      }
      localdmh.TTL = Float.intBitsToFloat(locala.abFh.AO());
      AppMethodBeat.o(200433);
      return 0;
    }
    AppMethodBeat.o(200433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmh
 * JD-Core Version:    0.7.0.1
 */