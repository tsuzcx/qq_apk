package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwc
  extends dpc
{
  public int error_code;
  public String error_msg;
  public String gqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123581);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123581);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.gqB != null) {
        paramVarArgs.e(2, this.gqB);
      }
      if (this.error_msg != null) {
        paramVarArgs.e(3, this.error_msg);
      }
      paramVarArgs.aM(4, this.error_code);
      AppMethodBeat.o(123581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gqB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.gqB);
      }
      i = paramInt;
      if (this.error_msg != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.error_msg);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.error_code);
      AppMethodBeat.o(123581);
      return i + paramInt;
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
          AppMethodBeat.o(123581);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwc localbwc = (bwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123581);
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
            localbwc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123581);
          return 0;
        case 2: 
          localbwc.gqB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123581);
          return 0;
        case 3: 
          localbwc.error_msg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123581);
          return 0;
        }
        localbwc.error_code = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123581);
        return 0;
      }
      AppMethodBeat.o(123581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwc
 * JD-Core Version:    0.7.0.1
 */