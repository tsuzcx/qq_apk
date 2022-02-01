package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akx
  extends com.tencent.mm.bx.a
{
  public int GkQ = 0;
  public long endTime = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.startTime);
      paramVarArgs.aY(2, this.endTime);
      paramVarArgs.aS(3, this.GkQ);
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.startTime);
      int i = f.a.a.b.b.a.p(2, this.endTime);
      int j = f.a.a.b.b.a.bz(3, this.GkQ);
      AppMethodBeat.o(122489);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akx localakx = (akx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122489);
        return -1;
      case 1: 
        localakx.startTime = locala.NPN.zd();
        AppMethodBeat.o(122489);
        return 0;
      case 2: 
        localakx.endTime = locala.NPN.zd();
        AppMethodBeat.o(122489);
        return 0;
      }
      localakx.GkQ = locala.NPN.zc();
      AppMethodBeat.o(122489);
      return 0;
    }
    AppMethodBeat.o(122489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */