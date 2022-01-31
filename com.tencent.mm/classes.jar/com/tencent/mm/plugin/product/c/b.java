package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public String name;
  public LinkedList<i> puJ;
  
  public b()
  {
    AppMethodBeat.i(56622);
    this.puJ = new LinkedList();
    AppMethodBeat.o(56622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56623);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.e(2, 8, this.puJ);
      AppMethodBeat.o(56623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.puJ);
      AppMethodBeat.o(56623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.puJ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56623);
          return -1;
        case 1: 
          localb.name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56623);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localb.puJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56623);
        return 0;
      }
      AppMethodBeat.o(56623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.b
 * JD-Core Version:    0.7.0.1
 */