package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edj
  extends com.tencent.mm.bx.a
{
  public long FAf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32551);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aY(1, this.FAf);
      AppMethodBeat.o(32551);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FAf);
      AppMethodBeat.o(32551);
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
      AppMethodBeat.o(32551);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      edj localedj = (edj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32551);
        return -1;
      }
      localedj.FAf = locala.NPN.zd();
      AppMethodBeat.o(32551);
      return 0;
    }
    AppMethodBeat.o(32551);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edj
 * JD-Core Version:    0.7.0.1
 */