package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cc
  extends buy
{
  public LinkedList<azf> woA;
  public int woz;
  
  public cc()
  {
    AppMethodBeat.i(28298);
    this.woA = new LinkedList();
    AppMethodBeat.o(28298);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28299);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.woz);
      paramVarArgs.e(3, 8, this.woA);
      AppMethodBeat.o(28299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.woz);
      int j = e.a.a.a.c(3, 8, this.woA);
      AppMethodBeat.o(28299);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.woA.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28299);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cc localcc = (cc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28299);
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
            localcc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28299);
          return 0;
        case 2: 
          localcc.woz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28299);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcc.woA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28299);
        return 0;
      }
      AppMethodBeat.o(28299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cc
 * JD-Core Version:    0.7.0.1
 */