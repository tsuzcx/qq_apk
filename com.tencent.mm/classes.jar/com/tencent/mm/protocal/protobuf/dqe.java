package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqe
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public int TWU;
  public String TWV;
  public int TWW;
  public String TWX;
  public String Tav;
  public elj TxL;
  public aez TxM;
  public String UserName;
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
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TWU);
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.TWV != null) {
        paramVarArgs.f(4, this.TWV);
      }
      paramVarArgs.aY(5, this.TWW);
      if (this.TWX != null) {
        paramVarArgs.f(6, this.TWX);
      }
      paramVarArgs.aY(7, this.mVy);
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
      if (this.mVD != null) {
        paramVarArgs.f(12, this.mVD);
      }
      paramVarArgs.aY(13, this.mVE);
      paramVarArgs.aY(14, this.mVF);
      if (this.mVG != null) {
        paramVarArgs.f(15, this.mVG);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(16, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(17, this.mVH);
      }
      if (this.mVI != null) {
        paramVarArgs.f(18, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(19, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.SjI != null) {
        paramVarArgs.f(20, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(21, this.SjJ);
      }
      if (this.Tav != null) {
        paramVarArgs.f(22, this.Tav);
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TWU) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.TWV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TWV);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TWW);
      paramInt = i;
      if (this.TWX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TWX);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.mVy);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.mVC);
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.mVD);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.mVE) + g.a.a.b.b.a.bM(14, this.mVF);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.mVG);
      }
      i = paramInt;
      if (this.TxL != null) {
        i = paramInt + g.a.a.a.oD(16, this.TxL.computeSize());
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.mVH);
      }
      i = paramInt;
      if (this.mVI != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.mVI);
      }
      paramInt = i;
      if (this.TxM != null) {
        paramInt = i + g.a.a.a.oD(19, this.TxM.computeSize());
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.SjJ);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.Tav);
      }
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dqe localdqe = (dqe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localdqe.TWU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localdqe.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localdqe.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localdqe.TWV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localdqe.TWW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localdqe.TWX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localdqe.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localdqe.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localdqe.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localdqe.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localdqe.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localdqe.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localdqe.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localdqe.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localdqe.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
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
          localdqe.TxL = ((elj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localdqe.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localdqe.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
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
          localdqe.TxM = ((aez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localdqe.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localdqe.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localdqe.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqe
 * JD-Core Version:    0.7.0.1
 */