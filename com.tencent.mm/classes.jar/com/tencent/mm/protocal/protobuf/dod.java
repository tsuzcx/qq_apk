package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dod
  extends com.tencent.mm.bx.a
{
  public int aaic;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.percent);
      paramVarArgs.bS(3, this.aaic);
      AppMethodBeat.o(258257);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      int i = i.a.a.b.b.a.cJ(2, this.percent);
      int j = i.a.a.b.b.a.cJ(3, this.aaic);
      AppMethodBeat.o(258257);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258257);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dod localdod = (dod)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258257);
        return -1;
      case 1: 
        localdod.type = locala.ajGk.aar();
        AppMethodBeat.o(258257);
        return 0;
      case 2: 
        localdod.percent = locala.ajGk.aar();
        AppMethodBeat.o(258257);
        return 0;
      }
      localdod.aaic = locala.ajGk.aar();
      AppMethodBeat.o(258257);
      return 0;
    }
    AppMethodBeat.o(258257);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dod
 * JD-Core Version:    0.7.0.1
 */