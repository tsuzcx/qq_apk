package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxw
  extends com.tencent.mm.cd.a
{
  public eae RIH;
  public String SjI;
  public String SjJ;
  public eaf SqW;
  public eaf SqX;
  public int Sqi;
  public eaf SrH;
  public eaf TFA;
  public eaf TFB;
  public eaf TFz;
  public int TGb;
  public String Tlm;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public elj TxL;
  public aez TxM;
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
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.SqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.SqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.TFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.TFA == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.TFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
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
      paramVarArgs.aY(7, this.TGb);
      if (this.TFz != null)
      {
        paramVarArgs.oE(8, this.TFz.computeSize());
        this.TFz.writeFields(paramVarArgs);
      }
      if (this.TFA != null)
      {
        paramVarArgs.oE(9, this.TFA.computeSize());
        this.TFA.writeFields(paramVarArgs);
      }
      if (this.TFB != null)
      {
        paramVarArgs.oE(10, this.TFB.computeSize());
        this.TFB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.Sqi);
      if (this.mVz != null) {
        paramVarArgs.f(12, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(13, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(14, this.mVB);
      }
      paramVarArgs.aY(15, this.mVC);
      paramVarArgs.aY(16, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(17, this.TxG);
      }
      if (this.TxH != null) {
        paramVarArgs.f(18, this.TxH);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(19, this.Tlm);
      }
      if (this.TxI != null) {
        paramVarArgs.f(20, this.TxI);
      }
      paramVarArgs.aY(21, this.TxJ);
      paramVarArgs.aY(22, this.mVF);
      paramVarArgs.aY(23, this.mVE);
      if (this.mVG != null) {
        paramVarArgs.f(24, this.mVG);
      }
      if (this.mVD != null) {
        paramVarArgs.f(25, this.mVD);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(26, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(27, this.mVH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(28, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(29, this.SjJ);
      }
      if (this.mVI != null) {
        paramVarArgs.f(30, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(31, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrH == null) {
        break label3038;
      }
    }
    label3038:
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
      i = paramInt + g.a.a.b.b.a.bM(7, this.TGb);
      paramInt = i;
      if (this.TFz != null) {
        paramInt = i + g.a.a.a.oD(8, this.TFz.computeSize());
      }
      i = paramInt;
      if (this.TFA != null) {
        i = paramInt + g.a.a.a.oD(9, this.TFA.computeSize());
      }
      paramInt = i;
      if (this.TFB != null) {
        paramInt = i + g.a.a.a.oD(10, this.TFB.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Sqi);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.mVC) + g.a.a.b.b.a.bM(16, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TxG);
      }
      i = paramInt;
      if (this.TxH != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.TxH);
      }
      paramInt = i;
      if (this.Tlm != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.Tlm);
      }
      i = paramInt;
      if (this.TxI != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.TxI);
      }
      i = i + g.a.a.b.b.a.bM(21, this.TxJ) + g.a.a.b.b.a.bM(22, this.mVF) + g.a.a.b.b.a.bM(23, this.mVE);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.mVG);
      }
      i = paramInt;
      if (this.mVD != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.mVD);
      }
      paramInt = i;
      if (this.TxL != null) {
        paramInt = i + g.a.a.a.oD(26, this.TxL.computeSize());
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.mVH);
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.SjJ);
      }
      paramInt = i;
      if (this.mVI != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.mVI);
      }
      i = paramInt;
      if (this.TxM != null) {
        i = paramInt + g.a.a.a.oD(31, this.TxM.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
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
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.SqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.SqX == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.RIH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.TFz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.TFA == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.TFB == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxw localcxw = (cxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
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
            localcxw.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcxw.TtX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcxw.SqW = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcxw.SqX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localcxw.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
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
            localcxw.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localcxw.TGb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
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
            localcxw.TFz = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
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
            localcxw.TFA = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
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
            localcxw.TFB = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localcxw.Sqi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localcxw.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localcxw.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localcxw.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localcxw.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localcxw.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localcxw.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localcxw.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localcxw.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localcxw.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localcxw.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localcxw.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localcxw.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localcxw.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localcxw.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
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
            localcxw.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localcxw.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localcxw.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localcxw.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localcxw.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
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
          localcxw.TxM = ((aez)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxw
 * JD-Core Version:    0.7.0.1
 */