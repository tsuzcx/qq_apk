package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class BaseResponse
  extends com.tencent.mm.bv.a
{
  public bwc ErrMsg;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58893);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ErrMsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ErrMsg");
        AppMethodBeat.o(58893);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.ErrMsg != null)
      {
        paramVarArgs.iQ(2, this.ErrMsg.computeSize());
        this.ErrMsg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58893);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.ErrMsg != null) {
        paramInt = i + e.a.a.a.iP(2, this.ErrMsg.computeSize());
      }
      AppMethodBeat.o(58893);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.ErrMsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ErrMsg");
        AppMethodBeat.o(58893);
        throw paramVarArgs;
      }
      AppMethodBeat.o(58893);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      BaseResponse localBaseResponse = (BaseResponse)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(58893);
        return -1;
      case 1: 
        localBaseResponse.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58893);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localBaseResponse.ErrMsg = ((bwc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(58893);
      return 0;
    }
    AppMethodBeat.o(58893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.BaseResponse
 * JD-Core Version:    0.7.0.1
 */