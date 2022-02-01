package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class BaseResponse
  extends com.tencent.mm.bw.a
{
  public cxn ErrMsg;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ErrMsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ErrMsg");
        AppMethodBeat.o(133157);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.ErrMsg != null)
      {
        paramVarArgs.lJ(2, this.ErrMsg.computeSize());
        this.ErrMsg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.ErrMsg != null) {
        paramInt = i + f.a.a.a.lI(2, this.ErrMsg.computeSize());
      }
      AppMethodBeat.o(133157);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.ErrMsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ErrMsg");
        AppMethodBeat.o(133157);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      BaseResponse localBaseResponse = (BaseResponse)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133157);
        return -1;
      case 1: 
        localBaseResponse.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133157);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localBaseResponse.ErrMsg = ((cxn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    AppMethodBeat.o(133157);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.BaseResponse
 * JD-Core Version:    0.7.0.1
 */