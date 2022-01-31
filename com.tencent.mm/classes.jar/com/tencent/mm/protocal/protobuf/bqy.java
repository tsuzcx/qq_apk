package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bqy
  extends buy
{
  public int time_stamp;
  public String wyb;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11799);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(11799);
        throw paramVarArgs;
      }
      if (this.wyb == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(11799);
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
      if (this.wyb != null) {
        paramVarArgs.e(3, this.wyb);
      }
      paramVarArgs.aO(4, this.time_stamp);
      AppMethodBeat.o(11799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wyh);
      }
      i = paramInt;
      if (this.wyb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wyb);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.time_stamp);
      AppMethodBeat.o(11799);
      return i + paramInt;
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
          AppMethodBeat.o(11799);
          throw paramVarArgs;
        }
        if (this.wyb == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(11799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bqy localbqy = (bqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11799);
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
            localbqy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11799);
          return 0;
        case 2: 
          localbqy.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11799);
          return 0;
        case 3: 
          localbqy.wyb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11799);
          return 0;
        }
        localbqy.time_stamp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(11799);
        return 0;
      }
      AppMethodBeat.o(11799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqy
 * JD-Core Version:    0.7.0.1
 */