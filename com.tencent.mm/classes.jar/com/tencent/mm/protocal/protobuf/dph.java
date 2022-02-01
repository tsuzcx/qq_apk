package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class dph
  extends com.tencent.mm.bx.a
{
  public int DeleteFlag;
  public int ExtFlag;
  public String IMu;
  public int IcB;
  public gol YFI;
  public String ZhO;
  public String ZhP;
  public String ZhS;
  public String ZhV;
  public String ZhW;
  public String ZhX;
  public String ZhY;
  public String Zia;
  public String Zib;
  public String Zic;
  public int ZoY;
  public int ZoZ;
  public etl ZpX;
  public etl ZpY;
  public int Zpe;
  public int Zpf;
  public LinkedList<esv> Zpg;
  public int Zpi;
  public int Zpj;
  public etl ZqL;
  public int ZqM;
  public String ZqN;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public ffs aaMs;
  public ahl aaMt;
  public int aaVH;
  public etl aaVL;
  public int aaVM;
  public int aaVN;
  public String aaVO;
  public String aaVP;
  public String aaVQ;
  public String aaVR;
  public String aaVS;
  public String aaVT;
  public String aaVU;
  public String aaVV;
  public ed aaVW;
  public int aaVX;
  public int aaVY;
  public int aaVZ;
  public etl aaVg;
  public etl aaVh;
  public etl aaVi;
  public String aaWa;
  public edk aaWb;
  public int aaWc;
  public int aaWd;
  public String aaWe;
  public String aaWf;
  public int aaWg;
  public String aanb;
  public zg aaqf;
  public String aayW;
  public String crB;
  public String kaq;
  public long kax;
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
  
  public dph()
  {
    AppMethodBeat.i(43106);
    this.Zpg = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
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
      paramVarArgs.bS(7, this.ZoY);
      paramVarArgs.bS(8, this.ZoZ);
      paramVarArgs.bS(9, this.aaVH);
      if (this.aaVg != null)
      {
        paramVarArgs.qD(10, this.aaVg.computeSize());
        this.aaVg.writeFields(paramVarArgs);
      }
      if (this.aaVh != null)
      {
        paramVarArgs.qD(11, this.aaVh.computeSize());
        this.aaVh.writeFields(paramVarArgs);
      }
      if (this.aaVi != null)
      {
        paramVarArgs.qD(12, this.aaVi.computeSize());
        this.aaVi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.Zpe);
      paramVarArgs.bS(14, this.Zpf);
      paramVarArgs.e(15, 8, this.Zpg);
      if (this.aaVL != null)
      {
        paramVarArgs.qD(16, this.aaVL.computeSize());
        this.aaVL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.Zpi);
      paramVarArgs.bS(18, this.Zpj);
      if (this.pSg != null) {
        paramVarArgs.g(19, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(20, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(21, this.pSi);
      }
      paramVarArgs.bS(22, this.pSj);
      paramVarArgs.bS(23, this.aaVM);
      paramVarArgs.bS(24, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(25, this.aaMn);
      }
      paramVarArgs.bS(26, this.aaVN);
      paramVarArgs.bS(27, this.IcB);
      if (this.aaMo != null) {
        paramVarArgs.g(28, this.aaMo);
      }
      if (this.aayW != null) {
        paramVarArgs.g(29, this.aayW);
      }
      if (this.pSk != null) {
        paramVarArgs.g(30, this.pSk);
      }
      if (this.aaVO != null) {
        paramVarArgs.g(31, this.aaVO);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(32, this.aaMp);
      }
      paramVarArgs.bS(33, this.aaMq);
      paramVarArgs.bS(34, this.pSm);
      paramVarArgs.bS(35, this.pSl);
      if (this.pSn != null) {
        paramVarArgs.g(36, this.pSn);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(37, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(38, this.pSo);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(39, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(40, this.ZhP);
      }
      if (this.pSp != null) {
        paramVarArgs.g(41, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(42, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      if (this.aaVP != null) {
        paramVarArgs.g(43, this.aaVP);
      }
      if (this.aaVQ != null) {
        paramVarArgs.g(44, this.aaVQ);
      }
      if (this.aaVR != null) {
        paramVarArgs.g(45, this.aaVR);
      }
      if (this.aaVS != null) {
        paramVarArgs.g(46, this.aaVS);
      }
      if (this.aaVT != null) {
        paramVarArgs.g(47, this.aaVT);
      }
      if (this.aaVU != null) {
        paramVarArgs.g(48, this.aaVU);
      }
      if (this.aaVV != null) {
        paramVarArgs.g(49, this.aaVV);
      }
      if (this.aaVW != null)
      {
        paramVarArgs.qD(50, this.aaVW.computeSize());
        this.aaVW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(53, this.aaVX);
      if (this.IMu != null) {
        paramVarArgs.g(54, this.IMu);
      }
      paramVarArgs.bS(55, this.aaVY);
      paramVarArgs.bS(56, this.aaVZ);
      if (this.aaqf != null)
      {
        paramVarArgs.qD(57, this.aaqf.computeSize());
        this.aaqf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(58, this.DeleteFlag);
      if (this.crB != null) {
        paramVarArgs.g(59, this.crB);
      }
      if (this.aaWa != null) {
        paramVarArgs.g(60, this.aaWa);
      }
      if (this.ZqN != null) {
        paramVarArgs.g(61, this.ZqN);
      }
      if (this.aaWb != null)
      {
        paramVarArgs.qD(62, this.aaWb.computeSize());
        this.aaWb.writeFields(paramVarArgs);
      }
      if (this.kaq != null) {
        paramVarArgs.g(63, this.kaq);
      }
      paramVarArgs.bS(64, this.aaWc);
      paramVarArgs.bS(65, this.ZqM);
      paramVarArgs.bS(66, this.aaWd);
      paramVarArgs.bS(67, this.ExtFlag);
      if (this.aaWe != null) {
        paramVarArgs.g(68, this.aaWe);
      }
      if (this.ZhS != null) {
        paramVarArgs.g(69, this.ZhS);
      }
      paramVarArgs.bv(70, this.kax);
      if (this.aanb != null) {
        paramVarArgs.g(71, this.aanb);
      }
      if (this.ZhV != null) {
        paramVarArgs.g(72, this.ZhV);
      }
      if (this.ZhW != null) {
        paramVarArgs.g(73, this.ZhW);
      }
      if (this.ZhX != null) {
        paramVarArgs.g(74, this.ZhX);
      }
      if (this.ZhY != null) {
        paramVarArgs.g(75, this.ZhY);
      }
      if (this.aaWf != null) {
        paramVarArgs.g(76, this.aaWf);
      }
      if (this.Zia != null) {
        paramVarArgs.g(77, this.Zia);
      }
      if (this.Zib != null) {
        paramVarArgs.g(78, this.Zib);
      }
      if (this.Zic != null) {
        paramVarArgs.g(79, this.Zic);
      }
      paramVarArgs.bS(80, this.aaWg);
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label5852;
      }
    }
    label5852:
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
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZoY) + i.a.a.b.b.a.cJ(8, this.ZoZ) + i.a.a.b.b.a.cJ(9, this.aaVH);
      paramInt = i;
      if (this.aaVg != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaVg.computeSize());
      }
      i = paramInt;
      if (this.aaVh != null) {
        i = paramInt + i.a.a.a.qC(11, this.aaVh.computeSize());
      }
      paramInt = i;
      if (this.aaVi != null) {
        paramInt = i + i.a.a.a.qC(12, this.aaVi.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.Zpe) + i.a.a.b.b.a.cJ(14, this.Zpf) + i.a.a.a.c(15, 8, this.Zpg);
      paramInt = i;
      if (this.aaVL != null) {
        paramInt = i + i.a.a.a.qC(16, this.aaVL.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.Zpi) + i.a.a.b.b.a.cJ(18, this.Zpj);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.pSj) + i.a.a.b.b.a.cJ(23, this.aaVM) + i.a.a.b.b.a.cJ(24, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.aaMn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(26, this.aaVN) + i.a.a.b.b.a.cJ(27, this.IcB);
      paramInt = i;
      if (this.aaMo != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.aaMo);
      }
      i = paramInt;
      if (this.aayW != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.aayW);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.pSk);
      }
      i = paramInt;
      if (this.aaVO != null) {
        i = paramInt + i.a.a.b.b.a.h(31, this.aaVO);
      }
      paramInt = i;
      if (this.aaMp != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.aaMp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(33, this.aaMq) + i.a.a.b.b.a.cJ(34, this.pSm) + i.a.a.b.b.a.cJ(35, this.pSl);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.pSn);
      }
      i = paramInt;
      if (this.aaMs != null) {
        i = paramInt + i.a.a.a.qC(37, this.aaMs.computeSize());
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.pSo);
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(39, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(40, this.ZhP);
      }
      i = paramInt;
      if (this.pSp != null) {
        i = paramInt + i.a.a.b.b.a.h(41, this.pSp);
      }
      paramInt = i;
      if (this.aaMt != null) {
        paramInt = i + i.a.a.a.qC(42, this.aaMt.computeSize());
      }
      i = paramInt;
      if (this.aaVP != null) {
        i = paramInt + i.a.a.b.b.a.h(43, this.aaVP);
      }
      paramInt = i;
      if (this.aaVQ != null) {
        paramInt = i + i.a.a.b.b.a.h(44, this.aaVQ);
      }
      i = paramInt;
      if (this.aaVR != null) {
        i = paramInt + i.a.a.b.b.a.h(45, this.aaVR);
      }
      paramInt = i;
      if (this.aaVS != null) {
        paramInt = i + i.a.a.b.b.a.h(46, this.aaVS);
      }
      i = paramInt;
      if (this.aaVT != null) {
        i = paramInt + i.a.a.b.b.a.h(47, this.aaVT);
      }
      paramInt = i;
      if (this.aaVU != null) {
        paramInt = i + i.a.a.b.b.a.h(48, this.aaVU);
      }
      i = paramInt;
      if (this.aaVV != null) {
        i = paramInt + i.a.a.b.b.a.h(49, this.aaVV);
      }
      paramInt = i;
      if (this.aaVW != null) {
        paramInt = i + i.a.a.a.qC(50, this.aaVW.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(53, this.aaVX);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(54, this.IMu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(55, this.aaVY) + i.a.a.b.b.a.cJ(56, this.aaVZ);
      paramInt = i;
      if (this.aaqf != null) {
        paramInt = i + i.a.a.a.qC(57, this.aaqf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(58, this.DeleteFlag);
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(59, this.crB);
      }
      i = paramInt;
      if (this.aaWa != null) {
        i = paramInt + i.a.a.b.b.a.h(60, this.aaWa);
      }
      paramInt = i;
      if (this.ZqN != null) {
        paramInt = i + i.a.a.b.b.a.h(61, this.ZqN);
      }
      i = paramInt;
      if (this.aaWb != null) {
        i = paramInt + i.a.a.a.qC(62, this.aaWb.computeSize());
      }
      paramInt = i;
      if (this.kaq != null) {
        paramInt = i + i.a.a.b.b.a.h(63, this.kaq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(64, this.aaWc) + i.a.a.b.b.a.cJ(65, this.ZqM) + i.a.a.b.b.a.cJ(66, this.aaWd) + i.a.a.b.b.a.cJ(67, this.ExtFlag);
      paramInt = i;
      if (this.aaWe != null) {
        paramInt = i + i.a.a.b.b.a.h(68, this.aaWe);
      }
      i = paramInt;
      if (this.ZhS != null) {
        i = paramInt + i.a.a.b.b.a.h(69, this.ZhS);
      }
      i += i.a.a.b.b.a.q(70, this.kax);
      paramInt = i;
      if (this.aanb != null) {
        paramInt = i + i.a.a.b.b.a.h(71, this.aanb);
      }
      i = paramInt;
      if (this.ZhV != null) {
        i = paramInt + i.a.a.b.b.a.h(72, this.ZhV);
      }
      paramInt = i;
      if (this.ZhW != null) {
        paramInt = i + i.a.a.b.b.a.h(73, this.ZhW);
      }
      i = paramInt;
      if (this.ZhX != null) {
        i = paramInt + i.a.a.b.b.a.h(74, this.ZhX);
      }
      paramInt = i;
      if (this.ZhY != null) {
        paramInt = i + i.a.a.b.b.a.h(75, this.ZhY);
      }
      i = paramInt;
      if (this.aaWf != null) {
        i = paramInt + i.a.a.b.b.a.h(76, this.aaWf);
      }
      paramInt = i;
      if (this.Zia != null) {
        paramInt = i + i.a.a.b.b.a.h(77, this.Zia);
      }
      i = paramInt;
      if (this.Zib != null) {
        i = paramInt + i.a.a.b.b.a.h(78, this.Zib);
      }
      paramInt = i;
      if (this.Zic != null) {
        paramInt = i + i.a.a.b.b.a.h(79, this.Zic);
      }
      i = i.a.a.b.b.a.cJ(80, this.aaWg);
      AppMethodBeat.o(43107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zpg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.YFI == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dph localdph = (dph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        default: 
          AppMethodBeat.o(43107);
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
            localdph.ZqL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localdph.aaIz = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localdph.ZpX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
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
            localdph.ZpY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localdph.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
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
            localdph.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localdph.ZoY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localdph.ZoZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localdph.aaVH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
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
            localdph.aaVg = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
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
            localdph.aaVh = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
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
            localdph.aaVi = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localdph.Zpe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localdph.Zpf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esv)localObject2).parseFrom((byte[])localObject1);
            }
            localdph.Zpg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
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
            localdph.aaVL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localdph.Zpi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localdph.Zpj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localdph.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localdph.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localdph.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localdph.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localdph.aaVM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localdph.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localdph.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localdph.aaVN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localdph.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localdph.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localdph.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localdph.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localdph.aaVO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localdph.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localdph.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localdph.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localdph.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localdph.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
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
            localdph.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localdph.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localdph.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localdph.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localdph.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
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
            localdph.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localdph.aaVP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localdph.aaVQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localdph.aaVR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localdph.aaVS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localdph.aaVT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localdph.aaVU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localdph.aaVV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ed();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ed)localObject2).parseFrom((byte[])localObject1);
            }
            localdph.aaVW = ((ed)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localdph.aaVX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localdph.IMu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localdph.aaVY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localdph.aaVZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new zg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((zg)localObject2).parseFrom((byte[])localObject1);
            }
            localdph.aaqf = ((zg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localdph.DeleteFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localdph.crB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localdph.aaWa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localdph.ZqN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edk)localObject2).parseFrom((byte[])localObject1);
            }
            localdph.aaWb = ((edk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localdph.kaq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localdph.aaWc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localdph.ZqM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localdph.aaWd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localdph.ExtFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localdph.aaWe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 69: 
          localdph.ZhS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 70: 
          localdph.kax = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(43107);
          return 0;
        case 71: 
          localdph.aanb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 72: 
          localdph.ZhV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 73: 
          localdph.ZhW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 74: 
          localdph.ZhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 75: 
          localdph.ZhY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 76: 
          localdph.aaWf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 77: 
          localdph.Zia = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 78: 
          localdph.Zib = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 79: 
          localdph.Zic = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43107);
          return 0;
        }
        localdph.aaWg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dph
 * JD-Core Version:    0.7.0.1
 */