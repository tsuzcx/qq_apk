package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class js
  extends buy
{
  public String jJA;
  public String lGH;
  public String wrW;
  public int wsW;
  public String wsp;
  public SKBuiltinBuffer_t wss;
  public String wvG;
  public String wvH;
  public int wvI;
  public String wvJ;
  public int wvK;
  public String wvL;
  public String wvM;
  public SKBuiltinBuffer_t wvN;
  public int wvO;
  public int wvP;
  public int wvQ;
  public String wvR;
  public SKBuiltinBuffer_t wvS;
  public String wvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123506);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.wvG != null) {
        paramVarArgs.e(3, this.wvG);
      }
      paramVarArgs.aO(4, this.wsW);
      if (this.wvH != null) {
        paramVarArgs.e(5, this.wvH);
      }
      paramVarArgs.aO(6, this.wvI);
      if (this.wvJ != null) {
        paramVarArgs.e(7, this.wvJ);
      }
      if (this.wrW != null) {
        paramVarArgs.e(8, this.wrW);
      }
      paramVarArgs.aO(9, this.wvK);
      if (this.wvL != null) {
        paramVarArgs.e(10, this.wvL);
      }
      if (this.wvM != null) {
        paramVarArgs.e(11, this.wvM);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(12, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.lGH != null) {
        paramVarArgs.e(13, this.lGH);
      }
      paramVarArgs.aO(14, this.wvO);
      paramVarArgs.aO(15, this.wvP);
      if (this.wsp != null) {
        paramVarArgs.e(16, this.wsp);
      }
      paramVarArgs.aO(17, this.wvQ);
      if (this.wvR != null) {
        paramVarArgs.e(18, this.wvR);
      }
      if (this.wvS != null)
      {
        paramVarArgs.iQ(19, this.wvS.computeSize());
        this.wvS.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(20, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      if (this.wvT != null) {
        paramVarArgs.e(21, this.wvT);
      }
      AppMethodBeat.o(123506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1726;
      }
    }
    label1726:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.wvG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvG);
      }
      i += e.a.a.b.b.a.bl(4, this.wsW);
      paramInt = i;
      if (this.wvH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wvH);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wvI);
      paramInt = i;
      if (this.wvJ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wvJ);
      }
      i = paramInt;
      if (this.wrW != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wrW);
      }
      i += e.a.a.b.b.a.bl(9, this.wvK);
      paramInt = i;
      if (this.wvL != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wvL);
      }
      i = paramInt;
      if (this.wvM != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wvM);
      }
      paramInt = i;
      if (this.wvN != null) {
        paramInt = i + e.a.a.a.iP(12, this.wvN.computeSize());
      }
      i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.lGH);
      }
      i = i + e.a.a.b.b.a.bl(14, this.wvO) + e.a.a.b.b.a.bl(15, this.wvP);
      paramInt = i;
      if (this.wsp != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wsp);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.wvQ);
      paramInt = i;
      if (this.wvR != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.wvR);
      }
      i = paramInt;
      if (this.wvS != null) {
        i = paramInt + e.a.a.a.iP(19, this.wvS.computeSize());
      }
      paramInt = i;
      if (this.wss != null) {
        paramInt = i + e.a.a.a.iP(20, this.wss.computeSize());
      }
      i = paramInt;
      if (this.wvT != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.wvT);
      }
      AppMethodBeat.o(123506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(123506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        js localjs = (js)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123506);
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
            localjs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123506);
          return 0;
        case 2: 
          localjs.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 3: 
          localjs.wvG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 4: 
          localjs.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 5: 
          localjs.wvH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 6: 
          localjs.wvI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 7: 
          localjs.wvJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 8: 
          localjs.wrW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 9: 
          localjs.wvK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 10: 
          localjs.wvL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 11: 
          localjs.wvM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjs.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123506);
          return 0;
        case 13: 
          localjs.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 14: 
          localjs.wvO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 15: 
          localjs.wvP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 16: 
          localjs.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 17: 
          localjs.wvQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123506);
          return 0;
        case 18: 
          localjs.wvR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123506);
          return 0;
        case 19: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjs.wvS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123506);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjs.wss = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123506);
          return 0;
        }
        localjs.wvT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(123506);
        return 0;
      }
      AppMethodBeat.o(123506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.js
 * JD-Core Version:    0.7.0.1
 */