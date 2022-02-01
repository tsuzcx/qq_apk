package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aie
  extends com.tencent.mm.bw.a
{
  public String ECA;
  public long ECB;
  public String ECC;
  public String ECD;
  public String ECE;
  public String ECF;
  public String ECG;
  public String ECH;
  public int ECI;
  public String ECJ;
  public int ECK;
  public long ECx;
  public long ECy;
  public long ECz;
  public String Enm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ECx);
      paramVarArgs.aO(2, this.ECy);
      paramVarArgs.aO(3, this.ECz);
      if (this.ECA != null) {
        paramVarArgs.d(4, this.ECA);
      }
      paramVarArgs.aO(5, this.ECB);
      if (this.ECC != null) {
        paramVarArgs.d(6, this.ECC);
      }
      if (this.ECD != null) {
        paramVarArgs.d(7, this.ECD);
      }
      if (this.ECE != null) {
        paramVarArgs.d(8, this.ECE);
      }
      if (this.ECF != null) {
        paramVarArgs.d(9, this.ECF);
      }
      if (this.ECG != null) {
        paramVarArgs.d(10, this.ECG);
      }
      if (this.ECH != null) {
        paramVarArgs.d(11, this.ECH);
      }
      paramVarArgs.aR(12, this.ECI);
      if (this.ECJ != null) {
        paramVarArgs.d(13, this.ECJ);
      }
      paramVarArgs.aR(14, this.ECK);
      if (this.Enm != null) {
        paramVarArgs.d(15, this.Enm);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.ECx) + 0 + f.a.a.b.b.a.p(2, this.ECy) + f.a.a.b.b.a.p(3, this.ECz);
      paramInt = i;
      if (this.ECA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ECA);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.ECB);
      paramInt = i;
      if (this.ECC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ECC);
      }
      i = paramInt;
      if (this.ECD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ECD);
      }
      paramInt = i;
      if (this.ECE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ECE);
      }
      i = paramInt;
      if (this.ECF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ECF);
      }
      paramInt = i;
      if (this.ECG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ECG);
      }
      i = paramInt;
      if (this.ECH != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ECH);
      }
      i += f.a.a.b.b.a.bx(12, this.ECI);
      paramInt = i;
      if (this.ECJ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ECJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.ECK);
      paramInt = i;
      if (this.Enm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Enm);
      }
      AppMethodBeat.o(91460);
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
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aie localaie = (aie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localaie.ECx = locala.LVo.xG();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localaie.ECy = locala.LVo.xG();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localaie.ECz = locala.LVo.xG();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localaie.ECA = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localaie.ECB = locala.LVo.xG();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localaie.ECC = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localaie.ECD = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localaie.ECE = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localaie.ECF = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localaie.ECG = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localaie.ECH = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localaie.ECI = locala.LVo.xF();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localaie.ECJ = locala.LVo.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localaie.ECK = locala.LVo.xF();
        AppMethodBeat.o(91460);
        return 0;
      }
      localaie.Enm = locala.LVo.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aie
 * JD-Core Version:    0.7.0.1
 */