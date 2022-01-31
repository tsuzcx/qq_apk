package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afh
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public int wYB;
  public LinkedList<aaj> wYC;
  public int wYD;
  
  public afh()
  {
    AppMethodBeat.i(118196);
    this.wYC = new LinkedList();
    AppMethodBeat.o(118196);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118197);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wYB);
      paramVarArgs.e(2, 8, this.wYC);
      paramVarArgs.aO(3, this.wYD);
      paramVarArgs.aO(4, this.bsY);
      AppMethodBeat.o(118197);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wYB);
      i = e.a.a.a.c(2, 8, this.wYC);
      int j = e.a.a.b.b.a.bl(3, this.wYD);
      int k = e.a.a.b.b.a.bl(4, this.bsY);
      AppMethodBeat.o(118197);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wYC.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(118197);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      afh localafh = (afh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118197);
        return -1;
      case 1: 
        localafh.wYB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(118197);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localafh.wYC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118197);
        return 0;
      case 3: 
        localafh.wYD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(118197);
        return 0;
      }
      localafh.bsY = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(118197);
      return 0;
    }
    AppMethodBeat.o(118197);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afh
 * JD-Core Version:    0.7.0.1
 */