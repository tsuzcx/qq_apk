package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ces
  extends com.tencent.mm.bv.a
{
  public int xIP;
  public int xPd;
  public LinkedList<cea> xPe;
  public int xPf;
  public int xPg;
  
  public ces()
  {
    AppMethodBeat.i(94600);
    this.xPe = new LinkedList();
    AppMethodBeat.o(94600);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94601);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xPd);
      paramVarArgs.e(2, 8, this.xPe);
      paramVarArgs.aO(3, this.xPf);
      paramVarArgs.aO(4, this.xIP);
      paramVarArgs.aO(5, this.xPg);
      AppMethodBeat.o(94601);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xPd);
      i = e.a.a.a.c(2, 8, this.xPe);
      int j = e.a.a.b.b.a.bl(3, this.xPf);
      int k = e.a.a.b.b.a.bl(4, this.xIP);
      int m = e.a.a.b.b.a.bl(5, this.xPg);
      AppMethodBeat.o(94601);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xPe.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94601);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ces localces = (ces)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94601);
        return -1;
      case 1: 
        localces.xPd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94601);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cea();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cea)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localces.xPe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94601);
        return 0;
      case 3: 
        localces.xPf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94601);
        return 0;
      case 4: 
        localces.xIP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94601);
        return 0;
      }
      localces.xPg = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(94601);
      return 0;
    }
    AppMethodBeat.o(94601);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ces
 * JD-Core Version:    0.7.0.1
 */