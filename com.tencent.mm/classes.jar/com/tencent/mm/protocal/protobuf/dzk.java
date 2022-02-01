package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzk
  extends com.tencent.mm.bx.a
{
  public int LxR;
  public String doh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.LxR);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      AppMethodBeat.o(203870);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.LxR) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      AppMethodBeat.o(203870);
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
      AppMethodBeat.o(203870);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzk localdzk = (dzk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203870);
        return -1;
      case 1: 
        localdzk.LxR = locala.KhF.xS();
        AppMethodBeat.o(203870);
        return 0;
      }
      localdzk.doh = locala.KhF.readString();
      AppMethodBeat.o(203870);
      return 0;
    }
    AppMethodBeat.o(203870);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzk
 * JD-Core Version:    0.7.0.1
 */