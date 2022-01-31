package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lq
  extends buy
{
  public int count;
  public int pmi;
  public int qst;
  public String qtW;
  public String qtX;
  public int type;
  public String value;
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public String wAf;
  public String wAg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11727);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wAb != null) {
        paramVarArgs.e(2, this.wAb);
      }
      if (this.wAc != null) {
        paramVarArgs.e(3, this.wAc);
      }
      if (this.wAd != null) {
        paramVarArgs.e(4, this.wAd);
      }
      if (this.wAe != null) {
        paramVarArgs.e(5, this.wAe);
      }
      if (this.wAf != null) {
        paramVarArgs.e(6, this.wAf);
      }
      paramVarArgs.aO(7, this.qst);
      if (this.wAg != null) {
        paramVarArgs.e(8, this.wAg);
      }
      if (this.qtX != null) {
        paramVarArgs.e(9, this.qtX);
      }
      if (this.qtW != null) {
        paramVarArgs.e(10, this.qtW);
      }
      paramVarArgs.aO(11, this.type);
      if (this.value != null) {
        paramVarArgs.e(12, this.value);
      }
      paramVarArgs.aO(13, this.count);
      paramVarArgs.aO(14, this.pmi);
      AppMethodBeat.o(11727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wAb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAb);
      }
      i = paramInt;
      if (this.wAc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wAc);
      }
      paramInt = i;
      if (this.wAd != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wAd);
      }
      i = paramInt;
      if (this.wAe != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wAe);
      }
      paramInt = i;
      if (this.wAf != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wAf);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.qst);
      paramInt = i;
      if (this.wAg != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wAg);
      }
      i = paramInt;
      if (this.qtX != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.qtX);
      }
      paramInt = i;
      if (this.qtW != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.qtW);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.value);
      }
      i = e.a.a.b.b.a.bl(13, this.count);
      int j = e.a.a.b.b.a.bl(14, this.pmi);
      AppMethodBeat.o(11727);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        lq locallq = (lq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11727);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11727);
          return 0;
        case 2: 
          locallq.wAb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 3: 
          locallq.wAc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 4: 
          locallq.wAd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 5: 
          locallq.wAe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 6: 
          locallq.wAf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 7: 
          locallq.qst = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11727);
          return 0;
        case 8: 
          locallq.wAg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 9: 
          locallq.qtX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 10: 
          locallq.qtW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 11: 
          locallq.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11727);
          return 0;
        case 12: 
          locallq.value = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11727);
          return 0;
        case 13: 
          locallq.count = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11727);
          return 0;
        }
        locallq.pmi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(11727);
        return 0;
      }
      AppMethodBeat.o(11727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lq
 * JD-Core Version:    0.7.0.1
 */