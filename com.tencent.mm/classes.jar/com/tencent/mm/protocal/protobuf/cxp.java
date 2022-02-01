package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxp
  extends com.tencent.mm.bx.a
{
  public int DVv;
  public boolean aaCX;
  public boolean aaCY;
  public int aaif;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50094);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.DVv);
      paramVarArgs.bS(2, this.aaif);
      paramVarArgs.di(3, this.aaCX);
      paramVarArgs.di(4, this.aaCY);
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.DVv);
      int i = i.a.a.b.b.a.cJ(2, this.aaif);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(50094);
      return paramInt + 0 + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cxp localcxp = (cxp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50094);
        return -1;
      case 1: 
        localcxp.DVv = locala.ajGk.aar();
        AppMethodBeat.o(50094);
        return 0;
      case 2: 
        localcxp.aaif = locala.ajGk.aar();
        AppMethodBeat.o(50094);
        return 0;
      case 3: 
        localcxp.aaCX = locala.ajGk.aai();
        AppMethodBeat.o(50094);
        return 0;
      }
      localcxp.aaCY = locala.ajGk.aai();
      AppMethodBeat.o(50094);
      return 0;
    }
    AppMethodBeat.o(50094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxp
 * JD-Core Version:    0.7.0.1
 */