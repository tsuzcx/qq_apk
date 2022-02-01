package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eji
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String KMl;
  public int NiR;
  public int NiS;
  public long xui;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NiR);
      if (this.KMl != null) {
        paramVarArgs.e(2, this.KMl);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(3, this.AesKey);
      }
      paramVarArgs.aM(4, this.NiS);
      paramVarArgs.bb(5, this.xui);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NiR) + 0;
      paramInt = i;
      if (this.KMl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KMl);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.AesKey);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.NiS);
      int j = g.a.a.b.b.a.r(5, this.xui);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eji localeji = (eji)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localeji.NiR = locala.UbS.zi();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localeji.KMl = locala.UbS.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localeji.AesKey = locala.UbS.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localeji.NiS = locala.UbS.zi();
        AppMethodBeat.o(127506);
        return 0;
      }
      localeji.xui = locala.UbS.zl();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eji
 * JD-Core Version:    0.7.0.1
 */