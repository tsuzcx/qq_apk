package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arm
  extends cpx
{
  public int DPI;
  public int DSv;
  public SKBuiltinBuffer_t DTI;
  public int DUB;
  public crm EKN;
  public crm EKO;
  public crm EKP;
  public crm EKQ;
  public String EKR;
  public int EKS;
  public String EKT;
  public SKBuiltinBuffer_t EKU;
  public int EKV;
  public String EKW;
  public int EKX;
  public SKBuiltinBuffer_t EKY;
  public int EKx;
  public String EKy;
  public int EoF;
  public int EoG;
  public int OpCode;
  public int Scene;
  public String nOG;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.DTI != null)
      {
        paramVarArgs.ln(3, this.DTI.computeSize());
        this.DTI.writeFields(paramVarArgs);
      }
      if (this.EKN != null)
      {
        paramVarArgs.ln(4, this.EKN.computeSize());
        this.EKN.writeFields(paramVarArgs);
      }
      if (this.EKO != null)
      {
        paramVarArgs.ln(5, this.EKO.computeSize());
        this.EKO.writeFields(paramVarArgs);
      }
      if (this.EKP != null)
      {
        paramVarArgs.ln(6, this.EKP.computeSize());
        this.EKP.writeFields(paramVarArgs);
      }
      if (this.EKQ != null)
      {
        paramVarArgs.ln(7, this.EKQ.computeSize());
        this.EKQ.writeFields(paramVarArgs);
      }
      if (this.EKR != null) {
        paramVarArgs.d(8, this.EKR);
      }
      paramVarArgs.aR(9, this.EKS);
      paramVarArgs.aR(10, this.Scene);
      if (this.ncR != null) {
        paramVarArgs.d(11, this.ncR);
      }
      if (this.EKT != null) {
        paramVarArgs.d(12, this.EKT);
      }
      if (this.EKU != null)
      {
        paramVarArgs.ln(13, this.EKU.computeSize());
        this.EKU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.DUB);
      paramVarArgs.aR(15, this.EKx);
      paramVarArgs.aR(16, this.DPI);
      if (this.nOG != null) {
        paramVarArgs.d(17, this.nOG);
      }
      paramVarArgs.aR(18, this.EoF);
      paramVarArgs.aR(19, this.EoG);
      paramVarArgs.aR(20, this.EKV);
      if (this.EKW != null) {
        paramVarArgs.d(21, this.EKW);
      }
      paramVarArgs.aR(22, this.EKX);
      if (this.EKY != null)
      {
        paramVarArgs.ln(23, this.EKY.computeSize());
        this.EKY.writeFields(paramVarArgs);
      }
      if (this.EKy != null) {
        paramVarArgs.d(24, this.EKy);
      }
      paramVarArgs.aR(25, this.DSv);
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2262;
      }
    }
    label2262:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode);
      paramInt = i;
      if (this.DTI != null) {
        paramInt = i + f.a.a.a.lm(3, this.DTI.computeSize());
      }
      i = paramInt;
      if (this.EKN != null) {
        i = paramInt + f.a.a.a.lm(4, this.EKN.computeSize());
      }
      paramInt = i;
      if (this.EKO != null) {
        paramInt = i + f.a.a.a.lm(5, this.EKO.computeSize());
      }
      i = paramInt;
      if (this.EKP != null) {
        i = paramInt + f.a.a.a.lm(6, this.EKP.computeSize());
      }
      paramInt = i;
      if (this.EKQ != null) {
        paramInt = i + f.a.a.a.lm(7, this.EKQ.computeSize());
      }
      i = paramInt;
      if (this.EKR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EKR);
      }
      i = i + f.a.a.b.b.a.bx(9, this.EKS) + f.a.a.b.b.a.bx(10, this.Scene);
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ncR);
      }
      i = paramInt;
      if (this.EKT != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EKT);
      }
      paramInt = i;
      if (this.EKU != null) {
        paramInt = i + f.a.a.a.lm(13, this.EKU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.DUB) + f.a.a.b.b.a.bx(15, this.EKx) + f.a.a.b.b.a.bx(16, this.DPI);
      paramInt = i;
      if (this.nOG != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.nOG);
      }
      i = paramInt + f.a.a.b.b.a.bx(18, this.EoF) + f.a.a.b.b.a.bx(19, this.EoG) + f.a.a.b.b.a.bx(20, this.EKV);
      paramInt = i;
      if (this.EKW != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.EKW);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.EKX);
      paramInt = i;
      if (this.EKY != null) {
        paramInt = i + f.a.a.a.lm(23, this.EKY.computeSize());
      }
      i = paramInt;
      if (this.EKy != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.EKy);
      }
      paramInt = f.a.a.b.b.a.bx(25, this.DSv);
      AppMethodBeat.o(152552);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arm localarm = (arm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localarm.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.DTI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKN = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKO = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKP = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKQ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localarm.EKR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localarm.EKS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localarm.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localarm.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localarm.EKT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localarm.DUB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localarm.EKx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localarm.DPI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localarm.nOG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localarm.EoF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localarm.EoG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localarm.EKV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localarm.EKW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localarm.EKX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarm.EKY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localarm.EKy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        localarm.DSv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arm
 * JD-Core Version:    0.7.0.1
 */