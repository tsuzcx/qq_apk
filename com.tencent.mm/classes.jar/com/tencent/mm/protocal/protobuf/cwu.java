package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwu
  extends com.tencent.mm.bv.a
{
  public int wzS;
  public boolean xKI;
  public LinkedList<cwn> xaT;
  
  public cwu()
  {
    AppMethodBeat.i(28726);
    this.xaT = new LinkedList();
    AppMethodBeat.o(28726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28727);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xaT);
      paramVarArgs.aO(2, this.wzS);
      paramVarArgs.aS(3, this.xKI);
      AppMethodBeat.o(28727);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.xaT);
      i = e.a.a.b.b.a.bl(2, this.wzS);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(28727);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xaT.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28727);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cwu localcwu = (cwu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28727);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cwn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcwu.xaT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28727);
        return 0;
      case 2: 
        localcwu.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28727);
        return 0;
      }
      localcwu.xKI = ((e.a.a.a.a)localObject1).CLY.emu();
      AppMethodBeat.o(28727);
      return 0;
    }
    AppMethodBeat.o(28727);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwu
 * JD-Core Version:    0.7.0.1
 */