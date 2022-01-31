package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ari
  extends bvk
{
  public String lHn;
  public String lHp;
  public boolean lHy;
  public int lNX;
  public String source;
  public LinkedList<adu> woL;
  public LinkedList<cgp> wpw;
  public LinkedList<dcd> xgA;
  public LinkedList<dcc> xgB;
  public LinkedList<String> xgC;
  public String xgD;
  public String xgE;
  public LinkedList<nl> xgF;
  public boolean xgG;
  public String xgy;
  public dcb xgz;
  
  public ari()
  {
    AppMethodBeat.i(28479);
    this.xgA = new LinkedList();
    this.xgB = new LinkedList();
    this.xgC = new LinkedList();
    this.wpw = new LinkedList();
    this.woL = new LinkedList();
    this.xgF = new LinkedList();
    AppMethodBeat.o(28479);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28480);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28480);
        throw paramVarArgs;
      }
      if (this.xgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(28480);
        throw paramVarArgs;
      }
      if (this.lHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(28480);
        throw paramVarArgs;
      }
      if (this.xgz == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(28480);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xgy != null) {
        paramVarArgs.e(2, this.xgy);
      }
      if (this.lHp != null) {
        paramVarArgs.e(3, this.lHp);
      }
      if (this.xgz != null)
      {
        paramVarArgs.iQ(4, this.xgz.computeSize());
        this.xgz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xgA);
      paramVarArgs.e(6, 8, this.xgB);
      if (this.source != null) {
        paramVarArgs.e(7, this.source);
      }
      paramVarArgs.e(8, 1, this.xgC);
      if (this.xgD != null) {
        paramVarArgs.e(9, this.xgD);
      }
      if (this.xgE != null) {
        paramVarArgs.e(10, this.xgE);
      }
      paramVarArgs.e(14, 8, this.wpw);
      paramVarArgs.e(15, 8, this.woL);
      paramVarArgs.aS(16, this.lHy);
      paramVarArgs.e(17, 8, this.xgF);
      paramVarArgs.aS(18, this.xgG);
      paramVarArgs.aO(19, this.lNX);
      if (this.lHn != null) {
        paramVarArgs.e(20, this.lHn);
      }
      AppMethodBeat.o(28480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1953;
      }
    }
    label1953:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xgy != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xgy);
      }
      i = paramInt;
      if (this.lHp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.lHp);
      }
      paramInt = i;
      if (this.xgz != null) {
        paramInt = i + e.a.a.a.iP(4, this.xgz.computeSize());
      }
      i = paramInt + e.a.a.a.c(5, 8, this.xgA) + e.a.a.a.c(6, 8, this.xgB);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.source);
      }
      i = paramInt + e.a.a.a.c(8, 1, this.xgC);
      paramInt = i;
      if (this.xgD != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xgD);
      }
      i = paramInt;
      if (this.xgE != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xgE);
      }
      i = i + e.a.a.a.c(14, 8, this.wpw) + e.a.a.a.c(15, 8, this.woL) + (e.a.a.b.b.a.eW(16) + 1) + e.a.a.a.c(17, 8, this.xgF) + (e.a.a.b.b.a.eW(18) + 1) + e.a.a.b.b.a.bl(19, this.lNX);
      paramInt = i;
      if (this.lHn != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.lHn);
      }
      AppMethodBeat.o(28480);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xgA.clear();
        this.xgB.clear();
        this.xgC.clear();
        this.wpw.clear();
        this.woL.clear();
        this.xgF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28480);
          throw paramVarArgs;
        }
        if (this.xgy == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(28480);
          throw paramVarArgs;
        }
        if (this.lHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(28480);
          throw paramVarArgs;
        }
        if (this.xgz == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(28480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ari localari = (ari)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(28480);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 2: 
          localari.xgy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28480);
          return 0;
        case 3: 
          localari.lHp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28480);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.xgz = ((dcb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.xgA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.xgB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 7: 
          localari.source = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28480);
          return 0;
        case 8: 
          localari.xgC.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(28480);
          return 0;
        case 9: 
          localari.xgD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28480);
          return 0;
        case 10: 
          localari.xgE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28480);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.wpw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.woL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 16: 
          localari.lHy = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28480);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localari.xgF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28480);
          return 0;
        case 18: 
          localari.xgG = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28480);
          return 0;
        case 19: 
          localari.lNX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28480);
          return 0;
        }
        localari.lHn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28480);
        return 0;
      }
      AppMethodBeat.o(28480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ari
 * JD-Core Version:    0.7.0.1
 */