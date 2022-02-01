package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gx
  extends dpc
{
  public String KDS;
  public boolean KKE;
  public String KKF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(207459);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KDS != null) {
        paramVarArgs.e(2, this.KDS);
      }
      paramVarArgs.cc(3, this.KKE);
      if (this.KKF != null) {
        paramVarArgs.e(4, this.KKF);
      }
      AppMethodBeat.o(207459);
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
      if (this.KDS != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KDS);
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.KKF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KKF);
      }
      AppMethodBeat.o(207459);
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
          AppMethodBeat.o(207459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gx localgx = (gx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207459);
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
            localgx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207459);
          return 0;
        case 2: 
          localgx.KDS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207459);
          return 0;
        case 3: 
          localgx.KKE = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(207459);
          return 0;
        }
        localgx.KKF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(207459);
        return 0;
      }
      AppMethodBeat.o(207459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */