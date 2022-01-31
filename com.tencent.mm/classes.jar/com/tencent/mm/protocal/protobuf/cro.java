package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cro
  extends buy
{
  public int wLO;
  public int wQP;
  public long wQQ;
  public String xCG;
  public cta xZX;
  public cta xZY;
  public long yab;
  public int yac;
  public int yam;
  public int yan;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5230);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCG != null) {
        paramVarArgs.e(2, this.xCG);
      }
      paramVarArgs.aO(3, this.wQP);
      paramVarArgs.aO(4, this.yam);
      if (this.xZX != null)
      {
        paramVarArgs.iQ(5, this.xZX.computeSize());
        this.xZX.writeFields(paramVarArgs);
      }
      if (this.xZY != null)
      {
        paramVarArgs.iQ(6, this.xZY.computeSize());
        this.xZY.writeFields(paramVarArgs);
      }
      paramVarArgs.am(7, this.wQQ);
      paramVarArgs.aO(8, this.wLO);
      paramVarArgs.am(9, this.yab);
      paramVarArgs.aO(10, this.yan);
      paramVarArgs.aO(11, this.yac);
      AppMethodBeat.o(5230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1023;
      }
    }
    label1023:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xCG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xCG);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wQP) + e.a.a.b.b.a.bl(4, this.yam);
      paramInt = i;
      if (this.xZX != null) {
        paramInt = i + e.a.a.a.iP(5, this.xZX.computeSize());
      }
      i = paramInt;
      if (this.xZY != null) {
        i = paramInt + e.a.a.a.iP(6, this.xZY.computeSize());
      }
      paramInt = e.a.a.b.b.a.p(7, this.wQQ);
      int j = e.a.a.b.b.a.bl(8, this.wLO);
      int k = e.a.a.b.b.a.p(9, this.yab);
      int m = e.a.a.b.b.a.bl(10, this.yan);
      int n = e.a.a.b.b.a.bl(11, this.yac);
      AppMethodBeat.o(5230);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5230);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cro localcro = (cro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5230);
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
            localcro.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5230);
          return 0;
        case 2: 
          localcro.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5230);
          return 0;
        case 3: 
          localcro.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5230);
          return 0;
        case 4: 
          localcro.yam = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5230);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcro.xZX = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5230);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcro.xZY = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5230);
          return 0;
        case 7: 
          localcro.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5230);
          return 0;
        case 8: 
          localcro.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5230);
          return 0;
        case 9: 
          localcro.yab = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5230);
          return 0;
        case 10: 
          localcro.yan = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5230);
          return 0;
        }
        localcro.yac = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5230);
        return 0;
      }
      AppMethodBeat.o(5230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cro
 * JD-Core Version:    0.7.0.1
 */