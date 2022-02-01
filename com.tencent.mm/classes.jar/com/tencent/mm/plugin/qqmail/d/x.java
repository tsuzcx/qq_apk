package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class x
  extends cvp
{
  public String xcl;
  public String xcm;
  public String xcn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215222);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(215222);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xcl != null) {
        paramVarArgs.d(2, this.xcl);
      }
      if (this.xcm != null) {
        paramVarArgs.d(3, this.xcm);
      }
      if (this.xcn != null) {
        paramVarArgs.d(4, this.xcn);
      }
      AppMethodBeat.o(215222);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xcl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xcl);
      }
      i = paramInt;
      if (this.xcm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xcm);
      }
      paramInt = i;
      if (this.xcn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xcn);
      }
      AppMethodBeat.o(215222);
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
          AppMethodBeat.o(215222);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215222);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215222);
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
            localx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215222);
          return 0;
        case 2: 
          localx.xcl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215222);
          return 0;
        case 3: 
          localx.xcm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215222);
          return 0;
        }
        localx.xcn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215222);
        return 0;
      }
      AppMethodBeat.o(215222);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.x
 * JD-Core Version:    0.7.0.1
 */