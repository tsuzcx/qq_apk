package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fne
  extends com.tencent.mm.bx.a
{
  public String IVk;
  public String JEL;
  public String JEM;
  public String abNl;
  public String abNm;
  public int abNn;
  public String egJ;
  public int hDq;
  public String mOI;
  public String msg;
  public String patchMd5;
  public int tQE;
  public String title;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.egJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.JEL == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.JEM == null)
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
      if (this.abNm == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.IVk == null)
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
      if (this.egJ != null) {
        paramVarArgs.g(1, this.egJ);
      }
      if (this.abNl != null) {
        paramVarArgs.g(2, this.abNl);
      }
      paramVarArgs.bS(3, this.tQE);
      if (this.JEL != null) {
        paramVarArgs.g(4, this.JEL);
      }
      if (this.JEM != null) {
        paramVarArgs.g(5, this.JEM);
      }
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.g(7, this.msg);
      }
      if (this.abNm != null) {
        paramVarArgs.g(8, this.abNm);
      }
      if (this.IVk != null) {
        paramVarArgs.g(9, this.IVk);
      }
      if (this.mOI != null) {
        paramVarArgs.g(10, this.mOI);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.g(11, this.patchMd5);
      }
      paramVarArgs.bS(12, this.versionCode);
      paramVarArgs.bS(13, this.abNn);
      paramVarArgs.bS(14, this.hDq);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.egJ == null) {
        break label1286;
      }
    }
    label1286:
    for (paramInt = i.a.a.b.b.a.h(1, this.egJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abNl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abNl);
      }
      i += i.a.a.b.b.a.cJ(3, this.tQE);
      paramInt = i;
      if (this.JEL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.JEL);
      }
      i = paramInt;
      if (this.JEM != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.JEM);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.msg);
      }
      paramInt = i;
      if (this.abNm != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abNm);
      }
      i = paramInt;
      if (this.IVk != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.IVk);
      }
      paramInt = i;
      if (this.mOI != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.mOI);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.patchMd5);
      }
      paramInt = i.a.a.b.b.a.cJ(12, this.versionCode);
      int j = i.a.a.b.b.a.cJ(13, this.abNn);
      int k = i.a.a.b.b.a.cJ(14, this.hDq);
      AppMethodBeat.o(123719);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.egJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.JEL == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.JEM == null)
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
        if (this.abNm == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.IVk == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fne localfne = (fne)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localfne.egJ = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localfne.abNl = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localfne.tQE = locala.ajGk.aar();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localfne.JEL = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localfne.JEM = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localfne.title = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localfne.msg = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localfne.abNm = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localfne.IVk = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localfne.mOI = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localfne.patchMd5 = locala.ajGk.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 12: 
          localfne.versionCode = locala.ajGk.aar();
          AppMethodBeat.o(123719);
          return 0;
        case 13: 
          localfne.abNn = locala.ajGk.aar();
          AppMethodBeat.o(123719);
          return 0;
        }
        localfne.hDq = locala.ajGk.aar();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fne
 * JD-Core Version:    0.7.0.1
 */