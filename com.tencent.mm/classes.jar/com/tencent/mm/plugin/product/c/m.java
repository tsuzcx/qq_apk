package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bv.a
{
  public String pvf;
  public String pvg;
  public LinkedList<h> pvh;
  
  public m()
  {
    AppMethodBeat.i(56637);
    this.pvh = new LinkedList();
    AppMethodBeat.o(56637);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56638);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pvf != null) {
        paramVarArgs.e(1, this.pvf);
      }
      if (this.pvg != null) {
        paramVarArgs.e(2, this.pvg);
      }
      paramVarArgs.e(3, 8, this.pvh);
      AppMethodBeat.o(56638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pvf == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.b.b.a.f(1, this.pvf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pvg != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.pvg);
      }
      paramInt = e.a.a.a.c(3, 8, this.pvh);
      AppMethodBeat.o(56638);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pvh.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56638);
          return -1;
        case 1: 
          localm.pvf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56638);
          return 0;
        case 2: 
          localm.pvg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56638);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localm.pvh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56638);
        return 0;
      }
      AppMethodBeat.o(56638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.m
 * JD-Core Version:    0.7.0.1
 */