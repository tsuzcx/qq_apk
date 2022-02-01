package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cub
  extends com.tencent.mm.cd.a
{
  public long TBJ;
  public long TBK;
  public long TBL;
  public int fod;
  public long liveId;
  public long yNv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231302);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.yNv);
      paramVarArgs.bm(2, this.TBJ);
      paramVarArgs.aY(3, this.fod);
      paramVarArgs.bm(4, this.liveId);
      paramVarArgs.bm(5, this.TBK);
      paramVarArgs.bm(6, this.TBL);
      AppMethodBeat.o(231302);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.yNv);
      int i = g.a.a.b.b.a.p(2, this.TBJ);
      int j = g.a.a.b.b.a.bM(3, this.fod);
      int k = g.a.a.b.b.a.p(4, this.liveId);
      int m = g.a.a.b.b.a.p(5, this.TBK);
      int n = g.a.a.b.b.a.p(6, this.TBL);
      AppMethodBeat.o(231302);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(231302);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cub localcub = (cub)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(231302);
        return -1;
      case 1: 
        localcub.yNv = locala.abFh.AN();
        AppMethodBeat.o(231302);
        return 0;
      case 2: 
        localcub.TBJ = locala.abFh.AN();
        AppMethodBeat.o(231302);
        return 0;
      case 3: 
        localcub.fod = locala.abFh.AK();
        AppMethodBeat.o(231302);
        return 0;
      case 4: 
        localcub.liveId = locala.abFh.AN();
        AppMethodBeat.o(231302);
        return 0;
      case 5: 
        localcub.TBK = locala.abFh.AN();
        AppMethodBeat.o(231302);
        return 0;
      }
      localcub.TBL = locala.abFh.AN();
      AppMethodBeat.o(231302);
      return 0;
    }
    AppMethodBeat.o(231302);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cub
 * JD-Core Version:    0.7.0.1
 */