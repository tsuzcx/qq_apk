package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bjg
  extends dpc
{
  public ccr LSV;
  public String LSW;
  public ccm LSX;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LSV != null)
      {
        paramVarArgs.ni(2, this.LSV.computeSize());
        this.LSV.writeFields(paramVarArgs);
      }
      if (this.LSW != null) {
        paramVarArgs.e(3, this.LSW);
      }
      if (this.LSX != null)
      {
        paramVarArgs.ni(4, this.LSX.computeSize());
        this.LSX.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LSV != null) {
        paramInt = i + g.a.a.a.nh(2, this.LSV.computeSize());
      }
      i = paramInt;
      if (this.LSW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LSW);
      }
      paramInt = i;
      if (this.LSX != null) {
        paramInt = i + g.a.a.a.nh(4, this.LSX.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.result);
      AppMethodBeat.o(82408);
      return paramInt + i;
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
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjg localbjg = (bjg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localbjg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbjg.LSV = ((ccr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localbjg.LSW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbjg.LSX = ((ccm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localbjg.result = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjg
 * JD-Core Version:    0.7.0.1
 */