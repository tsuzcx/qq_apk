package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aun
  extends com.tencent.mm.bx.a
{
  public int ZES;
  public int ZET;
  public int ZEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZES);
      paramVarArgs.bS(2, this.ZET);
      paramVarArgs.bS(3, this.ZEU);
      AppMethodBeat.o(257917);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZES);
      int i = i.a.a.b.b.a.cJ(2, this.ZET);
      int j = i.a.a.b.b.a.cJ(3, this.ZEU);
      AppMethodBeat.o(257917);
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
      AppMethodBeat.o(257917);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aun localaun = (aun)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257917);
        return -1;
      case 1: 
        localaun.ZES = locala.ajGk.aar();
        AppMethodBeat.o(257917);
        return 0;
      case 2: 
        localaun.ZET = locala.ajGk.aar();
        AppMethodBeat.o(257917);
        return 0;
      }
      localaun.ZEU = locala.ajGk.aar();
      AppMethodBeat.o(257917);
      return 0;
    }
    AppMethodBeat.o(257917);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aun
 * JD-Core Version:    0.7.0.1
 */