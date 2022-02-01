package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class env
  extends com.tencent.mm.bx.a
{
  public long absp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91663);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).bv(1, this.absp);
      AppMethodBeat.o(91663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.absp);
      AppMethodBeat.o(91663);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91663);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      env localenv = (env)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91663);
        return -1;
      }
      localenv.absp = locala.ajGk.aaw();
      AppMethodBeat.o(91663);
      return 0;
    }
    AppMethodBeat.o(91663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.env
 * JD-Core Version:    0.7.0.1
 */