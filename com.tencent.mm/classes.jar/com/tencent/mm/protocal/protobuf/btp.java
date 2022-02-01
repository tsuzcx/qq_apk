package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btp
  extends cpx
{
  public int ERj;
  public int Ehq;
  public int Ehr;
  public int FiA;
  public SKBuiltinBuffer_t FiB;
  public int FiC;
  public int FiD;
  public int FiE;
  public int FiF;
  public SKBuiltinBuffer_t FiG;
  public int FiH;
  public int FiI;
  public int FiJ;
  public int FiK;
  public int FiL;
  public String FiM;
  public String FiN;
  public String Fix;
  public String Fiy;
  public String Fiz;
  public String ThumbUrl;
  public int tit;
  public String tjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FiB == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.FiG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fix != null) {
        paramVarArgs.d(2, this.Fix);
      }
      if (this.Fiy != null) {
        paramVarArgs.d(3, this.Fiy);
      }
      if (this.Fiz != null) {
        paramVarArgs.d(4, this.Fiz);
      }
      paramVarArgs.aR(5, this.tit);
      paramVarArgs.aR(6, this.FiA);
      if (this.FiB != null)
      {
        paramVarArgs.ln(7, this.FiB.computeSize());
        this.FiB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.FiC);
      paramVarArgs.aR(9, this.FiD);
      paramVarArgs.aR(10, this.FiE);
      paramVarArgs.aR(11, this.FiF);
      if (this.FiG != null)
      {
        paramVarArgs.ln(12, this.FiG.computeSize());
        this.FiG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.FiH);
      paramVarArgs.aR(14, this.FiI);
      paramVarArgs.aR(15, this.FiJ);
      paramVarArgs.aR(16, this.FiK);
      paramVarArgs.aR(17, this.ERj);
      paramVarArgs.aR(18, this.FiL);
      if (this.tjt != null) {
        paramVarArgs.d(19, this.tjt);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(20, this.ThumbUrl);
      }
      paramVarArgs.aR(21, this.Ehr);
      paramVarArgs.aR(22, this.Ehq);
      if (this.FiM != null) {
        paramVarArgs.d(23, this.FiM);
      }
      if (this.FiN != null) {
        paramVarArgs.d(24, this.FiN);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fix != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fix);
      }
      i = paramInt;
      if (this.Fiy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fiy);
      }
      paramInt = i;
      if (this.Fiz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fiz);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.tit) + f.a.a.b.b.a.bx(6, this.FiA);
      paramInt = i;
      if (this.FiB != null) {
        paramInt = i + f.a.a.a.lm(7, this.FiB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FiC) + f.a.a.b.b.a.bx(9, this.FiD) + f.a.a.b.b.a.bx(10, this.FiE) + f.a.a.b.b.a.bx(11, this.FiF);
      paramInt = i;
      if (this.FiG != null) {
        paramInt = i + f.a.a.a.lm(12, this.FiG.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.FiH) + f.a.a.b.b.a.bx(14, this.FiI) + f.a.a.b.b.a.bx(15, this.FiJ) + f.a.a.b.b.a.bx(16, this.FiK) + f.a.a.b.b.a.bx(17, this.ERj) + f.a.a.b.b.a.bx(18, this.FiL);
      paramInt = i;
      if (this.tjt != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.tjt);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bx(21, this.Ehr) + f.a.a.b.b.a.bx(22, this.Ehq);
      paramInt = i;
      if (this.FiM != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FiM);
      }
      i = paramInt;
      if (this.FiN != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.FiN);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FiB == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.FiG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btp localbtp = (btp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localbtp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localbtp.Fix = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localbtp.Fiy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localbtp.Fiz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localbtp.tit = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localbtp.FiA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtp.FiB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localbtp.FiC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localbtp.FiD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localbtp.FiE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localbtp.FiF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
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
            localbtp.FiG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localbtp.FiH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localbtp.FiI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localbtp.FiJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localbtp.FiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localbtp.ERj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localbtp.FiL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localbtp.tjt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localbtp.ThumbUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localbtp.Ehr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localbtp.Ehq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localbtp.FiM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localbtp.FiN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btp
 * JD-Core Version:    0.7.0.1
 */