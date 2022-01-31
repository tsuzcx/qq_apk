package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzp
  extends buy
{
  public int xLp;
  public LinkedList<cux> xLq;
  public int xLr;
  public int xtq;
  
  public bzp()
  {
    AppMethodBeat.i(28633);
    this.xLq = new LinkedList();
    AppMethodBeat.o(28633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28634);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xtq);
      paramVarArgs.aO(3, this.xLp);
      paramVarArgs.e(4, 8, this.xLq);
      paramVarArgs.aO(5, this.xLr);
      AppMethodBeat.o(28634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xtq);
      int j = e.a.a.b.b.a.bl(3, this.xLp);
      int k = e.a.a.a.c(4, 8, this.xLq);
      int m = e.a.a.b.b.a.bl(5, this.xLr);
      AppMethodBeat.o(28634);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLq.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bzp localbzp = (bzp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28634);
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
            localbzp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28634);
          return 0;
        case 2: 
          localbzp.xtq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28634);
          return 0;
        case 3: 
          localbzp.xLp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28634);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cux();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cux)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbzp.xLq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28634);
          return 0;
        }
        localbzp.xLr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28634);
        return 0;
      }
      AppMethodBeat.o(28634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzp
 * JD-Core Version:    0.7.0.1
 */