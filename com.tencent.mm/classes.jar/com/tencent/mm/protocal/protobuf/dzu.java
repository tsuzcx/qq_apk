package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzu
  extends com.tencent.mm.bx.a
{
  public int abfa;
  public String abfb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32367);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abfa);
      if (this.abfb != null) {
        paramVarArgs.g(2, this.abfb);
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abfa) + 0;
      paramInt = i;
      if (this.abfb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abfb);
      }
      AppMethodBeat.o(32367);
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
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dzu localdzu = (dzu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32367);
        return -1;
      case 1: 
        localdzu.abfa = locala.ajGk.aar();
        AppMethodBeat.o(32367);
        return 0;
      }
      localdzu.abfb = locala.ajGk.readString();
      AppMethodBeat.o(32367);
      return 0;
    }
    AppMethodBeat.o(32367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzu
 * JD-Core Version:    0.7.0.1
 */