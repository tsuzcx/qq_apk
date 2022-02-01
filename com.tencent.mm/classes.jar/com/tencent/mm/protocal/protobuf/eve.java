package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eve
  extends com.tencent.mm.bx.a
{
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
  public int abxU;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(1, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      if (this.aaIz != null)
      {
        paramVarArgs.qD(2, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      if (this.ZpX != null)
      {
        paramVarArgs.qD(3, this.ZpX.computeSize());
        this.ZpX.writeFields(paramVarArgs);
      }
      if (this.ZpY != null)
      {
        paramVarArgs.qD(4, this.ZpY.computeSize());
        this.ZpY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.pSf);
      if (this.YFI != null)
      {
        paramVarArgs.qD(6, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      if (this.pSg != null) {
        paramVarArgs.g(7, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(8, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(9, this.pSi);
      }
      paramVarArgs.bS(10, this.pSj);
      paramVarArgs.bS(11, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(12, this.aaMn);
      }
      if (this.aaMo != null) {
        paramVarArgs.g(13, this.aaMo);
      }
      if (this.pSk != null) {
        paramVarArgs.g(14, this.pSk);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(15, this.aaMp);
      }
      paramVarArgs.bS(16, this.aaMq);
      paramVarArgs.bS(17, this.pSm);
      paramVarArgs.bS(18, this.pSl);
      if (this.pSn != null) {
        paramVarArgs.g(19, this.pSn);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(20, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(21, this.pSo);
      }
      if (this.pSp != null) {
        paramVarArgs.g(22, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(23, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(24, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(25, this.ZhP);
      }
      if (this.aant != null) {
        paramVarArgs.g(26, this.aant);
      }
      paramVarArgs.bS(27, this.abxU);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label2444;
      }
    }
    label2444:
    for (int i = i.a.a.a.qC(1, this.ZqL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaIz != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaIz.computeSize());
      }
      i = paramInt;
      if (this.ZpX != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZpX.computeSize());
      }
      paramInt = i;
      if (this.ZpY != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZpY.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.pSf);
      paramInt = i;
      if (this.YFI != null) {
        paramInt = i + i.a.a.a.qC(6, this.YFI.computeSize());
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.pSh);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.pSi);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.pSj) + i.a.a.b.b.a.cJ(11, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaMn);
      }
      i = paramInt;
      if (this.aaMo != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaMo);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.pSk);
      }
      i = paramInt;
      if (this.aaMp != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaMp);
      }
      i = i + i.a.a.b.b.a.cJ(16, this.aaMq) + i.a.a.b.b.a.cJ(17, this.pSm) + i.a.a.b.b.a.cJ(18, this.pSl);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.pSn);
      }
      i = paramInt;
      if (this.aaMs != null) {
        i = paramInt + i.a.a.a.qC(20, this.aaMs.computeSize());
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.pSo);
      }
      i = paramInt;
      if (this.pSp != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.pSp);
      }
      paramInt = i;
      if (this.aaMt != null) {
        paramInt = i + i.a.a.a.qC(23, this.aaMt.computeSize());
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.ZhP);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.aant);
      }
      paramInt = i.a.a.b.b.a.cJ(27, this.abxU);
      AppMethodBeat.o(152681);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eve localeve = (eve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
          return -1;
        case 1: 
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
            localeve.ZqL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localeve.aaIz = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localeve.ZpX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            localeve.ZpY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localeve.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 6: 
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
            localeve.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localeve.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localeve.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localeve.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localeve.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localeve.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localeve.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localeve.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localeve.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localeve.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localeve.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localeve.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localeve.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localeve.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
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
            localeve.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localeve.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localeve.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
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
            localeve.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localeve.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localeve.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localeve.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localeve.abxU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eve
 * JD-Core Version:    0.7.0.1
 */