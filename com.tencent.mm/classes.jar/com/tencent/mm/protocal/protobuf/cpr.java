package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpr
  extends buy
{
  public int cCd;
  public int wYN;
  public awd wYS;
  public awe wYT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48984);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wYN);
      paramVarArgs.aO(3, this.cCd);
      if (this.wYS != null)
      {
        paramVarArgs.iQ(4, this.wYS.computeSize());
        this.wYS.writeFields(paramVarArgs);
      }
      if (this.wYT != null)
      {
        paramVarArgs.iQ(5, this.wYT.computeSize());
        this.wYT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wYN) + e.a.a.b.b.a.bl(3, this.cCd);
      paramInt = i;
      if (this.wYS != null) {
        paramInt = i + e.a.a.a.iP(4, this.wYS.computeSize());
      }
      i = paramInt;
      if (this.wYT != null) {
        i = paramInt + e.a.a.a.iP(5, this.wYT.computeSize());
      }
      AppMethodBeat.o(48984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpr localcpr = (cpr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48984);
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
            localcpr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48984);
          return 0;
        case 2: 
          localcpr.wYN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48984);
          return 0;
        case 3: 
          localcpr.cCd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48984);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpr.wYS = ((awd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48984);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awe();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcpr.wYT = ((awe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48984);
        return 0;
      }
      AppMethodBeat.o(48984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpr
 * JD-Core Version:    0.7.0.1
 */