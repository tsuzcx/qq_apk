package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public int KAB;
  public int KAP;
  public int KAR;
  public LinkedList<e> KAS;
  public b KAT;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.KAS = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KAB);
      paramVarArgs.aM(2, this.KAR);
      paramVarArgs.aM(3, this.KAP);
      paramVarArgs.e(4, 8, this.KAS);
      if (this.KAT != null) {
        paramVarArgs.c(5, this.KAT);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KAB) + 0 + g.a.a.b.b.a.bu(2, this.KAR) + g.a.a.b.b.a.bu(3, this.KAP) + g.a.a.a.c(4, 8, this.KAS);
      paramInt = i;
      if (this.KAT != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.KAT);
      }
      AppMethodBeat.o(143951);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KAS.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143951);
        return -1;
      case 1: 
        locali.KAB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.KAR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.KAP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locali.KAS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.KAT = ((g.a.a.a.a)localObject1).UbS.hPo();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */