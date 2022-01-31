package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bv.a
{
  public int wje;
  public int wju;
  public LinkedList<b> wjv;
  public com.tencent.mm.bv.b wjw;
  
  public g()
  {
    AppMethodBeat.i(72823);
    this.wjv = new LinkedList();
    AppMethodBeat.o(72823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72824);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wje);
      paramVarArgs.aO(2, this.wju);
      paramVarArgs.e(3, 8, this.wjv);
      if (this.wjw != null) {
        paramVarArgs.c(4, this.wjw);
      }
      AppMethodBeat.o(72824);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wje) + 0 + e.a.a.b.b.a.bl(2, this.wju) + e.a.a.a.c(3, 8, this.wjv);
      paramInt = i;
      if (this.wjw != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.wjw);
      }
      AppMethodBeat.o(72824);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wjv.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72824);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72824);
        return -1;
      case 1: 
        localg.wje = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72824);
        return 0;
      case 2: 
        localg.wju = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72824);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localg.wjv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72824);
        return 0;
      }
      localg.wjw = ((e.a.a.a.a)localObject1).CLY.eqS();
      AppMethodBeat.o(72824);
      return 0;
    }
    AppMethodBeat.o(72824);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */