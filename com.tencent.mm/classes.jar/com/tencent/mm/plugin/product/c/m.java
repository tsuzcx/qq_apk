package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public String xcC;
  public String xcD;
  public LinkedList<h> xcE;
  
  public m()
  {
    AppMethodBeat.i(91280);
    this.xcE = new LinkedList();
    AppMethodBeat.o(91280);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91281);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcC != null) {
        paramVarArgs.d(1, this.xcC);
      }
      if (this.xcD != null) {
        paramVarArgs.d(2, this.xcD);
      }
      paramVarArgs.e(3, 8, this.xcE);
      AppMethodBeat.o(91281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xcC == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.xcC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xcD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xcD);
      }
      paramInt = f.a.a.a.c(3, 8, this.xcE);
      AppMethodBeat.o(91281);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91281);
          return -1;
        case 1: 
          localm.xcC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91281);
          return 0;
        case 2: 
          localm.xcD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91281);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.xcE.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.m
 * JD-Core Version:    0.7.0.1
 */