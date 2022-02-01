package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmz
  extends com.tencent.mm.bw.a
{
  public int FJT;
  public String FJU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114043);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FJT);
      if (this.FJU != null) {
        paramVarArgs.d(2, this.FJU);
      }
      AppMethodBeat.o(114043);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FJT) + 0;
      paramInt = i;
      if (this.FJU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FJU);
      }
      AppMethodBeat.o(114043);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(114043);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bmz localbmz = (bmz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114043);
        return -1;
      case 1: 
        localbmz.FJT = locala.OmT.zc();
        AppMethodBeat.o(114043);
        return 0;
      }
      localbmz.FJU = locala.OmT.readString();
      AppMethodBeat.o(114043);
      return 0;
    }
    AppMethodBeat.o(114043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmz
 * JD-Core Version:    0.7.0.1
 */