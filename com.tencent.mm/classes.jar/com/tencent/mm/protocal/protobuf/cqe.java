package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cqe
  extends com.tencent.mm.cd.a
{
  public int RIG;
  public int RIs;
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
  public int TxN;
  public String UserName;
  public String mVA;
  public String mVB;
  public String mVD;
  public String mVH;
  public String mVI;
  public int mVy;
  public String mVz;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
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
      paramVarArgs.aY(9, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(10, this.TxG);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(11, this.Tlm);
      }
      if (this.mVD != null) {
        paramVarArgs.f(12, this.mVD);
      }
      if (this.TxH != null) {
        paramVarArgs.f(13, this.TxH);
      }
      if (this.TxI != null) {
        paramVarArgs.f(14, this.TxI);
      }
      paramVarArgs.aY(15, this.TxJ);
      paramVarArgs.aY(19, this.TxK);
      if (this.TxL != null)
      {
        paramVarArgs.oE(20, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(21, this.mVH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(22, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(23, this.SjJ);
      }
      if (this.mVI != null) {
        paramVarArgs.f(24, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(25, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.Tav != null) {
        paramVarArgs.f(26, this.Tav);
      }
      paramVarArgs.aY(27, this.RIs);
      paramVarArgs.aY(28, this.TxN);
      AppMethodBeat.o(89925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1738;
      }
    }
    label1738:
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
      i = paramInt + g.a.a.b.b.a.bM(7, this.mVy) + g.a.a.b.b.a.bM(8, this.RIG) + g.a.a.b.b.a.bM(9, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TxG);
      }
      i = paramInt;
      if (this.Tlm != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Tlm);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.mVD);
      }
      i = paramInt;
      if (this.TxH != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TxH);
      }
      paramInt = i;
      if (this.TxI != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TxI);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.TxJ) + g.a.a.b.b.a.bM(19, this.TxK);
      paramInt = i;
      if (this.TxL != null) {
        paramInt = i + g.a.a.a.oD(20, this.TxL.computeSize());
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.mVH);
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.SjJ);
      }
      paramInt = i;
      if (this.mVI != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.mVI);
      }
      i = paramInt;
      if (this.TxM != null) {
        i = paramInt + g.a.a.a.oD(25, this.TxM.computeSize());
      }
      paramInt = i;
      if (this.Tav != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.Tav);
      }
      i = g.a.a.b.b.a.bM(27, this.RIs);
      int j = g.a.a.b.b.a.bM(28, this.TxN);
      AppMethodBeat.o(89925);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(89925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqe localcqe = (cqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(89925);
          return -1;
        case 1: 
          localcqe.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 2: 
          localcqe.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 3: 
          localcqe.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 4: 
          localcqe.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 5: 
          localcqe.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 6: 
          localcqe.TxE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 7: 
          localcqe.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
          return 0;
        case 8: 
          localcqe.RIG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
          return 0;
        case 9: 
          localcqe.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
          return 0;
        case 10: 
          localcqe.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 11: 
          localcqe.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 12: 
          localcqe.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 13: 
          localcqe.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 14: 
          localcqe.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 15: 
          localcqe.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
          return 0;
        case 19: 
          localcqe.TxK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
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
            localcqe.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 21: 
          localcqe.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 22: 
          localcqe.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 23: 
          localcqe.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 24: 
          localcqe.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 25: 
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
            localcqe.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89925);
          return 0;
        case 26: 
          localcqe.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89925);
          return 0;
        case 27: 
          localcqe.RIs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89925);
          return 0;
        }
        localcqe.TxN = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(89925);
        return 0;
      }
      AppMethodBeat.o(89925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqe
 * JD-Core Version:    0.7.0.1
 */