package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class sk
  extends com.tencent.mm.bw.a
{
  public String CEN;
  public String KZW;
  public String KZX;
  public int KZY;
  public String KZZ;
  public String Laa;
  public String Lab;
  public String Lac;
  public String Lad;
  public String Lae;
  public String Laf;
  public String Lag;
  public String Lah;
  public boolean Lai;
  public String Laj;
  public String aeskey;
  public int height;
  public String iwN;
  public int len;
  public String md5;
  public String thumburl;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226004);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(226004);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.e(1, this.md5);
      }
      paramVarArgs.aM(2, this.len);
      if (this.CEN != null) {
        paramVarArgs.e(3, this.CEN);
      }
      paramVarArgs.aM(4, this.type);
      if (this.KZW != null) {
        paramVarArgs.e(5, this.KZW);
      }
      if (this.KZX != null) {
        paramVarArgs.e(6, this.KZX);
      }
      paramVarArgs.aM(7, this.KZY);
      if (this.KZZ != null) {
        paramVarArgs.e(8, this.KZZ);
      }
      if (this.thumburl != null) {
        paramVarArgs.e(9, this.thumburl);
      }
      if (this.Laa != null) {
        paramVarArgs.e(10, this.Laa);
      }
      if (this.aeskey != null) {
        paramVarArgs.e(11, this.aeskey);
      }
      paramVarArgs.aM(12, this.width);
      paramVarArgs.aM(13, this.height);
      if (this.Lab != null) {
        paramVarArgs.e(14, this.Lab);
      }
      if (this.Lac != null) {
        paramVarArgs.e(15, this.Lac);
      }
      if (this.Lad != null) {
        paramVarArgs.e(16, this.Lad);
      }
      if (this.iwN != null) {
        paramVarArgs.e(17, this.iwN);
      }
      if (this.Lae != null) {
        paramVarArgs.e(18, this.Lae);
      }
      if (this.Laf != null) {
        paramVarArgs.e(19, this.Laf);
      }
      if (this.Lag != null) {
        paramVarArgs.e(20, this.Lag);
      }
      if (this.Lah != null) {
        paramVarArgs.e(21, this.Lah);
      }
      paramVarArgs.cc(22, this.Lai);
      if (this.Laj != null) {
        paramVarArgs.e(23, this.Laj);
      }
      AppMethodBeat.o(226004);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label1518;
      }
    }
    label1518:
    for (paramInt = g.a.a.b.b.a.f(1, this.md5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.len);
      paramInt = i;
      if (this.CEN != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.CEN);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.KZW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KZW);
      }
      i = paramInt;
      if (this.KZX != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KZX);
      }
      i += g.a.a.b.b.a.bu(7, this.KZY);
      paramInt = i;
      if (this.KZZ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KZZ);
      }
      i = paramInt;
      if (this.thumburl != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.thumburl);
      }
      paramInt = i;
      if (this.Laa != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Laa);
      }
      i = paramInt;
      if (this.aeskey != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.aeskey);
      }
      i = i + g.a.a.b.b.a.bu(12, this.width) + g.a.a.b.b.a.bu(13, this.height);
      paramInt = i;
      if (this.Lab != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Lab);
      }
      i = paramInt;
      if (this.Lac != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Lac);
      }
      paramInt = i;
      if (this.Lad != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Lad);
      }
      i = paramInt;
      if (this.iwN != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.iwN);
      }
      paramInt = i;
      if (this.Lae != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Lae);
      }
      i = paramInt;
      if (this.Laf != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.Laf);
      }
      paramInt = i;
      if (this.Lag != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.Lag);
      }
      i = paramInt;
      if (this.Lah != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.Lah);
      }
      i += g.a.a.b.b.a.fS(22) + 1;
      paramInt = i;
      if (this.Laj != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.Laj);
      }
      AppMethodBeat.o(226004);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(226004);
          throw paramVarArgs;
        }
        AppMethodBeat.o(226004);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sk localsk = (sk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(226004);
          return -1;
        case 1: 
          localsk.md5 = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 2: 
          localsk.len = locala.UbS.zi();
          AppMethodBeat.o(226004);
          return 0;
        case 3: 
          localsk.CEN = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 4: 
          localsk.type = locala.UbS.zi();
          AppMethodBeat.o(226004);
          return 0;
        case 5: 
          localsk.KZW = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 6: 
          localsk.KZX = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 7: 
          localsk.KZY = locala.UbS.zi();
          AppMethodBeat.o(226004);
          return 0;
        case 8: 
          localsk.KZZ = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 9: 
          localsk.thumburl = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 10: 
          localsk.Laa = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 11: 
          localsk.aeskey = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 12: 
          localsk.width = locala.UbS.zi();
          AppMethodBeat.o(226004);
          return 0;
        case 13: 
          localsk.height = locala.UbS.zi();
          AppMethodBeat.o(226004);
          return 0;
        case 14: 
          localsk.Lab = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 15: 
          localsk.Lac = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 16: 
          localsk.Lad = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 17: 
          localsk.iwN = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 18: 
          localsk.Lae = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 19: 
          localsk.Laf = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 20: 
          localsk.Lag = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 21: 
          localsk.Lah = locala.UbS.readString();
          AppMethodBeat.o(226004);
          return 0;
        case 22: 
          localsk.Lai = locala.UbS.yZ();
          AppMethodBeat.o(226004);
          return 0;
        }
        localsk.Laj = locala.UbS.readString();
        AppMethodBeat.o(226004);
        return 0;
      }
      AppMethodBeat.o(226004);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sk
 * JD-Core Version:    0.7.0.1
 */