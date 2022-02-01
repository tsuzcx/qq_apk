package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class do
  extends com.tencent.mm.bx.a
{
  public boolean FvP;
  public String FvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.FvP);
      if (this.FvQ != null) {
        paramVarArgs.d(2, this.FvQ);
      }
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.FvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FvQ);
      }
      AppMethodBeat.o(123538);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      do localdo = (do)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123538);
        return -1;
      case 1: 
        localdo.FvP = locala.NPN.grw();
        AppMethodBeat.o(123538);
        return 0;
      }
      localdo.FvQ = locala.NPN.readString();
      AppMethodBeat.o(123538);
      return 0;
    }
    AppMethodBeat.o(123538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.do
 * JD-Core Version:    0.7.0.1
 */