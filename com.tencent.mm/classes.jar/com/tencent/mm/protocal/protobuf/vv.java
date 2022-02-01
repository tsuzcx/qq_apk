package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vv
  extends com.tencent.mm.bw.a
{
  public boolean GnH;
  public boolean GnI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.GnH);
      paramVarArgs.bC(2, this.GnI);
      AppMethodBeat.o(124467);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(124467);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124467);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vv localvv = (vv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124467);
        return -1;
      case 1: 
        localvv.GnH = locala.OmT.gvY();
        AppMethodBeat.o(124467);
        return 0;
      }
      localvv.GnI = locala.OmT.gvY();
      AppMethodBeat.o(124467);
      return 0;
    }
    AppMethodBeat.o(124467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */