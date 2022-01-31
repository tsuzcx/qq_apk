package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnx
  extends buy
{
  public String bYu;
  public int brG;
  public String cqJ;
  public String fhP;
  public String xKa;
  public int xWE;
  public int xWF;
  public String xWG;
  public int xWH;
  public String xWI;
  public LinkedList<cga> xWJ;
  public int xWK;
  public int xWL;
  
  public cnx()
  {
    AppMethodBeat.i(55725);
    this.xWJ = new LinkedList();
    AppMethodBeat.o(55725);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55726);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.bYu != null) {
        paramVarArgs.e(2, this.bYu);
      }
      if (this.cqJ != null) {
        paramVarArgs.e(3, this.cqJ);
      }
      paramVarArgs.aO(4, this.xWE);
      paramVarArgs.aO(5, this.xWF);
      paramVarArgs.aO(6, this.brG);
      if (this.xWG != null) {
        paramVarArgs.e(7, this.xWG);
      }
      if (this.xKa != null) {
        paramVarArgs.e(8, this.xKa);
      }
      if (this.fhP != null) {
        paramVarArgs.e(9, this.fhP);
      }
      paramVarArgs.aO(10, this.xWH);
      if (this.xWI != null) {
        paramVarArgs.e(11, this.xWI);
      }
      paramVarArgs.e(12, 8, this.xWJ);
      paramVarArgs.aO(13, this.xWK);
      paramVarArgs.aO(14, this.xWL);
      AppMethodBeat.o(55726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bYu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.bYu);
      }
      i = paramInt;
      if (this.cqJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cqJ);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xWE) + e.a.a.b.b.a.bl(5, this.xWF) + e.a.a.b.b.a.bl(6, this.brG);
      paramInt = i;
      if (this.xWG != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xWG);
      }
      i = paramInt;
      if (this.xKa != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xKa);
      }
      paramInt = i;
      if (this.fhP != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.fhP);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.xWH);
      paramInt = i;
      if (this.xWI != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xWI);
      }
      i = e.a.a.a.c(12, 8, this.xWJ);
      int j = e.a.a.b.b.a.bl(13, this.xWK);
      int k = e.a.a.b.b.a.bl(14, this.xWL);
      AppMethodBeat.o(55726);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xWJ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnx localcnx = (cnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55726);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcnx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55726);
          return 0;
        case 2: 
          localcnx.bYu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 3: 
          localcnx.cqJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 4: 
          localcnx.xWE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55726);
          return 0;
        case 5: 
          localcnx.xWF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55726);
          return 0;
        case 6: 
          localcnx.brG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55726);
          return 0;
        case 7: 
          localcnx.xWG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 8: 
          localcnx.xKa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 9: 
          localcnx.fhP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 10: 
          localcnx.xWH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55726);
          return 0;
        case 11: 
          localcnx.xWI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55726);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cga();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cga)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcnx.xWJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55726);
          return 0;
        case 13: 
          localcnx.xWK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55726);
          return 0;
        }
        localcnx.xWL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(55726);
        return 0;
      }
      AppMethodBeat.o(55726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnx
 * JD-Core Version:    0.7.0.1
 */