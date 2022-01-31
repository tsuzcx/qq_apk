package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cei
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int xOG;
  public bwc xOH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94587);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xOG);
      if (this.xOH != null)
      {
        paramVarArgs.iQ(2, this.xOH.computeSize());
        this.xOH.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(94587);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xOG) + 0;
      paramInt = i;
      if (this.xOH != null) {
        paramInt = i + e.a.a.a.iP(2, this.xOH.computeSize());
      }
      i = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(94587);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94587);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cei localcei = (cei)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94587);
        return -1;
      case 1: 
        localcei.xOG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94587);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcei.xOH = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94587);
        return 0;
      }
      localcei.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(94587);
      return 0;
    }
    AppMethodBeat.o(94587);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cei
 * JD-Core Version:    0.7.0.1
 */