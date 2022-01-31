package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class boo
  extends buy
{
  public int wQP;
  public long wQQ;
  public String xCG;
  public int xCH;
  public int xCI;
  public long xCj;
  public long xCm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28593);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xCG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(28593);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xCG != null) {
        paramVarArgs.e(2, this.xCG);
      }
      paramVarArgs.aO(3, this.wQP);
      paramVarArgs.am(4, this.wQQ);
      paramVarArgs.am(5, this.xCj);
      paramVarArgs.aO(6, this.xCH);
      paramVarArgs.am(7, this.xCm);
      paramVarArgs.aO(8, this.xCI);
      AppMethodBeat.o(28593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xCG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xCG);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.wQP);
      int j = e.a.a.b.b.a.p(4, this.wQQ);
      int k = e.a.a.b.b.a.p(5, this.xCj);
      int m = e.a.a.b.b.a.bl(6, this.xCH);
      int n = e.a.a.b.b.a.p(7, this.xCm);
      int i1 = e.a.a.b.b.a.bl(8, this.xCI);
      AppMethodBeat.o(28593);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xCG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUsername");
          AppMethodBeat.o(28593);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        boo localboo = (boo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28593);
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
            localboo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28593);
          return 0;
        case 2: 
          localboo.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28593);
          return 0;
        case 3: 
          localboo.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28593);
          return 0;
        case 4: 
          localboo.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28593);
          return 0;
        case 5: 
          localboo.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28593);
          return 0;
        case 6: 
          localboo.xCH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28593);
          return 0;
        case 7: 
          localboo.xCm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28593);
          return 0;
        }
        localboo.xCI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28593);
        return 0;
      }
      AppMethodBeat.o(28593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boo
 * JD-Core Version:    0.7.0.1
 */