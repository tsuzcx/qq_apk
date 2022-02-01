package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cau
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String KLg;
  public String KOS;
  public String MfY;
  public String MfZ;
  public int Mga;
  public int Mgb;
  public int Mgc;
  public int Mgd;
  public String Mge;
  public String Mgf;
  public String Mgg;
  public String Mgh;
  public int Mgi;
  public int fMf;
  public long fMg;
  public String fMh;
  public String fMi;
  public String fMj;
  public String fMk;
  public String ked;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MfY != null) {
        paramVarArgs.e(1, this.MfY);
      }
      if (this.KLg != null) {
        paramVarArgs.e(2, this.KLg);
      }
      if (this.KOS != null) {
        paramVarArgs.e(3, this.KOS);
      }
      if (this.MfZ != null) {
        paramVarArgs.e(4, this.MfZ);
      }
      paramVarArgs.aM(5, this.Mga);
      paramVarArgs.aM(6, this.Mgb);
      paramVarArgs.aM(7, this.Mgc);
      paramVarArgs.aM(8, this.Mgd);
      if (this.Mge != null) {
        paramVarArgs.e(9, this.Mge);
      }
      if (this.ked != null) {
        paramVarArgs.e(10, this.ked);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(11, this.IconUrl);
      }
      if (this.xIy != null) {
        paramVarArgs.e(12, this.xIy);
      }
      if (this.Mgf != null) {
        paramVarArgs.e(13, this.Mgf);
      }
      if (this.Mgg != null) {
        paramVarArgs.e(14, this.Mgg);
      }
      if (this.Mgh != null) {
        paramVarArgs.e(15, this.Mgh);
      }
      paramVarArgs.aM(16, this.Mgi);
      paramVarArgs.aM(17, this.fMf);
      paramVarArgs.bb(18, this.fMg);
      if (this.fMh != null) {
        paramVarArgs.e(19, this.fMh);
      }
      if (this.fMi != null) {
        paramVarArgs.e(20, this.fMi);
      }
      if (this.fMj != null) {
        paramVarArgs.e(21, this.fMj);
      }
      if (this.fMk != null) {
        paramVarArgs.e(22, this.fMk);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MfY == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = g.a.a.b.b.a.f(1, this.MfY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KLg);
      }
      i = paramInt;
      if (this.KOS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KOS);
      }
      paramInt = i;
      if (this.MfZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MfZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Mga) + g.a.a.b.b.a.bu(6, this.Mgb) + g.a.a.b.b.a.bu(7, this.Mgc) + g.a.a.b.b.a.bu(8, this.Mgd);
      paramInt = i;
      if (this.Mge != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mge);
      }
      i = paramInt;
      if (this.ked != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.ked);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.IconUrl);
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.xIy);
      }
      paramInt = i;
      if (this.Mgf != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Mgf);
      }
      i = paramInt;
      if (this.Mgg != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.Mgg);
      }
      paramInt = i;
      if (this.Mgh != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Mgh);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.Mgi) + g.a.a.b.b.a.bu(17, this.fMf) + g.a.a.b.b.a.r(18, this.fMg);
      paramInt = i;
      if (this.fMh != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.fMh);
      }
      i = paramInt;
      if (this.fMi != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.fMi);
      }
      paramInt = i;
      if (this.fMj != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.fMj);
      }
      i = paramInt;
      if (this.fMk != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.fMk);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cau localcau = (cau)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localcau.MfY = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localcau.KLg = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localcau.KOS = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localcau.MfZ = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localcau.Mga = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localcau.Mgb = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localcau.Mgc = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localcau.Mgd = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localcau.Mge = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localcau.ked = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localcau.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localcau.xIy = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localcau.Mgf = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localcau.Mgg = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localcau.Mgh = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localcau.Mgi = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localcau.fMf = locala.UbS.zi();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localcau.fMg = locala.UbS.zl();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localcau.fMh = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localcau.fMi = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localcau.fMj = locala.UbS.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localcau.fMk = locala.UbS.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cau
 * JD-Core Version:    0.7.0.1
 */