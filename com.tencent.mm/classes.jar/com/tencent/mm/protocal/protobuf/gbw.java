package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gbw
  extends com.tencent.mm.bx.a
{
  public String errmsg;
  public int hGE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147782);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hGE);
      if (this.errmsg != null) {
        paramVarArgs.g(2, this.errmsg);
      }
      AppMethodBeat.o(147782);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.hGE) + 0;
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.errmsg);
      }
      AppMethodBeat.o(147782);
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
      AppMethodBeat.o(147782);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gbw localgbw = (gbw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147782);
        return -1;
      case 1: 
        localgbw.hGE = locala.ajGk.aar();
        AppMethodBeat.o(147782);
        return 0;
      }
      localgbw.errmsg = locala.ajGk.readString();
      AppMethodBeat.o(147782);
      return 0;
    }
    AppMethodBeat.o(147782);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbw
 * JD-Core Version:    0.7.0.1
 */