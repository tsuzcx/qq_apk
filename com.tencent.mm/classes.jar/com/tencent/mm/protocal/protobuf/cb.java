package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cb
  extends erp
{
  public ca YEc;
  public String channel;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125691);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.channel != null) {
        paramVarArgs.g(2, this.channel);
      }
      if (this.YEc != null)
      {
        paramVarArgs.qD(3, this.YEc.computeSize());
        this.YEc.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      AppMethodBeat.o(125691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.channel != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.channel);
      }
      i = paramInt;
      if (this.YEc != null) {
        i = paramInt + i.a.a.a.qC(3, this.YEc.computeSize());
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      AppMethodBeat.o(125691);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125691);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cb localcb = (cb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125691);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125691);
          return 0;
        case 2: 
          localcb.channel = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125691);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ca)localObject2).parseFrom((byte[])localObject1);
            }
            localcb.YEc = ((ca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125691);
          return 0;
        }
        localcb.content = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125691);
        return 0;
      }
      AppMethodBeat.o(125691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cb
 * JD-Core Version:    0.7.0.1
 */