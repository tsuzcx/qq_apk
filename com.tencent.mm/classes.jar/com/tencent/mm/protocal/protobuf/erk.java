package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erk
  extends dpc
{
  public int LUr;
  public com.tencent.mm.bw.b Npc;
  public String Npd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(239513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Npc != null) {
        paramVarArgs.c(2, this.Npc);
      }
      paramVarArgs.aM(3, this.LUr);
      if (this.Npd != null) {
        paramVarArgs.e(4, this.Npd);
      }
      AppMethodBeat.o(239513);
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
      int i = paramInt;
      if (this.Npc != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.Npc);
      }
      i += g.a.a.b.b.a.bu(3, this.LUr);
      paramInt = i;
      if (this.Npd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Npd);
      }
      AppMethodBeat.o(239513);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(239513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(239513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        erk localerk = (erk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239513);
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
            localerk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239513);
          return 0;
        case 2: 
          localerk.Npc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(239513);
          return 0;
        case 3: 
          localerk.LUr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(239513);
          return 0;
        }
        localerk.Npd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(239513);
        return 0;
      }
      AppMethodBeat.o(239513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erk
 * JD-Core Version:    0.7.0.1
 */