package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cti
  extends com.tencent.mm.cd.a
{
  public String Nickname;
  public String SjI;
  public String SjJ;
  public amh TBc;
  public String Tav;
  public elj TxL;
  public aez TxM;
  public String Username;
  public String mVA;
  public String mVB;
  public int mVC;
  public String mVD;
  public int mVE;
  public int mVF;
  public String mVG;
  public String mVH;
  public String mVI;
  public String mVx;
  public int mVy;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.f(2, this.Nickname);
      }
      if (this.mVx != null) {
        paramVarArgs.f(3, this.mVx);
      }
      paramVarArgs.aY(4, this.mVy);
      if (this.mVz != null) {
        paramVarArgs.f(5, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(6, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(7, this.mVB);
      }
      paramVarArgs.aY(8, this.mVC);
      if (this.mVD != null) {
        paramVarArgs.f(9, this.mVD);
      }
      if (this.TBc != null)
      {
        paramVarArgs.oE(10, this.TBc.computeSize());
        this.TBc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.mVE);
      paramVarArgs.aY(12, this.mVF);
      if (this.mVG != null) {
        paramVarArgs.f(13, this.mVG);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(14, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(15, this.mVH);
      }
      if (this.mVI != null) {
        paramVarArgs.f(16, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(17, this.TxM.computeSize());
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
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1544;
      }
    }
    label1544:
    for (int i = g.a.a.b.b.a.g(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Nickname);
      }
      i = paramInt;
      if (this.mVx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVx);
      }
      i += g.a.a.b.b.a.bM(4, this.mVy);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.mVC);
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mVD);
      }
      i = paramInt;
      if (this.TBc != null) {
        i = paramInt + g.a.a.a.oD(10, this.TBc.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(11, this.mVE) + g.a.a.b.b.a.bM(12, this.mVF);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.mVG);
      }
      i = paramInt;
      if (this.TxL != null) {
        i = paramInt + g.a.a.a.oD(14, this.TxL.computeSize());
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.mVH);
      }
      i = paramInt;
      if (this.mVI != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.mVI);
      }
      paramInt = i;
      if (this.TxM != null) {
        paramInt = i + g.a.a.a.oD(17, this.TxM.computeSize());
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
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cti localcti = (cti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localcti.Username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localcti.Nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localcti.mVx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localcti.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localcti.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localcti.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localcti.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localcti.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localcti.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amh)localObject2).parseFrom((byte[])localObject1);
            }
            localcti.TBc = ((amh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localcti.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localcti.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localcti.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
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
            localcti.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localcti.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localcti.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
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
            localcti.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localcti.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localcti.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localcti.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cti
 * JD-Core Version:    0.7.0.1
 */