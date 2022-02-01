package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class sd
  extends com.tencent.mm.cd.a
{
  public String IKm;
  public String Sbf;
  public String Sbg;
  public int Sbh;
  public String Sbi;
  public String Sbj;
  public String Sbk;
  public String Sbl;
  public String Sbm;
  public String Sbn;
  public String Sbo;
  public String Sbp;
  public String Sbq;
  public boolean Sbr;
  public String Sbs;
  public String aeskey;
  public int fTZ;
  public int height;
  public String lmc;
  public String md5;
  public String thumburl;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(247676);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.f(1, this.md5);
      }
      paramVarArgs.aY(2, this.fTZ);
      if (this.IKm != null) {
        paramVarArgs.f(3, this.IKm);
      }
      paramVarArgs.aY(4, this.type);
      if (this.Sbf != null) {
        paramVarArgs.f(5, this.Sbf);
      }
      if (this.Sbg != null) {
        paramVarArgs.f(6, this.Sbg);
      }
      paramVarArgs.aY(7, this.Sbh);
      if (this.Sbi != null) {
        paramVarArgs.f(8, this.Sbi);
      }
      if (this.thumburl != null) {
        paramVarArgs.f(9, this.thumburl);
      }
      if (this.Sbj != null) {
        paramVarArgs.f(10, this.Sbj);
      }
      if (this.aeskey != null) {
        paramVarArgs.f(11, this.aeskey);
      }
      paramVarArgs.aY(12, this.width);
      paramVarArgs.aY(13, this.height);
      if (this.Sbk != null) {
        paramVarArgs.f(14, this.Sbk);
      }
      if (this.Sbl != null) {
        paramVarArgs.f(15, this.Sbl);
      }
      if (this.Sbm != null) {
        paramVarArgs.f(16, this.Sbm);
      }
      if (this.lmc != null) {
        paramVarArgs.f(17, this.lmc);
      }
      if (this.Sbn != null) {
        paramVarArgs.f(18, this.Sbn);
      }
      if (this.Sbo != null) {
        paramVarArgs.f(19, this.Sbo);
      }
      if (this.Sbp != null) {
        paramVarArgs.f(20, this.Sbp);
      }
      if (this.Sbq != null) {
        paramVarArgs.f(21, this.Sbq);
      }
      paramVarArgs.co(22, this.Sbr);
      if (this.Sbs != null) {
        paramVarArgs.f(23, this.Sbs);
      }
      AppMethodBeat.o(247676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label1518;
      }
    }
    label1518:
    for (paramInt = g.a.a.b.b.a.g(1, this.md5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fTZ);
      paramInt = i;
      if (this.IKm != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.IKm);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.Sbf != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sbf);
      }
      i = paramInt;
      if (this.Sbg != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Sbg);
      }
      i += g.a.a.b.b.a.bM(7, this.Sbh);
      paramInt = i;
      if (this.Sbi != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Sbi);
      }
      i = paramInt;
      if (this.thumburl != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.thumburl);
      }
      paramInt = i;
      if (this.Sbj != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Sbj);
      }
      i = paramInt;
      if (this.aeskey != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.aeskey);
      }
      i = i + g.a.a.b.b.a.bM(12, this.width) + g.a.a.b.b.a.bM(13, this.height);
      paramInt = i;
      if (this.Sbk != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Sbk);
      }
      i = paramInt;
      if (this.Sbl != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Sbl);
      }
      paramInt = i;
      if (this.Sbm != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Sbm);
      }
      i = paramInt;
      if (this.lmc != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.lmc);
      }
      paramInt = i;
      if (this.Sbn != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.Sbn);
      }
      i = paramInt;
      if (this.Sbo != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.Sbo);
      }
      paramInt = i;
      if (this.Sbp != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.Sbp);
      }
      i = paramInt;
      if (this.Sbq != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.Sbq);
      }
      i += g.a.a.b.b.a.gL(22) + 1;
      paramInt = i;
      if (this.Sbs != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.Sbs);
      }
      AppMethodBeat.o(247676);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(247676);
          throw paramVarArgs;
        }
        AppMethodBeat.o(247676);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(247676);
          return -1;
        case 1: 
          localsd.md5 = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 2: 
          localsd.fTZ = locala.abFh.AK();
          AppMethodBeat.o(247676);
          return 0;
        case 3: 
          localsd.IKm = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 4: 
          localsd.type = locala.abFh.AK();
          AppMethodBeat.o(247676);
          return 0;
        case 5: 
          localsd.Sbf = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 6: 
          localsd.Sbg = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 7: 
          localsd.Sbh = locala.abFh.AK();
          AppMethodBeat.o(247676);
          return 0;
        case 8: 
          localsd.Sbi = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 9: 
          localsd.thumburl = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 10: 
          localsd.Sbj = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 11: 
          localsd.aeskey = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 12: 
          localsd.width = locala.abFh.AK();
          AppMethodBeat.o(247676);
          return 0;
        case 13: 
          localsd.height = locala.abFh.AK();
          AppMethodBeat.o(247676);
          return 0;
        case 14: 
          localsd.Sbk = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 15: 
          localsd.Sbl = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 16: 
          localsd.Sbm = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 17: 
          localsd.lmc = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 18: 
          localsd.Sbn = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 19: 
          localsd.Sbo = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 20: 
          localsd.Sbp = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 21: 
          localsd.Sbq = locala.abFh.readString();
          AppMethodBeat.o(247676);
          return 0;
        case 22: 
          localsd.Sbr = locala.abFh.AB();
          AppMethodBeat.o(247676);
          return 0;
        }
        localsd.Sbs = locala.abFh.readString();
        AppMethodBeat.o(247676);
        return 0;
      }
      AppMethodBeat.o(247676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */