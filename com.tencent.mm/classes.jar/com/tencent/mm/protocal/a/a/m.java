package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public int FHQ;
  public int FHR;
  public LinkedList<n> FHS;
  
  public m()
  {
    AppMethodBeat.i(143956);
    this.FHS = new LinkedList();
    AppMethodBeat.o(143956);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHQ);
      paramVarArgs.aS(2, this.FHR);
      paramVarArgs.e(3, 8, this.FHS);
      AppMethodBeat.o(143957);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FHQ);
      i = f.a.a.b.b.a.bz(2, this.FHR);
      int j = f.a.a.a.c(3, 8, this.FHS);
      AppMethodBeat.o(143957);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143957);
        return -1;
      case 1: 
        localm.FHQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143957);
        return 0;
      case 2: 
        localm.FHR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143957);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new n();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localm.FHS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    AppMethodBeat.o(143957);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.m
 * JD-Core Version:    0.7.0.1
 */