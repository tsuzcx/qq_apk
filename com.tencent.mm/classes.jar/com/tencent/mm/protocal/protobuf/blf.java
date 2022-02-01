package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class blf
  extends dpc
{
  public String LUh;
  public xg LUi;
  public int oTw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.LUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LUh != null) {
        paramVarArgs.e(2, this.LUh);
      }
      paramVarArgs.aM(3, this.oTw);
      if (this.LUi != null)
      {
        paramVarArgs.ni(4, this.LUi.computeSize());
        this.LUi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LUh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LUh);
      }
      i += g.a.a.b.b.a.bu(3, this.oTw);
      paramInt = i;
      if (this.LUi != null) {
        paramInt = i + g.a.a.a.nh(4, this.LUi.computeSize());
      }
      AppMethodBeat.o(101815);
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
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        if (this.LUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NewChatroomData");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        blf localblf = (blf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101815);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101815);
          return 0;
        case 2: 
          localblf.LUh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101815);
          return 0;
        case 3: 
          localblf.oTw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101815);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblf.LUi = ((xg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      AppMethodBeat.o(101815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blf
 * JD-Core Version:    0.7.0.1
 */