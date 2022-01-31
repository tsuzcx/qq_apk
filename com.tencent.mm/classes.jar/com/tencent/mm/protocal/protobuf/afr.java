package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class afr
  extends buy
{
  public int count;
  public String cwc;
  public String desc;
  public int scene;
  public String sign;
  public int wYN;
  public int wYO;
  public String wYP;
  public String wYQ;
  public String wYR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48843);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(48843);
        throw paramVarArgs;
      }
      if (this.wYQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(48843);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wYN);
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      paramVarArgs.aO(5, this.wYO);
      if (this.wYP != null) {
        paramVarArgs.e(6, this.wYP);
      }
      paramVarArgs.aO(7, this.count);
      paramVarArgs.aO(8, this.scene);
      if (this.wYQ != null) {
        paramVarArgs.e(9, this.wYQ);
      }
      if (this.sign != null) {
        paramVarArgs.e(10, this.sign);
      }
      if (this.wYR != null) {
        paramVarArgs.e(11, this.wYR);
      }
      AppMethodBeat.o(48843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wYN);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cwc);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.desc);
      }
      i += e.a.a.b.b.a.bl(5, this.wYO);
      paramInt = i;
      if (this.wYP != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wYP);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.count) + e.a.a.b.b.a.bl(8, this.scene);
      paramInt = i;
      if (this.wYQ != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wYQ);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.sign);
      }
      paramInt = i;
      if (this.wYR != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wYR);
      }
      AppMethodBeat.o(48843);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.cwc == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(48843);
          throw paramVarArgs;
        }
        if (this.wYQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(48843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        afr localafr = (afr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48843);
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
            localafr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48843);
          return 0;
        case 2: 
          localafr.wYN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48843);
          return 0;
        case 3: 
          localafr.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48843);
          return 0;
        case 4: 
          localafr.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48843);
          return 0;
        case 5: 
          localafr.wYO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48843);
          return 0;
        case 6: 
          localafr.wYP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48843);
          return 0;
        case 7: 
          localafr.count = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48843);
          return 0;
        case 8: 
          localafr.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48843);
          return 0;
        case 9: 
          localafr.wYQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48843);
          return 0;
        case 10: 
          localafr.sign = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48843);
          return 0;
        }
        localafr.wYR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48843);
        return 0;
      }
      AppMethodBeat.o(48843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afr
 * JD-Core Version:    0.7.0.1
 */