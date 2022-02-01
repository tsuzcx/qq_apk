package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crs
  extends com.tencent.mm.bw.a
{
  public long MwJ;
  public long MwK;
  public long MwL;
  public long duration;
  public long hlf;
  public long igp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hlf);
      paramVarArgs.bb(2, this.igp);
      paramVarArgs.bb(3, this.MwJ);
      paramVarArgs.bb(4, this.MwK);
      paramVarArgs.bb(5, this.MwL);
      paramVarArgs.bb(6, this.duration);
      AppMethodBeat.o(208706);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.hlf);
      int i = g.a.a.b.b.a.r(2, this.igp);
      int j = g.a.a.b.b.a.r(3, this.MwJ);
      int k = g.a.a.b.b.a.r(4, this.MwK);
      int m = g.a.a.b.b.a.r(5, this.MwL);
      int n = g.a.a.b.b.a.r(6, this.duration);
      AppMethodBeat.o(208706);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(208706);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crs localcrs = (crs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208706);
        return -1;
      case 1: 
        localcrs.hlf = locala.UbS.zl();
        AppMethodBeat.o(208706);
        return 0;
      case 2: 
        localcrs.igp = locala.UbS.zl();
        AppMethodBeat.o(208706);
        return 0;
      case 3: 
        localcrs.MwJ = locala.UbS.zl();
        AppMethodBeat.o(208706);
        return 0;
      case 4: 
        localcrs.MwK = locala.UbS.zl();
        AppMethodBeat.o(208706);
        return 0;
      case 5: 
        localcrs.MwL = locala.UbS.zl();
        AppMethodBeat.o(208706);
        return 0;
      }
      localcrs.duration = locala.UbS.zl();
      AppMethodBeat.o(208706);
      return 0;
    }
    AppMethodBeat.o(208706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */