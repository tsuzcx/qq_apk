package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnr
  extends dpc
{
  public long LRV;
  public String LWe;
  public rx LWf;
  public de LWg;
  public int LWh;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      paramVarArgs.bb(3, this.LRV);
      if (this.LWg != null)
      {
        paramVarArgs.ni(4, this.LWg.computeSize());
        this.LWg.writeFields(paramVarArgs);
      }
      if (this.LWe != null) {
        paramVarArgs.e(5, this.LWe);
      }
      paramVarArgs.aM(6, this.LWh);
      if (this.LWf != null)
      {
        paramVarArgs.ni(7, this.LWf.computeSize());
        this.LWf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode) + g.a.a.b.b.a.r(3, this.LRV);
      paramInt = i;
      if (this.LWg != null) {
        paramInt = i + g.a.a.a.nh(4, this.LWg.computeSize());
      }
      i = paramInt;
      if (this.LWe != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LWe);
      }
      i += g.a.a.b.b.a.bu(6, this.LWh);
      paramInt = i;
      if (this.LWf != null) {
        paramInt = i + g.a.a.a.nh(7, this.LWf.computeSize());
      }
      AppMethodBeat.o(114788);
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
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnr localbnr = (bnr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localbnr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localbnr.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localbnr.LRV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbnr.LWg = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localbnr.LWe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localbnr.LWh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbnr.LWf = ((rx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnr
 * JD-Core Version:    0.7.0.1
 */