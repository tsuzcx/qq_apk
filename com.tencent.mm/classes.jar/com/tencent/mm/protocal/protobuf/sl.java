package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sl
  extends com.tencent.mm.bw.a
{
  public int ETL;
  public int ETM;
  public int Lak;
  public int Lal;
  public int Lam;
  public int Lan;
  public int Lao;
  public int Lap;
  public int Laq;
  public int Lar;
  public int Las;
  public int Lat;
  public int Lau;
  public String aeskey;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226005);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.aeskey != null) {
        paramVarArgs.e(1, this.aeskey);
      }
      paramVarArgs.aM(2, this.Lak);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.aM(4, this.Lal);
      paramVarArgs.aM(5, this.Lam);
      paramVarArgs.aM(6, this.Lan);
      paramVarArgs.aM(7, this.ETM);
      paramVarArgs.aM(8, this.ETL);
      if (this.md5 != null) {
        paramVarArgs.e(9, this.md5);
      }
      paramVarArgs.aM(10, this.Lao);
      paramVarArgs.aM(11, this.Lap);
      paramVarArgs.aM(12, this.Laq);
      paramVarArgs.aM(13, this.Lar);
      paramVarArgs.aM(14, this.Las);
      paramVarArgs.aM(15, this.Lat);
      paramVarArgs.aM(16, this.Lau);
      AppMethodBeat.o(226005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = g.a.a.b.b.a.f(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Lak);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Lal) + g.a.a.b.b.a.bu(5, this.Lam) + g.a.a.b.b.a.bu(6, this.Lan) + g.a.a.b.b.a.bu(7, this.ETM) + g.a.a.b.b.a.bu(8, this.ETL);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.md5);
      }
      i = g.a.a.b.b.a.bu(10, this.Lao);
      int j = g.a.a.b.b.a.bu(11, this.Lap);
      int k = g.a.a.b.b.a.bu(12, this.Laq);
      int m = g.a.a.b.b.a.bu(13, this.Lar);
      int n = g.a.a.b.b.a.bu(14, this.Las);
      int i1 = g.a.a.b.b.a.bu(15, this.Lat);
      int i2 = g.a.a.b.b.a.bu(16, this.Lau);
      AppMethodBeat.o(226005);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(226005);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sl localsl = (sl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(226005);
          return -1;
        case 1: 
          localsl.aeskey = locala.UbS.readString();
          AppMethodBeat.o(226005);
          return 0;
        case 2: 
          localsl.Lak = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 3: 
          localsl.url = locala.UbS.readString();
          AppMethodBeat.o(226005);
          return 0;
        case 4: 
          localsl.Lal = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 5: 
          localsl.Lam = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 6: 
          localsl.Lan = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 7: 
          localsl.ETM = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 8: 
          localsl.ETL = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 9: 
          localsl.md5 = locala.UbS.readString();
          AppMethodBeat.o(226005);
          return 0;
        case 10: 
          localsl.Lao = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 11: 
          localsl.Lap = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 12: 
          localsl.Laq = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 13: 
          localsl.Lar = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 14: 
          localsl.Las = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        case 15: 
          localsl.Lat = locala.UbS.zi();
          AppMethodBeat.o(226005);
          return 0;
        }
        localsl.Lau = locala.UbS.zi();
        AppMethodBeat.o(226005);
        return 0;
      }
      AppMethodBeat.o(226005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sl
 * JD-Core Version:    0.7.0.1
 */