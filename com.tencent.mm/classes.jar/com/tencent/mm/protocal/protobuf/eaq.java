package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaq
  extends com.tencent.mm.bx.a
{
  public long LyX;
  public long LyY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.LyX);
      paramVarArgs.aG(2, this.LyY);
      AppMethodBeat.o(202513);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.LyX);
      int i = f.a.a.b.b.a.q(2, this.LyY);
      AppMethodBeat.o(202513);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(202513);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaq localeaq = (eaq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202513);
        return -1;
      case 1: 
        localeaq.LyX = locala.KhF.xT();
        AppMethodBeat.o(202513);
        return 0;
      }
      localeaq.LyY = locala.KhF.xT();
      AppMethodBeat.o(202513);
      return 0;
    }
    AppMethodBeat.o(202513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaq
 * JD-Core Version:    0.7.0.1
 */