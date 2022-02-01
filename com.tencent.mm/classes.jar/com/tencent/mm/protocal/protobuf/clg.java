package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class clg
  extends dpc
{
  public String MqB;
  public int type;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124536);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.type);
      if (this.version != null) {
        paramVarArgs.e(3, this.version);
      }
      if (this.MqB != null) {
        paramVarArgs.e(4, this.MqB);
      }
      AppMethodBeat.o(124536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.version);
      }
      i = paramInt;
      if (this.MqB != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MqB);
      }
      AppMethodBeat.o(124536);
      return i;
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
          AppMethodBeat.o(124536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        clg localclg = (clg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124536);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localclg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124536);
          return 0;
        case 2: 
          localclg.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124536);
          return 0;
        case 3: 
          localclg.version = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124536);
          return 0;
        }
        localclg.MqB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124536);
        return 0;
      }
      AppMethodBeat.o(124536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clg
 * JD-Core Version:    0.7.0.1
 */