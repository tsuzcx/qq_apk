package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqa
  extends buy
{
  public String cwc;
  public String xYE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96310);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.xYE != null) {
        paramVarArgs.e(3, this.xYE);
      }
      AppMethodBeat.o(96310);
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
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.xYE != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xYE);
      }
      AppMethodBeat.o(96310);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96310);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqa localcqa = (cqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96310);
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
            localcqa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96310);
          return 0;
        case 2: 
          localcqa.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96310);
          return 0;
        }
        localcqa.xYE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96310);
        return 0;
      }
      AppMethodBeat.o(96310);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqa
 * JD-Core Version:    0.7.0.1
 */