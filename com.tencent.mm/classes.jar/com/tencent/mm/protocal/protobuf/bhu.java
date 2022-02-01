package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhu
  extends com.tencent.mm.cd.a
{
  public long SSg;
  public int SSh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SSg);
      paramVarArgs.aY(2, this.SSh);
      AppMethodBeat.o(209577);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SSg);
      int i = g.a.a.b.b.a.bM(2, this.SSh);
      AppMethodBeat.o(209577);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209577);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bhu localbhu = (bhu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209577);
        return -1;
      case 1: 
        localbhu.SSg = locala.abFh.AN();
        AppMethodBeat.o(209577);
        return 0;
      }
      localbhu.SSh = locala.abFh.AK();
      AppMethodBeat.o(209577);
      return 0;
    }
    AppMethodBeat.o(209577);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhu
 * JD-Core Version:    0.7.0.1
 */