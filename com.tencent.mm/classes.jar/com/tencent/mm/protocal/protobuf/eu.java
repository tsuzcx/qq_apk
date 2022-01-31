package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eu
  extends com.tencent.mm.bv.a
{
  public LinkedList<et> wqW;
  
  public eu()
  {
    AppMethodBeat.i(11692);
    this.wqW = new LinkedList();
    AppMethodBeat.o(11692);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11693);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).e(1, 8, this.wqW);
      AppMethodBeat.o(11693);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.wqW);
      AppMethodBeat.o(11693);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wqW.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(11693);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      eu localeu = (eu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(11693);
        return -1;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new et();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((et)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localeu.wqW.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(11693);
      return 0;
    }
    AppMethodBeat.o(11693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eu
 * JD-Core Version:    0.7.0.1
 */