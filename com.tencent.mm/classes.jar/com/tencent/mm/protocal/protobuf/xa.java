package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xa
  extends com.tencent.mm.bw.a
{
  public String KFI;
  public int LhW;
  public String LhX;
  public int LhY;
  public String LhZ;
  public int Lia;
  public String Lib;
  public String Lic;
  public String Lid;
  public String Lie;
  public int Lif;
  public String Lig;
  public String qGA;
  public String qGB;
  public int qGt;
  public String qGu;
  public String qHn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LhW);
      if (this.qHn != null) {
        paramVarArgs.e(2, this.qHn);
      }
      if (this.LhX != null) {
        paramVarArgs.e(3, this.LhX);
      }
      if (this.qGA != null) {
        paramVarArgs.e(4, this.qGA);
      }
      paramVarArgs.aM(5, this.LhY);
      if (this.LhZ != null) {
        paramVarArgs.e(6, this.LhZ);
      }
      paramVarArgs.aM(7, this.Lia);
      if (this.qGB != null) {
        paramVarArgs.e(8, this.qGB);
      }
      if (this.KFI != null) {
        paramVarArgs.e(9, this.KFI);
      }
      paramVarArgs.aM(10, this.qGt);
      if (this.qGu != null) {
        paramVarArgs.e(11, this.qGu);
      }
      if (this.Lib != null) {
        paramVarArgs.e(12, this.Lib);
      }
      if (this.Lic != null) {
        paramVarArgs.e(13, this.Lic);
      }
      if (this.Lid != null) {
        paramVarArgs.e(14, this.Lid);
      }
      if (this.Lie != null) {
        paramVarArgs.e(15, this.Lie);
      }
      paramVarArgs.aM(16, this.Lif);
      if (this.Lig != null) {
        paramVarArgs.e(17, this.Lig);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LhW) + 0;
      paramInt = i;
      if (this.qHn != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qHn);
      }
      i = paramInt;
      if (this.LhX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LhX);
      }
      paramInt = i;
      if (this.qGA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGA);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LhY);
      paramInt = i;
      if (this.LhZ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LhZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.Lia);
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qGB);
      }
      i = paramInt;
      if (this.KFI != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KFI);
      }
      i += g.a.a.b.b.a.bu(10, this.qGt);
      paramInt = i;
      if (this.qGu != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.qGu);
      }
      i = paramInt;
      if (this.Lib != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Lib);
      }
      paramInt = i;
      if (this.Lic != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Lic);
      }
      i = paramInt;
      if (this.Lid != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.Lid);
      }
      paramInt = i;
      if (this.Lie != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Lie);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.Lif);
      paramInt = i;
      if (this.Lig != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Lig);
      }
      AppMethodBeat.o(125715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      xa localxa = (xa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localxa.LhW = locala.UbS.zi();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localxa.qHn = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localxa.LhX = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localxa.qGA = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localxa.LhY = locala.UbS.zi();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localxa.LhZ = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localxa.Lia = locala.UbS.zi();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localxa.qGB = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localxa.KFI = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localxa.qGt = locala.UbS.zi();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localxa.qGu = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localxa.Lib = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localxa.Lic = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localxa.Lid = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localxa.Lie = locala.UbS.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localxa.Lif = locala.UbS.zi();
        AppMethodBeat.o(125715);
        return 0;
      }
      localxa.Lig = locala.UbS.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xa
 * JD-Core Version:    0.7.0.1
 */