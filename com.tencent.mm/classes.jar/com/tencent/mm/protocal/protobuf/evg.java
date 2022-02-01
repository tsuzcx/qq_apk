package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class evg
  extends esc
{
  public int ExtFlag;
  public gol YFI;
  public String ZhO;
  public String ZhP;
  public etl ZpX;
  public etl ZpY;
  public etl ZqL;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public ffs aaMs;
  public ahl aaMt;
  public String aant;
  public int aaqy;
  public LinkedList<eve> aaqz;
  public int abxU;
  public gol abxW;
  public String abxX;
  public String abxY;
  public int abxZ;
  public LinkedList<evx> abya;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public int pSj;
  public String pSk;
  public int pSl;
  public int pSm;
  public String pSn;
  public String pSo;
  public String pSp;
  
  public evg()
  {
    AppMethodBeat.i(152683);
    this.aaqz = new LinkedList();
    this.abya = new LinkedList();
    AppMethodBeat.o(152683);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152684);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(2, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      if (this.aaIz != null)
      {
        paramVarArgs.qD(3, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      if (this.ZpX != null)
      {
        paramVarArgs.qD(4, this.ZpX.computeSize());
        this.ZpX.writeFields(paramVarArgs);
      }
      if (this.ZpY != null)
      {
        paramVarArgs.qD(5, this.ZpY.computeSize());
        this.ZpY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.pSf);
      if (this.YFI != null)
      {
        paramVarArgs.qD(7, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      if (this.pSg != null) {
        paramVarArgs.g(8, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(9, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(10, this.pSi);
      }
      paramVarArgs.bS(11, this.pSj);
      paramVarArgs.bS(12, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(13, this.aaMn);
      }
      if (this.aaMo != null) {
        paramVarArgs.g(14, this.aaMo);
      }
      if (this.pSk != null) {
        paramVarArgs.g(15, this.pSk);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(16, this.aaMp);
      }
      paramVarArgs.bS(17, this.aaMq);
      paramVarArgs.bS(18, this.pSm);
      paramVarArgs.bS(19, this.pSl);
      if (this.pSn != null) {
        paramVarArgs.g(20, this.pSn);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(21, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(22, this.pSo);
      }
      if (this.pSp != null) {
        paramVarArgs.g(23, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(24, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(25, this.aaqy);
      paramVarArgs.e(26, 8, this.aaqz);
      if (this.ZhO != null) {
        paramVarArgs.g(27, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(28, this.ZhP);
      }
      if (this.abxW != null)
      {
        paramVarArgs.qD(29, this.abxW.computeSize());
        this.abxW.writeFields(paramVarArgs);
      }
      if (this.aant != null) {
        paramVarArgs.g(30, this.aant);
      }
      if (this.abxX != null) {
        paramVarArgs.g(31, this.abxX);
      }
      paramVarArgs.bS(32, this.abxU);
      if (this.abxY != null) {
        paramVarArgs.g(33, this.abxY);
      }
      paramVarArgs.bS(34, this.abxZ);
      paramVarArgs.e(35, 8, this.abya);
      paramVarArgs.bS(36, this.ExtFlag);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3264;
      }
    }
    label3264:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZqL != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZqL.computeSize());
      }
      i = paramInt;
      if (this.aaIz != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaIz.computeSize());
      }
      paramInt = i;
      if (this.ZpX != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZpX.computeSize());
      }
      i = paramInt;
      if (this.ZpY != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZpY.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.pSf);
      paramInt = i;
      if (this.YFI != null) {
        paramInt = i + i.a.a.a.qC(7, this.YFI.computeSize());
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pSh);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.pSi);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.pSj) + i.a.a.b.b.a.cJ(12, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aaMn);
      }
      i = paramInt;
      if (this.aaMo != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaMo);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.pSk);
      }
      i = paramInt;
      if (this.aaMp != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.aaMp);
      }
      i = i + i.a.a.b.b.a.cJ(17, this.aaMq) + i.a.a.b.b.a.cJ(18, this.pSm) + i.a.a.b.b.a.cJ(19, this.pSl);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.pSn);
      }
      i = paramInt;
      if (this.aaMs != null) {
        i = paramInt + i.a.a.a.qC(21, this.aaMs.computeSize());
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.pSo);
      }
      i = paramInt;
      if (this.pSp != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.pSp);
      }
      paramInt = i;
      if (this.aaMt != null) {
        paramInt = i + i.a.a.a.qC(24, this.aaMt.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.aaqy) + i.a.a.a.c(26, 8, this.aaqz);
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.ZhP);
      }
      paramInt = i;
      if (this.abxW != null) {
        paramInt = i + i.a.a.a.qC(29, this.abxW.computeSize());
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.aant);
      }
      paramInt = i;
      if (this.abxX != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.abxX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.abxU);
      paramInt = i;
      if (this.abxY != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.abxY);
      }
      i = i.a.a.b.b.a.cJ(34, this.abxZ);
      int j = i.a.a.a.c(35, 8, this.abya);
      int k = i.a.a.b.b.a.cJ(36, this.ExtFlag);
      AppMethodBeat.o(152684);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqz.clear();
        this.abya.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        evg localevg = (evg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localevg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localevg.ZqL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localevg.aaIz = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localevg.ZpX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localevg.ZpY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localevg.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localevg.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localevg.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localevg.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localevg.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localevg.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localevg.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localevg.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localevg.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localevg.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localevg.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localevg.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localevg.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localevg.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localevg.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localevg.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localevg.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localevg.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahl)localObject2).parseFrom((byte[])localObject1);
            }
            localevg.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localevg.aaqy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eve)localObject2).parseFrom((byte[])localObject1);
            }
            localevg.aaqz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localevg.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localevg.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localevg.abxW = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localevg.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localevg.abxX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localevg.abxU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localevg.abxY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localevg.abxZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152684);
          return 0;
        case 35: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evx)localObject2).parseFrom((byte[])localObject1);
            }
            localevg.abya.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        }
        localevg.ExtFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152684);
        return 0;
      }
      AppMethodBeat.o(152684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evg
 * JD-Core Version:    0.7.0.1
 */