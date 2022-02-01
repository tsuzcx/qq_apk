package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwq
  extends dpc
{
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(74660);
        throw paramVarArgs;
      }
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(74660);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.BsF);
      paramVarArgs.aM(3, this.BsG);
      paramVarArgs.aM(4, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(5, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(74660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsF) + g.a.a.b.b.a.bu(3, this.BsG) + g.a.a.b.b.a.bu(4, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(5, this.BsI.computeSize());
      }
      AppMethodBeat.o(74660);
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
          AppMethodBeat.o(74660);
          throw paramVarArgs;
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(74660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(74660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwq localbwq = (bwq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74660);
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
            localbwq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74660);
          return 0;
        case 2: 
          localbwq.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74660);
          return 0;
        case 3: 
          localbwq.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74660);
          return 0;
        case 4: 
          localbwq.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74660);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbwq.BsI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(74660);
        return 0;
      }
      AppMethodBeat.o(74660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwq
 * JD-Core Version:    0.7.0.1
 */