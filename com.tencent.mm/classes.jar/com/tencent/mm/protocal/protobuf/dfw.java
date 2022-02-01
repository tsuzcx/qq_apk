package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfw
  extends com.tencent.mm.bx.a
{
  public int OzG;
  public int aaLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133175);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.OzG);
      paramVarArgs.bS(2, this.aaLu);
      AppMethodBeat.o(133175);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.OzG);
      int i = i.a.a.b.b.a.cJ(2, this.aaLu);
      AppMethodBeat.o(133175);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133175);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dfw localdfw = (dfw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133175);
        return -1;
      case 1: 
        localdfw.OzG = locala.ajGk.aar();
        AppMethodBeat.o(133175);
        return 0;
      }
      localdfw.aaLu = locala.ajGk.aar();
      AppMethodBeat.o(133175);
      return 0;
    }
    AppMethodBeat.o(133175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfw
 * JD-Core Version:    0.7.0.1
 */