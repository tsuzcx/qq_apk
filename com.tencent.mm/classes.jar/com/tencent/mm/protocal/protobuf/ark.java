package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ark
  extends bvk
{
  public String fhi;
  public boolean lHL;
  public LinkedList<adu> woL;
  public LinkedList<String> xgC;
  public String xgD;
  public String xgE;
  public boolean xgG;
  public LinkedList<dbz> xgJ;
  public LinkedList<dca> xgK;
  public String xgL;
  public String xgM;
  public String xgN;
  public String xgO;
  public boolean xgP;
  public int xgQ;
  public String xgR;
  
  public ark()
  {
    AppMethodBeat.i(28482);
    this.xgJ = new LinkedList();
    this.xgK = new LinkedList();
    this.xgC = new LinkedList();
    this.woL = new LinkedList();
    AppMethodBeat.o(28482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28483);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28483);
        throw paramVarArgs;
      }
      if (this.xgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(28483);
        throw paramVarArgs;
      }
      if (this.xgM == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(28483);
        throw paramVarArgs;
      }
      if (this.fhi == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(28483);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xgJ);
      paramVarArgs.e(3, 8, this.xgK);
      paramVarArgs.e(4, 1, this.xgC);
      if (this.xgL != null) {
        paramVarArgs.e(5, this.xgL);
      }
      if (this.xgM != null) {
        paramVarArgs.e(6, this.xgM);
      }
      if (this.fhi != null) {
        paramVarArgs.e(7, this.fhi);
      }
      if (this.xgN != null) {
        paramVarArgs.e(8, this.xgN);
      }
      if (this.xgD != null) {
        paramVarArgs.e(9, this.xgD);
      }
      paramVarArgs.aS(10, this.lHL);
      if (this.xgE != null) {
        paramVarArgs.e(11, this.xgE);
      }
      paramVarArgs.e(12, 8, this.woL);
      paramVarArgs.aS(13, this.xgG);
      if (this.xgO != null) {
        paramVarArgs.e(14, this.xgO);
      }
      paramVarArgs.aS(15, this.xgP);
      paramVarArgs.aO(16, this.xgQ);
      if (this.xgR != null) {
        paramVarArgs.e(17, this.xgR);
      }
      AppMethodBeat.o(28483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1677;
      }
    }
    label1677:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xgJ) + e.a.a.a.c(3, 8, this.xgK) + e.a.a.a.c(4, 1, this.xgC);
      paramInt = i;
      if (this.xgL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xgL);
      }
      i = paramInt;
      if (this.xgM != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xgM);
      }
      paramInt = i;
      if (this.fhi != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fhi);
      }
      i = paramInt;
      if (this.xgN != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xgN);
      }
      paramInt = i;
      if (this.xgD != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xgD);
      }
      i = paramInt + (e.a.a.b.b.a.eW(10) + 1);
      paramInt = i;
      if (this.xgE != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xgE);
      }
      i = paramInt + e.a.a.a.c(12, 8, this.woL) + (e.a.a.b.b.a.eW(13) + 1);
      paramInt = i;
      if (this.xgO != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xgO);
      }
      i = paramInt + (e.a.a.b.b.a.eW(15) + 1) + e.a.a.b.b.a.bl(16, this.xgQ);
      paramInt = i;
      if (this.xgR != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xgR);
      }
      AppMethodBeat.o(28483);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xgJ.clear();
        this.xgK.clear();
        this.xgC.clear();
        this.woL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28483);
          throw paramVarArgs;
        }
        if (this.xgL == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(28483);
          throw paramVarArgs;
        }
        if (this.xgM == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(28483);
          throw paramVarArgs;
        }
        if (this.fhi == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(28483);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ark localark = (ark)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28483);
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
            localark.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28483);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localark.xgJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28483);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dca();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localark.xgK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28483);
          return 0;
        case 4: 
          localark.xgC.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(28483);
          return 0;
        case 5: 
          localark.xgL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 6: 
          localark.xgM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 7: 
          localark.fhi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 8: 
          localark.xgN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 9: 
          localark.xgD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 10: 
          localark.lHL = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28483);
          return 0;
        case 11: 
          localark.xgE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localark.woL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28483);
          return 0;
        case 13: 
          localark.xgG = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28483);
          return 0;
        case 14: 
          localark.xgO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28483);
          return 0;
        case 15: 
          localark.xgP = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(28483);
          return 0;
        case 16: 
          localark.xgQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28483);
          return 0;
        }
        localark.xgR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28483);
        return 0;
      }
      AppMethodBeat.o(28483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ark
 * JD-Core Version:    0.7.0.1
 */