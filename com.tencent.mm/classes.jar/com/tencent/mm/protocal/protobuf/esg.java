package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esg
  extends com.tencent.mm.bw.a
{
  public int KKA;
  public int KKB;
  public int KKC;
  public int KKD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KKA);
      paramVarArgs.aM(2, this.KKB);
      paramVarArgs.aM(3, this.KKC);
      paramVarArgs.aM(4, this.KKD);
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KKA);
      int i = g.a.a.b.b.a.bu(2, this.KKB);
      int j = g.a.a.b.b.a.bu(3, this.KKC);
      int k = g.a.a.b.b.a.bu(4, this.KKD);
      AppMethodBeat.o(32498);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32498);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      esg localesg = (esg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32498);
        return -1;
      case 1: 
        localesg.KKA = locala.UbS.zi();
        AppMethodBeat.o(32498);
        return 0;
      case 2: 
        localesg.KKB = locala.UbS.zi();
        AppMethodBeat.o(32498);
        return 0;
      case 3: 
        localesg.KKC = locala.UbS.zi();
        AppMethodBeat.o(32498);
        return 0;
      }
      localesg.KKD = locala.UbS.zi();
      AppMethodBeat.o(32498);
      return 0;
    }
    AppMethodBeat.o(32498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esg
 * JD-Core Version:    0.7.0.1
 */