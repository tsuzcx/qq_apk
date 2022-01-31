package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cte
  extends buy
{
  public int wLO;
  public int wQP;
  public long wQQ;
  public double wyO;
  public double wyP;
  public LinkedList<cfu> xcd;
  public long ycp;
  public bwc ycq;
  public bwc ycr;
  public int ycs;
  
  public cte()
  {
    AppMethodBeat.i(5267);
    this.xcd = new LinkedList();
    AppMethodBeat.o(5267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5268);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ycq == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(5268);
        throw paramVarArgs;
      }
      if (this.ycr == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(5268);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.ycp);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.wLO);
      if (this.ycq != null)
      {
        paramVarArgs.iQ(5, this.ycq.computeSize());
        this.ycq.writeFields(paramVarArgs);
      }
      if (this.ycr != null)
      {
        paramVarArgs.iQ(6, this.ycr.computeSize());
        this.ycr.writeFields(paramVarArgs);
      }
      paramVarArgs.f(7, this.wyO);
      paramVarArgs.f(8, this.wyP);
      paramVarArgs.aO(9, this.wQP);
      paramVarArgs.aO(10, this.ycs);
      paramVarArgs.e(11, 8, this.xcd);
      AppMethodBeat.o(5268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1205;
      }
    }
    label1205:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.ycp) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.wLO);
      paramInt = i;
      if (this.ycq != null) {
        paramInt = i + e.a.a.a.iP(5, this.ycq.computeSize());
      }
      i = paramInt;
      if (this.ycr != null) {
        i = paramInt + e.a.a.a.iP(6, this.ycr.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(7);
      int j = e.a.a.b.b.a.eW(8);
      int k = e.a.a.b.b.a.bl(9, this.wQP);
      int m = e.a.a.b.b.a.bl(10, this.ycs);
      int n = e.a.a.a.c(11, 8, this.xcd);
      AppMethodBeat.o(5268);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcd.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ycq == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(5268);
          throw paramVarArgs;
        }
        if (this.ycr == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(5268);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cte localcte = (cte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5268);
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
            localcte.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5268);
          return 0;
        case 2: 
          localcte.ycp = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5268);
          return 0;
        case 3: 
          localcte.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5268);
          return 0;
        case 4: 
          localcte.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5268);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcte.ycq = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5268);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcte.ycr = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5268);
          return 0;
        case 7: 
          localcte.wyO = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(5268);
          return 0;
        case 8: 
          localcte.wyP = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(5268);
          return 0;
        case 9: 
          localcte.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5268);
          return 0;
        case 10: 
          localcte.ycs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5268);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcte.xcd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5268);
        return 0;
      }
      AppMethodBeat.o(5268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cte
 * JD-Core Version:    0.7.0.1
 */