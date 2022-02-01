package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqv
  extends cvp
{
  public cqq Hje;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hje == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.id);
      if (this.Hje != null)
      {
        paramVarArgs.lC(2, this.Hje.computeSize());
        this.Hje.writeFields(paramVarArgs);
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.Hje != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hje.computeSize());
      }
      i = paramInt;
      if (this.BaseResponse != null) {
        i = paramInt + f.a.a.a.lB(3, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(32406);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Hje == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32406);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqv localcqv = (cqv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32406);
        return -1;
      case 1: 
        localcqv.id = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32406);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqv.Hje = ((cqq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32406);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new BaseResponse();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcqv.BaseResponse = ((BaseResponse)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32406);
      return 0;
    }
    AppMethodBeat.o(32406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqv
 * JD-Core Version:    0.7.0.1
 */