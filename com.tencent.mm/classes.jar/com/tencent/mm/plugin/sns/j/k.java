package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public long DNN;
  public LinkedList<l> DRY;
  public long DRZ;
  
  public k()
  {
    AppMethodBeat.i(179119);
    this.DRY = new LinkedList();
    AppMethodBeat.o(179119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DRY);
      paramVarArgs.bb(2, this.DRZ);
      paramVarArgs.bb(3, this.DNN);
      AppMethodBeat.o(179120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.DRY);
      i = g.a.a.b.b.a.r(2, this.DRZ);
      int j = g.a.a.b.b.a.r(3, this.DNN);
      AppMethodBeat.o(179120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DRY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(179120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(179120);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localk.DRY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(179120);
        return 0;
      case 2: 
        localk.DRZ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(179120);
        return 0;
      }
      localk.DNN = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(179120);
      return 0;
    }
    AppMethodBeat.o(179120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.k
 * JD-Core Version:    0.7.0.1
 */