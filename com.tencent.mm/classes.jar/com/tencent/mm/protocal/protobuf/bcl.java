package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcl
  extends cvp
{
  public String Gzc;
  public String Gzd;
  public String tRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32242);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32242);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gzc != null) {
        paramVarArgs.d(2, this.Gzc);
      }
      if (this.Gzd != null) {
        paramVarArgs.d(3, this.Gzd);
      }
      if (this.tRU != null) {
        paramVarArgs.d(4, this.tRU);
      }
      AppMethodBeat.o(32242);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gzc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gzc);
      }
      i = paramInt;
      if (this.Gzd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gzd);
      }
      paramInt = i;
      if (this.tRU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tRU);
      }
      AppMethodBeat.o(32242);
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
          AppMethodBeat.o(32242);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32242);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcl localbcl = (bcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32242);
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
            localbcl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32242);
          return 0;
        case 2: 
          localbcl.Gzc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32242);
          return 0;
        case 3: 
          localbcl.Gzd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32242);
          return 0;
        }
        localbcl.tRU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32242);
        return 0;
      }
      AppMethodBeat.o(32242);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcl
 * JD-Core Version:    0.7.0.1
 */