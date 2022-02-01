package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvn
  extends com.tencent.mm.bx.a
{
  public int DSR;
  public String saB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DSR);
      if (this.saB != null) {
        paramVarArgs.d(2, this.saB);
      }
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DSR) + 0;
      paramInt = i;
      if (this.saB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.saB);
      }
      AppMethodBeat.o(152639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvn localbvn = (bvn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152639);
        return -1;
      case 1: 
        localbvn.DSR = locala.KhF.xS();
        AppMethodBeat.o(152639);
        return 0;
      }
      localbvn.saB = locala.KhF.readString();
      AppMethodBeat.o(152639);
      return 0;
    }
    AppMethodBeat.o(152639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */