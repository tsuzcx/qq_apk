package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eht
  extends com.tencent.mm.bw.a
{
  public String Nhj;
  public String Nhk;
  public int Nhl;
  public String cri;
  public String msg;
  public int nJK;
  public String patchMd5;
  public String pkK;
  public String title;
  public int versionCode;
  public String xWM;
  public String ynv;
  public String ynw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.cri == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.ynv == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.ynw == null)
      {
        paramVarArgs = new b("Not all required fields were included: oldApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.Nhk == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.xWM == null)
      {
        paramVarArgs = new b("Not all required fields were included: cancelBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.patchMd5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.cri != null) {
        paramVarArgs.e(1, this.cri);
      }
      if (this.Nhj != null) {
        paramVarArgs.e(2, this.Nhj);
      }
      paramVarArgs.aM(3, this.nJK);
      if (this.ynv != null) {
        paramVarArgs.e(4, this.ynv);
      }
      if (this.ynw != null) {
        paramVarArgs.e(5, this.ynw);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.e(7, this.msg);
      }
      if (this.Nhk != null) {
        paramVarArgs.e(8, this.Nhk);
      }
      if (this.xWM != null) {
        paramVarArgs.e(9, this.xWM);
      }
      if (this.pkK != null) {
        paramVarArgs.e(10, this.pkK);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.e(11, this.patchMd5);
      }
      paramVarArgs.aM(12, this.versionCode);
      paramVarArgs.aM(13, this.Nhl);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cri == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = g.a.a.b.b.a.f(1, this.cri) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nhj != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Nhj);
      }
      i += g.a.a.b.b.a.bu(3, this.nJK);
      paramInt = i;
      if (this.ynv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ynv);
      }
      i = paramInt;
      if (this.ynw != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ynw);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.msg);
      }
      paramInt = i;
      if (this.Nhk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nhk);
      }
      i = paramInt;
      if (this.xWM != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xWM);
      }
      paramInt = i;
      if (this.pkK != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.pkK);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.patchMd5);
      }
      paramInt = g.a.a.b.b.a.bu(12, this.versionCode);
      int j = g.a.a.b.b.a.bu(13, this.Nhl);
      AppMethodBeat.o(123719);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.cri == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.ynv == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.ynw == null)
        {
          paramVarArgs = new b("Not all required fields were included: oldApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.Nhk == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.xWM == null)
        {
          paramVarArgs = new b("Not all required fields were included: cancelBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.patchMd5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123719);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eht localeht = (eht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localeht.cri = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localeht.Nhj = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localeht.nJK = locala.UbS.zi();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localeht.ynv = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localeht.ynw = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localeht.title = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localeht.msg = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localeht.Nhk = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localeht.xWM = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localeht.pkK = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localeht.patchMd5 = locala.UbS.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 12: 
          localeht.versionCode = locala.UbS.zi();
          AppMethodBeat.o(123719);
          return 0;
        }
        localeht.Nhl = locala.UbS.zi();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eht
 * JD-Core Version:    0.7.0.1
 */