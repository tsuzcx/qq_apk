package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ckf
  extends com.tencent.mm.bv.a
{
  public String bWN;
  public String bjm;
  public int iHT;
  public String nDF;
  public String nKP;
  public String nKR;
  public String nKS;
  public String nKT;
  public String title;
  public int versionCode;
  public String xUk;
  public String xUl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105579);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nKR == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.nKS == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.nKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: oldApkMd5");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.xUl == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.nDF == null)
      {
        paramVarArgs = new b("Not all required fields were included: cancelBtn");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.bWN == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchMd5");
        AppMethodBeat.o(105579);
        throw paramVarArgs;
      }
      if (this.nKR != null) {
        paramVarArgs.e(1, this.nKR);
      }
      if (this.xUk != null) {
        paramVarArgs.e(2, this.xUk);
      }
      paramVarArgs.aO(3, this.iHT);
      if (this.nKS != null) {
        paramVarArgs.e(4, this.nKS);
      }
      if (this.nKT != null) {
        paramVarArgs.e(5, this.nKT);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.bjm != null) {
        paramVarArgs.e(7, this.bjm);
      }
      if (this.xUl != null) {
        paramVarArgs.e(8, this.xUl);
      }
      if (this.nDF != null) {
        paramVarArgs.e(9, this.nDF);
      }
      if (this.nKP != null) {
        paramVarArgs.e(10, this.nKP);
      }
      if (this.bWN != null) {
        paramVarArgs.e(11, this.bWN);
      }
      paramVarArgs.aO(12, this.versionCode);
      AppMethodBeat.o(105579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nKR == null) {
        break label1194;
      }
    }
    label1194:
    for (paramInt = e.a.a.b.b.a.f(1, this.nKR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xUk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xUk);
      }
      i += e.a.a.b.b.a.bl(3, this.iHT);
      paramInt = i;
      if (this.nKS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nKS);
      }
      i = paramInt;
      if (this.nKT != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nKT);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.title);
      }
      i = paramInt;
      if (this.bjm != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.bjm);
      }
      paramInt = i;
      if (this.xUl != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xUl);
      }
      i = paramInt;
      if (this.nDF != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.nDF);
      }
      paramInt = i;
      if (this.nKP != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.nKP);
      }
      i = paramInt;
      if (this.bWN != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.bWN);
      }
      paramInt = e.a.a.b.b.a.bl(12, this.versionCode);
      AppMethodBeat.o(105579);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nKR == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.nKS == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.nKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: oldApkMd5");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.xUl == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.nDF == null)
        {
          paramVarArgs = new b("Not all required fields were included: cancelBtn");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        if (this.bWN == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchMd5");
          AppMethodBeat.o(105579);
          throw paramVarArgs;
        }
        AppMethodBeat.o(105579);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckf localckf = (ckf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(105579);
          return -1;
        case 1: 
          localckf.nKR = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 2: 
          localckf.xUk = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 3: 
          localckf.iHT = locala.CLY.sl();
          AppMethodBeat.o(105579);
          return 0;
        case 4: 
          localckf.nKS = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 5: 
          localckf.nKT = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 6: 
          localckf.title = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 7: 
          localckf.bjm = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 8: 
          localckf.xUl = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 9: 
          localckf.nDF = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 10: 
          localckf.nKP = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        case 11: 
          localckf.bWN = locala.CLY.readString();
          AppMethodBeat.o(105579);
          return 0;
        }
        localckf.versionCode = locala.CLY.sl();
        AppMethodBeat.o(105579);
        return 0;
      }
      AppMethodBeat.o(105579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckf
 * JD-Core Version:    0.7.0.1
 */