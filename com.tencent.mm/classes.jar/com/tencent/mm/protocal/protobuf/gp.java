package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gp
  extends com.tencent.mm.bx.a
{
  public int YIm;
  public String YIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YIm);
      if (this.YIn != null) {
        paramVarArgs.g(2, this.YIn);
      }
      AppMethodBeat.o(123542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YIm) + 0;
      paramInt = i;
      if (this.YIn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YIn);
      }
      AppMethodBeat.o(123542);
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
      AppMethodBeat.o(123542);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gp localgp = (gp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123542);
        return -1;
      case 1: 
        localgp.YIm = locala.ajGk.aar();
        AppMethodBeat.o(123542);
        return 0;
      }
      localgp.YIn = locala.ajGk.readString();
      AppMethodBeat.o(123542);
      return 0;
    }
    AppMethodBeat.o(123542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */