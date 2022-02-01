package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzc
  extends com.tencent.mm.bx.a
{
  public boolean HMu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147783);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).bt(1, this.HMu);
      AppMethodBeat.o(147783);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      AppMethodBeat.o(147783);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(147783);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzc localdzc = (dzc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147783);
        return -1;
      }
      localdzc.HMu = locala.NPN.grw();
      AppMethodBeat.o(147783);
      return 0;
    }
    AppMethodBeat.o(147783);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzc
 * JD-Core Version:    0.7.0.1
 */