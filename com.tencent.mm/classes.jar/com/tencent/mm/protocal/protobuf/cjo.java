package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cjo
  extends com.tencent.mm.bv.a
{
  public bwc xTE;
  public int xoo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28668);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(28668);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xoo);
      if (this.xTE != null)
      {
        paramVarArgs.iQ(2, this.xTE.computeSize());
        this.xTE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xoo) + 0;
      paramInt = i;
      if (this.xTE != null) {
        paramInt = i + e.a.a.a.iP(2, this.xTE.computeSize());
      }
      AppMethodBeat.o(28668);
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
      if (this.xTE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(28668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cjo localcjo = (cjo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28668);
        return -1;
      case 1: 
        localcjo.xoo = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28668);
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
        localcjo.xTE = ((bwc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28668);
      return 0;
    }
    AppMethodBeat.o(28668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */