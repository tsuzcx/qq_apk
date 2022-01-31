package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqz
  extends buy
{
  public int pIx;
  public int pIy;
  public int wkX;
  public int xgd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127722);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xgd);
      paramVarArgs.aO(3, this.pIx);
      paramVarArgs.aO(4, this.pIy);
      paramVarArgs.aO(5, this.wkX);
      AppMethodBeat.o(127722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xgd);
      int j = e.a.a.b.b.a.bl(3, this.pIx);
      int k = e.a.a.b.b.a.bl(4, this.pIy);
      int m = e.a.a.b.b.a.bl(5, this.wkX);
      AppMethodBeat.o(127722);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(127722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqz localaqz = (aqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127722);
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
            localaqz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127722);
          return 0;
        case 2: 
          localaqz.xgd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(127722);
          return 0;
        case 3: 
          localaqz.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(127722);
          return 0;
        case 4: 
          localaqz.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(127722);
          return 0;
        }
        localaqz.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(127722);
        return 0;
      }
      AppMethodBeat.o(127722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqz
 * JD-Core Version:    0.7.0.1
 */