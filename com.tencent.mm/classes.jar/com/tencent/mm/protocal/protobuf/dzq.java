package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzq
  extends com.tencent.mm.bw.a
{
  public int pAG;
  public String pAH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123684);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(2, this.pAH);
      }
      AppMethodBeat.o(123684);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.pAG) + 0;
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pAH);
      }
      AppMethodBeat.o(123684);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123684);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzq localdzq = (dzq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123684);
        return -1;
      case 1: 
        localdzq.pAG = locala.LVo.xF();
        AppMethodBeat.o(123684);
        return 0;
      }
      localdzq.pAH = locala.LVo.readString();
      AppMethodBeat.o(123684);
      return 0;
    }
    AppMethodBeat.o(123684);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzq
 * JD-Core Version:    0.7.0.1
 */