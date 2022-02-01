package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eow
  extends com.tencent.mm.bw.a
{
  public int errCode;
  public String errMsg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.errCode);
      if (this.errMsg != null) {
        paramVarArgs.e(2, this.errMsg);
      }
      AppMethodBeat.o(147780);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.errCode) + 0;
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.errMsg);
      }
      AppMethodBeat.o(147780);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(147780);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eow localeow = (eow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147780);
        return -1;
      case 1: 
        localeow.errCode = locala.UbS.zi();
        AppMethodBeat.o(147780);
        return 0;
      }
      localeow.errMsg = locala.UbS.readString();
      AppMethodBeat.o(147780);
      return 0;
    }
    AppMethodBeat.o(147780);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eow
 * JD-Core Version:    0.7.0.1
 */