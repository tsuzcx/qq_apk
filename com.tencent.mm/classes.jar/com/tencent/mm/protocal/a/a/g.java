package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public int KAB;
  public int KAR;
  public LinkedList<b> KAS;
  public com.tencent.mm.bw.b KAT;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.KAS = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KAB);
      paramVarArgs.aM(2, this.KAR);
      paramVarArgs.e(3, 8, this.KAS);
      if (this.KAT != null) {
        paramVarArgs.c(4, this.KAT);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KAB) + 0 + g.a.a.b.b.a.bu(2, this.KAR) + g.a.a.a.c(3, 8, this.KAS);
      paramInt = i;
      if (this.KAT != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.KAT);
      }
      AppMethodBeat.o(143948);
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
      AppMethodBeat.o(143948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143948);
        return -1;
      case 1: 
        localg.KAB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.KAR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localg.KAS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.KAT = ((g.a.a.a.a)localObject1).UbS.hPo();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */