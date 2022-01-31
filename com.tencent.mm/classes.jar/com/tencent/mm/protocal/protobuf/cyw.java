package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyw
  extends com.tencent.mm.bv.a
{
  public LinkedList<cyt> yfR;
  public boolean yfS;
  
  public cyw()
  {
    AppMethodBeat.i(63700);
    this.yfR = new LinkedList();
    AppMethodBeat.o(63700);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.yfR);
      paramVarArgs.aS(2, this.yfS);
      AppMethodBeat.o(63701);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.yfR);
      i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(63701);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yfR.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(63701);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cyw localcyw = (cyw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(63701);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyt();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyw.yfR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63701);
        return 0;
      }
      localcyw.yfS = ((e.a.a.a.a)localObject1).CLY.emu();
      AppMethodBeat.o(63701);
      return 0;
    }
    AppMethodBeat.o(63701);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyw
 * JD-Core Version:    0.7.0.1
 */