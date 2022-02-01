package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgp
  extends cvp
{
  public caq GBT;
  public dtw GBU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.GBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.GBU == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GBT != null)
      {
        paramVarArgs.lC(2, this.GBT.computeSize());
        this.GBT.writeFields(paramVarArgs);
      }
      if (this.GBU != null)
      {
        paramVarArgs.lC(3, this.GBU.computeSize());
        this.GBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GBT != null) {
        paramInt = i + f.a.a.a.lB(2, this.GBT.computeSize());
      }
      i = paramInt;
      if (this.GBU != null) {
        i = paramInt + f.a.a.a.lB(3, this.GBU.computeSize());
      }
      AppMethodBeat.o(134246);
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
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.GBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.GBU == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfoExt");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgp localbgp = (bgp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134246);
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
            localbgp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgp.GBT = ((caq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgp.GBU = ((dtw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      AppMethodBeat.o(134246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgp
 * JD-Core Version:    0.7.0.1
 */