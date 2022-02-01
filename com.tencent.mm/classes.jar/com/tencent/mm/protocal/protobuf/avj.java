package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avj
  extends com.tencent.mm.bx.a
{
  public String ZFB;
  public long commentId;
  public long hKN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.hKN);
      paramVarArgs.bv(2, this.commentId);
      if (this.ZFB != null) {
        paramVarArgs.g(3, this.ZFB);
      }
      AppMethodBeat.o(257488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.hKN) + 0 + i.a.a.b.b.a.q(2, this.commentId);
      paramInt = i;
      if (this.ZFB != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZFB);
      }
      AppMethodBeat.o(257488);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257488);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      avj localavj = (avj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257488);
        return -1;
      case 1: 
        localavj.hKN = locala.ajGk.aaw();
        AppMethodBeat.o(257488);
        return 0;
      case 2: 
        localavj.commentId = locala.ajGk.aaw();
        AppMethodBeat.o(257488);
        return 0;
      }
      localavj.ZFB = locala.ajGk.readString();
      AppMethodBeat.o(257488);
      return 0;
    }
    AppMethodBeat.o(257488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avj
 * JD-Core Version:    0.7.0.1
 */