package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efl
  extends com.tencent.mm.bw.a
{
  public long HuS;
  public int Ijo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ijo);
      paramVarArgs.aZ(2, this.HuS);
      AppMethodBeat.o(32563);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Ijo);
      int i = f.a.a.b.b.a.p(2, this.HuS);
      AppMethodBeat.o(32563);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32563);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efl localefl = (efl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32563);
        return -1;
      case 1: 
        localefl.Ijo = locala.OmT.zc();
        AppMethodBeat.o(32563);
        return 0;
      }
      localefl.HuS = locala.OmT.zd();
      AppMethodBeat.o(32563);
      return 0;
    }
    AppMethodBeat.o(32563);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efl
 * JD-Core Version:    0.7.0.1
 */