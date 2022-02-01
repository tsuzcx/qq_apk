package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abx
  extends cvp
{
  public String FyA;
  public boolean Fyz;
  public buq Gbx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211934);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(211934);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gbx != null)
      {
        paramVarArgs.lC(2, this.Gbx.computeSize());
        this.Gbx.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(3, this.Fyz);
      if (this.FyA != null) {
        paramVarArgs.d(4, this.FyA);
      }
      AppMethodBeat.o(211934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gbx != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gbx.computeSize());
      }
      i += f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.FyA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FyA);
      }
      AppMethodBeat.o(211934);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(211934);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211934);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abx localabx = (abx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211934);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211934);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabx.Gbx = ((buq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211934);
          return 0;
        case 3: 
          localabx.Fyz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(211934);
          return 0;
        }
        localabx.FyA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(211934);
        return 0;
      }
      AppMethodBeat.o(211934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abx
 * JD-Core Version:    0.7.0.1
 */