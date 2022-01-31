package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mg
  extends com.tencent.mm.bv.a
{
  public int wAI;
  public int wAJ;
  public int wAK;
  public LinkedList<mf> wAL;
  public LinkedList<mf> wAM;
  
  public mg()
  {
    AppMethodBeat.i(58895);
    this.wAL = new LinkedList();
    this.wAM = new LinkedList();
    AppMethodBeat.o(58895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58896);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wAI);
      paramVarArgs.aO(2, this.wAJ);
      paramVarArgs.aO(5, this.wAK);
      paramVarArgs.e(3, 8, this.wAL);
      paramVarArgs.e(4, 8, this.wAM);
      AppMethodBeat.o(58896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wAI);
      i = e.a.a.b.b.a.bl(2, this.wAJ);
      int j = e.a.a.b.b.a.bl(5, this.wAK);
      int k = e.a.a.a.c(3, 8, this.wAL);
      int m = e.a.a.a.c(4, 8, this.wAM);
      AppMethodBeat.o(58896);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wAL.clear();
      this.wAM.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(58896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      mg localmg = (mg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(58896);
        return -1;
      case 1: 
        localmg.wAI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58896);
        return 0;
      case 2: 
        localmg.wAJ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58896);
        return 0;
      case 5: 
        localmg.wAK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58896);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localmg.wAL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58896);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new mf();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((mf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localmg.wAM.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(58896);
      return 0;
    }
    AppMethodBeat.o(58896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mg
 * JD-Core Version:    0.7.0.1
 */