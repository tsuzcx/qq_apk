package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eaa
  extends com.tencent.mm.bw.a
{
  public String ErZ;
  public int Esb;
  public int Esd;
  public String LIb;
  public float LbC;
  public float LbD;
  public String Mpt;
  public int Mpu;
  public int Mpv;
  public b Mpw;
  public String Mpx;
  public float cjn;
  public String country;
  public String kHV;
  public String kea;
  public int score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.LbC);
      paramVarArgs.E(2, this.LbD);
      if (this.kea != null) {
        paramVarArgs.e(3, this.kea);
      }
      if (this.kHV != null) {
        paramVarArgs.e(4, this.kHV);
      }
      if (this.ErZ != null) {
        paramVarArgs.e(5, this.ErZ);
      }
      if (this.LIb != null) {
        paramVarArgs.e(6, this.LIb);
      }
      paramVarArgs.aM(7, this.Esb);
      if (this.Mpt != null) {
        paramVarArgs.e(8, this.Mpt);
      }
      paramVarArgs.aM(9, this.Mpu);
      paramVarArgs.aM(10, this.Mpv);
      paramVarArgs.aM(11, this.Esd);
      paramVarArgs.E(12, this.cjn);
      if (this.Mpw != null) {
        paramVarArgs.c(13, this.Mpw);
      }
      paramVarArgs.aM(14, this.score);
      if (this.Mpx != null) {
        paramVarArgs.e(15, this.Mpx);
      }
      if (this.country != null) {
        paramVarArgs.e(16, this.country);
      }
      AppMethodBeat.o(209815);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 4 + 0 + (g.a.a.b.b.a.fS(2) + 4);
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.kea);
      }
      i = paramInt;
      if (this.kHV != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.kHV);
      }
      paramInt = i;
      if (this.ErZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ErZ);
      }
      i = paramInt;
      if (this.LIb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LIb);
      }
      i += g.a.a.b.b.a.bu(7, this.Esb);
      paramInt = i;
      if (this.Mpt != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mpt);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Mpu) + g.a.a.b.b.a.bu(10, this.Mpv) + g.a.a.b.b.a.bu(11, this.Esd) + (g.a.a.b.b.a.fS(12) + 4);
      paramInt = i;
      if (this.Mpw != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.Mpw);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.score);
      paramInt = i;
      if (this.Mpx != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Mpx);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.country);
      }
      AppMethodBeat.o(209815);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209815);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eaa localeaa = (eaa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209815);
        return -1;
      case 1: 
        localeaa.LbC = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209815);
        return 0;
      case 2: 
        localeaa.LbD = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209815);
        return 0;
      case 3: 
        localeaa.kea = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      case 4: 
        localeaa.kHV = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      case 5: 
        localeaa.ErZ = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      case 6: 
        localeaa.LIb = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      case 7: 
        localeaa.Esb = locala.UbS.zi();
        AppMethodBeat.o(209815);
        return 0;
      case 8: 
        localeaa.Mpt = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      case 9: 
        localeaa.Mpu = locala.UbS.zi();
        AppMethodBeat.o(209815);
        return 0;
      case 10: 
        localeaa.Mpv = locala.UbS.zi();
        AppMethodBeat.o(209815);
        return 0;
      case 11: 
        localeaa.Esd = locala.UbS.zi();
        AppMethodBeat.o(209815);
        return 0;
      case 12: 
        localeaa.cjn = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209815);
        return 0;
      case 13: 
        localeaa.Mpw = locala.UbS.hPo();
        AppMethodBeat.o(209815);
        return 0;
      case 14: 
        localeaa.score = locala.UbS.zi();
        AppMethodBeat.o(209815);
        return 0;
      case 15: 
        localeaa.Mpx = locala.UbS.readString();
        AppMethodBeat.o(209815);
        return 0;
      }
      localeaa.country = locala.UbS.readString();
      AppMethodBeat.o(209815);
      return 0;
    }
    AppMethodBeat.o(209815);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaa
 * JD-Core Version:    0.7.0.1
 */