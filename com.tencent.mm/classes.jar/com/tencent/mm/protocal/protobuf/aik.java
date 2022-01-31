package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aik
  extends buy
{
  public double latitude;
  public double longitude;
  public int scene;
  public String xad;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89089);
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
      paramVarArgs.aO(4, this.scene);
      if (this.xad != null) {
        paramVarArgs.e(5, this.xad);
      }
      AppMethodBeat.o(89089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8) + e.a.a.b.b.a.bl(4, this.scene);
      paramInt = i;
      if (this.xad != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xad);
      }
      AppMethodBeat.o(89089);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aik localaik = (aik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89089);
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
            localaik.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89089);
          return 0;
        case 2: 
          localaik.latitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89089);
          return 0;
        case 3: 
          localaik.longitude = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(89089);
          return 0;
        case 4: 
          localaik.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89089);
          return 0;
        }
        localaik.xad = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89089);
        return 0;
      }
      AppMethodBeat.o(89089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aik
 * JD-Core Version:    0.7.0.1
 */