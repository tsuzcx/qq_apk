package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class giq
  extends com.tencent.mm.bx.a
{
  public boolean aceZ;
  public boolean acfa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110855);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aceZ);
      paramVarArgs.di(2, this.acfa);
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(110855);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      giq localgiq = (giq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110855);
        return -1;
      case 1: 
        localgiq.aceZ = locala.ajGk.aai();
        AppMethodBeat.o(110855);
        return 0;
      }
      localgiq.acfa = locala.ajGk.aai();
      AppMethodBeat.o(110855);
      return 0;
    }
    AppMethodBeat.o(110855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.giq
 * JD-Core Version:    0.7.0.1
 */