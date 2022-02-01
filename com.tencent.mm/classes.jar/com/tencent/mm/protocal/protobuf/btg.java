package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btg
  extends ckq
{
  public int CBP;
  public String CBQ;
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public acp CCa;
  public int CFR;
  public SKBuiltinBuffer_t CFU;
  public int CFX;
  public String CFY;
  public String CGf;
  public int CuF;
  public String CuG;
  public String CuH;
  public String DLU;
  public int DQA;
  public String DQB;
  public String DQC;
  public int DQr;
  public int DQs;
  public int DQt;
  public String DQu;
  public String DQv;
  public String DQw;
  public String DQx;
  public String DQy;
  public String DQz;
  public String Ddm;
  public String Ddo;
  public String DfF;
  public String DpQ;
  public String DyD;
  public String DyE;
  public int DyF;
  public String ijR;
  public String mAQ;
  public String mBV;
  public String oXr;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.CGf != null) {
        paramVarArgs.d(3, this.CGf);
      }
      if (this.mBV != null) {
        paramVarArgs.d(4, this.mBV);
      }
      paramVarArgs.aR(5, this.CuF);
      if (this.CuG != null) {
        paramVarArgs.d(6, this.CuG);
      }
      if (this.CuH != null) {
        paramVarArgs.d(7, this.CuH);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(8, this.Ddo);
      }
      paramVarArgs.aR(12, this.CBP);
      paramVarArgs.aR(13, this.DQr);
      paramVarArgs.aR(14, this.DyF);
      if (this.oXr != null) {
        paramVarArgs.d(15, this.oXr);
      }
      if (this.oXs != null) {
        paramVarArgs.d(16, this.oXs);
      }
      paramVarArgs.aR(17, this.CFR);
      if (this.Ddm != null) {
        paramVarArgs.d(18, this.Ddm);
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(19, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      if (this.ijR != null) {
        paramVarArgs.d(20, this.ijR);
      }
      if (this.DyD != null) {
        paramVarArgs.d(21, this.DyD);
      }
      if (this.DyE != null) {
        paramVarArgs.d(22, this.DyE);
      }
      paramVarArgs.aR(23, this.DQs);
      paramVarArgs.aR(24, this.DQt);
      if (this.CBQ != null) {
        paramVarArgs.d(31, this.CBQ);
      }
      if (this.DLU != null) {
        paramVarArgs.d(32, this.DLU);
      }
      if (this.DQu != null) {
        paramVarArgs.d(33, this.DQu);
      }
      if (this.DfF != null) {
        paramVarArgs.d(34, this.DfF);
      }
      if (this.DQv != null) {
        paramVarArgs.d(35, this.DQv);
      }
      if (this.DQw != null) {
        paramVarArgs.d(36, this.DQw);
      }
      if (this.CCa != null)
      {
        paramVarArgs.kX(37, this.CCa.computeSize());
        this.CCa.writeFields(paramVarArgs);
      }
      if (this.DQx != null) {
        paramVarArgs.d(38, this.DQx);
      }
      if (this.DpQ != null) {
        paramVarArgs.d(39, this.DpQ);
      }
      if (this.DQy != null) {
        paramVarArgs.d(40, this.DQy);
      }
      if (this.DQz != null) {
        paramVarArgs.d(41, this.DQz);
      }
      paramVarArgs.aR(42, this.DQA);
      if (this.CBT != null)
      {
        paramVarArgs.kX(43, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(44, this.CFX);
      if (this.CFY != null) {
        paramVarArgs.d(45, this.CFY);
      }
      if (this.DQB != null) {
        paramVarArgs.d(46, this.DQB);
      }
      if (this.DQC != null) {
        paramVarArgs.d(47, this.DQC);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(48, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2922;
      }
    }
    label2922:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.CGf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CGf);
      }
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mBV);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CuF);
      paramInt = i;
      if (this.CuG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CuG);
      }
      i = paramInt;
      if (this.CuH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CuH);
      }
      paramInt = i;
      if (this.Ddo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ddo);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CBP) + f.a.a.b.b.a.bA(13, this.DQr) + f.a.a.b.b.a.bA(14, this.DyF);
      paramInt = i;
      if (this.oXr != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.oXr);
      }
      i = paramInt;
      if (this.oXs != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.oXs);
      }
      i += f.a.a.b.b.a.bA(17, this.CFR);
      paramInt = i;
      if (this.Ddm != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Ddm);
      }
      i = paramInt;
      if (this.CFU != null) {
        i = paramInt + f.a.a.a.kW(19, this.CFU.computeSize());
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.ijR);
      }
      i = paramInt;
      if (this.DyD != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.DyD);
      }
      paramInt = i;
      if (this.DyE != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DyE);
      }
      i = paramInt + f.a.a.b.b.a.bA(23, this.DQs) + f.a.a.b.b.a.bA(24, this.DQt);
      paramInt = i;
      if (this.CBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.CBQ);
      }
      i = paramInt;
      if (this.DLU != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.DLU);
      }
      paramInt = i;
      if (this.DQu != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.DQu);
      }
      i = paramInt;
      if (this.DfF != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.DfF);
      }
      paramInt = i;
      if (this.DQv != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.DQv);
      }
      i = paramInt;
      if (this.DQw != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.DQw);
      }
      paramInt = i;
      if (this.CCa != null) {
        paramInt = i + f.a.a.a.kW(37, this.CCa.computeSize());
      }
      i = paramInt;
      if (this.DQx != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.DQx);
      }
      paramInt = i;
      if (this.DpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(39, this.DpQ);
      }
      i = paramInt;
      if (this.DQy != null) {
        i = paramInt + f.a.a.b.b.a.e(40, this.DQy);
      }
      paramInt = i;
      if (this.DQz != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.DQz);
      }
      i = paramInt + f.a.a.b.b.a.bA(42, this.DQA);
      paramInt = i;
      if (this.CBT != null) {
        paramInt = i + f.a.a.a.kW(43, this.CBT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(44, this.CFX);
      paramInt = i;
      if (this.CFY != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.CFY);
      }
      i = paramInt;
      if (this.DQB != null) {
        i = paramInt + f.a.a.b.b.a.e(46, this.DQB);
      }
      paramInt = i;
      if (this.DQC != null) {
        paramInt = i + f.a.a.b.b.a.e(47, this.DQC);
      }
      i = paramInt;
      if (this.CBU != null) {
        i = paramInt + f.a.a.a.kW(48, this.CBU.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        default: 
          AppMethodBeat.o(133184);
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
            localbtg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localbtg.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localbtg.CGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localbtg.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localbtg.CuF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localbtg.CuG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localbtg.CuH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localbtg.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localbtg.CBP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localbtg.DQr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localbtg.DyF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localbtg.oXr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localbtg.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localbtg.CFR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localbtg.Ddm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localbtg.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localbtg.DyD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localbtg.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localbtg.DQs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localbtg.DQt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localbtg.CBQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localbtg.DLU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localbtg.DQu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localbtg.DfF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localbtg.DQv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localbtg.DQw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.CCa = ((acp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localbtg.DQx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localbtg.DpQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localbtg.DQy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localbtg.DQz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localbtg.DQA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtg.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localbtg.CFX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localbtg.CFY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localbtg.DQB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localbtg.DQC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133184);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtg.CBU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      AppMethodBeat.o(133184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */