package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtw
  extends cvw
{
  public String FKQ;
  public String FKR;
  public String FKS;
  public cxn FNG;
  public cxn FNH;
  public String FNL;
  public int GUb;
  public String Ghg;
  public int Ghh;
  public int Ghi;
  public int Ghj;
  public String Ghk;
  public int GqB;
  public int GwZ;
  public int HJK;
  public int HPi;
  public int HZA;
  public int HZB;
  public int HZC;
  public cxn HZu;
  public String HZv;
  public String HZw;
  public int HZx;
  public int HZy;
  public String HZz;
  public String Hdo;
  public int HoG;
  public String Hvb;
  public String Md5;
  public String ikm;
  public String ikp;
  public int urJ;
  public int xsB;
  public int xsC;
  public int xsD;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HZu != null)
      {
        paramVarArgs.lJ(2, this.HZu.computeSize());
        this.HZu.writeFields(paramVarArgs);
      }
      if (this.FNG != null)
      {
        paramVarArgs.lJ(3, this.FNG.computeSize());
        this.FNG.writeFields(paramVarArgs);
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(4, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xsB);
      paramVarArgs.aS(6, this.xsC);
      paramVarArgs.aS(7, this.xsD);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(8, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.urJ);
      if (this.FNL != null) {
        paramVarArgs.d(10, this.FNL);
      }
      paramVarArgs.aS(11, this.GUb);
      paramVarArgs.aS(12, this.GqB);
      paramVarArgs.aS(13, this.HPi);
      if (this.ikp != null) {
        paramVarArgs.d(14, this.ikp);
      }
      if (this.HZv != null) {
        paramVarArgs.d(15, this.HZv);
      }
      if (this.HZw != null) {
        paramVarArgs.d(16, this.HZw);
      }
      if (this.Ghg != null) {
        paramVarArgs.d(17, this.Ghg);
      }
      paramVarArgs.aS(18, this.Ghh);
      paramVarArgs.aS(19, this.HZx);
      paramVarArgs.aS(20, this.HZy);
      if (this.HZz != null) {
        paramVarArgs.d(21, this.HZz);
      }
      paramVarArgs.aS(22, this.HZA);
      paramVarArgs.aS(23, this.HZB);
      paramVarArgs.aS(24, this.HZC);
      if (this.Hdo != null) {
        paramVarArgs.d(25, this.Hdo);
      }
      paramVarArgs.aS(26, this.GwZ);
      if (this.Md5 != null) {
        paramVarArgs.d(27, this.Md5);
      }
      paramVarArgs.aS(28, this.Ghi);
      paramVarArgs.aS(29, this.Ghj);
      paramVarArgs.aS(30, this.HJK);
      if (this.ikm != null) {
        paramVarArgs.d(31, this.ikm);
      }
      if (this.FKS != null) {
        paramVarArgs.d(32, this.FKS);
      }
      if (this.FKR != null) {
        paramVarArgs.d(33, this.FKR);
      }
      if (this.FKQ != null) {
        paramVarArgs.d(34, this.FKQ);
      }
      if (this.Ghk != null) {
        paramVarArgs.d(35, this.Ghk);
      }
      paramVarArgs.aS(36, this.HoG);
      if (this.Hvb != null) {
        paramVarArgs.d(37, this.Hvb);
      }
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2794;
      }
    }
    label2794:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HZu != null) {
        paramInt = i + f.a.a.a.lI(2, this.HZu.computeSize());
      }
      i = paramInt;
      if (this.FNG != null) {
        i = paramInt + f.a.a.a.lI(3, this.FNG.computeSize());
      }
      paramInt = i;
      if (this.FNH != null) {
        paramInt = i + f.a.a.a.lI(4, this.FNH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xsB) + f.a.a.b.b.a.bz(6, this.xsC) + f.a.a.b.b.a.bz(7, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(8, this.xsE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.urJ);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FNL);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GUb) + f.a.a.b.b.a.bz(12, this.GqB) + f.a.a.b.b.a.bz(13, this.HPi);
      paramInt = i;
      if (this.ikp != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ikp);
      }
      i = paramInt;
      if (this.HZv != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HZv);
      }
      paramInt = i;
      if (this.HZw != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HZw);
      }
      i = paramInt;
      if (this.Ghg != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Ghg);
      }
      i = i + f.a.a.b.b.a.bz(18, this.Ghh) + f.a.a.b.b.a.bz(19, this.HZx) + f.a.a.b.b.a.bz(20, this.HZy);
      paramInt = i;
      if (this.HZz != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.HZz);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.HZA) + f.a.a.b.b.a.bz(23, this.HZB) + f.a.a.b.b.a.bz(24, this.HZC);
      paramInt = i;
      if (this.Hdo != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Hdo);
      }
      i = paramInt + f.a.a.b.b.a.bz(26, this.GwZ);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(28, this.Ghi) + f.a.a.b.b.a.bz(29, this.Ghj) + f.a.a.b.b.a.bz(30, this.HJK);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.ikm);
      }
      i = paramInt;
      if (this.FKS != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.FKS);
      }
      paramInt = i;
      if (this.FKR != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.FKR);
      }
      i = paramInt;
      if (this.FKQ != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.FKQ);
      }
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.Ghk);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.HoG);
      paramInt = i;
      if (this.Hvb != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.Hvb);
      }
      AppMethodBeat.o(152719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HZu == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.FNG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.FNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.HZu = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.FNG = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.FNH = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localdtw.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localdtw.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localdtw.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localdtw.urJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localdtw.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localdtw.GUb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localdtw.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localdtw.HPi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localdtw.ikp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localdtw.HZv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localdtw.HZw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localdtw.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localdtw.Ghh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localdtw.HZx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localdtw.HZy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localdtw.HZz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localdtw.HZA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localdtw.HZB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localdtw.HZC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localdtw.Hdo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localdtw.GwZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localdtw.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localdtw.Ghi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localdtw.Ghj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localdtw.HJK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localdtw.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localdtw.FKS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localdtw.FKR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localdtw.FKQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localdtw.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 36: 
          localdtw.HoG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152719);
          return 0;
        }
        localdtw.Hvb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */