package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auw
  extends com.tencent.mm.bv.a
{
  public int xkc;
  public LinkedList<bfe> xkd;
  public int xke;
  
  public auw()
  {
    AppMethodBeat.i(72853);
    this.xkd = new LinkedList();
    AppMethodBeat.o(72853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72854);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xkc);
      paramVarArgs.e(2, 8, this.xkd);
      paramVarArgs.aO(3, this.xke);
      AppMethodBeat.o(72854);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xkc);
      i = e.a.a.a.c(2, 8, this.xkd);
      int j = e.a.a.b.b.a.bl(3, this.xke);
      AppMethodBeat.o(72854);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xkd.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72854);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      auw localauw = (auw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72854);
        return -1;
      case 1: 
        localauw.xkc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72854);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfe();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bfe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localauw.xkd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72854);
        return 0;
      }
      localauw.xke = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72854);
      return 0;
    }
    AppMethodBeat.o(72854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */