package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public int ret;
  public int wje;
  public int wjf;
  public o wjg;
  public o wjh;
  public int wji;
  public int wjj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72818);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ret);
      paramVarArgs.aO(2, this.wje);
      paramVarArgs.aO(3, this.wjf);
      if (this.wjg != null)
      {
        paramVarArgs.iQ(4, this.wjg.computeSize());
        this.wjg.writeFields(paramVarArgs);
      }
      if (this.wjh != null)
      {
        paramVarArgs.iQ(5, this.wjh.computeSize());
        this.wjh.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wji);
      paramVarArgs.aO(7, this.wjj);
      AppMethodBeat.o(72818);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.ret) + 0 + e.a.a.b.b.a.bl(2, this.wje) + e.a.a.b.b.a.bl(3, this.wjf);
      paramInt = i;
      if (this.wjg != null) {
        paramInt = i + e.a.a.a.iP(4, this.wjg.computeSize());
      }
      i = paramInt;
      if (this.wjh != null) {
        i = paramInt + e.a.a.a.iP(5, this.wjh.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wji);
      int j = e.a.a.b.b.a.bl(7, this.wjj);
      AppMethodBeat.o(72818);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72818);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72818);
        return -1;
      case 1: 
        localc.ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72818);
        return 0;
      case 2: 
        localc.wje = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72818);
        return 0;
      case 3: 
        localc.wjf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72818);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.wjg = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72818);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.wjh = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72818);
        return 0;
      case 6: 
        localc.wji = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72818);
        return 0;
      }
      localc.wjj = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72818);
      return 0;
    }
    AppMethodBeat.o(72818);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.c
 * JD-Core Version:    0.7.0.1
 */