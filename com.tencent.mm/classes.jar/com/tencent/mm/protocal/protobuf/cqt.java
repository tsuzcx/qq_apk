package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqt
  extends com.tencent.mm.bv.a
{
  public int xZh;
  public bfj xZi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124373);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xZh);
      if (this.xZi != null)
      {
        paramVarArgs.iQ(3, this.xZi.computeSize());
        this.xZi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124373);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xZh) + 0;
      paramInt = i;
      if (this.xZi != null) {
        paramInt = i + e.a.a.a.iP(3, this.xZi.computeSize());
      }
      AppMethodBeat.o(124373);
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
      AppMethodBeat.o(124373);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cqt localcqt = (cqt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124373);
        return -1;
      case 1: 
        localcqt.xZh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124373);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfj();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcqt.xZi = ((bfj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124373);
      return 0;
    }
    AppMethodBeat.o(124373);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqt
 * JD-Core Version:    0.7.0.1
 */