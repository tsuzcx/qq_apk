package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dao
  extends com.tencent.mm.cd.a
{
  public long THQ;
  public long THR;
  public long THS;
  public long THT;
  public long duration;
  public long jWO;
  public long kVd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.jWO);
      paramVarArgs.bm(2, this.kVd);
      paramVarArgs.bm(3, this.THQ);
      paramVarArgs.bm(4, this.THR);
      paramVarArgs.bm(5, this.THS);
      paramVarArgs.bm(6, this.duration);
      paramVarArgs.bm(7, this.THT);
      AppMethodBeat.o(205525);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.jWO);
      int i = g.a.a.b.b.a.p(2, this.kVd);
      int j = g.a.a.b.b.a.p(3, this.THQ);
      int k = g.a.a.b.b.a.p(4, this.THR);
      int m = g.a.a.b.b.a.p(5, this.THS);
      int n = g.a.a.b.b.a.p(6, this.duration);
      int i1 = g.a.a.b.b.a.p(7, this.THT);
      AppMethodBeat.o(205525);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205525);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dao localdao = (dao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(205525);
        return -1;
      case 1: 
        localdao.jWO = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      case 2: 
        localdao.kVd = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      case 3: 
        localdao.THQ = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      case 4: 
        localdao.THR = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      case 5: 
        localdao.THS = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      case 6: 
        localdao.duration = locala.abFh.AN();
        AppMethodBeat.o(205525);
        return 0;
      }
      localdao.THT = locala.abFh.AN();
      AppMethodBeat.o(205525);
      return 0;
    }
    AppMethodBeat.o(205525);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dao
 * JD-Core Version:    0.7.0.1
 */