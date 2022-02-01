package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btf
  extends dpc
{
  public dgn LZP;
  public dgl LZQ;
  public int him;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155413);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.LZP == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.LZQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.him);
      if (this.LZP != null)
      {
        paramVarArgs.ni(3, this.LZP.computeSize());
        this.LZP.writeFields(paramVarArgs);
      }
      if (this.LZQ != null)
      {
        paramVarArgs.ni(4, this.LZQ.computeSize());
        this.LZQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.him);
      paramInt = i;
      if (this.LZP != null) {
        paramInt = i + g.a.a.a.nh(3, this.LZP.computeSize());
      }
      i = paramInt;
      if (this.LZQ != null) {
        i = paramInt + g.a.a.a.nh(4, this.LZQ.computeSize());
      }
      AppMethodBeat.o(155413);
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
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.LZP == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.LZQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btf localbtf = (btf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155413);
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
            localbtf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        case 2: 
          localbtf.him = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155413);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtf.LZP = ((dgn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbtf.LZQ = ((dgl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      AppMethodBeat.o(155413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */