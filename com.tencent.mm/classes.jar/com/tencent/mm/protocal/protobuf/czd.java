package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czd
  extends com.tencent.mm.cd.a
{
  public int RFr;
  public int RFu;
  public eaf SrH;
  public long SwY;
  public String SwZ;
  public ahx TGF;
  public int TGU;
  public int TGh;
  public int THa;
  public com.tencent.mm.cd.b THb;
  public int THd;
  public eaf THe;
  public eaf THf;
  public int THg;
  public int THh;
  public int THi;
  public int THj;
  public int THk;
  public chn THl;
  public int THm;
  public String THn;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public String mVA;
  public String mVB;
  public int mVC;
  public String mVD;
  public int mVE;
  public int mVF;
  public String mVG;
  public String mVH;
  public int mVy;
  public String mVz;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.THe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.THf == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.THd);
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
      paramVarArgs.aY(4, this.RFr);
      if (this.THe != null)
      {
        paramVarArgs.oE(5, this.THe.computeSize());
        this.THe.writeFields(paramVarArgs);
      }
      if (this.THf != null)
      {
        paramVarArgs.oE(6, this.THf.computeSize());
        this.THf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.rVU);
      paramVarArgs.aY(8, this.THa);
      if (this.THb != null) {
        paramVarArgs.c(9, this.THb);
      }
      paramVarArgs.aY(10, this.mVy);
      if (this.mVz != null) {
        paramVarArgs.f(11, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(12, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(13, this.mVB);
      }
      paramVarArgs.aY(14, this.mVC);
      if (this.TGF != null)
      {
        paramVarArgs.oE(15, this.TGF.computeSize());
        this.TGF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.RFu);
      paramVarArgs.aY(17, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(18, this.TxG);
      }
      paramVarArgs.aY(19, this.THg);
      paramVarArgs.aY(20, this.THh);
      paramVarArgs.aY(21, this.TGh);
      paramVarArgs.aY(22, this.THi);
      paramVarArgs.aY(23, this.THj);
      if (this.TxH != null) {
        paramVarArgs.f(24, this.TxH);
      }
      paramVarArgs.aY(25, this.THk);
      if (this.THl != null)
      {
        paramVarArgs.oE(26, this.THl.computeSize());
        this.THl.writeFields(paramVarArgs);
      }
      if (this.mVD != null) {
        paramVarArgs.f(27, this.mVD);
      }
      if (this.TxI != null) {
        paramVarArgs.f(28, this.TxI);
      }
      paramVarArgs.aY(29, this.TxJ);
      paramVarArgs.aY(30, this.THm);
      paramVarArgs.bm(31, this.SwY);
      if (this.SwZ != null) {
        paramVarArgs.f(32, this.SwZ);
      }
      paramVarArgs.aY(33, this.mVF);
      paramVarArgs.aY(34, this.mVE);
      if (this.mVG != null) {
        paramVarArgs.f(35, this.mVG);
      }
      paramVarArgs.aY(36, this.TGU);
      if (this.THn != null) {
        paramVarArgs.f(37, this.THn);
      }
      if (this.mVH != null) {
        paramVarArgs.f(38, this.mVH);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.THd) + 0;
      paramInt = i;
      if (this.SrH != null) {
        paramInt = i + g.a.a.a.oD(2, this.SrH.computeSize());
      }
      i = paramInt;
      if (this.TtX != null) {
        i = paramInt + g.a.a.a.oD(3, this.TtX.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.RFr);
      paramInt = i;
      if (this.THe != null) {
        paramInt = i + g.a.a.a.oD(5, this.THe.computeSize());
      }
      i = paramInt;
      if (this.THf != null) {
        i = paramInt + g.a.a.a.oD(6, this.THf.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(7, this.rVU) + g.a.a.b.b.a.bM(8, this.THa);
      paramInt = i;
      if (this.THb != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.THb);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.mVy);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.mVC);
      paramInt = i;
      if (this.TGF != null) {
        paramInt = i + g.a.a.a.oD(15, this.TGF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.RFu) + g.a.a.b.b.a.bM(17, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TxG);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.THg) + g.a.a.b.b.a.bM(20, this.THh) + g.a.a.b.b.a.bM(21, this.TGh) + g.a.a.b.b.a.bM(22, this.THi) + g.a.a.b.b.a.bM(23, this.THj);
      paramInt = i;
      if (this.TxH != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.TxH);
      }
      i = paramInt + g.a.a.b.b.a.bM(25, this.THk);
      paramInt = i;
      if (this.THl != null) {
        paramInt = i + g.a.a.a.oD(26, this.THl.computeSize());
      }
      i = paramInt;
      if (this.mVD != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.mVD);
      }
      paramInt = i;
      if (this.TxI != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.TxI);
      }
      i = paramInt + g.a.a.b.b.a.bM(29, this.TxJ) + g.a.a.b.b.a.bM(30, this.THm) + g.a.a.b.b.a.p(31, this.SwY);
      paramInt = i;
      if (this.SwZ != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.SwZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(33, this.mVF) + g.a.a.b.b.a.bM(34, this.mVE);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.mVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(36, this.TGU);
      paramInt = i;
      if (this.THn != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.THn);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(38, this.mVH);
      }
      AppMethodBeat.o(43112);
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
      if (this.SrH == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.THe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.THf == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      czd localczd = (czd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localczd.THd = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
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
          localczd.SrH = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
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
          localczd.TtX = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localczd.RFr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
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
          localczd.THe = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
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
          localczd.THf = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localczd.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localczd.THa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localczd.THb = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localczd.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localczd.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localczd.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localczd.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localczd.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahx)localObject2).parseFrom((byte[])localObject1);
          }
          localczd.TGF = ((ahx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localczd.RFu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localczd.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localczd.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localczd.THg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localczd.THh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localczd.TGh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localczd.THi = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localczd.THj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localczd.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localczd.THk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new chn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((chn)localObject2).parseFrom((byte[])localObject1);
          }
          localczd.THl = ((chn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localczd.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localczd.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localczd.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localczd.THm = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localczd.SwY = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localczd.SwZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localczd.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localczd.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localczd.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localczd.TGU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localczd.THn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localczd.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czd
 * JD-Core Version:    0.7.0.1
 */