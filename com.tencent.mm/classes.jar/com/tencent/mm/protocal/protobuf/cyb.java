package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class cyb
  extends com.tencent.mm.cd.a
{
  public String CSe;
  public int Cqs;
  public int DeleteFlag;
  public int ExtFlag;
  public String RIC;
  public eae RIH;
  public String SjI;
  public String SjJ;
  public String SjU;
  public String SjW;
  public eaf SqW;
  public eaf SqX;
  public int Sqc;
  public int Sqd;
  public int Sqi;
  public int Sqj;
  public LinkedList<dzp> Sqk;
  public int Sqm;
  public int Sqn;
  public eaf SrH;
  public int SrI;
  public String SrJ;
  public eaf TFA;
  public eaf TFB;
  public eaf TFz;
  public int TGb;
  public eaf TGf;
  public int TGg;
  public int TGh;
  public String TGi;
  public String TGj;
  public String TGk;
  public String TGl;
  public String TGm;
  public String TGn;
  public String TGo;
  public String TGp;
  public do TGq;
  public int TGr;
  public int TGs;
  public int TGt;
  public String TGu;
  public dla TGv;
  public int TGw;
  public int TGx;
  public String TGy;
  public int TGz;
  public String Tad;
  public xm TcQ;
  public String Tlm;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String TxH;
  public String TxI;
  public int TxJ;
  public elj TxL;
  public aez TxM;
  public long hDC;
  public String hDv;
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
  
  public cyb()
  {
    AppMethodBeat.i(43106);
    this.Sqk = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.SqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.SqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
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
      paramVarArgs.aY(7, this.Sqc);
      paramVarArgs.aY(8, this.Sqd);
      paramVarArgs.aY(9, this.TGb);
      if (this.TFz != null)
      {
        paramVarArgs.oE(10, this.TFz.computeSize());
        this.TFz.writeFields(paramVarArgs);
      }
      if (this.TFA != null)
      {
        paramVarArgs.oE(11, this.TFA.computeSize());
        this.TFA.writeFields(paramVarArgs);
      }
      if (this.TFB != null)
      {
        paramVarArgs.oE(12, this.TFB.computeSize());
        this.TFB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.Sqi);
      paramVarArgs.aY(14, this.Sqj);
      paramVarArgs.e(15, 8, this.Sqk);
      if (this.TGf != null)
      {
        paramVarArgs.oE(16, this.TGf.computeSize());
        this.TGf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(17, this.Sqm);
      paramVarArgs.aY(18, this.Sqn);
      if (this.mVz != null) {
        paramVarArgs.f(19, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(20, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(21, this.mVB);
      }
      paramVarArgs.aY(22, this.mVC);
      paramVarArgs.aY(23, this.TGg);
      paramVarArgs.aY(24, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(25, this.TxG);
      }
      paramVarArgs.aY(26, this.TGh);
      paramVarArgs.aY(27, this.Cqs);
      if (this.TxH != null) {
        paramVarArgs.f(28, this.TxH);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(29, this.Tlm);
      }
      if (this.mVD != null) {
        paramVarArgs.f(30, this.mVD);
      }
      if (this.TGi != null) {
        paramVarArgs.f(31, this.TGi);
      }
      if (this.TxI != null) {
        paramVarArgs.f(32, this.TxI);
      }
      paramVarArgs.aY(33, this.TxJ);
      paramVarArgs.aY(34, this.mVF);
      paramVarArgs.aY(35, this.mVE);
      if (this.mVG != null) {
        paramVarArgs.f(36, this.mVG);
      }
      if (this.TxL != null)
      {
        paramVarArgs.oE(37, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      if (this.mVH != null) {
        paramVarArgs.f(38, this.mVH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(39, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(40, this.SjJ);
      }
      if (this.mVI != null) {
        paramVarArgs.f(41, this.mVI);
      }
      if (this.TxM != null)
      {
        paramVarArgs.oE(42, this.TxM.computeSize());
        this.TxM.writeFields(paramVarArgs);
      }
      if (this.TGj != null) {
        paramVarArgs.f(43, this.TGj);
      }
      if (this.TGk != null) {
        paramVarArgs.f(44, this.TGk);
      }
      if (this.TGl != null) {
        paramVarArgs.f(45, this.TGl);
      }
      if (this.TGm != null) {
        paramVarArgs.f(46, this.TGm);
      }
      if (this.TGn != null) {
        paramVarArgs.f(47, this.TGn);
      }
      if (this.TGo != null) {
        paramVarArgs.f(48, this.TGo);
      }
      if (this.TGp != null) {
        paramVarArgs.f(49, this.TGp);
      }
      if (this.TGq != null)
      {
        paramVarArgs.oE(50, this.TGq.computeSize());
        this.TGq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(53, this.TGr);
      if (this.CSe != null) {
        paramVarArgs.f(54, this.CSe);
      }
      paramVarArgs.aY(55, this.TGs);
      paramVarArgs.aY(56, this.TGt);
      if (this.TcQ != null)
      {
        paramVarArgs.oE(57, this.TcQ.computeSize());
        this.TcQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(58, this.DeleteFlag);
      if (this.RIC != null) {
        paramVarArgs.f(59, this.RIC);
      }
      if (this.TGu != null) {
        paramVarArgs.f(60, this.TGu);
      }
      if (this.SrJ != null) {
        paramVarArgs.f(61, this.SrJ);
      }
      if (this.TGv != null)
      {
        paramVarArgs.oE(62, this.TGv.computeSize());
        this.TGv.writeFields(paramVarArgs);
      }
      if (this.hDv != null) {
        paramVarArgs.f(63, this.hDv);
      }
      paramVarArgs.aY(64, this.TGw);
      paramVarArgs.aY(65, this.SrI);
      paramVarArgs.aY(66, this.TGx);
      paramVarArgs.aY(67, this.ExtFlag);
      if (this.TGy != null) {
        paramVarArgs.f(68, this.TGy);
      }
      paramVarArgs.bm(70, this.hDC);
      if (this.Tad != null) {
        paramVarArgs.f(71, this.Tad);
      }
      if (this.SjU != null) {
        paramVarArgs.f(77, this.SjU);
      }
      if (this.SjW != null) {
        paramVarArgs.f(79, this.SjW);
      }
      paramVarArgs.aY(80, this.TGz);
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrH == null) {
        break label5448;
      }
    }
    label5448:
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
      i = paramInt + g.a.a.b.b.a.bM(7, this.Sqc) + g.a.a.b.b.a.bM(8, this.Sqd) + g.a.a.b.b.a.bM(9, this.TGb);
      paramInt = i;
      if (this.TFz != null) {
        paramInt = i + g.a.a.a.oD(10, this.TFz.computeSize());
      }
      i = paramInt;
      if (this.TFA != null) {
        i = paramInt + g.a.a.a.oD(11, this.TFA.computeSize());
      }
      paramInt = i;
      if (this.TFB != null) {
        paramInt = i + g.a.a.a.oD(12, this.TFB.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.Sqi) + g.a.a.b.b.a.bM(14, this.Sqj) + g.a.a.a.c(15, 8, this.Sqk);
      paramInt = i;
      if (this.TGf != null) {
        paramInt = i + g.a.a.a.oD(16, this.TGf.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.Sqm) + g.a.a.b.b.a.bM(18, this.Sqn);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.mVC) + g.a.a.b.b.a.bM(23, this.TGg) + g.a.a.b.b.a.bM(24, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.TxG);
      }
      i = paramInt + g.a.a.b.b.a.bM(26, this.TGh) + g.a.a.b.b.a.bM(27, this.Cqs);
      paramInt = i;
      if (this.TxH != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.TxH);
      }
      i = paramInt;
      if (this.Tlm != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.Tlm);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.mVD);
      }
      i = paramInt;
      if (this.TGi != null) {
        i = paramInt + g.a.a.b.b.a.g(31, this.TGi);
      }
      paramInt = i;
      if (this.TxI != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.TxI);
      }
      i = paramInt + g.a.a.b.b.a.bM(33, this.TxJ) + g.a.a.b.b.a.bM(34, this.mVF) + g.a.a.b.b.a.bM(35, this.mVE);
      paramInt = i;
      if (this.mVG != null) {
        paramInt = i + g.a.a.b.b.a.g(36, this.mVG);
      }
      i = paramInt;
      if (this.TxL != null) {
        i = paramInt + g.a.a.a.oD(37, this.TxL.computeSize());
      }
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(38, this.mVH);
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(39, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(40, this.SjJ);
      }
      i = paramInt;
      if (this.mVI != null) {
        i = paramInt + g.a.a.b.b.a.g(41, this.mVI);
      }
      paramInt = i;
      if (this.TxM != null) {
        paramInt = i + g.a.a.a.oD(42, this.TxM.computeSize());
      }
      i = paramInt;
      if (this.TGj != null) {
        i = paramInt + g.a.a.b.b.a.g(43, this.TGj);
      }
      paramInt = i;
      if (this.TGk != null) {
        paramInt = i + g.a.a.b.b.a.g(44, this.TGk);
      }
      i = paramInt;
      if (this.TGl != null) {
        i = paramInt + g.a.a.b.b.a.g(45, this.TGl);
      }
      paramInt = i;
      if (this.TGm != null) {
        paramInt = i + g.a.a.b.b.a.g(46, this.TGm);
      }
      i = paramInt;
      if (this.TGn != null) {
        i = paramInt + g.a.a.b.b.a.g(47, this.TGn);
      }
      paramInt = i;
      if (this.TGo != null) {
        paramInt = i + g.a.a.b.b.a.g(48, this.TGo);
      }
      i = paramInt;
      if (this.TGp != null) {
        i = paramInt + g.a.a.b.b.a.g(49, this.TGp);
      }
      paramInt = i;
      if (this.TGq != null) {
        paramInt = i + g.a.a.a.oD(50, this.TGq.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(53, this.TGr);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(54, this.CSe);
      }
      i = paramInt + g.a.a.b.b.a.bM(55, this.TGs) + g.a.a.b.b.a.bM(56, this.TGt);
      paramInt = i;
      if (this.TcQ != null) {
        paramInt = i + g.a.a.a.oD(57, this.TcQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(58, this.DeleteFlag);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(59, this.RIC);
      }
      i = paramInt;
      if (this.TGu != null) {
        i = paramInt + g.a.a.b.b.a.g(60, this.TGu);
      }
      paramInt = i;
      if (this.SrJ != null) {
        paramInt = i + g.a.a.b.b.a.g(61, this.SrJ);
      }
      i = paramInt;
      if (this.TGv != null) {
        i = paramInt + g.a.a.a.oD(62, this.TGv.computeSize());
      }
      paramInt = i;
      if (this.hDv != null) {
        paramInt = i + g.a.a.b.b.a.g(63, this.hDv);
      }
      i = paramInt + g.a.a.b.b.a.bM(64, this.TGw) + g.a.a.b.b.a.bM(65, this.SrI) + g.a.a.b.b.a.bM(66, this.TGx) + g.a.a.b.b.a.bM(67, this.ExtFlag);
      paramInt = i;
      if (this.TGy != null) {
        paramInt = i + g.a.a.b.b.a.g(68, this.TGy);
      }
      i = paramInt + g.a.a.b.b.a.p(70, this.hDC);
      paramInt = i;
      if (this.Tad != null) {
        paramInt = i + g.a.a.b.b.a.g(71, this.Tad);
      }
      i = paramInt;
      if (this.SjU != null) {
        i = paramInt + g.a.a.b.b.a.g(77, this.SjU);
      }
      paramInt = i;
      if (this.SjW != null) {
        paramInt = i + g.a.a.b.b.a.g(79, this.SjW);
      }
      i = g.a.a.b.b.a.bM(80, this.TGz);
      AppMethodBeat.o(43107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sqk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.SqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.SqX == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.RIH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyb localcyb = (cyb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        case 69: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 78: 
        default: 
          AppMethodBeat.o(43107);
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
            localcyb.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcyb.TtX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcyb.SqW = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localcyb.SqX = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localcyb.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
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
            localcyb.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localcyb.Sqc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localcyb.Sqd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localcyb.TGb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
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
            localcyb.TFz = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
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
            localcyb.TFA = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
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
            localcyb.TFB = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localcyb.Sqi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localcyb.Sqj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzp)localObject2).parseFrom((byte[])localObject1);
            }
            localcyb.Sqk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
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
            localcyb.TGf = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localcyb.Sqm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localcyb.Sqn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localcyb.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localcyb.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localcyb.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localcyb.mVC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localcyb.TGg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localcyb.TxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localcyb.TxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localcyb.TGh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localcyb.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localcyb.TxH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localcyb.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localcyb.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localcyb.TGi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localcyb.TxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localcyb.TxJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localcyb.mVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localcyb.mVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localcyb.mVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
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
            localcyb.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localcyb.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localcyb.SjI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localcyb.SjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localcyb.mVI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
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
            localcyb.TxM = ((aez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localcyb.TGj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localcyb.TGk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localcyb.TGl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localcyb.TGm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localcyb.TGn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localcyb.TGo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localcyb.TGp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new do();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((do)localObject2).parseFrom((byte[])localObject1);
            }
            localcyb.TGq = ((do)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localcyb.TGr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localcyb.CSe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localcyb.TGs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localcyb.TGt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new xm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((xm)localObject2).parseFrom((byte[])localObject1);
            }
            localcyb.TcQ = ((xm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localcyb.DeleteFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localcyb.RIC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localcyb.TGu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localcyb.SrJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dla();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dla)localObject2).parseFrom((byte[])localObject1);
            }
            localcyb.TGv = ((dla)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localcyb.hDv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localcyb.TGw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localcyb.SrI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localcyb.TGx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localcyb.ExtFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localcyb.TGy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 70: 
          localcyb.hDC = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(43107);
          return 0;
        case 71: 
          localcyb.Tad = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 77: 
          localcyb.SjU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 79: 
          localcyb.SjW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(43107);
          return 0;
        }
        localcyb.TGz = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyb
 * JD-Core Version:    0.7.0.1
 */