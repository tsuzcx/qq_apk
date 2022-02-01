package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctt
  extends com.tencent.mm.bw.a
{
  public LinkedList<tx> Lps;
  public int Lpt;
  public int Lpu;
  public long lastUpdateTime;
  public int version;
  
  public ctt()
  {
    AppMethodBeat.i(32357);
    this.Lps = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Lps);
      paramVarArgs.aM(2, this.version);
      paramVarArgs.aM(3, this.Lpt);
      paramVarArgs.aM(4, this.Lpu);
      paramVarArgs.bb(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Lps);
      i = g.a.a.b.b.a.bu(2, this.version);
      int j = g.a.a.b.b.a.bu(3, this.Lpt);
      int k = g.a.a.b.b.a.bu(4, this.Lpu);
      int m = g.a.a.b.b.a.r(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lps.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ctt localctt = (ctt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((tx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localctt.Lps.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localctt.version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localctt.Lpt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localctt.Lpu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32358);
        return 0;
      }
      localctt.lastUpdateTime = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctt
 * JD-Core Version:    0.7.0.1
 */