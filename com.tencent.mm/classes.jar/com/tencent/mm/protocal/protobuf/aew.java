package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aew
  extends buy
{
  public int qst;
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public String wAf;
  public String wAg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59602);
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
      AppMethodBeat.o(59602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
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
      AppMethodBeat.o(59602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(59602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aew localaew = (aew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(59602);
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
            localaew.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(59602);
          return 0;
        case 2: 
          localaew.wAb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59602);
          return 0;
        case 3: 
          localaew.wAc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59602);
          return 0;
        case 4: 
          localaew.wAd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59602);
          return 0;
        case 5: 
          localaew.wAe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59602);
          return 0;
        case 6: 
          localaew.wAf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59602);
          return 0;
        case 7: 
          localaew.qst = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(59602);
          return 0;
        }
        localaew.wAg = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(59602);
        return 0;
      }
      AppMethodBeat.o(59602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aew
 * JD-Core Version:    0.7.0.1
 */