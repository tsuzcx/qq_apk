package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dhl
  extends com.tencent.mm.bw.a
{
  public String FQH;
  public String FQI;
  public String bIO;
  public String gnO;
  public int lTX;
  public String ntl;
  public String patchMd5;
  public String tGu;
  public String tGv;
  public String title;
  public String tuX;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ntl == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.tGu == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.tGv == null)
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
      if (this.FQI == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.tuX == null)
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
      if (this.ntl != null) {
        paramVarArgs.d(1, this.ntl);
      }
      if (this.FQH != null) {
        paramVarArgs.d(2, this.FQH);
      }
      paramVarArgs.aR(3, this.lTX);
      if (this.tGu != null) {
        paramVarArgs.d(4, this.tGu);
      }
      if (this.tGv != null) {
        paramVarArgs.d(5, this.tGv);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.bIO != null) {
        paramVarArgs.d(7, this.bIO);
      }
      if (this.FQI != null) {
        paramVarArgs.d(8, this.FQI);
      }
      if (this.tuX != null) {
        paramVarArgs.d(9, this.tuX);
      }
      if (this.gnO != null) {
        paramVarArgs.d(10, this.gnO);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.d(11, this.patchMd5);
      }
      paramVarArgs.aR(12, this.versionCode);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntl == null) {
        break label1194;
      }
    }
    label1194:
    for (paramInt = f.a.a.b.b.a.e(1, this.ntl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FQH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FQH);
      }
      i += f.a.a.b.b.a.bx(3, this.lTX);
      paramInt = i;
      if (this.tGu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tGu);
      }
      i = paramInt;
      if (this.tGv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tGv);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.title);
      }
      i = paramInt;
      if (this.bIO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bIO);
      }
      paramInt = i;
      if (this.FQI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FQI);
      }
      i = paramInt;
      if (this.tuX != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.tuX);
      }
      paramInt = i;
      if (this.gnO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.gnO);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.patchMd5);
      }
      paramInt = f.a.a.b.b.a.bx(12, this.versionCode);
      AppMethodBeat.o(123719);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ntl == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.tGu == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.tGv == null)
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
        if (this.FQI == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.tuX == null)
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
        dhl localdhl = (dhl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localdhl.ntl = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localdhl.FQH = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localdhl.lTX = locala.LVo.xF();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localdhl.tGu = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localdhl.tGv = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localdhl.title = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localdhl.bIO = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localdhl.FQI = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localdhl.tuX = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localdhl.gnO = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localdhl.patchMd5 = locala.LVo.readString();
          AppMethodBeat.o(123719);
          return 0;
        }
        localdhl.versionCode = locala.LVo.xF();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhl
 * JD-Core Version:    0.7.0.1
 */