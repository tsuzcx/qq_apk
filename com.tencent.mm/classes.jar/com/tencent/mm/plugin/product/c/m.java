package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public String Bae;
  public String Baf;
  public LinkedList<h> Bag;
  
  public m()
  {
    AppMethodBeat.i(91280);
    this.Bag = new LinkedList();
    AppMethodBeat.o(91280);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Bae != null) {
        paramVarArgs.e(1, this.Bae);
      }
      if (this.Baf != null) {
        paramVarArgs.e(2, this.Baf);
      }
      paramVarArgs.e(3, 8, this.Bag);
      AppMethodBeat.o(91281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bae == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.Bae) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Baf != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Baf);
      }
      paramInt = g.a.a.a.c(3, 8, this.Bag);
      AppMethodBeat.o(91281);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Bag.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91281);
          return -1;
        case 1: 
          localm.Bae = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91281);
          return 0;
        case 2: 
          localm.Baf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91281);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localm.Bag.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91281);
        return 0;
      }
      AppMethodBeat.o(91281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.m
 * JD-Core Version:    0.7.0.1
 */