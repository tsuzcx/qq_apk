package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String por;
  public LinkedList<d> tTW;
  
  public c()
  {
    AppMethodBeat.i(56643);
    this.tTW = new LinkedList();
    AppMethodBeat.o(56643);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56644);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.por != null) {
        paramVarArgs.e(1, this.por);
      }
      paramVarArgs.e(2, 8, this.tTW);
      AppMethodBeat.o(56644);
      return 0;
    }
    if (paramInt == 1) {
      if (this.por == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.b.b.a.f(1, this.por) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.tTW);
      AppMethodBeat.o(56644);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tTW.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56644);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56644);
          return -1;
        case 1: 
          localc.por = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56644);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.tTW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56644);
        return 0;
      }
      AppMethodBeat.o(56644);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.c
 * JD-Core Version:    0.7.0.1
 */