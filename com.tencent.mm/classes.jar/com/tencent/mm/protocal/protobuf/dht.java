package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dht
  extends ckq
{
  public String COP;
  public int COQ;
  public int COR;
  public int COS;
  public String COT;
  public int CYi;
  public String CuS;
  public String CuT;
  public String CuU;
  public String CxC;
  public cmf Cxx;
  public cmf Cxy;
  public String DET;
  public int DPf;
  public int DdJ;
  public int DvO;
  public int EiL;
  public int EnY;
  public cmf ExR;
  public String ExS;
  public String ExT;
  public int ExU;
  public int ExV;
  public String ExW;
  public int ExX;
  public int ExY;
  public int ExZ;
  public String Md5;
  public String hnC;
  public String hnF;
  public int saz;
  public int uKQ;
  public int uKR;
  public int uKS;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ExR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ExR != null)
      {
        paramVarArgs.kX(2, this.ExR.computeSize());
        this.ExR.writeFields(paramVarArgs);
      }
      if (this.Cxx != null)
      {
        paramVarArgs.kX(3, this.Cxx.computeSize());
        this.Cxx.writeFields(paramVarArgs);
      }
      if (this.Cxy != null)
      {
        paramVarArgs.kX(4, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.uKQ);
      paramVarArgs.aR(6, this.uKR);
      paramVarArgs.aR(7, this.uKS);
      if (this.uKT != null)
      {
        paramVarArgs.kX(8, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.saz);
      if (this.CxC != null) {
        paramVarArgs.d(10, this.CxC);
      }
      paramVarArgs.aR(11, this.DvO);
      paramVarArgs.aR(12, this.CYi);
      paramVarArgs.aR(13, this.EnY);
      if (this.hnF != null) {
        paramVarArgs.d(14, this.hnF);
      }
      if (this.ExS != null) {
        paramVarArgs.d(15, this.ExS);
      }
      if (this.ExT != null) {
        paramVarArgs.d(16, this.ExT);
      }
      if (this.COP != null) {
        paramVarArgs.d(17, this.COP);
      }
      paramVarArgs.aR(18, this.COQ);
      paramVarArgs.aR(19, this.ExU);
      paramVarArgs.aR(20, this.ExV);
      if (this.ExW != null) {
        paramVarArgs.d(21, this.ExW);
      }
      paramVarArgs.aR(22, this.ExX);
      paramVarArgs.aR(23, this.ExY);
      paramVarArgs.aR(24, this.ExZ);
      if (this.DET != null) {
        paramVarArgs.d(25, this.DET);
      }
      paramVarArgs.aR(26, this.DdJ);
      if (this.Md5 != null) {
        paramVarArgs.d(27, this.Md5);
      }
      paramVarArgs.aR(28, this.COR);
      paramVarArgs.aR(29, this.COS);
      paramVarArgs.aR(30, this.EiL);
      if (this.hnC != null) {
        paramVarArgs.d(31, this.hnC);
      }
      if (this.CuU != null) {
        paramVarArgs.d(32, this.CuU);
      }
      if (this.CuT != null) {
        paramVarArgs.d(33, this.CuT);
      }
      if (this.CuS != null) {
        paramVarArgs.d(34, this.CuS);
      }
      if (this.COT != null) {
        paramVarArgs.d(35, this.COT);
      }
      paramVarArgs.aR(36, this.DPf);
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2734;
      }
    }
    label2734:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ExR != null) {
        paramInt = i + f.a.a.a.kW(2, this.ExR.computeSize());
      }
      i = paramInt;
      if (this.Cxx != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cxx.computeSize());
      }
      paramInt = i;
      if (this.Cxy != null) {
        paramInt = i + f.a.a.a.kW(4, this.Cxy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.uKQ) + f.a.a.b.b.a.bA(6, this.uKR) + f.a.a.b.b.a.bA(7, this.uKS);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(8, this.uKT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.saz);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CxC);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.DvO) + f.a.a.b.b.a.bA(12, this.CYi) + f.a.a.b.b.a.bA(13, this.EnY);
      paramInt = i;
      if (this.hnF != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.hnF);
      }
      i = paramInt;
      if (this.ExS != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.ExS);
      }
      paramInt = i;
      if (this.ExT != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.ExT);
      }
      i = paramInt;
      if (this.COP != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.COP);
      }
      i = i + f.a.a.b.b.a.bA(18, this.COQ) + f.a.a.b.b.a.bA(19, this.ExU) + f.a.a.b.b.a.bA(20, this.ExV);
      paramInt = i;
      if (this.ExW != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ExW);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.ExX) + f.a.a.b.b.a.bA(23, this.ExY) + f.a.a.b.b.a.bA(24, this.ExZ);
      paramInt = i;
      if (this.DET != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.DET);
      }
      i = paramInt + f.a.a.b.b.a.bA(26, this.DdJ);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bA(28, this.COR) + f.a.a.b.b.a.bA(29, this.COS) + f.a.a.b.b.a.bA(30, this.EiL);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.hnC);
      }
      i = paramInt;
      if (this.CuU != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.CuU);
      }
      paramInt = i;
      if (this.CuT != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.CuT);
      }
      i = paramInt;
      if (this.CuS != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.CuS);
      }
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.COT);
      }
      i = f.a.a.b.b.a.bA(36, this.DPf);
      AppMethodBeat.o(152719);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ExR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.Cxx == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.Cxy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.uKT == null)
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
        dht localdht = (dht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdht.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdht.ExR = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdht.Cxx = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdht.Cxy = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localdht.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localdht.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localdht.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdht.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localdht.saz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localdht.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localdht.DvO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localdht.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localdht.EnY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localdht.hnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localdht.ExS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localdht.ExT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localdht.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localdht.COQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localdht.ExU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localdht.ExV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localdht.ExW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localdht.ExX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localdht.ExY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localdht.ExZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localdht.DET = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localdht.DdJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localdht.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localdht.COR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localdht.COS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localdht.EiL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localdht.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localdht.CuU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localdht.CuT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localdht.CuS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localdht.COT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152719);
          return 0;
        }
        localdht.DPf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dht
 * JD-Core Version:    0.7.0.1
 */