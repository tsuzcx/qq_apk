package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edf
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public int MYS;
  public int MYT;
  public int MYX;
  public String NdA;
  public String NdB;
  public int NdC;
  public int NdD;
  public int NdE;
  public String ThumbUrl;
  public String iAc;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Id);
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      if (this.NdA != null) {
        paramVarArgs.e(4, this.NdA);
      }
      if (this.NdB != null) {
        paramVarArgs.e(5, this.NdB);
      }
      paramVarArgs.aM(6, this.CreateTime);
      if (this.iAc != null) {
        paramVarArgs.e(7, this.iAc);
      }
      paramVarArgs.aM(8, this.NdC);
      paramVarArgs.aM(9, this.MYX);
      paramVarArgs.aM(10, this.MYS);
      paramVarArgs.aM(11, this.MYT);
      paramVarArgs.aM(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(13, this.ThumbUrl);
      }
      paramVarArgs.aM(14, this.NdD);
      paramVarArgs.aM(15, this.NdE);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNG);
      }
      paramInt = i;
      if (this.NdA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NdA);
      }
      i = paramInt;
      if (this.NdB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NdB);
      }
      i += g.a.a.b.b.a.bu(6, this.CreateTime);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.NdC) + g.a.a.b.b.a.bu(9, this.MYX) + g.a.a.b.b.a.bu(10, this.MYS) + g.a.a.b.b.a.bu(11, this.MYT) + g.a.a.b.b.a.bu(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.ThumbUrl);
      }
      i = g.a.a.b.b.a.bu(14, this.NdD);
      int j = g.a.a.b.b.a.bu(15, this.NdE);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      edf localedf = (edf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localedf.Id = locala.UbS.zl();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localedf.xNH = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localedf.xNG = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localedf.NdA = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localedf.NdB = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localedf.CreateTime = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localedf.iAc = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localedf.NdC = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localedf.MYX = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localedf.MYS = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localedf.MYT = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localedf.IsNotRichText = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localedf.ThumbUrl = locala.UbS.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localedf.NdD = locala.UbS.zi();
        AppMethodBeat.o(118438);
        return 0;
      }
      localedf.NdE = locala.UbS.zi();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edf
 * JD-Core Version:    0.7.0.1
 */