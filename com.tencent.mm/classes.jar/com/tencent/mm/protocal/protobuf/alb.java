package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class alb
  extends dpc
{
  public int KLp;
  public String UserName;
  public String hio;
  public int oTW;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(256408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBx);
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      paramVarArgs.aM(4, this.oTW);
      paramVarArgs.aM(5, this.KLp);
      if (this.hio != null) {
        paramVarArgs.e(6, this.hio);
      }
      AppMethodBeat.o(256408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBx);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.UserName);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.KLp);
      paramInt = i;
      if (this.hio != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.hio);
      }
      AppMethodBeat.o(256408);
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
          AppMethodBeat.o(256408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alb localalb = (alb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256408);
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
            localalb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256408);
          return 0;
        case 2: 
          localalb.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256408);
          return 0;
        case 3: 
          localalb.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256408);
          return 0;
        case 4: 
          localalb.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256408);
          return 0;
        case 5: 
          localalb.KLp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256408);
          return 0;
        }
        localalb.hio = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256408);
        return 0;
      }
      AppMethodBeat.o(256408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alb
 * JD-Core Version:    0.7.0.1
 */