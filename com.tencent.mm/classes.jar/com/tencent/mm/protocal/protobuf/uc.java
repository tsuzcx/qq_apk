package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class uc
  extends com.tencent.mm.bv.a
{
  public b wMA;
  public bmf wMB;
  public int wMz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48824);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wMz);
      if (this.wMA != null) {
        paramVarArgs.c(2, this.wMA);
      }
      if (this.wMB != null)
      {
        paramVarArgs.iQ(3, this.wMB.computeSize());
        this.wMB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48824);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wMz) + 0;
      paramInt = i;
      if (this.wMA != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wMA);
      }
      i = paramInt;
      if (this.wMB != null) {
        i = paramInt + e.a.a.a.iP(3, this.wMB.computeSize());
      }
      AppMethodBeat.o(48824);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48824);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      uc localuc = (uc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48824);
        return -1;
      case 1: 
        localuc.wMz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48824);
        return 0;
      case 2: 
        localuc.wMA = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(48824);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bmf();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bmf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localuc.wMB = ((bmf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48824);
      return 0;
    }
    AppMethodBeat.o(48824);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uc
 * JD-Core Version:    0.7.0.1
 */