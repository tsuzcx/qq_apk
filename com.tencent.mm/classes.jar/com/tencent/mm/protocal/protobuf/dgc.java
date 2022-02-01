package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgc
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DPI;
  public int EaA;
  public int EaB;
  public String Eal;
  public String Ean;
  public String Eap;
  public String Eaq;
  public String Ear;
  public String Eay;
  public int Eaz;
  public long FPu;
  public String FPv;
  public String Title;
  public int hkQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DPI);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Eal != null) {
        paramVarArgs.d(3, this.Eal);
      }
      if (this.Ean != null) {
        paramVarArgs.d(6, this.Ean);
      }
      if (this.Eap != null) {
        paramVarArgs.d(8, this.Eap);
      }
      if (this.Eaq != null) {
        paramVarArgs.d(9, this.Eaq);
      }
      if (this.Ear != null) {
        paramVarArgs.d(10, this.Ear);
      }
      paramVarArgs.aR(11, this.hkQ);
      if (this.Eay != null) {
        paramVarArgs.d(15, this.Eay);
      }
      paramVarArgs.aR(16, this.Eaz);
      paramVarArgs.aR(17, this.EaA);
      paramVarArgs.aR(18, this.EaB);
      paramVarArgs.aR(19, this.CreateTime);
      paramVarArgs.aO(20, this.FPu);
      if (this.FPv != null) {
        paramVarArgs.d(21, this.FPv);
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DPI) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Eal != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eal);
      }
      paramInt = i;
      if (this.Ean != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ean);
      }
      i = paramInt;
      if (this.Eap != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Eap);
      }
      paramInt = i;
      if (this.Eaq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Eaq);
      }
      i = paramInt;
      if (this.Ear != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ear);
      }
      i += f.a.a.b.b.a.bx(11, this.hkQ);
      paramInt = i;
      if (this.Eay != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Eay);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.Eaz) + f.a.a.b.b.a.bx(17, this.EaA) + f.a.a.b.b.a.bx(18, this.EaB) + f.a.a.b.b.a.bx(19, this.CreateTime) + f.a.a.b.b.a.p(20, this.FPu);
      paramInt = i;
      if (this.FPv != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FPv);
      }
      AppMethodBeat.o(124558);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dgc localdgc = (dgc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localdgc.DPI = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localdgc.Title = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localdgc.Eal = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localdgc.Ean = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localdgc.Eap = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localdgc.Eaq = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localdgc.Ear = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localdgc.hkQ = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localdgc.Eay = locala.LVo.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localdgc.Eaz = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localdgc.EaA = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localdgc.EaB = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localdgc.CreateTime = locala.LVo.xF();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localdgc.FPu = locala.LVo.xG();
        AppMethodBeat.o(124558);
        return 0;
      }
      localdgc.FPv = locala.LVo.readString();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgc
 * JD-Core Version:    0.7.0.1
 */