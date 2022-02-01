package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecp
  extends com.tencent.mm.bw.a
{
  public String ElT;
  public String KxO;
  public String NcK;
  public int NcL;
  public int adType;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.adType);
      if (this.NcK != null) {
        paramVarArgs.e(2, this.NcK);
      }
      if (this.KxO != null) {
        paramVarArgs.e(3, this.KxO);
      }
      paramVarArgs.aM(4, this.source);
      if (this.ElT != null) {
        paramVarArgs.e(5, this.ElT);
      }
      paramVarArgs.aM(6, this.NcL);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.adType) + 0;
      paramInt = i;
      if (this.NcK != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NcK);
      }
      i = paramInt;
      if (this.KxO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KxO);
      }
      i += g.a.a.b.b.a.bu(4, this.source);
      paramInt = i;
      if (this.ElT != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ElT);
      }
      i = g.a.a.b.b.a.bu(6, this.NcL);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ecp localecp = (ecp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localecp.adType = locala.UbS.zi();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localecp.NcK = locala.UbS.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localecp.KxO = locala.UbS.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localecp.source = locala.UbS.zi();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localecp.ElT = locala.UbS.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localecp.NcL = locala.UbS.zi();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecp
 * JD-Core Version:    0.7.0.1
 */