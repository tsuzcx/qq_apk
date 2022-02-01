package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bex
  extends cqk
{
  public int error_code;
  public String error_msg;
  public String fre;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123581);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fre != null) {
        paramVarArgs.d(2, this.fre);
      }
      if (this.error_msg != null) {
        paramVarArgs.d(3, this.error_msg);
      }
      paramVarArgs.aR(4, this.error_code);
      AppMethodBeat.o(123581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fre != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fre);
      }
      i = paramInt;
      if (this.error_msg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.error_msg);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.error_code);
      AppMethodBeat.o(123581);
      return i + paramInt;
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
          AppMethodBeat.o(123581);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bex localbex = (bex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123581);
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
            localbex.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123581);
          return 0;
        case 2: 
          localbex.fre = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123581);
          return 0;
        case 3: 
          localbex.error_msg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123581);
          return 0;
        }
        localbex.error_code = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123581);
        return 0;
      }
      AppMethodBeat.o(123581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bex
 * JD-Core Version:    0.7.0.1
 */