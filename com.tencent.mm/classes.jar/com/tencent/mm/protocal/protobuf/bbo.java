package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbo
  extends com.tencent.mm.cd.a
{
  public int SNj;
  public boolean SNk;
  public int SNl;
  public long SNm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SNj);
      paramVarArgs.co(2, this.SNk);
      paramVarArgs.aY(3, this.SNl);
      paramVarArgs.bm(4, this.SNm);
      AppMethodBeat.o(200555);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SNj);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.SNl);
      int k = g.a.a.b.b.a.p(4, this.SNm);
      AppMethodBeat.o(200555);
      return paramInt + 0 + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200555);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbo localbbo = (bbo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200555);
        return -1;
      case 1: 
        localbbo.SNj = locala.abFh.AK();
        AppMethodBeat.o(200555);
        return 0;
      case 2: 
        localbbo.SNk = locala.abFh.AB();
        AppMethodBeat.o(200555);
        return 0;
      case 3: 
        localbbo.SNl = locala.abFh.AK();
        AppMethodBeat.o(200555);
        return 0;
      }
      localbbo.SNm = locala.abFh.AN();
      AppMethodBeat.o(200555);
      return 0;
    }
    AppMethodBeat.o(200555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbo
 * JD-Core Version:    0.7.0.1
 */