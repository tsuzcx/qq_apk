package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dbz
  extends com.tencent.mm.bx.a
{
  public String EtF;
  public String EtG;
  public String bLg;
  public int lsc;
  public String patchMd5;
  public String sne;
  public String syH;
  public String syJ;
  public String syK;
  public String syL;
  public String title;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.syJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.syK == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.syL == null)
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
      if (this.EtG == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.sne == null)
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
      if (this.syJ != null) {
        paramVarArgs.d(1, this.syJ);
      }
      if (this.EtF != null) {
        paramVarArgs.d(2, this.EtF);
      }
      paramVarArgs.aR(3, this.lsc);
      if (this.syK != null) {
        paramVarArgs.d(4, this.syK);
      }
      if (this.syL != null) {
        paramVarArgs.d(5, this.syL);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.bLg != null) {
        paramVarArgs.d(7, this.bLg);
      }
      if (this.EtG != null) {
        paramVarArgs.d(8, this.EtG);
      }
      if (this.sne != null) {
        paramVarArgs.d(9, this.sne);
      }
      if (this.syH != null) {
        paramVarArgs.d(10, this.syH);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.d(11, this.patchMd5);
      }
      paramVarArgs.aR(12, this.versionCode);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syJ == null) {
        break label1194;
      }
    }
    label1194:
    for (paramInt = f.a.a.b.b.a.e(1, this.syJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EtF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EtF);
      }
      i += f.a.a.b.b.a.bA(3, this.lsc);
      paramInt = i;
      if (this.syK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.syK);
      }
      i = paramInt;
      if (this.syL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.syL);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.title);
      }
      i = paramInt;
      if (this.bLg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bLg);
      }
      paramInt = i;
      if (this.EtG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EtG);
      }
      i = paramInt;
      if (this.sne != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.sne);
      }
      paramInt = i;
      if (this.syH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.syH);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.patchMd5);
      }
      paramInt = f.a.a.b.b.a.bA(12, this.versionCode);
      AppMethodBeat.o(123719);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.syJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.syK == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.syL == null)
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
        if (this.EtG == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.sne == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dbz localdbz = (dbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localdbz.syJ = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localdbz.EtF = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localdbz.lsc = locala.KhF.xS();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localdbz.syK = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localdbz.syL = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localdbz.title = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localdbz.bLg = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localdbz.EtG = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localdbz.sne = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localdbz.syH = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localdbz.patchMd5 = locala.KhF.readString();
          AppMethodBeat.o(123719);
          return 0;
        }
        localdbz.versionCode = locala.KhF.xS();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbz
 * JD-Core Version:    0.7.0.1
 */