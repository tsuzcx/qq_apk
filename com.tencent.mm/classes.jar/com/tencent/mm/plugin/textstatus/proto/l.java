package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int ToO;
  public boolean ToP;
  public int ToQ;
  public int nDl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290017);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.nDl);
      paramVarArgs.bS(2, this.ToO);
      paramVarArgs.di(3, this.ToP);
      paramVarArgs.bS(4, this.ToQ);
      AppMethodBeat.o(290017);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.nDl);
      int i = i.a.a.b.b.a.cJ(2, this.ToO);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.cJ(4, this.ToQ);
      AppMethodBeat.o(290017);
      return paramInt + 0 + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290017);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290017);
        return -1;
      case 1: 
        locall.nDl = locala.ajGk.aar();
        AppMethodBeat.o(290017);
        return 0;
      case 2: 
        locall.ToO = locala.ajGk.aar();
        AppMethodBeat.o(290017);
        return 0;
      case 3: 
        locall.ToP = locala.ajGk.aai();
        AppMethodBeat.o(290017);
        return 0;
      }
      locall.ToQ = locala.ajGk.aar();
      AppMethodBeat.o(290017);
      return 0;
    }
    AppMethodBeat.o(290017);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.l
 * JD-Core Version:    0.7.0.1
 */