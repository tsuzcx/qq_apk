package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lg
  extends cpx
{
  public String DTL;
  public int DUY;
  public String DUo;
  public SKBuiltinBuffer_t DUr;
  public String DYA;
  public czj DYB;
  public bxk DYC;
  public String DYn;
  public String DYo;
  public int DYp;
  public String DYq;
  public int DYr;
  public String DYs;
  public String DYt;
  public SKBuiltinBuffer_t DYu;
  public int DYv;
  public int DYw;
  public int DYx;
  public String DYy;
  public SKBuiltinBuffer_t DYz;
  public String ncR;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.DYn != null) {
        paramVarArgs.d(3, this.DYn);
      }
      paramVarArgs.aR(4, this.DUY);
      if (this.DYo != null) {
        paramVarArgs.d(5, this.DYo);
      }
      paramVarArgs.aR(6, this.DYp);
      if (this.DYq != null) {
        paramVarArgs.d(7, this.DYq);
      }
      if (this.DTL != null) {
        paramVarArgs.d(8, this.DTL);
      }
      paramVarArgs.aR(9, this.DYr);
      if (this.DYs != null) {
        paramVarArgs.d(10, this.DYs);
      }
      if (this.DYt != null) {
        paramVarArgs.d(11, this.DYt);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(12, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.pAD != null) {
        paramVarArgs.d(13, this.pAD);
      }
      paramVarArgs.aR(14, this.DYv);
      paramVarArgs.aR(15, this.DYw);
      if (this.DUo != null) {
        paramVarArgs.d(16, this.DUo);
      }
      paramVarArgs.aR(17, this.DYx);
      if (this.DYy != null) {
        paramVarArgs.d(18, this.DYy);
      }
      if (this.DYz != null)
      {
        paramVarArgs.ln(19, this.DYz.computeSize());
        this.DYz.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(20, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      if (this.DYA != null) {
        paramVarArgs.d(21, this.DYA);
      }
      if (this.DYB != null)
      {
        paramVarArgs.ln(22, this.DYB.computeSize());
        this.DYB.writeFields(paramVarArgs);
      }
      if (this.DYC != null)
      {
        paramVarArgs.ln(23, this.DYC.computeSize());
        this.DYC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2038;
      }
    }
    label2038:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.DYn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYn);
      }
      i += f.a.a.b.b.a.bx(4, this.DUY);
      paramInt = i;
      if (this.DYo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DYo);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.DYp);
      paramInt = i;
      if (this.DYq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DYq);
      }
      i = paramInt;
      if (this.DTL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DTL);
      }
      i += f.a.a.b.b.a.bx(9, this.DYr);
      paramInt = i;
      if (this.DYs != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DYs);
      }
      i = paramInt;
      if (this.DYt != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DYt);
      }
      paramInt = i;
      if (this.DYu != null) {
        paramInt = i + f.a.a.a.lm(12, this.DYu.computeSize());
      }
      i = paramInt;
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.pAD);
      }
      i = i + f.a.a.b.b.a.bx(14, this.DYv) + f.a.a.b.b.a.bx(15, this.DYw);
      paramInt = i;
      if (this.DUo != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DUo);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.DYx);
      paramInt = i;
      if (this.DYy != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DYy);
      }
      i = paramInt;
      if (this.DYz != null) {
        i = paramInt + f.a.a.a.lm(19, this.DYz.computeSize());
      }
      paramInt = i;
      if (this.DUr != null) {
        paramInt = i + f.a.a.a.lm(20, this.DUr.computeSize());
      }
      i = paramInt;
      if (this.DYA != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.DYA);
      }
      paramInt = i;
      if (this.DYB != null) {
        paramInt = i + f.a.a.a.lm(22, this.DYB.computeSize());
      }
      i = paramInt;
      if (this.DYC != null) {
        i = paramInt + f.a.a.a.lm(23, this.DYC.computeSize());
      }
      AppMethodBeat.o(134243);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lg locallg = (lg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
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
            locallg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          locallg.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          locallg.DYn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          locallg.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          locallg.DYo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          locallg.DYp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          locallg.DYq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          locallg.DTL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          locallg.DYr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          locallg.DYs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          locallg.DYt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallg.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          locallg.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          locallg.DYv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          locallg.DYw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          locallg.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          locallg.DYx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          locallg.DYy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallg.DYz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallg.DUr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          locallg.DYA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallg.DYB = ((czj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallg.DYC = ((bxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lg
 * JD-Core Version:    0.7.0.1
 */