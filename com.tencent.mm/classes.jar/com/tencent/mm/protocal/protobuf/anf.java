package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anf
  extends com.tencent.mm.bv.a
{
  public int scene;
  public am xdH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28452);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.scene);
      if (this.xdH != null)
      {
        paramVarArgs.iQ(2, this.xdH.computeSize());
        this.xdH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28452);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.scene) + 0;
      paramInt = i;
      if (this.xdH != null) {
        paramInt = i + e.a.a.a.iP(2, this.xdH.computeSize());
      }
      AppMethodBeat.o(28452);
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
      AppMethodBeat.o(28452);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      anf localanf = (anf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28452);
        return -1;
      case 1: 
        localanf.scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28452);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new am();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localanf.xdH = ((am)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28452);
      return 0;
    }
    AppMethodBeat.o(28452);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */