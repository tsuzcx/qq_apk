package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxz
  extends cvp
{
  public int FAx;
  public LinkedList<dws> FAy;
  public int GeI;
  public long GeJ;
  public int HJA;
  public int HJB;
  public int HJC;
  public int HJD;
  public int HJE;
  public int HJF;
  public int HJG;
  public int HJH;
  public int HJI;
  public int HJJ;
  public int HJK;
  public int HJL;
  public dyg HJm;
  public int HJn;
  public int HJo;
  public int HJp;
  public int HJq;
  public SKBuiltinBuffer_t HJr;
  public int HJw;
  public LinkedList<dyi> HJx;
  public int HJy;
  public int HJz;
  public int HKs;
  public int HKt;
  public int HKu;
  public int Hgi;
  
  public dxz()
  {
    AppMethodBeat.i(115885);
    this.FAy = new LinkedList();
    this.HJx = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aS(3, this.FAx);
      paramVarArgs.e(4, 8, this.FAy);
      paramVarArgs.aY(5, this.GeJ);
      paramVarArgs.aS(6, this.Hgi);
      if (this.HJm != null)
      {
        paramVarArgs.lC(7, this.HJm.computeSize());
        this.HJm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HJw);
      paramVarArgs.e(9, 8, this.HJx);
      paramVarArgs.aS(10, this.HJy);
      paramVarArgs.aS(11, this.HJz);
      paramVarArgs.aS(12, this.HJA);
      paramVarArgs.aS(13, this.HJB);
      paramVarArgs.aS(14, this.HKs);
      paramVarArgs.aS(15, this.HJC);
      paramVarArgs.aS(16, this.HJD);
      paramVarArgs.aS(17, this.HJn);
      paramVarArgs.aS(18, this.HJE);
      paramVarArgs.aS(19, this.HJF);
      paramVarArgs.aS(20, this.HJo);
      paramVarArgs.aS(21, this.HJG);
      paramVarArgs.aS(22, this.HJH);
      paramVarArgs.aS(23, this.HJI);
      paramVarArgs.aS(24, this.HKt);
      paramVarArgs.aS(25, this.HJJ);
      paramVarArgs.aS(26, this.HKu);
      paramVarArgs.aS(27, this.HJp);
      paramVarArgs.aS(28, this.HJq);
      paramVarArgs.aS(29, this.HJK);
      paramVarArgs.aS(30, this.HJL);
      if (this.HJr != null)
      {
        paramVarArgs.lC(31, this.HJr.computeSize());
        this.HJr.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.bz(3, this.FAx) + f.a.a.a.c(4, 8, this.FAy) + f.a.a.b.b.a.p(5, this.GeJ) + f.a.a.b.b.a.bz(6, this.Hgi);
      paramInt = i;
      if (this.HJm != null) {
        paramInt = i + f.a.a.a.lB(7, this.HJm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HJw) + f.a.a.a.c(9, 8, this.HJx) + f.a.a.b.b.a.bz(10, this.HJy) + f.a.a.b.b.a.bz(11, this.HJz) + f.a.a.b.b.a.bz(12, this.HJA) + f.a.a.b.b.a.bz(13, this.HJB) + f.a.a.b.b.a.bz(14, this.HKs) + f.a.a.b.b.a.bz(15, this.HJC) + f.a.a.b.b.a.bz(16, this.HJD) + f.a.a.b.b.a.bz(17, this.HJn) + f.a.a.b.b.a.bz(18, this.HJE) + f.a.a.b.b.a.bz(19, this.HJF) + f.a.a.b.b.a.bz(20, this.HJo) + f.a.a.b.b.a.bz(21, this.HJG) + f.a.a.b.b.a.bz(22, this.HJH) + f.a.a.b.b.a.bz(23, this.HJI) + f.a.a.b.b.a.bz(24, this.HKt) + f.a.a.b.b.a.bz(25, this.HJJ) + f.a.a.b.b.a.bz(26, this.HKu) + f.a.a.b.b.a.bz(27, this.HJp) + f.a.a.b.b.a.bz(28, this.HJq) + f.a.a.b.b.a.bz(29, this.HJK) + f.a.a.b.b.a.bz(30, this.HJL);
      paramInt = i;
      if (this.HJr != null) {
        paramInt = i + f.a.a.a.lB(31, this.HJr.computeSize());
      }
      AppMethodBeat.o(115886);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAy.clear();
        this.HJx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        dxz localdxz = (dxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 2: 
          localdxz.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 3: 
          localdxz.FAx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.FAy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 5: 
          localdxz.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115886);
          return 0;
        case 6: 
          localdxz.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.HJm = ((dyg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 8: 
          localdxz.HJw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.HJx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 10: 
          localdxz.HJy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 11: 
          localdxz.HJz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 12: 
          localdxz.HJA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 13: 
          localdxz.HJB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 14: 
          localdxz.HKs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 15: 
          localdxz.HJC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 16: 
          localdxz.HJD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 17: 
          localdxz.HJn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 18: 
          localdxz.HJE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 19: 
          localdxz.HJF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 20: 
          localdxz.HJo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 21: 
          localdxz.HJG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 22: 
          localdxz.HJH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 23: 
          localdxz.HJI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 24: 
          localdxz.HKt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 25: 
          localdxz.HJJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 26: 
          localdxz.HKu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 27: 
          localdxz.HJp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 28: 
          localdxz.HJq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 29: 
          localdxz.HJK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        case 30: 
          localdxz.HJL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxz.HJr = ((SKBuiltinBuffer_t)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxz
 * JD-Core Version:    0.7.0.1
 */