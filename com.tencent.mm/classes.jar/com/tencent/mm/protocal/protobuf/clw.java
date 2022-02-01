package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clw
  extends com.tencent.mm.cd.a
{
  public long TtH;
  public int TtI;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.key);
      paramVarArgs.bm(2, this.TtH);
      paramVarArgs.aY(3, this.length);
      paramVarArgs.aY(4, this.TtI);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.key);
      int i = g.a.a.b.b.a.p(2, this.TtH);
      int j = g.a.a.b.b.a.bM(3, this.length);
      int k = g.a.a.b.b.a.bM(4, this.TtI);
      AppMethodBeat.o(111786);
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
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clw localclw = (clw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localclw.key = locala.abFh.AK();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localclw.TtH = locala.abFh.AN();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localclw.length = locala.abFh.AK();
        AppMethodBeat.o(111786);
        return 0;
      }
      localclw.TtI = locala.abFh.AK();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clw
 * JD-Core Version:    0.7.0.1
 */