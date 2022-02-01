package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djm
  extends com.tencent.mm.bw.a
{
  public int HRm;
  public boolean HRn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HRm);
      paramVarArgs.bC(2, this.HRn);
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HRm);
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(116476);
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
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djm localdjm = (djm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116476);
        return -1;
      case 1: 
        localdjm.HRm = locala.OmT.zc();
        AppMethodBeat.o(116476);
        return 0;
      }
      localdjm.HRn = locala.OmT.gvY();
      AppMethodBeat.o(116476);
      return 0;
    }
    AppMethodBeat.o(116476);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djm
 * JD-Core Version:    0.7.0.1
 */