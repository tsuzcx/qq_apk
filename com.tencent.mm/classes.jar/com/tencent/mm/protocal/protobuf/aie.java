package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aie
  extends buy
{
  public double latitude;
  public double longitude;
  public String wEJ;
  public int wFN;
  public long wFa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89082);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wEJ != null) {
        paramVarArgs.e(2, this.wEJ);
      }
      paramVarArgs.f(3, this.latitude);
      paramVarArgs.f(4, this.longitude);
      paramVarArgs.am(5, this.wFa);
      paramVarArgs.aO(6, this.wFN);
      AppMethodBeat.o(89082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wEJ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wEJ);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.p(5, this.wFa);
      int m = e.a.a.b.b.a.bl(6, this.wFN);
      AppMethodBeat.o(89082);
      return i + (paramInt + 8) + (j + 8) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aie localaie = (aie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89082);
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
            localaie.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89082);
          return 0;
        case 2: 
          localaie.wEJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89082);
          return 0;
        case 3: 
          localaie.latitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89082);
          return 0;
        case 4: 
          localaie.longitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89082);
          return 0;
        case 5: 
          localaie.wFa = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(89082);
          return 0;
        }
        localaie.wFN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89082);
        return 0;
      }
      AppMethodBeat.o(89082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aie
 * JD-Core Version:    0.7.0.1
 */