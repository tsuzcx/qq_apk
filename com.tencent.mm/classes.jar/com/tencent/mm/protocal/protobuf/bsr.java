package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsr
  extends dpc
{
  public String CEI;
  public int LZv;
  public String LZw;
  public int Lia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CEI != null) {
        paramVarArgs.e(2, this.CEI);
      }
      paramVarArgs.aM(3, this.LZv);
      if (this.LZw != null) {
        paramVarArgs.e(4, this.LZw);
      }
      paramVarArgs.aM(5, this.Lia);
      AppMethodBeat.o(116455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CEI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.CEI);
      }
      i += g.a.a.b.b.a.bu(3, this.LZv);
      paramInt = i;
      if (this.LZw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LZw);
      }
      i = g.a.a.b.b.a.bu(5, this.Lia);
      AppMethodBeat.o(116455);
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
          AppMethodBeat.o(116455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsr localbsr = (bsr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116455);
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
            localbsr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116455);
          return 0;
        case 2: 
          localbsr.CEI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116455);
          return 0;
        case 3: 
          localbsr.LZv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116455);
          return 0;
        case 4: 
          localbsr.LZw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116455);
          return 0;
        }
        localbsr.Lia = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116455);
        return 0;
      }
      AppMethodBeat.o(116455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsr
 * JD-Core Version:    0.7.0.1
 */