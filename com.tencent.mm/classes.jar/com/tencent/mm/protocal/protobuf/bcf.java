package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcf
  extends com.tencent.mm.cd.a
{
  public int CkG;
  public int SHk;
  public long tsi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SHk);
      paramVarArgs.aY(2, this.CkG);
      paramVarArgs.bm(3, this.tsi);
      AppMethodBeat.o(207156);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SHk);
      int i = g.a.a.b.b.a.bM(2, this.CkG);
      int j = g.a.a.b.b.a.p(3, this.tsi);
      AppMethodBeat.o(207156);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207156);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bcf localbcf = (bcf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207156);
        return -1;
      case 1: 
        localbcf.SHk = locala.abFh.AK();
        AppMethodBeat.o(207156);
        return 0;
      case 2: 
        localbcf.CkG = locala.abFh.AK();
        AppMethodBeat.o(207156);
        return 0;
      }
      localbcf.tsi = locala.abFh.AN();
      AppMethodBeat.o(207156);
      return 0;
    }
    AppMethodBeat.o(207156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */