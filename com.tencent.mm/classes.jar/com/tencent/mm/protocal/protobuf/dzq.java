package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzq
  extends cwj
{
  public int FST;
  public LinkedList<dyj> FSU;
  public int Gxq;
  public long Gxr;
  public int HzI;
  public int IdE;
  public LinkedList<dzz> IdF;
  public int IdG;
  public int IdH;
  public int IdI;
  public int IdJ;
  public int IdK;
  public int IdL;
  public int IdM;
  public int IdN;
  public int IdO;
  public int IdP;
  public int IdQ;
  public int IdR;
  public int IdS;
  public int IdT;
  public dzx Idu;
  public int Idv;
  public int Idw;
  public int Idx;
  public int Idy;
  public SKBuiltinBuffer_t Idz;
  public int IeA;
  public int IeB;
  public int IeC;
  
  public dzq()
  {
    AppMethodBeat.i(115885);
    this.FSU = new LinkedList();
    this.IdF = new LinkedList();
    AppMethodBeat.o(115885);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115886);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aS(3, this.FST);
      paramVarArgs.e(4, 8, this.FSU);
      paramVarArgs.aZ(5, this.Gxr);
      paramVarArgs.aS(6, this.HzI);
      if (this.Idu != null)
      {
        paramVarArgs.lJ(7, this.Idu.computeSize());
        this.Idu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.IdE);
      paramVarArgs.e(9, 8, this.IdF);
      paramVarArgs.aS(10, this.IdG);
      paramVarArgs.aS(11, this.IdH);
      paramVarArgs.aS(12, this.IdI);
      paramVarArgs.aS(13, this.IdJ);
      paramVarArgs.aS(14, this.IeA);
      paramVarArgs.aS(15, this.IdK);
      paramVarArgs.aS(16, this.IdL);
      paramVarArgs.aS(17, this.Idv);
      paramVarArgs.aS(18, this.IdM);
      paramVarArgs.aS(19, this.IdN);
      paramVarArgs.aS(20, this.Idw);
      paramVarArgs.aS(21, this.IdO);
      paramVarArgs.aS(22, this.IdP);
      paramVarArgs.aS(23, this.IdQ);
      paramVarArgs.aS(24, this.IeB);
      paramVarArgs.aS(25, this.IdR);
      paramVarArgs.aS(26, this.IeC);
      paramVarArgs.aS(27, this.Idx);
      paramVarArgs.aS(28, this.Idy);
      paramVarArgs.aS(29, this.IdS);
      paramVarArgs.aS(30, this.IdT);
      if (this.Idz != null)
      {
        paramVarArgs.lJ(31, this.Idz.computeSize());
        this.Idz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2090;
      }
    }
    label2090:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.bz(3, this.FST) + f.a.a.a.c(4, 8, this.FSU) + f.a.a.b.b.a.p(5, this.Gxr) + f.a.a.b.b.a.bz(6, this.HzI);
      paramInt = i;
      if (this.Idu != null) {
        paramInt = i + f.a.a.a.lI(7, this.Idu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.IdE) + f.a.a.a.c(9, 8, this.IdF) + f.a.a.b.b.a.bz(10, this.IdG) + f.a.a.b.b.a.bz(11, this.IdH) + f.a.a.b.b.a.bz(12, this.IdI) + f.a.a.b.b.a.bz(13, this.IdJ) + f.a.a.b.b.a.bz(14, this.IeA) + f.a.a.b.b.a.bz(15, this.IdK) + f.a.a.b.b.a.bz(16, this.IdL) + f.a.a.b.b.a.bz(17, this.Idv) + f.a.a.b.b.a.bz(18, this.IdM) + f.a.a.b.b.a.bz(19, this.IdN) + f.a.a.b.b.a.bz(20, this.Idw) + f.a.a.b.b.a.bz(21, this.IdO) + f.a.a.b.b.a.bz(22, this.IdP) + f.a.a.b.b.a.bz(23, this.IdQ) + f.a.a.b.b.a.bz(24, this.IeB) + f.a.a.b.b.a.bz(25, this.IdR) + f.a.a.b.b.a.bz(26, this.IeC) + f.a.a.b.b.a.bz(27, this.Idx) + f.a.a.b.b.a.bz(28, this.Idy) + f.a.a.b.b.a.bz(29, this.IdS) + f.a.a.b.b.a.bz(30, this.IdT);
      paramInt = i;
      if (this.Idz != null) {
        paramInt = i + f.a.a.a.lI(31, this.Idz.computeSize());
      }
      AppMethodBeat.o(115886);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSU.clear();
        this.IdF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115886);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzq localdzq = (dzq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 2: 
          localdzq.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 3: 
          localdzq.FST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 5: 
          localdzq.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115886);
          return 0;
        case 6: 
          localdzq.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.Idu = ((dzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 8: 
          localdzq.IdE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.IdF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 10: 
          localdzq.IdG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 11: 
          localdzq.IdH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 12: 
          localdzq.IdI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 13: 
          localdzq.IdJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 14: 
          localdzq.IeA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 15: 
          localdzq.IdK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 16: 
          localdzq.IdL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 17: 
          localdzq.Idv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 18: 
          localdzq.IdM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 19: 
          localdzq.IdN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 20: 
          localdzq.Idw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 21: 
          localdzq.IdO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 22: 
          localdzq.IdP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 23: 
          localdzq.IdQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 24: 
          localdzq.IeB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 25: 
          localdzq.IdR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 26: 
          localdzq.IeC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 27: 
          localdzq.Idx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 28: 
          localdzq.Idy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 29: 
          localdzq.IdS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 30: 
          localdzq.IdT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzq.Idz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      AppMethodBeat.o(115886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzq
 * JD-Core Version:    0.7.0.1
 */