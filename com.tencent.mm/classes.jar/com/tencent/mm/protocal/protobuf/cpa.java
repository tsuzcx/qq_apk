package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpa
  extends buy
{
  public int fKi;
  public String nul;
  public String num;
  public SKBuiltinBuffer_t pIA;
  public int pIE;
  public long pIG;
  public int wAr;
  public int wPU;
  public int wQz;
  public String woU;
  public String wpS;
  public int wyT;
  public int wzS;
  public int xXO;
  public int xXP;
  public int xrK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116811);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116811);
        throw paramVarArgs;
      }
      if (this.num != null) {
        paramVarArgs.e(1, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(2, this.nul);
      }
      paramVarArgs.aO(3, this.wzS);
      paramVarArgs.aO(4, this.wyT);
      if (this.wpS != null) {
        paramVarArgs.e(5, this.wpS);
      }
      paramVarArgs.aO(6, this.pIE);
      paramVarArgs.aO(7, this.wAr);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(8, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.fKi);
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.wPU);
      if (this.woU != null) {
        paramVarArgs.e(12, this.woU);
      }
      paramVarArgs.aO(13, this.xrK);
      paramVarArgs.aO(14, this.xXO);
      paramVarArgs.aO(15, this.xXP);
      paramVarArgs.am(16, this.pIG);
      paramVarArgs.aO(17, this.wQz);
      AppMethodBeat.o(116811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.num == null) {
        break label1266;
      }
    }
    label1266:
    for (paramInt = e.a.a.b.b.a.f(1, this.num) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nul);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wzS) + e.a.a.b.b.a.bl(4, this.wyT);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wpS);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.pIE) + e.a.a.b.b.a.bl(7, this.wAr);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(8, this.pIA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.fKi);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + e.a.a.a.iP(10, this.BaseRequest.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.wPU);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.woU);
      }
      i = e.a.a.b.b.a.bl(13, this.xrK);
      int j = e.a.a.b.b.a.bl(14, this.xXO);
      int k = e.a.a.b.b.a.bl(15, this.xXP);
      int m = e.a.a.b.b.a.p(16, this.pIG);
      int n = e.a.a.b.b.a.bl(17, this.wQz);
      AppMethodBeat.o(116811);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(116811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116811);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpa localcpa = (cpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116811);
          return -1;
        case 1: 
          localcpa.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116811);
          return 0;
        case 2: 
          localcpa.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116811);
          return 0;
        case 3: 
          localcpa.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 4: 
          localcpa.wyT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 5: 
          localcpa.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116811);
          return 0;
        case 6: 
          localcpa.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 7: 
          localcpa.wAr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpa.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116811);
          return 0;
        case 9: 
          localcpa.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116811);
          return 0;
        case 11: 
          localcpa.wPU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 12: 
          localcpa.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116811);
          return 0;
        case 13: 
          localcpa.xrK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 14: 
          localcpa.xXO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 15: 
          localcpa.xXP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116811);
          return 0;
        case 16: 
          localcpa.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(116811);
          return 0;
        }
        localcpa.wQz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116811);
        return 0;
      }
      AppMethodBeat.o(116811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpa
 * JD-Core Version:    0.7.0.1
 */