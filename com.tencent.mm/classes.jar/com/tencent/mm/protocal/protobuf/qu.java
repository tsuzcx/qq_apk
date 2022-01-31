package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qu
  extends buy
{
  public String wIZ;
  public String wpt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48810);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpt != null) {
        paramVarArgs.e(2, this.wpt);
      }
      if (this.wIZ != null) {
        paramVarArgs.e(3, this.wIZ);
      }
      AppMethodBeat.o(48810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpt != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpt);
      }
      i = paramInt;
      if (this.wIZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wIZ);
      }
      AppMethodBeat.o(48810);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qu localqu = (qu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48810);
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
            localqu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48810);
          return 0;
        case 2: 
          localqu.wpt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48810);
          return 0;
        }
        localqu.wIZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48810);
        return 0;
      }
      AppMethodBeat.o(48810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qu
 * JD-Core Version:    0.7.0.1
 */