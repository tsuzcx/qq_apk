package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ber
  extends dpc
{
  public int LOv;
  public String LOw;
  public String LOx;
  public int LOy;
  public String LOz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91467);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LOv);
      if (this.LOw != null) {
        paramVarArgs.e(3, this.LOw);
      }
      if (this.LOx != null) {
        paramVarArgs.e(4, this.LOx);
      }
      paramVarArgs.aM(5, this.LOy);
      if (this.LOz != null) {
        paramVarArgs.e(6, this.LOz);
      }
      AppMethodBeat.o(91467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LOv);
      paramInt = i;
      if (this.LOw != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LOw);
      }
      i = paramInt;
      if (this.LOx != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LOx);
      }
      i += g.a.a.b.b.a.bu(5, this.LOy);
      paramInt = i;
      if (this.LOz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LOz);
      }
      AppMethodBeat.o(91467);
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
          AppMethodBeat.o(91467);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ber localber = (ber)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91467);
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
            localber.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91467);
          return 0;
        case 2: 
          localber.LOv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91467);
          return 0;
        case 3: 
          localber.LOw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 4: 
          localber.LOx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 5: 
          localber.LOy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91467);
          return 0;
        }
        localber.LOz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91467);
        return 0;
      }
      AppMethodBeat.o(91467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ber
 * JD-Core Version:    0.7.0.1
 */