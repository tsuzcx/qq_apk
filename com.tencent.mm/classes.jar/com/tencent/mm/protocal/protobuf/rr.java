package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rr
  extends com.tencent.mm.bx.a
{
  public String YQK;
  public int YTg;
  public int YTh;
  public int YWB;
  public String YWC;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YTg);
      paramVarArgs.bS(2, this.YTh);
      paramVarArgs.bS(3, this.YWB);
      if (this.hAP != null) {
        paramVarArgs.g(4, this.hAP);
      }
      if (this.YWC != null) {
        paramVarArgs.g(5, this.YWC);
      }
      if (this.YQK != null) {
        paramVarArgs.g(6, this.YQK);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YTg) + 0 + i.a.a.b.b.a.cJ(2, this.YTh) + i.a.a.b.b.a.cJ(3, this.YWB);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hAP);
      }
      i = paramInt;
      if (this.YWC != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YWC);
      }
      paramInt = i;
      if (this.YQK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YQK);
      }
      AppMethodBeat.o(124464);
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
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      rr localrr = (rr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localrr.YTg = locala.ajGk.aar();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localrr.YTh = locala.ajGk.aar();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localrr.YWB = locala.ajGk.aar();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localrr.hAP = locala.ajGk.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localrr.YWC = locala.ajGk.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localrr.YQK = locala.ajGk.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rr
 * JD-Core Version:    0.7.0.1
 */