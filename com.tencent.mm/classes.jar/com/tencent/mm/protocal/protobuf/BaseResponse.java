package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class BaseResponse
  extends com.tencent.mm.bw.a
{
  public dqi ErrMsg;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133157);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ErrMsg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ErrMsg");
        AppMethodBeat.o(133157);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.ErrMsg != null)
      {
        paramVarArgs.ni(2, this.ErrMsg.computeSize());
        this.ErrMsg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.ErrMsg != null) {
        paramInt = i + g.a.a.a.nh(2, this.ErrMsg.computeSize());
      }
      AppMethodBeat.o(133157);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      BaseResponse localBaseResponse = (BaseResponse)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133157);
        return -1;
      case 1: 
        localBaseResponse.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133157);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localBaseResponse.ErrMsg = ((dqi)localObject1);
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