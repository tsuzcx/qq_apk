package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bct
  extends com.tencent.mm.bv.a
{
  public LinkedList<bwc> GroupUser;
  public String cGT;
  public int cMQ;
  public String cpW;
  public int ePG;
  public String pIw;
  public String token;
  public String wQf;
  public int xrU;
  public cen xsA;
  public LinkedList<cet> xsB;
  public String xsC;
  public long xsD;
  public String xsE;
  public boolean xsF;
  public cdo xsG;
  public int xso;
  public int xsp;
  public LinkedList<bam> xsq;
  public LinkedList<cfm> xsr;
  public int xss;
  public long xst;
  public int xsu;
  public LinkedList<Long> xsv;
  public int xsw;
  public int xsx;
  public String xsy;
  public int xsz;
  
  public bct()
  {
    AppMethodBeat.i(94540);
    this.xsq = new LinkedList();
    this.xsr = new LinkedList();
    this.xsv = new LinkedList();
    this.GroupUser = new LinkedList();
    this.xsB = new LinkedList();
    AppMethodBeat.o(94540);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94541);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xso);
      paramVarArgs.aO(2, this.xsp);
      paramVarArgs.aO(3, this.xrU);
      if (this.pIw != null) {
        paramVarArgs.e(4, this.pIw);
      }
      paramVarArgs.e(5, 8, this.xsq);
      paramVarArgs.e(6, 8, this.xsr);
      paramVarArgs.aO(7, this.xss);
      paramVarArgs.aO(8, this.ePG);
      paramVarArgs.am(9, this.xst);
      paramVarArgs.aO(10, this.xsu);
      paramVarArgs.e(11, 3, this.xsv);
      paramVarArgs.aO(12, this.xsw);
      paramVarArgs.aO(13, this.xsx);
      if (this.token != null) {
        paramVarArgs.e(14, this.token);
      }
      if (this.xsy != null) {
        paramVarArgs.e(15, this.xsy);
      }
      paramVarArgs.aO(16, this.xsz);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.xsA != null)
      {
        paramVarArgs.iQ(18, this.xsA.computeSize());
        this.xsA.writeFields(paramVarArgs);
      }
      if (this.cGT != null) {
        paramVarArgs.e(19, this.cGT);
      }
      paramVarArgs.e(20, 8, this.xsB);
      if (this.cpW != null) {
        paramVarArgs.e(21, this.cpW);
      }
      if (this.xsC != null) {
        paramVarArgs.e(22, this.xsC);
      }
      if (this.wQf != null) {
        paramVarArgs.e(23, this.wQf);
      }
      paramVarArgs.aO(24, this.cMQ);
      paramVarArgs.am(25, this.xsD);
      if (this.xsE != null) {
        paramVarArgs.e(26, this.xsE);
      }
      paramVarArgs.aS(27, this.xsF);
      if (this.xsG != null)
      {
        paramVarArgs.iQ(28, this.xsG.computeSize());
        this.xsG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94541);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xso) + 0 + e.a.a.b.b.a.bl(2, this.xsp) + e.a.a.b.b.a.bl(3, this.xrU);
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pIw);
      }
      i = paramInt + e.a.a.a.c(5, 8, this.xsq) + e.a.a.a.c(6, 8, this.xsr) + e.a.a.b.b.a.bl(7, this.xss) + e.a.a.b.b.a.bl(8, this.ePG) + e.a.a.b.b.a.p(9, this.xst) + e.a.a.b.b.a.bl(10, this.xsu) + e.a.a.a.c(11, 3, this.xsv) + e.a.a.b.b.a.bl(12, this.xsw) + e.a.a.b.b.a.bl(13, this.xsx);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.token);
      }
      i = paramInt;
      if (this.xsy != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xsy);
      }
      i = i + e.a.a.b.b.a.bl(16, this.xsz) + e.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.xsA != null) {
        paramInt = i + e.a.a.a.iP(18, this.xsA.computeSize());
      }
      i = paramInt;
      if (this.cGT != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.cGT);
      }
      i += e.a.a.a.c(20, 8, this.xsB);
      paramInt = i;
      if (this.cpW != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.cpW);
      }
      i = paramInt;
      if (this.xsC != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.xsC);
      }
      paramInt = i;
      if (this.wQf != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.wQf);
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.cMQ) + e.a.a.b.b.a.p(25, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.xsE);
      }
      i = paramInt + (e.a.a.b.b.a.eW(27) + 1);
      paramInt = i;
      if (this.xsG != null) {
        paramInt = i + e.a.a.a.iP(28, this.xsG.computeSize());
      }
      AppMethodBeat.o(94541);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xsq.clear();
      this.xsr.clear();
      this.xsv.clear();
      this.GroupUser.clear();
      this.xsB.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94541);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bct localbct = (bct)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94541);
        return -1;
      case 1: 
        localbct.xso = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 2: 
        localbct.xsp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 3: 
        localbct.xrU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 4: 
        localbct.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bam();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bam)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbct.xsq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94541);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbct.xsr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94541);
        return 0;
      case 7: 
        localbct.xss = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 8: 
        localbct.ePG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 9: 
        localbct.xst = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94541);
        return 0;
      case 10: 
        localbct.xsu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 11: 
        localbct.xsv.add(Long.valueOf(((e.a.a.a.a)localObject1).CLY.sm()));
        AppMethodBeat.o(94541);
        return 0;
      case 12: 
        localbct.xsw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 13: 
        localbct.xsx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 14: 
        localbct.token = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 15: 
        localbct.xsy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 16: 
        localbct.xsz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 17: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbct.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94541);
        return 0;
      case 18: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cen();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cen)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbct.xsA = ((cen)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94541);
        return 0;
      case 19: 
        localbct.cGT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 20: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cet();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cet)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbct.xsB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94541);
        return 0;
      case 21: 
        localbct.cpW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 22: 
        localbct.xsC = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 23: 
        localbct.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 24: 
        localbct.cMQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94541);
        return 0;
      case 25: 
        localbct.xsD = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94541);
        return 0;
      case 26: 
        localbct.xsE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94541);
        return 0;
      case 27: 
        localbct.xsF = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(94541);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdo();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cdo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbct.xsG = ((cdo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94541);
      return 0;
    }
    AppMethodBeat.o(94541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bct
 * JD-Core Version:    0.7.0.1
 */