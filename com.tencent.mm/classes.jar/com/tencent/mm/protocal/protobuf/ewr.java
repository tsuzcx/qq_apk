package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewr
  extends com.tencent.mm.bx.a
{
  public int YCs;
  public int YCt;
  public int YCu;
  public int YCv;
  public int YCw;
  public int YCx;
  public int YCy;
  public com.tencent.mm.bx.b Zsu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zsu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.YCs);
      paramVarArgs.bS(2, this.YCt);
      paramVarArgs.bS(3, this.YCu);
      paramVarArgs.bS(4, this.YCv);
      paramVarArgs.bS(5, this.YCw);
      paramVarArgs.bS(6, this.YCx);
      paramVarArgs.bS(7, this.YCy);
      if (this.Zsu != null) {
        paramVarArgs.d(8, this.Zsu);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YCs) + 0 + i.a.a.b.b.a.cJ(2, this.YCt) + i.a.a.b.b.a.cJ(3, this.YCu) + i.a.a.b.b.a.cJ(4, this.YCv) + i.a.a.b.b.a.cJ(5, this.YCw) + i.a.a.b.b.a.cJ(6, this.YCx) + i.a.a.b.b.a.cJ(7, this.YCy);
      paramInt = i;
      if (this.Zsu != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.Zsu);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    i.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.kFT();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (i.a.a.a.a)paramVarArgs[0];
      ewr localewr = (ewr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localewr.YCs = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localewr.YCt = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localewr.YCu = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localewr.YCv = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localewr.YCw = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localewr.YCx = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localewr.YCy = locala.ajGk.aar();
        AppMethodBeat.o(32425);
        return 0;
      }
      localewr.Zsu = locala.ajGk.kFX();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewr
 * JD-Core Version:    0.7.0.1
 */