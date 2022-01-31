package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cym
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String lGH;
  public cjh uIN;
  public long wBW;
  public String wBZ;
  public String wXt;
  public int wzS;
  public int xHM;
  public int xHQ;
  public LinkedList<cpj> xKn;
  public int xpF;
  public int xpG;
  public String xpJ;
  public com.tencent.mm.bv.b xpK;
  public com.tencent.mm.bv.b xpL;
  public azu xqU;
  public LinkedList<up> yel;
  public LinkedList<String> yfA;
  public LinkedList<bgl> yfB;
  public cdv yfC;
  public wf yfD;
  public bmt yfE;
  public String yfx;
  public String yfy;
  public int yfz;
  
  public cym()
  {
    AppMethodBeat.i(124386);
    this.xKn = new LinkedList();
    this.yfA = new LinkedList();
    this.xpG = 2;
    this.yel = new LinkedList();
    this.yfB = new LinkedList();
    AppMethodBeat.o(124386);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124387);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wXt == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(124387);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xHM);
      if (this.wXt != null) {
        paramVarArgs.e(2, this.wXt);
      }
      paramVarArgs.aO(3, this.wzS);
      paramVarArgs.am(4, this.wBW);
      paramVarArgs.aO(5, this.xpF);
      if (this.xqU != null)
      {
        paramVarArgs.iQ(6, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.xKn);
      paramVarArgs.aO(8, this.Scene);
      if (this.wBZ != null) {
        paramVarArgs.e(9, this.wBZ);
      }
      paramVarArgs.aO(10, this.xHQ);
      if (this.yfx != null) {
        paramVarArgs.e(11, this.yfx);
      }
      if (this.yfy != null) {
        paramVarArgs.e(12, this.yfy);
      }
      paramVarArgs.aO(13, this.yfz);
      paramVarArgs.e(14, 1, this.yfA);
      paramVarArgs.aO(15, this.xpG);
      if (this.uIN != null)
      {
        paramVarArgs.iQ(16, this.uIN.computeSize());
        this.uIN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.yel);
      paramVarArgs.e(18, 8, this.yfB);
      if (this.lGH != null) {
        paramVarArgs.e(19, this.lGH);
      }
      if (this.xpL != null) {
        paramVarArgs.c(20, this.xpL);
      }
      if (this.xpJ != null) {
        paramVarArgs.e(21, this.xpJ);
      }
      if (this.xpK != null) {
        paramVarArgs.c(22, this.xpK);
      }
      if (this.yfC != null)
      {
        paramVarArgs.iQ(23, this.yfC.computeSize());
        this.yfC.writeFields(paramVarArgs);
      }
      if (this.yfD != null)
      {
        paramVarArgs.iQ(24, this.yfD.computeSize());
        this.yfD.writeFields(paramVarArgs);
      }
      if (this.yfE != null)
      {
        paramVarArgs.iQ(25, this.yfE.computeSize());
        this.yfE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124387);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xHM) + 0;
      paramInt = i;
      if (this.wXt != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wXt);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wzS) + e.a.a.b.b.a.p(4, this.wBW) + e.a.a.b.b.a.bl(5, this.xpF);
      paramInt = i;
      if (this.xqU != null) {
        paramInt = i + e.a.a.a.iP(6, this.xqU.computeSize());
      }
      i = paramInt + e.a.a.a.c(7, 8, this.xKn) + e.a.a.b.b.a.bl(8, this.Scene);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wBZ);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.xHQ);
      paramInt = i;
      if (this.yfx != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.yfx);
      }
      i = paramInt;
      if (this.yfy != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.yfy);
      }
      i = i + e.a.a.b.b.a.bl(13, this.yfz) + e.a.a.a.c(14, 1, this.yfA) + e.a.a.b.b.a.bl(15, this.xpG);
      paramInt = i;
      if (this.uIN != null) {
        paramInt = i + e.a.a.a.iP(16, this.uIN.computeSize());
      }
      i = paramInt + e.a.a.a.c(17, 8, this.yel) + e.a.a.a.c(18, 8, this.yfB);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.lGH);
      }
      i = paramInt;
      if (this.xpL != null) {
        i = paramInt + e.a.a.b.b.a.b(20, this.xpL);
      }
      paramInt = i;
      if (this.xpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.xpJ);
      }
      i = paramInt;
      if (this.xpK != null) {
        i = paramInt + e.a.a.b.b.a.b(22, this.xpK);
      }
      paramInt = i;
      if (this.yfC != null) {
        paramInt = i + e.a.a.a.iP(23, this.yfC.computeSize());
      }
      i = paramInt;
      if (this.yfD != null) {
        i = paramInt + e.a.a.a.iP(24, this.yfD.computeSize());
      }
      paramInt = i;
      if (this.yfE != null) {
        paramInt = i + e.a.a.a.iP(25, this.yfE.computeSize());
      }
      AppMethodBeat.o(124387);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xKn.clear();
      this.yfA.clear();
      this.yel.clear();
      this.yfB.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wXt == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(124387);
        throw paramVarArgs;
      }
      AppMethodBeat.o(124387);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cym localcym = (cym)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124387);
        return -1;
      case 1: 
        localcym.xHM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 2: 
        localcym.wXt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 3: 
        localcym.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 4: 
        localcym.wBW = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124387);
        return 0;
      case 5: 
        localcym.xpF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.xKn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 8: 
        localcym.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 9: 
        localcym.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 10: 
        localcym.xHQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 11: 
        localcym.yfx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 12: 
        localcym.yfy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 13: 
        localcym.yfz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 14: 
        localcym.yfA.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(124387);
        return 0;
      case 15: 
        localcym.xpG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124387);
        return 0;
      case 16: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.uIN = ((cjh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 17: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new up();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((up)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.yel.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 18: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.yfB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 19: 
        localcym.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 20: 
        localcym.xpL = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(124387);
        return 0;
      case 21: 
        localcym.xpJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124387);
        return 0;
      case 22: 
        localcym.xpK = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(124387);
        return 0;
      case 23: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.yfC = ((cdv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      case 24: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcym.yfD = ((wf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124387);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmt();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bmt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcym.yfE = ((bmt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124387);
      return 0;
    }
    AppMethodBeat.o(124387);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */