package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoi
  extends ckq
{
  public SKBuiltinBuffer_t CBk;
  public int CCe;
  public int CVW;
  public int CVX;
  public int Cxm;
  public int CzZ;
  public cmf DpK;
  public cmf DpL;
  public cmf DpM;
  public cmf DpN;
  public String DpO;
  public int DpP;
  public String DpQ;
  public SKBuiltinBuffer_t DpR;
  public int DpS;
  public String DpT;
  public int DpU;
  public SKBuiltinBuffer_t DpV;
  public int Dpw;
  public String Dpx;
  public int OpCode;
  public int Scene;
  public String mAQ;
  public String nlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.CBk != null)
      {
        paramVarArgs.kX(3, this.CBk.computeSize());
        this.CBk.writeFields(paramVarArgs);
      }
      if (this.DpK != null)
      {
        paramVarArgs.kX(4, this.DpK.computeSize());
        this.DpK.writeFields(paramVarArgs);
      }
      if (this.DpL != null)
      {
        paramVarArgs.kX(5, this.DpL.computeSize());
        this.DpL.writeFields(paramVarArgs);
      }
      if (this.DpM != null)
      {
        paramVarArgs.kX(6, this.DpM.computeSize());
        this.DpM.writeFields(paramVarArgs);
      }
      if (this.DpN != null)
      {
        paramVarArgs.kX(7, this.DpN.computeSize());
        this.DpN.writeFields(paramVarArgs);
      }
      if (this.DpO != null) {
        paramVarArgs.d(8, this.DpO);
      }
      paramVarArgs.aR(9, this.DpP);
      paramVarArgs.aR(10, this.Scene);
      if (this.mAQ != null) {
        paramVarArgs.d(11, this.mAQ);
      }
      if (this.DpQ != null) {
        paramVarArgs.d(12, this.DpQ);
      }
      if (this.DpR != null)
      {
        paramVarArgs.kX(13, this.DpR.computeSize());
        this.DpR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.CCe);
      paramVarArgs.aR(15, this.Dpw);
      paramVarArgs.aR(16, this.Cxm);
      if (this.nlG != null) {
        paramVarArgs.d(17, this.nlG);
      }
      paramVarArgs.aR(18, this.CVW);
      paramVarArgs.aR(19, this.CVX);
      paramVarArgs.aR(20, this.DpS);
      if (this.DpT != null) {
        paramVarArgs.d(21, this.DpT);
      }
      paramVarArgs.aR(22, this.DpU);
      if (this.DpV != null)
      {
        paramVarArgs.kX(23, this.DpV.computeSize());
        this.DpV.writeFields(paramVarArgs);
      }
      if (this.Dpx != null) {
        paramVarArgs.d(24, this.Dpx);
      }
      paramVarArgs.aR(25, this.CzZ);
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2262;
      }
    }
    label2262:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode);
      paramInt = i;
      if (this.CBk != null) {
        paramInt = i + f.a.a.a.kW(3, this.CBk.computeSize());
      }
      i = paramInt;
      if (this.DpK != null) {
        i = paramInt + f.a.a.a.kW(4, this.DpK.computeSize());
      }
      paramInt = i;
      if (this.DpL != null) {
        paramInt = i + f.a.a.a.kW(5, this.DpL.computeSize());
      }
      i = paramInt;
      if (this.DpM != null) {
        i = paramInt + f.a.a.a.kW(6, this.DpM.computeSize());
      }
      paramInt = i;
      if (this.DpN != null) {
        paramInt = i + f.a.a.a.kW(7, this.DpN.computeSize());
      }
      i = paramInt;
      if (this.DpO != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DpO);
      }
      i = i + f.a.a.b.b.a.bA(9, this.DpP) + f.a.a.b.b.a.bA(10, this.Scene);
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.mAQ);
      }
      i = paramInt;
      if (this.DpQ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DpQ);
      }
      paramInt = i;
      if (this.DpR != null) {
        paramInt = i + f.a.a.a.kW(13, this.DpR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.CCe) + f.a.a.b.b.a.bA(15, this.Dpw) + f.a.a.b.b.a.bA(16, this.Cxm);
      paramInt = i;
      if (this.nlG != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.nlG);
      }
      i = paramInt + f.a.a.b.b.a.bA(18, this.CVW) + f.a.a.b.b.a.bA(19, this.CVX) + f.a.a.b.b.a.bA(20, this.DpS);
      paramInt = i;
      if (this.DpT != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DpT);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.DpU);
      paramInt = i;
      if (this.DpV != null) {
        paramInt = i + f.a.a.a.kW(23, this.DpV.computeSize());
      }
      i = paramInt;
      if (this.Dpx != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.Dpx);
      }
      paramInt = f.a.a.b.b.a.bA(25, this.CzZ);
      AppMethodBeat.o(152552);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoi localaoi = (aoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
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
            localaoi.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localaoi.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.CBk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
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
            localaoi.DpK = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.DpL = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.DpM = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.DpN = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localaoi.DpO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localaoi.DpP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localaoi.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localaoi.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localaoi.DpQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.DpR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localaoi.CCe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localaoi.Dpw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localaoi.Cxm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localaoi.nlG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localaoi.CVW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localaoi.CVX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localaoi.DpS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localaoi.DpT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localaoi.DpU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoi.DpV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localaoi.Dpx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        localaoi.CzZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoi
 * JD-Core Version:    0.7.0.1
 */