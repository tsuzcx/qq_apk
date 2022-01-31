package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public String iuQ;
  public g pvb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56633);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.bsY);
      if (this.pvb != null)
      {
        paramVarArgs.iQ(2, this.pvb.computeSize());
        this.pvb.writeFields(paramVarArgs);
      }
      if (this.iuQ != null) {
        paramVarArgs.e(3, this.iuQ);
      }
      AppMethodBeat.o(56633);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.bsY) + 0;
      paramInt = i;
      if (this.pvb != null) {
        paramInt = i + e.a.a.a.iP(2, this.pvb.computeSize());
      }
      i = paramInt;
      if (this.iuQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.iuQ);
      }
      AppMethodBeat.o(56633);
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
      AppMethodBeat.o(56633);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56633);
        return -1;
      case 1: 
        localj.bsY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56633);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.pvb = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56633);
        return 0;
      }
      localj.iuQ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56633);
      return 0;
    }
    AppMethodBeat.o(56633);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.j
 * JD-Core Version:    0.7.0.1
 */