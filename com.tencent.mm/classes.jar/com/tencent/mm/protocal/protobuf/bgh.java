package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgh
  extends cvp
{
  public String tnT;
  public String tnU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32263);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32263);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.tnT != null) {
        paramVarArgs.d(2, this.tnT);
      }
      if (this.tnU != null) {
        paramVarArgs.d(3, this.tnU);
      }
      AppMethodBeat.o(32263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label491;
      }
    }
    label491:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tnT);
      }
      i = paramInt;
      if (this.tnU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tnU);
      }
      AppMethodBeat.o(32263);
      return i;
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
          AppMethodBeat.o(32263);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgh localbgh = (bgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32263);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32263);
          return 0;
        case 2: 
          localbgh.tnT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32263);
          return 0;
        }
        localbgh.tnU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32263);
        return 0;
      }
      AppMethodBeat.o(32263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgh
 * JD-Core Version:    0.7.0.1
 */