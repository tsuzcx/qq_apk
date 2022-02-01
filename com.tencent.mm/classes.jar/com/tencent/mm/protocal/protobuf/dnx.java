package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dnx
  extends com.tencent.mm.bw.a
{
  public String HUZ;
  public String HVa;
  public int HVb;
  public String gKg;
  public String msg;
  public int myJ;
  public String nZN;
  public String patchMd5;
  public String title;
  public String uEP;
  public String uUU;
  public String uUV;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nZN == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.uUU == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.uUV == null)
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
      if (this.HVa == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.uEP == null)
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
      if (this.nZN != null) {
        paramVarArgs.d(1, this.nZN);
      }
      if (this.HUZ != null) {
        paramVarArgs.d(2, this.HUZ);
      }
      paramVarArgs.aS(3, this.myJ);
      if (this.uUU != null) {
        paramVarArgs.d(4, this.uUU);
      }
      if (this.uUV != null) {
        paramVarArgs.d(5, this.uUV);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.d(7, this.msg);
      }
      if (this.HVa != null) {
        paramVarArgs.d(8, this.HVa);
      }
      if (this.uEP != null) {
        paramVarArgs.d(9, this.uEP);
      }
      if (this.gKg != null) {
        paramVarArgs.d(10, this.gKg);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.d(11, this.patchMd5);
      }
      paramVarArgs.aS(12, this.versionCode);
      paramVarArgs.aS(13, this.HVb);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nZN == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = f.a.a.b.b.a.e(1, this.nZN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HUZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HUZ);
      }
      i += f.a.a.b.b.a.bz(3, this.myJ);
      paramInt = i;
      if (this.uUU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uUU);
      }
      i = paramInt;
      if (this.uUV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uUV);
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
      if (this.HVa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HVa);
      }
      i = paramInt;
      if (this.uEP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uEP);
      }
      paramInt = i;
      if (this.gKg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.gKg);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.patchMd5);
      }
      paramInt = f.a.a.b.b.a.bz(12, this.versionCode);
      int j = f.a.a.b.b.a.bz(13, this.HVb);
      AppMethodBeat.o(123719);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nZN == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.uUU == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.uUV == null)
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
        if (this.HVa == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.uEP == null)
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
        dnx localdnx = (dnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localdnx.nZN = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localdnx.HUZ = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localdnx.myJ = locala.OmT.zc();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localdnx.uUU = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localdnx.uUV = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localdnx.title = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localdnx.msg = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localdnx.HVa = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localdnx.uEP = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localdnx.gKg = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localdnx.patchMd5 = locala.OmT.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 12: 
          localdnx.versionCode = locala.OmT.zc();
          AppMethodBeat.o(123719);
          return 0;
        }
        localdnx.HVb = locala.OmT.zc();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnx
 * JD-Core Version:    0.7.0.1
 */