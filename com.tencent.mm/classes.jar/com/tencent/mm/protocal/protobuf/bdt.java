package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdt
  extends com.tencent.mm.bv.a
{
  public int DeleteFlag;
  public int ExtFlag;
  public String dqY;
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwU;
  public int gwV;
  public int gwW;
  public String gwX;
  public String gwY;
  public String gwZ;
  public int niK;
  public String nuz;
  public String wJq;
  public String wJr;
  public int wNK;
  public int wNL;
  public int wNQ;
  public int wNR;
  public LinkedList<bvx> wNS;
  public int wNU;
  public int wNV;
  public bwc wOT;
  public int wOU;
  public String wOV;
  public bwc wOv;
  public bwc wOw;
  public String woO;
  public SKBuiltinBuffer_t woT;
  public rc xaC;
  public String xfJ;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public cfj xpk;
  public wc xpl;
  public bwc xsT;
  public bwc xsU;
  public bwc xsV;
  public int xtA;
  public int xtB;
  public int xtC;
  public String xtD;
  public bmi xtE;
  public int xtF;
  public int xtG;
  public String xtH;
  public int xtk;
  public bwc xto;
  public int xtp;
  public int xtq;
  public String xtr;
  public String xts;
  public String xtt;
  public String xtu;
  public String xtv;
  public String xtw;
  public String xtx;
  public String xty;
  public cw xtz;
  
  public bdt()
  {
    AppMethodBeat.i(60046);
    this.wNS = new LinkedList();
    AppMethodBeat.o(60046);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60047);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(60047);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(60047);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(60047);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(60047);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(60047);
        throw paramVarArgs;
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(1, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(2, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.wOv != null)
      {
        paramVarArgs.iQ(3, this.wOv.computeSize());
        this.wOv.writeFields(paramVarArgs);
      }
      if (this.wOw != null)
      {
        paramVarArgs.iQ(4, this.wOw.computeSize());
        this.wOw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.gwP);
      if (this.woT != null)
      {
        paramVarArgs.iQ(6, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wNK);
      paramVarArgs.aO(8, this.wNL);
      paramVarArgs.aO(9, this.xtk);
      if (this.xsT != null)
      {
        paramVarArgs.iQ(10, this.xsT.computeSize());
        this.xsT.writeFields(paramVarArgs);
      }
      if (this.xsU != null)
      {
        paramVarArgs.iQ(11, this.xsU.computeSize());
        this.xsU.writeFields(paramVarArgs);
      }
      if (this.xsV != null)
      {
        paramVarArgs.iQ(12, this.xsV.computeSize());
        this.xsV.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(13, this.wNQ);
      paramVarArgs.aO(14, this.wNR);
      paramVarArgs.e(15, 8, this.wNS);
      if (this.xto != null)
      {
        paramVarArgs.iQ(16, this.xto.computeSize());
        this.xto.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(17, this.wNU);
      paramVarArgs.aO(18, this.wNV);
      if (this.gwQ != null) {
        paramVarArgs.e(19, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(20, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(21, this.gwS);
      }
      paramVarArgs.aO(22, this.gwT);
      paramVarArgs.aO(23, this.xtp);
      paramVarArgs.aO(24, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(25, this.xpf);
      }
      paramVarArgs.aO(26, this.xtq);
      paramVarArgs.aO(27, this.niK);
      if (this.xpg != null) {
        paramVarArgs.e(28, this.xpg);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(29, this.xfJ);
      }
      if (this.gwU != null) {
        paramVarArgs.e(30, this.gwU);
      }
      if (this.xtr != null) {
        paramVarArgs.e(31, this.xtr);
      }
      if (this.xph != null) {
        paramVarArgs.e(32, this.xph);
      }
      paramVarArgs.aO(33, this.xpi);
      paramVarArgs.aO(34, this.gwW);
      paramVarArgs.aO(35, this.gwV);
      if (this.gwX != null) {
        paramVarArgs.e(36, this.gwX);
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(37, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(38, this.gwY);
      }
      if (this.wJq != null) {
        paramVarArgs.e(39, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(40, this.wJr);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(41, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(42, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      if (this.xts != null) {
        paramVarArgs.e(43, this.xts);
      }
      if (this.xtt != null) {
        paramVarArgs.e(44, this.xtt);
      }
      if (this.xtu != null) {
        paramVarArgs.e(45, this.xtu);
      }
      if (this.xtv != null) {
        paramVarArgs.e(46, this.xtv);
      }
      if (this.xtw != null) {
        paramVarArgs.e(47, this.xtw);
      }
      if (this.xtx != null) {
        paramVarArgs.e(48, this.xtx);
      }
      if (this.xty != null) {
        paramVarArgs.e(49, this.xty);
      }
      if (this.xtz != null)
      {
        paramVarArgs.iQ(50, this.xtz.computeSize());
        this.xtz.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(53, this.xtA);
      if (this.nuz != null) {
        paramVarArgs.e(54, this.nuz);
      }
      paramVarArgs.aO(55, this.xtB);
      paramVarArgs.aO(56, this.xtC);
      if (this.xaC != null)
      {
        paramVarArgs.iQ(57, this.xaC.computeSize());
        this.xaC.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(58, this.DeleteFlag);
      if (this.woO != null) {
        paramVarArgs.e(59, this.woO);
      }
      if (this.xtD != null) {
        paramVarArgs.e(60, this.xtD);
      }
      if (this.wOV != null) {
        paramVarArgs.e(61, this.wOV);
      }
      if (this.xtE != null)
      {
        paramVarArgs.iQ(62, this.xtE.computeSize());
        this.xtE.writeFields(paramVarArgs);
      }
      if (this.dqY != null) {
        paramVarArgs.e(63, this.dqY);
      }
      paramVarArgs.aO(64, this.xtF);
      paramVarArgs.aO(65, this.wOU);
      paramVarArgs.aO(66, this.xtG);
      paramVarArgs.aO(67, this.ExtFlag);
      if (this.xtH != null) {
        paramVarArgs.e(68, this.xtH);
      }
      AppMethodBeat.o(60047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label5470;
      }
    }
    label5470:
    for (int i = e.a.a.a.iP(1, this.wOT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xmi != null) {
        paramInt = i + e.a.a.a.iP(2, this.xmi.computeSize());
      }
      i = paramInt;
      if (this.wOv != null) {
        i = paramInt + e.a.a.a.iP(3, this.wOv.computeSize());
      }
      paramInt = i;
      if (this.wOw != null) {
        paramInt = i + e.a.a.a.iP(4, this.wOw.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.gwP);
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(6, this.woT.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wNK) + e.a.a.b.b.a.bl(8, this.wNL) + e.a.a.b.b.a.bl(9, this.xtk);
      paramInt = i;
      if (this.xsT != null) {
        paramInt = i + e.a.a.a.iP(10, this.xsT.computeSize());
      }
      i = paramInt;
      if (this.xsU != null) {
        i = paramInt + e.a.a.a.iP(11, this.xsU.computeSize());
      }
      paramInt = i;
      if (this.xsV != null) {
        paramInt = i + e.a.a.a.iP(12, this.xsV.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.wNQ) + e.a.a.b.b.a.bl(14, this.wNR) + e.a.a.a.c(15, 8, this.wNS);
      paramInt = i;
      if (this.xto != null) {
        paramInt = i + e.a.a.a.iP(16, this.xto.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.wNU) + e.a.a.b.b.a.bl(18, this.wNV);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(22, this.gwT) + e.a.a.b.b.a.bl(23, this.xtp) + e.a.a.b.b.a.bl(24, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.xpf);
      }
      i = paramInt + e.a.a.b.b.a.bl(26, this.xtq) + e.a.a.b.b.a.bl(27, this.niK);
      paramInt = i;
      if (this.xpg != null) {
        paramInt = i + e.a.a.b.b.a.f(28, this.xpg);
      }
      i = paramInt;
      if (this.xfJ != null) {
        i = paramInt + e.a.a.b.b.a.f(29, this.xfJ);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(30, this.gwU);
      }
      i = paramInt;
      if (this.xtr != null) {
        i = paramInt + e.a.a.b.b.a.f(31, this.xtr);
      }
      paramInt = i;
      if (this.xph != null) {
        paramInt = i + e.a.a.b.b.a.f(32, this.xph);
      }
      i = paramInt + e.a.a.b.b.a.bl(33, this.xpi) + e.a.a.b.b.a.bl(34, this.gwW) + e.a.a.b.b.a.bl(35, this.gwV);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(36, this.gwX);
      }
      i = paramInt;
      if (this.xpk != null) {
        i = paramInt + e.a.a.a.iP(37, this.xpk.computeSize());
      }
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(38, this.gwY);
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(39, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(40, this.wJr);
      }
      i = paramInt;
      if (this.gwZ != null) {
        i = paramInt + e.a.a.b.b.a.f(41, this.gwZ);
      }
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + e.a.a.a.iP(42, this.xpl.computeSize());
      }
      i = paramInt;
      if (this.xts != null) {
        i = paramInt + e.a.a.b.b.a.f(43, this.xts);
      }
      paramInt = i;
      if (this.xtt != null) {
        paramInt = i + e.a.a.b.b.a.f(44, this.xtt);
      }
      i = paramInt;
      if (this.xtu != null) {
        i = paramInt + e.a.a.b.b.a.f(45, this.xtu);
      }
      paramInt = i;
      if (this.xtv != null) {
        paramInt = i + e.a.a.b.b.a.f(46, this.xtv);
      }
      i = paramInt;
      if (this.xtw != null) {
        i = paramInt + e.a.a.b.b.a.f(47, this.xtw);
      }
      paramInt = i;
      if (this.xtx != null) {
        paramInt = i + e.a.a.b.b.a.f(48, this.xtx);
      }
      i = paramInt;
      if (this.xty != null) {
        i = paramInt + e.a.a.b.b.a.f(49, this.xty);
      }
      paramInt = i;
      if (this.xtz != null) {
        paramInt = i + e.a.a.a.iP(50, this.xtz.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(53, this.xtA);
      paramInt = i;
      if (this.nuz != null) {
        paramInt = i + e.a.a.b.b.a.f(54, this.nuz);
      }
      i = paramInt + e.a.a.b.b.a.bl(55, this.xtB) + e.a.a.b.b.a.bl(56, this.xtC);
      paramInt = i;
      if (this.xaC != null) {
        paramInt = i + e.a.a.a.iP(57, this.xaC.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(58, this.DeleteFlag);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(59, this.woO);
      }
      i = paramInt;
      if (this.xtD != null) {
        i = paramInt + e.a.a.b.b.a.f(60, this.xtD);
      }
      paramInt = i;
      if (this.wOV != null) {
        paramInt = i + e.a.a.b.b.a.f(61, this.wOV);
      }
      i = paramInt;
      if (this.xtE != null) {
        i = paramInt + e.a.a.a.iP(62, this.xtE.computeSize());
      }
      paramInt = i;
      if (this.dqY != null) {
        paramInt = i + e.a.a.b.b.a.f(63, this.dqY);
      }
      i = paramInt + e.a.a.b.b.a.bl(64, this.xtF) + e.a.a.b.b.a.bl(65, this.wOU) + e.a.a.b.b.a.bl(66, this.xtG) + e.a.a.b.b.a.bl(67, this.ExtFlag);
      paramInt = i;
      if (this.xtH != null) {
        paramInt = i + e.a.a.b.b.a.f(68, this.xtH);
      }
      AppMethodBeat.o(60047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wNS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(60047);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(60047);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(60047);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(60047);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(60047);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdt localbdt = (bdt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        default: 
          AppMethodBeat.o(60047);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 5: 
          localbdt.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 7: 
          localbdt.wNK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 8: 
          localbdt.wNL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 9: 
          localbdt.xtk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xsT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xsU = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xsV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 13: 
          localbdt.wNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 14: 
          localbdt.wNR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.wNS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xto = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 17: 
          localbdt.wNU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 18: 
          localbdt.wNV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 19: 
          localbdt.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 20: 
          localbdt.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 21: 
          localbdt.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 22: 
          localbdt.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 23: 
          localbdt.xtp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 24: 
          localbdt.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 25: 
          localbdt.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 26: 
          localbdt.xtq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 27: 
          localbdt.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 28: 
          localbdt.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 29: 
          localbdt.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 30: 
          localbdt.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 31: 
          localbdt.xtr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 32: 
          localbdt.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 33: 
          localbdt.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 34: 
          localbdt.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 35: 
          localbdt.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 36: 
          localbdt.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 37: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 38: 
          localbdt.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 39: 
          localbdt.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 40: 
          localbdt.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 41: 
          localbdt.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 42: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 43: 
          localbdt.xts = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 44: 
          localbdt.xtt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 45: 
          localbdt.xtu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 46: 
          localbdt.xtv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 47: 
          localbdt.xtw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 48: 
          localbdt.xtx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 49: 
          localbdt.xty = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 50: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xtz = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 53: 
          localbdt.xtA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 54: 
          localbdt.nuz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 55: 
          localbdt.xtB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 56: 
          localbdt.xtC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 57: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xaC = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 58: 
          localbdt.DeleteFlag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 59: 
          localbdt.woO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 60: 
          localbdt.xtD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 61: 
          localbdt.wOV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 62: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdt.xtE = ((bmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60047);
          return 0;
        case 63: 
          localbdt.dqY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60047);
          return 0;
        case 64: 
          localbdt.xtF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 65: 
          localbdt.wOU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 66: 
          localbdt.xtG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        case 67: 
          localbdt.ExtFlag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60047);
          return 0;
        }
        localbdt.xtH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60047);
        return 0;
      }
      AppMethodBeat.o(60047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdt
 * JD-Core Version:    0.7.0.1
 */