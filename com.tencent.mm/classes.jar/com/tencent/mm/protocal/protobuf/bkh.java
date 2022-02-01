package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkh
  extends com.tencent.mm.bx.a
{
  public String vJI;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vJz);
      if (this.vJI != null) {
        paramVarArgs.d(2, this.vJI);
      }
      AppMethodBeat.o(43100);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.vJz) + 0;
      paramInt = i;
      if (this.vJI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vJI);
      }
      AppMethodBeat.o(43100);
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
      AppMethodBeat.o(43100);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkh localbkh = (bkh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43100);
        return -1;
      case 1: 
        localbkh.vJz = locala.KhF.xS();
        AppMethodBeat.o(43100);
        return 0;
      }
      localbkh.vJI = locala.KhF.readString();
      AppMethodBeat.o(43100);
      return 0;
    }
    AppMethodBeat.o(43100);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkh
 * JD-Core Version:    0.7.0.1
 */