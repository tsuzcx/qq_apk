package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cmq
  extends buy
{
  public kp wXl;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11822);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(11822);
        throw paramVarArgs;
      }
      if (this.wXl == null)
      {
        paramVarArgs = new b("Not all required fields were included: chat");
        AppMethodBeat.o(11822);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wyh != null) {
        paramVarArgs.e(2, this.wyh);
      }
      if (this.wXl != null)
      {
        paramVarArgs.iQ(3, this.wXl.computeSize());
        this.wXl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label635;
      }
    }
    label635:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wyh);
      }
      i = paramInt;
      if (this.wXl != null) {
        i = paramInt + e.a.a.a.iP(3, this.wXl.computeSize());
      }
      AppMethodBeat.o(11822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wyh == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(11822);
          throw paramVarArgs;
        }
        if (this.wXl == null)
        {
          paramVarArgs = new b("Not all required fields were included: chat");
          AppMethodBeat.o(11822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cmq localcmq = (cmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11822);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcmq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11822);
          return 0;
        case 2: 
          localcmq.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11822);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcmq.wXl = ((kp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11822);
        return 0;
      }
      AppMethodBeat.o(11822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmq
 * JD-Core Version:    0.7.0.1
 */