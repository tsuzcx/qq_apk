package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zv
  extends buy
{
  public int Scene;
  public String wQO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28386);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wQO != null) {
        paramVarArgs.e(2, this.wQO);
      }
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(28386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label423;
      }
    }
    label423:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQO != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wQO);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(28386);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zv localzv = (zv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28386);
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
            localzv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28386);
          return 0;
        case 2: 
          localzv.wQO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28386);
          return 0;
        }
        localzv.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28386);
        return 0;
      }
      AppMethodBeat.o(28386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zv
 * JD-Core Version:    0.7.0.1
 */