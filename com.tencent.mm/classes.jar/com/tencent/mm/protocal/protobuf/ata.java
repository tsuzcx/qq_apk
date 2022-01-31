package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ata
  extends buy
{
  public int aXG;
  public int condition;
  public int xio;
  public int xip;
  public int xiq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96246);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.aXG);
      paramVarArgs.aO(3, this.condition);
      paramVarArgs.aO(4, this.xio);
      paramVarArgs.aO(5, this.xip);
      paramVarArgs.aO(6, this.xiq);
      AppMethodBeat.o(96246);
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
      int i = e.a.a.b.b.a.bl(2, this.aXG);
      int j = e.a.a.b.b.a.bl(3, this.condition);
      int k = e.a.a.b.b.a.bl(4, this.xio);
      int m = e.a.a.b.b.a.bl(5, this.xip);
      int n = e.a.a.b.b.a.bl(6, this.xiq);
      AppMethodBeat.o(96246);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ata localata = (ata)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96246);
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
            localata.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96246);
          return 0;
        case 2: 
          localata.aXG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96246);
          return 0;
        case 3: 
          localata.condition = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96246);
          return 0;
        case 4: 
          localata.xio = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96246);
          return 0;
        case 5: 
          localata.xip = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96246);
          return 0;
        }
        localata.xiq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96246);
        return 0;
      }
      AppMethodBeat.o(96246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ata
 * JD-Core Version:    0.7.0.1
 */