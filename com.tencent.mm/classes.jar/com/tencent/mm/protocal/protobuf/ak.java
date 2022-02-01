package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ak
  extends com.tencent.mm.bw.a
{
  public int KCZ;
  public int KDa;
  public int KDb;
  public LinkedList<ai> KDc;
  public int KDd;
  public LinkedList<ai> KDe;
  
  public ak()
  {
    AppMethodBeat.i(143963);
    this.KDc = new LinkedList();
    this.KDe = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KCZ);
      paramVarArgs.aM(2, this.KDb);
      paramVarArgs.e(3, 8, this.KDc);
      paramVarArgs.aM(4, this.KDa);
      paramVarArgs.aM(5, this.KDd);
      paramVarArgs.e(6, 8, this.KDe);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KCZ);
      i = g.a.a.b.b.a.bu(2, this.KDb);
      int j = g.a.a.a.c(3, 8, this.KDc);
      int k = g.a.a.b.b.a.bu(4, this.KDa);
      int m = g.a.a.b.b.a.bu(5, this.KDd);
      int n = g.a.a.a.c(6, 8, this.KDe);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KDc.clear();
      this.KDe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ak localak = (ak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143964);
        return -1;
      case 1: 
        localak.KCZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localak.KDb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ai();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localak.KDc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localak.KDa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localak.KDd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ai();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localak.KDe.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    AppMethodBeat.o(143964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */