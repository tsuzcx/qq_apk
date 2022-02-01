package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcq
  extends com.tencent.mm.bw.a
{
  public bob FVo;
  public int GSm;
  public int GSn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GSm);
      paramVarArgs.aS(2, this.GSn);
      if (this.FVo != null)
      {
        paramVarArgs.lJ(3, this.FVo.computeSize());
        this.FVo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GSm) + 0 + f.a.a.b.b.a.bz(2, this.GSn);
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.a.lI(3, this.FVo.computeSize());
      }
      AppMethodBeat.o(82410);
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
      if (this.FVo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bcq localbcq = (bcq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82410);
        return -1;
      case 1: 
        localbcq.GSm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82410);
        return 0;
      case 2: 
        localbcq.GSn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82410);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bob();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbcq.FVo = ((bob)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    AppMethodBeat.o(82410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcq
 * JD-Core Version:    0.7.0.1
 */