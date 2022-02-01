package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cns
  extends cwj
{
  public LinkedList<cnk> FSU;
  public int Gxq;
  public long Gxr;
  public int HzI;
  public int HzJ;
  public LinkedList<cnk> HzK;
  public String HzL;
  public com.tencent.mm.bw.b HzM;
  public int HzN;
  public long Hzz;
  public int uXB;
  public int uXE;
  public int uXl;
  public String uXm;
  public int uXq;
  public int uXw;
  public int uXx;
  public int uXy;
  public com.tencent.mm.bw.b uXz;
  
  public cns()
  {
    AppMethodBeat.i(32379);
    this.FSU = new LinkedList();
    this.HzK = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.HzI);
      paramVarArgs.e(5, 8, this.FSU);
      paramVarArgs.aS(6, this.HzJ);
      paramVarArgs.aS(7, this.uXw);
      paramVarArgs.aS(8, this.uXx);
      paramVarArgs.aZ(9, this.Hzz);
      paramVarArgs.aS(10, this.uXy);
      if (this.uXz != null) {
        paramVarArgs.c(11, this.uXz);
      }
      paramVarArgs.aS(12, this.uXq);
      paramVarArgs.aS(13, this.uXl);
      if (this.uXm != null) {
        paramVarArgs.d(14, this.uXm);
      }
      paramVarArgs.aS(15, this.uXB);
      paramVarArgs.e(16, 8, this.HzK);
      paramVarArgs.aS(17, this.uXE);
      if (this.HzL != null) {
        paramVarArgs.d(18, this.HzL);
      }
      if (this.HzM != null) {
        paramVarArgs.c(19, this.HzM);
      }
      paramVarArgs.aS(20, this.HzN);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.HzI) + f.a.a.a.c(5, 8, this.FSU) + f.a.a.b.b.a.bz(6, this.HzJ) + f.a.a.b.b.a.bz(7, this.uXw) + f.a.a.b.b.a.bz(8, this.uXx) + f.a.a.b.b.a.p(9, this.Hzz) + f.a.a.b.b.a.bz(10, this.uXy);
      paramInt = i;
      if (this.uXz != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.uXz);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.uXq) + f.a.a.b.b.a.bz(13, this.uXl);
      paramInt = i;
      if (this.uXm != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uXm);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.uXB) + f.a.a.a.c(16, 8, this.HzK) + f.a.a.b.b.a.bz(17, this.uXE);
      paramInt = i;
      if (this.HzL != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HzL);
      }
      i = paramInt;
      if (this.HzM != null) {
        i = paramInt + f.a.a.b.b.a.b(19, this.HzM);
      }
      paramInt = f.a.a.b.b.a.bz(20, this.HzN);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSU.clear();
        this.HzK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cns localcns = (cns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
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
            localcns.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localcns.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localcns.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localcns.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcns.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localcns.HzJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localcns.uXw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localcns.uXx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localcns.Hzz = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localcns.uXy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localcns.uXz = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localcns.uXq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localcns.uXl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localcns.uXm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localcns.uXB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcns.HzK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localcns.uXE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localcns.HzL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localcns.HzM = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(32380);
          return 0;
        }
        localcns.HzN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cns
 * JD-Core Version:    0.7.0.1
 */