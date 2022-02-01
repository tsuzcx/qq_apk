package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class enh
  extends com.tencent.mm.bx.a
{
  public int abrN;
  public int abrO;
  public int abrP;
  public boolean abrQ;
  public int abrR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abrN);
      paramVarArgs.bS(2, this.abrO);
      paramVarArgs.bS(3, this.abrP);
      paramVarArgs.di(4, this.abrQ);
      paramVarArgs.bS(5, this.abrR);
      AppMethodBeat.o(259985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abrN);
      int i = i.a.a.b.b.a.cJ(2, this.abrO);
      int j = i.a.a.b.b.a.cJ(3, this.abrP);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.cJ(5, this.abrR);
      AppMethodBeat.o(259985);
      return paramInt + 0 + i + j + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259985);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      enh localenh = (enh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259985);
        return -1;
      case 1: 
        localenh.abrN = locala.ajGk.aar();
        AppMethodBeat.o(259985);
        return 0;
      case 2: 
        localenh.abrO = locala.ajGk.aar();
        AppMethodBeat.o(259985);
        return 0;
      case 3: 
        localenh.abrP = locala.ajGk.aar();
        AppMethodBeat.o(259985);
        return 0;
      case 4: 
        localenh.abrQ = locala.ajGk.aai();
        AppMethodBeat.o(259985);
        return 0;
      }
      localenh.abrR = locala.ajGk.aar();
      AppMethodBeat.o(259985);
      return 0;
    }
    AppMethodBeat.o(259985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enh
 * JD-Core Version:    0.7.0.1
 */