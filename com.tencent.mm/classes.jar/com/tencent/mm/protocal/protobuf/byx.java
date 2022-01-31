package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class byx
  extends buy
{
  public int xLd;
  public LinkedList<Integer> xLe;
  
  public byx()
  {
    AppMethodBeat.i(73755);
    this.xLe = new LinkedList();
    AppMethodBeat.o(73755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73756);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xLd);
      paramVarArgs.f(3, 2, this.xLe);
      AppMethodBeat.o(73756);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label429;
      }
    }
    label429:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xLd);
      int j = e.a.a.a.d(3, 2, this.xLe);
      AppMethodBeat.o(73756);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLe.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73756);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        byx localbyx = (byx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73756);
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
            localbyx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73756);
          return 0;
        case 2: 
          localbyx.xLd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73756);
          return 0;
        }
        localbyx.xLe = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(73756);
        return 0;
      }
      AppMethodBeat.o(73756);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */