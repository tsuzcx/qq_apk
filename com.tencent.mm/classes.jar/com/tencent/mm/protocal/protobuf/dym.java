package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dym
  extends cwj
{
  public int FST;
  public LinkedList<dyj> FSU;
  public int Gxq;
  public long Gxr;
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
  public int Idt;
  public dzx Idu;
  public int Idv;
  public int Idw;
  public int Idx;
  public int Idy;
  public SKBuiltinBuffer_t Idz;
  
  public dym()
  {
    AppMethodBeat.i(115865);
    this.FSU = new LinkedList();
    this.IdF = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.Idu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FST);
      paramVarArgs.e(3, 8, this.FSU);
      paramVarArgs.aS(4, this.Gxq);
      paramVarArgs.aZ(5, this.Gxr);
      paramVarArgs.aS(6, this.Idt);
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
      paramVarArgs.aS(14, this.IdK);
      paramVarArgs.aS(15, this.IdL);
      paramVarArgs.aS(16, this.Idv);
      paramVarArgs.aS(17, this.IdM);
      paramVarArgs.aS(18, this.IdN);
      paramVarArgs.aS(19, this.Idw);
      paramVarArgs.aS(20, this.IdO);
      paramVarArgs.aS(21, this.IdP);
      paramVarArgs.aS(22, this.IdQ);
      paramVarArgs.aS(23, this.IdR);
      paramVarArgs.aS(24, this.Idx);
      paramVarArgs.aS(25, this.Idy);
      paramVarArgs.aS(26, this.IdS);
      paramVarArgs.aS(27, this.IdT);
      if (this.Idz != null)
      {
        paramVarArgs.lJ(28, this.Idz.computeSize());
        this.Idz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2006;
      }
    }
    label2006:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FST) + f.a.a.a.c(3, 8, this.FSU) + f.a.a.b.b.a.bz(4, this.Gxq) + f.a.a.b.b.a.p(5, this.Gxr) + f.a.a.b.b.a.bz(6, this.Idt);
      paramInt = i;
      if (this.Idu != null) {
        paramInt = i + f.a.a.a.lI(7, this.Idu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.IdE) + f.a.a.a.c(9, 8, this.IdF) + f.a.a.b.b.a.bz(10, this.IdG) + f.a.a.b.b.a.bz(11, this.IdH) + f.a.a.b.b.a.bz(12, this.IdI) + f.a.a.b.b.a.bz(13, this.IdJ) + f.a.a.b.b.a.bz(14, this.IdK) + f.a.a.b.b.a.bz(15, this.IdL) + f.a.a.b.b.a.bz(16, this.Idv) + f.a.a.b.b.a.bz(17, this.IdM) + f.a.a.b.b.a.bz(18, this.IdN) + f.a.a.b.b.a.bz(19, this.Idw) + f.a.a.b.b.a.bz(20, this.IdO) + f.a.a.b.b.a.bz(21, this.IdP) + f.a.a.b.b.a.bz(22, this.IdQ) + f.a.a.b.b.a.bz(23, this.IdR) + f.a.a.b.b.a.bz(24, this.Idx) + f.a.a.b.b.a.bz(25, this.Idy) + f.a.a.b.b.a.bz(26, this.IdS) + f.a.a.b.b.a.bz(27, this.IdT);
      paramInt = i;
      if (this.Idz != null) {
        paramInt = i + f.a.a.a.lI(28, this.Idz.computeSize());
      }
      AppMethodBeat.o(115866);
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
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.Idu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RelayData");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dym localdym = (dym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
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
            localdym.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localdym.FST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdym.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localdym.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localdym.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localdym.Idt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
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
            localdym.Idu = ((dzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localdym.IdE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
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
            localdym.IdF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localdym.IdG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localdym.IdH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localdym.IdI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localdym.IdJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localdym.IdK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localdym.IdL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localdym.Idv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localdym.IdM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localdym.IdN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localdym.Idw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localdym.IdO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localdym.IdP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localdym.IdQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localdym.IdR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localdym.Idx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localdym.Idy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localdym.IdS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localdym.IdT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115866);
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
          localdym.Idz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      AppMethodBeat.o(115866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dym
 * JD-Core Version:    0.7.0.1
 */