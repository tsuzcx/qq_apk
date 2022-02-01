package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxk
  extends com.tencent.mm.bx.a
{
  public int aagh;
  public boolean aagi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258243);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aagh);
      paramVarArgs.di(2, this.aagi);
      AppMethodBeat.o(258243);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aagh);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(258243);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258243);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bxk localbxk = (bxk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258243);
        return -1;
      case 1: 
        localbxk.aagh = locala.ajGk.aar();
        AppMethodBeat.o(258243);
        return 0;
      }
      localbxk.aagi = locala.ajGk.aai();
      AppMethodBeat.o(258243);
      return 0;
    }
    AppMethodBeat.o(258243);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxk
 * JD-Core Version:    0.7.0.1
 */