package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaq
  extends com.tencent.mm.bx.a
{
  public String IMu;
  public String LensId;
  public int abfS;
  public int abfT;
  public int abfU;
  public long abfV;
  public int abfW;
  public int abfX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abfS);
      paramVarArgs.bS(2, this.abfT);
      paramVarArgs.bS(3, this.abfU);
      if (this.IMu != null) {
        paramVarArgs.g(4, this.IMu);
      }
      paramVarArgs.bv(5, this.abfV);
      paramVarArgs.bS(6, this.abfW);
      if (this.LensId != null) {
        paramVarArgs.g(7, this.LensId);
      }
      paramVarArgs.bS(8, this.abfX);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abfS) + 0 + i.a.a.b.b.a.cJ(2, this.abfT) + i.a.a.b.b.a.cJ(3, this.abfU);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMu);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.abfV) + i.a.a.b.b.a.cJ(6, this.abfW);
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.LensId);
      }
      i = i.a.a.b.b.a.cJ(8, this.abfX);
      AppMethodBeat.o(104825);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eaq localeaq = (eaq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localeaq.abfS = locala.ajGk.aar();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localeaq.abfT = locala.ajGk.aar();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localeaq.abfU = locala.ajGk.aar();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localeaq.IMu = locala.ajGk.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localeaq.abfV = locala.ajGk.aaw();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localeaq.abfW = locala.ajGk.aar();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localeaq.LensId = locala.ajGk.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localeaq.abfX = locala.ajGk.aar();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaq
 * JD-Core Version:    0.7.0.1
 */