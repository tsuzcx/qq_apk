package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajb
  extends com.tencent.mm.bw.a
{
  public LinkedList<ene> LsE;
  public int LsF;
  public boolean LsG;
  public int Scene;
  public int xIY;
  
  public ajb()
  {
    AppMethodBeat.i(104763);
    this.LsE = new LinkedList();
    this.LsG = false;
    this.xIY = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LsE);
      paramVarArgs.aM(2, this.LsF);
      paramVarArgs.cc(3, this.LsG);
      paramVarArgs.aM(4, this.xIY);
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.LsE);
      i = g.a.a.b.b.a.bu(2, this.LsF);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.bu(4, this.xIY);
      int m = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LsE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ajb localajb = (ajb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ene();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ene)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localajb.LsE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localajb.LsF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localajb.LsG = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localajb.xIY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104764);
        return 0;
      }
      localajb.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajb
 * JD-Core Version:    0.7.0.1
 */