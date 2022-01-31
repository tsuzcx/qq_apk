package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public int ret;
  public int wje;
  public int wjf;
  public o wjg;
  public o wjh;
  public int wji;
  public int wjj;
  public int wjs;
  public o wjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72822);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ret);
      paramVarArgs.aO(2, this.wje);
      paramVarArgs.aO(3, this.wjf);
      paramVarArgs.aO(4, this.wjs);
      if (this.wjg != null)
      {
        paramVarArgs.iQ(5, this.wjg.computeSize());
        this.wjg.writeFields(paramVarArgs);
      }
      if (this.wjh != null)
      {
        paramVarArgs.iQ(6, this.wjh.computeSize());
        this.wjh.writeFields(paramVarArgs);
      }
      if (this.wjt != null)
      {
        paramVarArgs.iQ(7, this.wjt.computeSize());
        this.wjt.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wji);
      paramVarArgs.aO(9, this.wjj);
      AppMethodBeat.o(72822);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.ret) + 0 + e.a.a.b.b.a.bl(2, this.wje) + e.a.a.b.b.a.bl(3, this.wjf) + e.a.a.b.b.a.bl(4, this.wjs);
      paramInt = i;
      if (this.wjg != null) {
        paramInt = i + e.a.a.a.iP(5, this.wjg.computeSize());
      }
      i = paramInt;
      if (this.wjh != null) {
        i = paramInt + e.a.a.a.iP(6, this.wjh.computeSize());
      }
      paramInt = i;
      if (this.wjt != null) {
        paramInt = i + e.a.a.a.iP(7, this.wjt.computeSize());
      }
      i = e.a.a.b.b.a.bl(8, this.wji);
      int j = e.a.a.b.b.a.bl(9, this.wjj);
      AppMethodBeat.o(72822);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72822);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72822);
        return -1;
      case 1: 
        localf.ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72822);
        return 0;
      case 2: 
        localf.wje = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72822);
        return 0;
      case 3: 
        localf.wjf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72822);
        return 0;
      case 4: 
        localf.wjs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72822);
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
          localf.wjg = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72822);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localf.wjh = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72822);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localf.wjt = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72822);
        return 0;
      case 8: 
        localf.wji = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72822);
        return 0;
      }
      localf.wjj = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72822);
      return 0;
    }
    AppMethodBeat.o(72822);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.f
 * JD-Core Version:    0.7.0.1
 */