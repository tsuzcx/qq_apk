package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cex
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public LinkedList<bwc> jJv;
  public String ntn;
  public long xPq;
  
  public cex()
  {
    AppMethodBeat.i(94606);
    this.jJv = new LinkedList();
    AppMethodBeat.o(94606);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94607);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xPq);
      if (this.ntn != null) {
        paramVarArgs.e(2, this.ntn);
      }
      paramVarArgs.aO(3, this.jJu);
      paramVarArgs.e(4, 8, this.jJv);
      AppMethodBeat.o(94607);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.xPq) + 0;
      paramInt = i;
      if (this.ntn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntn);
      }
      i = e.a.a.b.b.a.bl(3, this.jJu);
      int j = e.a.a.a.c(4, 8, this.jJv);
      AppMethodBeat.o(94607);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jJv.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94607);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cex localcex = (cex)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94607);
        return -1;
      case 1: 
        localcex.xPq = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94607);
        return 0;
      case 2: 
        localcex.ntn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94607);
        return 0;
      case 3: 
        localcex.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94607);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcex.jJv.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94607);
      return 0;
    }
    AppMethodBeat.o(94607);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cex
 * JD-Core Version:    0.7.0.1
 */