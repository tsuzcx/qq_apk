package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqq
  extends cvw
{
  public String FZq;
  public String FZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124541);
        throw paramVarArgs;
      }
      if (this.FZq == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124541);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZx != null) {
        paramVarArgs.d(2, this.FZx);
      }
      if (this.FZq != null) {
        paramVarArgs.d(3, this.FZq);
      }
      AppMethodBeat.o(124541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZx);
      }
      i = paramInt;
      if (this.FZq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FZq);
      }
      AppMethodBeat.o(124541);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124541);
          throw paramVarArgs;
        }
        if (this.FZq == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124541);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqq localcqq = (cqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124541);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124541);
          return 0;
        case 2: 
          localcqq.FZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124541);
          return 0;
        }
        localcqq.FZq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124541);
        return 0;
      }
      AppMethodBeat.o(124541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqq
 * JD-Core Version:    0.7.0.1
 */