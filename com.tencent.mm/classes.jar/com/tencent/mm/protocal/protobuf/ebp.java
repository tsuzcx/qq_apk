package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebp
  extends dyy
{
  public eae RIH;
  public String SjI;
  public String SjJ;
  public eaf SqW;
  public eaf SqX;
  public eaf SrH;
  public String Tav;
  public int Tdj;
  public LinkedList<ebn> Tdk;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public elj TxL;
  public aez TxM;
  public int Ugt;
  public eae Ugv;
  public String Ugw;
  public String Ugx;
  public int Ugy;
  public LinkedList<ecg> Ugz;
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
  
  public ebp()
  {
    AppMethodBeat.i(152683);
    this.Tdk = new LinkedList();
    this.Ugz = new LinkedList();
    AppMethodBeat.o(152683);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152684);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.SqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.SqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(2, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      if (this.TtX != null)
      {
        paramVarArgs.oE(3, this.TtX.computeSize());
        this.TtX.writeFields(paramVarArgs);
      }
      if (this.SqW != null)
      {
        paramVarArgs.oE(4, this.SqW.computeSize());
        this.SqW.writeFields(paramVarArgs);
      }
      if (this.SqX != null)
      {
        paramVarArgs.oE(5, this.SqX.computeSize());
        this.SqX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.mVy);
      if (this.RIH != null)
      {
        paramVarArgs.oE(7, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      if (this.mVz != null) {
        paramVarArgs.f(8, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(9, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(10, this.mVB);
      }
      paramVarArgs.aY(11, this.mVC);
      paramVarArgs.aY(12, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(13, this.TxG);
      }
      if (this.TxH != null) {
        paramVarArgs.f(14, this.TxH);
      }
      if (this.mVD != null) {
        paramVarArgs.f(15, this.mVD);
      }
      if (this.TxI != null) {
        paramVarArgs.f(16, this.TxI);
      }
      paramVarArgs.aY(17, this.TxJ);
      paramVarArgs.aY(18, this.mVF);
      paramVarArgs.aY(19, this.mVE);
      if (this.mVG != null) {
        paramVarArgs.f(20, this.mVG);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(21, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(22, this.mVH);
      }
      if (this.mVI != null) {
        paramVarArgs.f(23, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(24, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(25, this.Tdj);
      paramVarArgs.e(26, 8, this.Tdk);
      if (this.SjI != null) {
        paramVarArgs.f(27, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(28, this.SjJ);
      }
      if (this.Ugv != null)
      {
        paramVarArgs.oE(29, this.Ugv.computeSize());
        this.Ugv.writeFields(paramVarArgs);
      }
      if (this.Tav != null) {
        paramVarArgs.f(30, this.Tav);
      }
      if (this.Ugw != null) {
        paramVarArgs.f(31, this.Ugw);
      }
      paramVarArgs.aY(32, this.Ugt);
      if (this.Ugx != null) {
        paramVarArgs.f(33, this.Ugx);
      }
      paramVarArgs.aY(34, this.Ugy);
      paramVarArgs.e(35, 8, this.Ugz);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3220;
      }
    }
    label3220:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SrH != null) {
        paramInt = i + g.a.a.a.oD(2, this.SrH.computeSize());
      }
      i = paramInt;
      if (this.TtX != null) {
        i = paramInt + g.a.a.a.oD(3, this.TtX.computeSize());
      }
      paramInt = i;
      if (this.SqW != null) {
        paramInt = i + g.a.a.a.oD(4, this.SqW.computeSize());
      }
      i = paramInt;
      if (this.SqX != null) {
        i = paramInt + g.a.a.a.oD(5, this.SqX.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.mVy);
      paramInt = i;
      if (this.RIH != null) {
        paramInt = i + g.a.a.a.oD(7, this.RIH.computeSize());
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.mVz);
      }
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mVA);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.mVB);
      }
      i = i + g.a.a.b.b.a.bM(11, this.mVC) + g.a.a.b.b.a.bM(12, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TxG);
      }
      i = paramInt;
      if (this.TxH != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TxH);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.mVD);
      }
      i = paramInt;
      if (this.TxI != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.TxI);
      }
      i = i + g.a.a.b.b.a.bM(17, this.TxJ) + g.a.a.b.b.a.bM(18, this.mVF) + g.a.a.b.b.a.bM(19, this.mVE);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.mVG);
      }
      i = paramInt;
      if (this.TxL != null) {
        i = paramInt + g.a.a.a.oD(21, this.TxL.computeSize());
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.mVH);
      }
      i = paramInt;
      if (this.mVI != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.mVI);
      }
      paramInt = i;
      if (this.TxM != null) {
        paramInt = i + g.a.a.a.oD(24, this.TxM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(25, this.Tdj) + g.a.a.a.c(26, 8, this.Tdk);
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(28, this.SjJ);
      }
      paramInt = i;
      if (this.Ugv != null) {
        paramInt = i + g.a.a.a.oD(29, this.Ugv.computeSize());
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.Tav);
      }
      paramInt = i;
      if (this.Ugw != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.Ugw);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.Ugt);
      paramInt = i;
      if (this.Ugx != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.Ugx);
      }
      i = g.a.a.b.b.a.bM(34, this.Ugy);
      int j = g.a.a.a.c(35, 8, this.Ugz);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tdk.clear();
        this.Ugz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.SqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.SqX == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.RIH == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebp localebp = (ebp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localebp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            localebp.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            localebp.TtX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            localebp.SqW = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
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
            localebp.SqX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localebp.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
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
            localebp.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localebp.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localebp.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localebp.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localebp.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localebp.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localebp.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localebp.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localebp.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localebp.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localebp.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localebp.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localebp.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localebp.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
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
            localebp.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localebp.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localebp.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
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
            localebp.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localebp.Tdj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebn)localObject2).parseFrom((byte[])localObject1);
            }
            localebp.Tdk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localebp.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localebp.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
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
            localebp.Ugv = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localebp.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localebp.Ugw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localebp.Ugt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localebp.Ugx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localebp.Ugy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ecg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ecg)localObject2).parseFrom((byte[])localObject1);
          }
          localebp.Ugz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152684);
        return 0;
      }
      AppMethodBeat.o(152684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebp
 * JD-Core Version:    0.7.0.1
 */