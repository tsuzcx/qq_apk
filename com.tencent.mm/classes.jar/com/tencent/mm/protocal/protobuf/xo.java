package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class xo
  extends dpc
{
  public String KIf;
  public lu LiM;
  public en LiN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(194540);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KIf != null) {
        paramVarArgs.e(2, this.KIf);
      }
      if (this.LiM != null)
      {
        paramVarArgs.ni(3, this.LiM.computeSize());
        this.LiM.writeFields(paramVarArgs);
      }
      if (this.LiN != null)
      {
        paramVarArgs.ni(4, this.LiN.computeSize());
        this.LiN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KIf != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KIf);
      }
      i = paramInt;
      if (this.LiM != null) {
        i = paramInt + g.a.a.a.nh(3, this.LiM.computeSize());
      }
      paramInt = i;
      if (this.LiN != null) {
        paramInt = i + g.a.a.a.nh(4, this.LiN.computeSize());
      }
      AppMethodBeat.o(194540);
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
          AppMethodBeat.o(194540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        xo localxo = (xo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194540);
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
            localxo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194540);
          return 0;
        case 2: 
          localxo.KIf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194540);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localxo.LiM = ((lu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194540);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localxo.LiN = ((en)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194540);
        return 0;
      }
      AppMethodBeat.o(194540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xo
 * JD-Core Version:    0.7.0.1
 */