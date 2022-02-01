package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class egw
  extends com.tencent.mm.cd.a
{
  public int RIG;
  public String SjI;
  public String SjJ;
  public String Tav;
  public String Tlm;
  public String TxE;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public int TxK;
  public elj TxL;
  public aez TxM;
  public int Ujk;
  public eae Ujl;
  public int Ujm;
  public String UserName;
  public String mVA;
  public String mVB;
  public String mVH;
  public String mVI;
  public int mVy;
  public String mVz;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ujl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.mVz != null) {
        paramVarArgs.f(3, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(4, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(5, this.mVB);
      }
      if (this.TxE != null) {
        paramVarArgs.f(6, this.TxE);
      }
      paramVarArgs.aY(7, this.mVy);
      paramVarArgs.aY(8, this.RIG);
      paramVarArgs.aY(9, this.Ujk);
      if (this.Ujl != null)
      {
        paramVarArgs.oE(10, this.Ujl.computeSize());
        this.Ujl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.Ujm);
      if (this.TxH != null) {
        paramVarArgs.f(12, this.TxH);
      }
      if (this.TxI != null) {
        paramVarArgs.f(13, this.TxI);
      }
      paramVarArgs.aY(14, this.TxJ);
      paramVarArgs.aY(15, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(16, this.TxG);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(17, this.Tlm);
      }
      paramVarArgs.aY(21, this.TxK);
      if (this.TxL != null)
      {
        paramVarArgs.oE(22, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(23, this.mVH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(24, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(25, this.SjJ);
      }
      if (this.mVI != null) {
        paramVarArgs.f(26, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(27, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.Tav != null) {
        paramVarArgs.f(28, this.Tav);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1887;
      }
    }
    label1887:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVz);
      }
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVA);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVB);
      }
      paramInt = i;
      if (this.TxE != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TxE);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.mVy) + g.a.a.b.b.a.bM(8, this.RIG) + g.a.a.b.b.a.bM(9, this.Ujk);
      paramInt = i;
      if (this.Ujl != null) {
        paramInt = i + g.a.a.a.oD(10, this.Ujl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Ujm);
      paramInt = i;
      if (this.TxH != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TxH);
      }
      i = paramInt;
      if (this.TxI != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TxI);
      }
      i = i + g.a.a.b.b.a.bM(14, this.TxJ) + g.a.a.b.b.a.bM(15, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TxG);
      }
      i = paramInt;
      if (this.Tlm != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.Tlm);
      }
      i += g.a.a.b.b.a.bM(21, this.TxK);
      paramInt = i;
      if (this.TxL != null) {
        paramInt = i + g.a.a.a.oD(22, this.TxL.computeSize());
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.mVH);
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.SjJ);
      }
      paramInt = i;
      if (this.mVI != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.mVI);
      }
      i = paramInt;
      if (this.TxM != null) {
        i = paramInt + g.a.a.a.oD(27, this.TxM.computeSize());
      }
      paramInt = i;
      if (this.Tav != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.Tav);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ujl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egw localegw = (egw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localegw.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localegw.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localegw.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localegw.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localegw.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localegw.TxE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localegw.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localegw.RIG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localegw.Ujk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 10: 
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
            localegw.Ujl = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localegw.Ujm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localegw.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localegw.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localegw.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localegw.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localegw.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localegw.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localegw.TxK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
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
            localegw.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localegw.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localegw.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localegw.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localegw.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
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
            localegw.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localegw.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egw
 * JD-Core Version:    0.7.0.1
 */