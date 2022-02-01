package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class kz
  extends cld
{
  public String CFL;
  public String CFM;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(184127);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.d(2, this.session_id);
      }
      if (this.CFL != null) {
        paramVarArgs.d(3, this.CFL);
      }
      if (this.CFM != null) {
        paramVarArgs.d(4, this.CFM);
      }
      AppMethodBeat.o(184127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.session_id);
      }
      i = paramInt;
      if (this.CFL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFL);
      }
      paramInt = i;
      if (this.CFM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFM);
      }
      AppMethodBeat.o(184127);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(184127);
          throw paramVarArgs;
        }
        AppMethodBeat.o(184127);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        kz localkz = (kz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(184127);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localkz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(184127);
          return 0;
        case 2: 
          localkz.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(184127);
          return 0;
        case 3: 
          localkz.CFL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(184127);
          return 0;
        }
        localkz.CFM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184127);
        return 0;
      }
      AppMethodBeat.o(184127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kz
 * JD-Core Version:    0.7.0.1
 */