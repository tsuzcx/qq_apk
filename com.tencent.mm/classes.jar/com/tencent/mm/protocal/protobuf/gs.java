package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gs
  extends com.tencent.mm.bv.a
{
  public LinkedList<gr> wsZ;
  
  public gs()
  {
    AppMethodBeat.i(28325);
    this.wsZ = new LinkedList();
    AppMethodBeat.o(28325);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28326);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).e(1, 8, this.wsZ);
      AppMethodBeat.o(28326);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.wsZ);
      AppMethodBeat.o(28326);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wsZ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28326);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      gs localgs = (gs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28326);
        return -1;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gr();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((gr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localgs.wsZ.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28326);
      return 0;
    }
    AppMethodBeat.o(28326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gs
 * JD-Core Version:    0.7.0.1
 */