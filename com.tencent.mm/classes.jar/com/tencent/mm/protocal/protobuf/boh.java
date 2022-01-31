package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boh
  extends com.tencent.mm.bv.a
{
  public int nNu;
  public int wQP;
  public long wQQ;
  public LinkedList<boq> xCB;
  
  public boh()
  {
    AppMethodBeat.i(28584);
    this.xCB = new LinkedList();
    AppMethodBeat.o(28584);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28585);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wQP);
      paramVarArgs.am(2, this.wQQ);
      paramVarArgs.e(3, 8, this.xCB);
      paramVarArgs.aO(4, this.nNu);
      AppMethodBeat.o(28585);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wQP);
      i = e.a.a.b.b.a.p(2, this.wQQ);
      int j = e.a.a.a.c(3, 8, this.xCB);
      int k = e.a.a.b.b.a.bl(4, this.nNu);
      AppMethodBeat.o(28585);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xCB.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28585);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      boh localboh = (boh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28585);
        return -1;
      case 1: 
        localboh.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28585);
        return 0;
      case 2: 
        localboh.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28585);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((boq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localboh.xCB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28585);
        return 0;
      }
      localboh.nNu = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(28585);
      return 0;
    }
    AppMethodBeat.o(28585);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boh
 * JD-Core Version:    0.7.0.1
 */