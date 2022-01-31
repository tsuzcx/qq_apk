package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coh
  extends buy
{
  public String jJA;
  public int wsW;
  public String wvG;
  public int xXa;
  public int xXb;
  public LinkedList<bba> xXc;
  public LinkedList<bdj> xpz;
  
  public coh()
  {
    AppMethodBeat.i(73773);
    this.xpz = new LinkedList();
    this.xXc = new LinkedList();
    AppMethodBeat.o(73773);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73774);
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
      paramVarArgs.aO(3, this.wsW);
      if (this.wvG != null) {
        paramVarArgs.e(4, this.wvG);
      }
      paramVarArgs.aO(5, this.xXa);
      paramVarArgs.e(6, 8, this.xpz);
      paramVarArgs.aO(7, this.xXb);
      paramVarArgs.e(8, 8, this.xXc);
      AppMethodBeat.o(73774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i += e.a.a.b.b.a.bl(3, this.wsW);
      paramInt = i;
      if (this.wvG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvG);
      }
      i = e.a.a.b.b.a.bl(5, this.xXa);
      int j = e.a.a.a.c(6, 8, this.xpz);
      int k = e.a.a.b.b.a.bl(7, this.xXb);
      int m = e.a.a.a.c(8, 8, this.xXc);
      AppMethodBeat.o(73774);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xpz.clear();
        this.xXc.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        coh localcoh = (coh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73774);
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
            localcoh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73774);
          return 0;
        case 2: 
          localcoh.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73774);
          return 0;
        case 3: 
          localcoh.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73774);
          return 0;
        case 4: 
          localcoh.wvG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73774);
          return 0;
        case 5: 
          localcoh.xXa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73774);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoh.xpz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73774);
          return 0;
        case 7: 
          localcoh.xXb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73774);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bba();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bba)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcoh.xXc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73774);
        return 0;
      }
      AppMethodBeat.o(73774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coh
 * JD-Core Version:    0.7.0.1
 */