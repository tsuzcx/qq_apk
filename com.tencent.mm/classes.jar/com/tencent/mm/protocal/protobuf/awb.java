package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awb
  extends cqk
{
  public String iJU;
  public String iJV;
  public String iKc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32237);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32237);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(2, this.iKc);
      }
      if (this.iJU != null) {
        paramVarArgs.d(3, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(4, this.iJV);
      }
      AppMethodBeat.o(32237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iKc);
      }
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iJU);
      }
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iJV);
      }
      AppMethodBeat.o(32237);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32237);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awb localawb = (awb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32237);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32237);
          return 0;
        case 2: 
          localawb.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32237);
          return 0;
        case 3: 
          localawb.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32237);
          return 0;
        }
        localawb.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32237);
        return 0;
      }
      AppMethodBeat.o(32237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awb
 * JD-Core Version:    0.7.0.1
 */