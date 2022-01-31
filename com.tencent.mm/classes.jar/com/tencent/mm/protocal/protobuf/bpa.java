package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpa
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public LinkedList<boz> xDg;
  public int xeq;
  
  public bpa()
  {
    AppMethodBeat.i(73748);
    this.xDg = new LinkedList();
    AppMethodBeat.o(73748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73749);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xeq);
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.xDg);
      AppMethodBeat.o(73749);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xeq);
      i = e.a.a.b.b.a.bl(2, this.jJu);
      int j = e.a.a.a.c(3, 8, this.xDg);
      AppMethodBeat.o(73749);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xDg.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73749);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bpa localbpa = (bpa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(73749);
        return -1;
      case 1: 
        localbpa.xeq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73749);
        return 0;
      case 2: 
        localbpa.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73749);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new boz();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbpa.xDg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(73749);
      return 0;
    }
    AppMethodBeat.o(73749);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpa
 * JD-Core Version:    0.7.0.1
 */