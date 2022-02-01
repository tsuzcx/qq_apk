package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgr
  extends cvp
{
  public cnu GBV;
  public cns GBW;
  public int gsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.GBV == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.GBW == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.gsV);
      if (this.GBV != null)
      {
        paramVarArgs.lC(3, this.GBV.computeSize());
        this.GBV.writeFields(paramVarArgs);
      }
      if (this.GBW != null)
      {
        paramVarArgs.lC(4, this.GBW.computeSize());
        this.GBW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.gsV);
      paramInt = i;
      if (this.GBV != null) {
        paramInt = i + f.a.a.a.lB(3, this.GBV.computeSize());
      }
      i = paramInt;
      if (this.GBW != null) {
        i = paramInt + f.a.a.a.lB(4, this.GBW.computeSize());
      }
      AppMethodBeat.o(155413);
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
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.GBV == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.GBW == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgr localbgr = (bgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155413);
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
            localbgr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        case 2: 
          localbgr.gsV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155413);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgr.GBV = ((cnu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cns();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgr.GBW = ((cns)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      AppMethodBeat.o(155413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgr
 * JD-Core Version:    0.7.0.1
 */