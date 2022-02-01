package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dug
  extends com.tencent.mm.bw.a
{
  public int xsB;
  public int xsC;
  public int xsD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xsB);
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsD);
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.xsB);
      int i = f.a.a.b.b.a.bz(2, this.xsC);
      int j = f.a.a.b.b.a.bz(3, this.xsD);
      AppMethodBeat.o(32486);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dug localdug = (dug)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32486);
        return -1;
      case 1: 
        localdug.xsB = locala.OmT.zc();
        AppMethodBeat.o(32486);
        return 0;
      case 2: 
        localdug.xsC = locala.OmT.zc();
        AppMethodBeat.o(32486);
        return 0;
      }
      localdug.xsD = locala.OmT.zc();
      AppMethodBeat.o(32486);
      return 0;
    }
    AppMethodBeat.o(32486);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dug
 * JD-Core Version:    0.7.0.1
 */