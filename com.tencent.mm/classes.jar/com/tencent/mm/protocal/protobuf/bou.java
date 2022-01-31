package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bou
  extends buy
{
  public String wxP;
  public int xCT;
  public int xCU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80156);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xCT);
      paramVarArgs.aO(3, this.xCU);
      if (this.wxP != null) {
        paramVarArgs.e(4, this.wxP);
      }
      AppMethodBeat.o(80156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xCT) + e.a.a.b.b.a.bl(3, this.xCU);
      paramInt = i;
      if (this.wxP != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wxP);
      }
      AppMethodBeat.o(80156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bou localbou = (bou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80156);
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
            localbou.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80156);
          return 0;
        case 2: 
          localbou.xCT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80156);
          return 0;
        case 3: 
          localbou.xCU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80156);
          return 0;
        }
        localbou.wxP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80156);
        return 0;
      }
      AppMethodBeat.o(80156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bou
 * JD-Core Version:    0.7.0.1
 */