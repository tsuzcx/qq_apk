package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public int wje;
  public int wjs;
  public int wju;
  public LinkedList<e> wjv;
  public b wjw;
  
  public i()
  {
    AppMethodBeat.i(72826);
    this.wjv = new LinkedList();
    AppMethodBeat.o(72826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72827);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wje);
      paramVarArgs.aO(2, this.wju);
      paramVarArgs.aO(3, this.wjs);
      paramVarArgs.e(4, 8, this.wjv);
      if (this.wjw != null) {
        paramVarArgs.c(5, this.wjw);
      }
      AppMethodBeat.o(72827);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wje) + 0 + e.a.a.b.b.a.bl(2, this.wju) + e.a.a.b.b.a.bl(3, this.wjs) + e.a.a.a.c(4, 8, this.wjv);
      paramInt = i;
      if (this.wjw != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.wjw);
      }
      AppMethodBeat.o(72827);
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
      AppMethodBeat.o(72827);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72827);
        return -1;
      case 1: 
        locali.wje = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72827);
        return 0;
      case 2: 
        locali.wju = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72827);
        return 0;
      case 3: 
        locali.wjs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72827);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locali.wjv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72827);
        return 0;
      }
      locali.wjw = ((e.a.a.a.a)localObject1).CLY.eqS();
      AppMethodBeat.o(72827);
      return 0;
    }
    AppMethodBeat.o(72827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */