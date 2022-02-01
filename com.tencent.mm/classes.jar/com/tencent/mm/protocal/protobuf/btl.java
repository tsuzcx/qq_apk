package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btl
  extends dpc
{
  public String Mab;
  public String Mac;
  public String Mad;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192778);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(192778);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.Mab != null) {
        paramVarArgs.e(3, this.Mab);
      }
      if (this.Mac != null) {
        paramVarArgs.e(4, this.Mac);
      }
      if (this.Mad != null) {
        paramVarArgs.e(5, this.Mad);
      }
      AppMethodBeat.o(192778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.Mab != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mab);
      }
      paramInt = i;
      if (this.Mac != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mac);
      }
      i = paramInt;
      if (this.Mad != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mad);
      }
      AppMethodBeat.o(192778);
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
          AppMethodBeat.o(192778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(192778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btl localbtl = (btl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192778);
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
            localbtl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192778);
          return 0;
        case 2: 
          localbtl.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192778);
          return 0;
        case 3: 
          localbtl.Mab = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192778);
          return 0;
        case 4: 
          localbtl.Mac = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192778);
          return 0;
        }
        localbtl.Mad = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(192778);
        return 0;
      }
      AppMethodBeat.o(192778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btl
 * JD-Core Version:    0.7.0.1
 */