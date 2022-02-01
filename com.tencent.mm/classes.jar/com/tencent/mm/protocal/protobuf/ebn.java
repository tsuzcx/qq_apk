package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebn
  extends com.tencent.mm.cd.a
{
  public eae RIH;
  public String SjI;
  public String SjJ;
  public eaf SqW;
  public eaf SqX;
  public eaf SrH;
  public String Tav;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public elj TxL;
  public aez TxM;
  public int Ugt;
  public String mVA;
  public String mVB;
  public int mVC;
  public String mVD;
  public int mVE;
  public int mVF;
  public String mVG;
  public String mVH;
  public String mVI;
  public int mVy;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.SqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.SqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(1, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      if (this.TtX != null)
      {
        paramVarArgs.oE(2, this.TtX.computeSize());
        this.TtX.writeFields(paramVarArgs);
      }
      if (this.SqW != null)
      {
        paramVarArgs.oE(3, this.SqW.computeSize());
        this.SqW.writeFields(paramVarArgs);
      }
      if (this.SqX != null)
      {
        paramVarArgs.oE(4, this.SqX.computeSize());
        this.SqX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.mVy);
      if (this.RIH != null)
      {
        paramVarArgs.oE(6, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      if (this.mVz != null) {
        paramVarArgs.f(7, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(8, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(9, this.mVB);
      }
      paramVarArgs.aY(10, this.mVC);
      paramVarArgs.aY(11, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(12, this.TxG);
      }
      if (this.TxH != null) {
        paramVarArgs.f(13, this.TxH);
      }
      if (this.mVD != null) {
        paramVarArgs.f(14, this.mVD);
      }
      if (this.TxI != null) {
        paramVarArgs.f(15, this.TxI);
      }
      paramVarArgs.aY(16, this.TxJ);
      paramVarArgs.aY(17, this.mVF);
      paramVarArgs.aY(18, this.mVE);
      if (this.mVG != null) {
        paramVarArgs.f(19, this.mVG);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(20, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(21, this.mVH);
      }
      if (this.mVI != null) {
        paramVarArgs.f(22, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(23, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.SjI != null) {
        paramVarArgs.f(24, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(25, this.SjJ);
      }
      if (this.Tav != null) {
        paramVarArgs.f(26, this.Tav);
      }
      paramVarArgs.aY(27, this.Ugt);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrH == null) {
        break label2448;
      }
    }
    label2448:
    for (int i = g.a.a.a.oD(1, this.SrH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TtX != null) {
        paramInt = i + g.a.a.a.oD(2, this.TtX.computeSize());
      }
      i = paramInt;
      if (this.SqW != null) {
        i = paramInt + g.a.a.a.oD(3, this.SqW.computeSize());
      }
      paramInt = i;
      if (this.SqX != null) {
        paramInt = i + g.a.a.a.oD(4, this.SqX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.mVy);
      paramInt = i;
      if (this.RIH != null) {
        paramInt = i + g.a.a.a.oD(6, this.RIH.computeSize());
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mVz);
      }
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mVA);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.mVB);
      }
      i = i + g.a.a.b.b.a.bM(10, this.mVC) + g.a.a.b.b.a.bM(11, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TxG);
      }
      i = paramInt;
      if (this.TxH != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TxH);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.mVD);
      }
      i = paramInt;
      if (this.TxI != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TxI);
      }
      i = i + g.a.a.b.b.a.bM(16, this.TxJ) + g.a.a.b.b.a.bM(17, this.mVF) + g.a.a.b.b.a.bM(18, this.mVE);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.mVG);
      }
      i = paramInt;
      if (this.TxL != null) {
        i = paramInt + g.a.a.a.oD(20, this.TxL.computeSize());
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.mVH);
      }
      i = paramInt;
      if (this.mVI != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.mVI);
      }
      paramInt = i;
      if (this.TxM != null) {
        paramInt = i + g.a.a.a.oD(23, this.TxM.computeSize());
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.SjJ);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.Tav);
      }
      paramInt = g.a.a.b.b.a.bM(27, this.Ugt);
      AppMethodBeat.o(152681);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.SqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.SqX == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.RIH == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebn localebn = (ebn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localebn.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localebn.TtX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localebn.SqW = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localebn.SqX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localebn.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localebn.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localebn.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localebn.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localebn.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localebn.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localebn.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localebn.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localebn.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localebn.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localebn.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localebn.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localebn.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localebn.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localebn.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elj)localObject2).parseFrom((byte[])localObject1);
            }
            localebn.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localebn.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localebn.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aez)localObject2).parseFrom((byte[])localObject1);
            }
            localebn.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localebn.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localebn.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localebn.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localebn.Ugt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebn
 * JD-Core Version:    0.7.0.1
 */