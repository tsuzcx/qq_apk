package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dpb
  extends com.tencent.mm.bx.a
{
  public gol YFI;
  public String ZhO;
  public String ZhP;
  public etl ZpX;
  public etl ZpY;
  public int Zpe;
  public etl ZqL;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public ffs aaMs;
  public ahl aaMt;
  public int aaVH;
  public etl aaVg;
  public etl aaVh;
  public etl aaVi;
  public String aayW;
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
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.aaVg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.aaVh == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.aaVi == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
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
      paramVarArgs.bS(7, this.aaVH);
      if (this.aaVg != null)
      {
        paramVarArgs.qD(8, this.aaVg.computeSize());
        this.aaVg.writeFields(paramVarArgs);
      }
      if (this.aaVh != null)
      {
        paramVarArgs.qD(9, this.aaVh.computeSize());
        this.aaVh.writeFields(paramVarArgs);
      }
      if (this.aaVi != null)
      {
        paramVarArgs.qD(10, this.aaVi.computeSize());
        this.aaVi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.Zpe);
      if (this.pSg != null) {
        paramVarArgs.g(12, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(13, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(14, this.pSi);
      }
      paramVarArgs.bS(15, this.pSj);
      paramVarArgs.bS(16, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(17, this.aaMn);
      }
      if (this.aaMo != null) {
        paramVarArgs.g(18, this.aaMo);
      }
      if (this.aayW != null) {
        paramVarArgs.g(19, this.aayW);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(20, this.aaMp);
      }
      paramVarArgs.bS(21, this.aaMq);
      paramVarArgs.bS(22, this.pSm);
      paramVarArgs.bS(23, this.pSl);
      if (this.pSn != null) {
        paramVarArgs.g(24, this.pSn);
      }
      if (this.pSk != null) {
        paramVarArgs.g(25, this.pSk);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(26, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(27, this.pSo);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(28, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(29, this.ZhP);
      }
      if (this.pSp != null) {
        paramVarArgs.g(30, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(31, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label3034;
      }
    }
    label3034:
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
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaVH);
      paramInt = i;
      if (this.aaVg != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaVg.computeSize());
      }
      i = paramInt;
      if (this.aaVh != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaVh.computeSize());
      }
      paramInt = i;
      if (this.aaVi != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaVi.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.Zpe);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.pSj) + i.a.a.b.b.a.cJ(16, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aaMn);
      }
      i = paramInt;
      if (this.aaMo != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.aaMo);
      }
      paramInt = i;
      if (this.aayW != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.aayW);
      }
      i = paramInt;
      if (this.aaMp != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.aaMp);
      }
      i = i + i.a.a.b.b.a.cJ(21, this.aaMq) + i.a.a.b.b.a.cJ(22, this.pSm) + i.a.a.b.b.a.cJ(23, this.pSl);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.pSn);
      }
      i = paramInt;
      if (this.pSk != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.pSk);
      }
      paramInt = i;
      if (this.aaMs != null) {
        paramInt = i + i.a.a.a.qC(26, this.aaMs.computeSize());
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.pSo);
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.ZhP);
      }
      paramInt = i;
      if (this.pSp != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.pSp);
      }
      i = paramInt;
      if (this.aaMt != null) {
        i = paramInt + i.a.a.a.qC(31, this.aaMt.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
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
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.aaVg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.aaVh == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.aaVi == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dpb localdpb = (dpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
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
            localdpb.ZqL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localdpb.aaIz = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localdpb.ZpX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localdpb.ZpY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localdpb.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
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
            localdpb.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localdpb.aaVH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
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
            localdpb.aaVg = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
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
            localdpb.aaVh = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
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
            localdpb.aaVi = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localdpb.Zpe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localdpb.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localdpb.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localdpb.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localdpb.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localdpb.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localdpb.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localdpb.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localdpb.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localdpb.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localdpb.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localdpb.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localdpb.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localdpb.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localdpb.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
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
            localdpb.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localdpb.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localdpb.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localdpb.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localdpb.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
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
          localdpb.aaMt = ((ahl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      AppMethodBeat.o(101824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpb
 * JD-Core Version:    0.7.0.1
 */