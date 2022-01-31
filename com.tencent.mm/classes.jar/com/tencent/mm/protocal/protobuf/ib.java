package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ib
  extends buy
{
  public LinkedList<bkw> wuA;
  public int wuB;
  public int wuC;
  
  public ib()
  {
    AppMethodBeat.i(56713);
    this.wuA = new LinkedList();
    AppMethodBeat.o(56713);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56714);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wuA);
      paramVarArgs.aO(3, this.wuB);
      paramVarArgs.aO(4, this.wuC);
      AppMethodBeat.o(56714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.wuA);
      int j = e.a.a.b.b.a.bl(3, this.wuB);
      int k = e.a.a.b.b.a.bl(4, this.wuC);
      AppMethodBeat.o(56714);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wuA.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ib localib = (ib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56714);
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
            localib.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56714);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localib.wuA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56714);
          return 0;
        case 3: 
          localib.wuB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56714);
          return 0;
        }
        localib.wuC = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56714);
        return 0;
      }
      AppMethodBeat.o(56714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */