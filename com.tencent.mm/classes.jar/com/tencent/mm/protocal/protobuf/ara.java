package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ara
  extends dpc
{
  public int LCN;
  public String thumbUrl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209387);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(209387);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(2, this.thumbUrl);
      }
      paramVarArgs.aM(3, this.LCN);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(4, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.thumbUrl);
      }
      i += g.a.a.b.b.a.bu(3, this.LCN);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.nh(4, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(209387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(209387);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ara localara = (ara)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209387);
          return -1;
        case 1: 
          localara.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209387);
          return 0;
        case 2: 
          localara.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209387);
          return 0;
        case 3: 
          localara.LCN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209387);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localara.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209387);
        return 0;
      }
      AppMethodBeat.o(209387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ara
 * JD-Core Version:    0.7.0.1
 */