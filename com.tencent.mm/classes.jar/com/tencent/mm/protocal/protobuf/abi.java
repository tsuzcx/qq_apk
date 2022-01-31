package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abi
  extends buy
{
  public double latitude;
  public double longitude;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56786);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.f(2, this.latitude);
      paramVarArgs.f(3, this.longitude);
      paramVarArgs.am(4, this.timestamp);
      AppMethodBeat.o(56786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(56786);
      return paramInt + (i + 8) + (j + 8) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abi localabi = (abi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56786);
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
            localabi.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56786);
          return 0;
        case 2: 
          localabi.latitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56786);
          return 0;
        case 3: 
          localabi.longitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56786);
          return 0;
        }
        localabi.timestamp = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56786);
        return 0;
      }
      AppMethodBeat.o(56786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abi
 * JD-Core Version:    0.7.0.1
 */