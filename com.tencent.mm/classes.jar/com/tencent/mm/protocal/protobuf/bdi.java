package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdi
  extends com.tencent.mm.cd.a
{
  public int SOq;
  public int bitrate;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200242);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.percent);
      paramVarArgs.aY(3, this.SOq);
      paramVarArgs.aY(4, this.bitrate);
      AppMethodBeat.o(200242);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.type);
      int i = g.a.a.b.b.a.bM(2, this.percent);
      int j = g.a.a.b.b.a.bM(3, this.SOq);
      int k = g.a.a.b.b.a.bM(4, this.bitrate);
      AppMethodBeat.o(200242);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200242);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bdi localbdi = (bdi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200242);
        return -1;
      case 1: 
        localbdi.type = locala.abFh.AK();
        AppMethodBeat.o(200242);
        return 0;
      case 2: 
        localbdi.percent = locala.abFh.AK();
        AppMethodBeat.o(200242);
        return 0;
      case 3: 
        localbdi.SOq = locala.abFh.AK();
        AppMethodBeat.o(200242);
        return 0;
      }
      localbdi.bitrate = locala.abFh.AK();
      AppMethodBeat.o(200242);
      return 0;
    }
    AppMethodBeat.o(200242);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdi
 * JD-Core Version:    0.7.0.1
 */