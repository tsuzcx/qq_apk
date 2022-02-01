package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dna
  extends com.tencent.mm.bx.a
{
  public String HBm;
  public String HBn;
  public int HBo;
  public String gHx;
  public String msg;
  public int mtM;
  public String nUh;
  public String patchMd5;
  public String title;
  public String uJh;
  public String uJi;
  public String utw;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nUh == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.uJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.uJi == null)
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
      if (this.HBn == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.utw == null)
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
      if (this.nUh != null) {
        paramVarArgs.d(1, this.nUh);
      }
      if (this.HBm != null) {
        paramVarArgs.d(2, this.HBm);
      }
      paramVarArgs.aS(3, this.mtM);
      if (this.uJh != null) {
        paramVarArgs.d(4, this.uJh);
      }
      if (this.uJi != null) {
        paramVarArgs.d(5, this.uJi);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.d(7, this.msg);
      }
      if (this.HBn != null) {
        paramVarArgs.d(8, this.HBn);
      }
      if (this.utw != null) {
        paramVarArgs.d(9, this.utw);
      }
      if (this.gHx != null) {
        paramVarArgs.d(10, this.gHx);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.d(11, this.patchMd5);
      }
      paramVarArgs.aS(12, this.versionCode);
      paramVarArgs.aS(13, this.HBo);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUh == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = f.a.a.b.b.a.e(1, this.nUh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HBm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HBm);
      }
      i += f.a.a.b.b.a.bz(3, this.mtM);
      paramInt = i;
      if (this.uJh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uJh);
      }
      i = paramInt;
      if (this.uJi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uJi);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.msg);
      }
      paramInt = i;
      if (this.HBn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HBn);
      }
      i = paramInt;
      if (this.utw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.utw);
      }
      paramInt = i;
      if (this.gHx != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.gHx);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.patchMd5);
      }
      paramInt = f.a.a.b.b.a.bz(12, this.versionCode);
      int j = f.a.a.b.b.a.bz(13, this.HBo);
      AppMethodBeat.o(123719);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nUh == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.uJh == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.uJi == null)
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
        if (this.HBn == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.utw == null)
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
        dna localdna = (dna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localdna.nUh = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localdna.HBm = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localdna.mtM = locala.NPN.zc();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localdna.uJh = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localdna.uJi = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localdna.title = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localdna.msg = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localdna.HBn = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localdna.utw = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localdna.gHx = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localdna.patchMd5 = locala.NPN.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 12: 
          localdna.versionCode = locala.NPN.zc();
          AppMethodBeat.o(123719);
          return 0;
        }
        localdna.HBo = locala.NPN.zc();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */