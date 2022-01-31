package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bjp
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public bjq xxX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60058);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xxX == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(60058);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.xxX != null)
      {
        paramVarArgs.iQ(2, this.xxX.computeSize());
        this.xxX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60058);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.xxX != null) {
        paramInt = i + e.a.a.a.iP(2, this.xxX.computeSize());
      }
      AppMethodBeat.o(60058);
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
      if (this.xxX == null)
      {
        paramVarArgs = new b("Not all required fields were included: OplogRet");
        AppMethodBeat.o(60058);
        throw paramVarArgs;
      }
      AppMethodBeat.o(60058);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bjp localbjp = (bjp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60058);
        return -1;
      case 1: 
        localbjp.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60058);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjq();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bjq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbjp.xxX = ((bjq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(60058);
      return 0;
    }
    AppMethodBeat.o(60058);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjp
 * JD-Core Version:    0.7.0.1
 */