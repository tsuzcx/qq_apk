package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxs
  extends com.tencent.mm.bx.a
{
  public int EpO;
  public boolean EpP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EpO);
      paramVarArgs.bg(2, this.EpP);
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EpO);
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(116476);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxs localcxs = (cxs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116476);
        return -1;
      case 1: 
        localcxs.EpO = locala.KhF.xS();
        AppMethodBeat.o(116476);
        return 0;
      }
      localcxs.EpP = locala.KhF.fHu();
      AppMethodBeat.o(116476);
      return 0;
    }
    AppMethodBeat.o(116476);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxs
 * JD-Core Version:    0.7.0.1
 */