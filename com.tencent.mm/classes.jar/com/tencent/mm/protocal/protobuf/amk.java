package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amk
  extends buy
{
  public double latitude;
  public double longitude;
  public int offset;
  public int wvk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89097);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.offset);
      paramVarArgs.aO(3, this.wvk);
      paramVarArgs.f(4, this.latitude);
      paramVarArgs.f(5, this.longitude);
      AppMethodBeat.o(89097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.offset);
      int j = e.a.a.b.b.a.bl(3, this.wvk);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(89097);
      return paramInt + i + j + (k + 8) + (m + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amk localamk = (amk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89097);
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
            localamk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89097);
          return 0;
        case 2: 
          localamk.offset = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89097);
          return 0;
        case 3: 
          localamk.wvk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89097);
          return 0;
        case 4: 
          localamk.latitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89097);
          return 0;
        }
        localamk.longitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(89097);
        return 0;
      }
      AppMethodBeat.o(89097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amk
 * JD-Core Version:    0.7.0.1
 */