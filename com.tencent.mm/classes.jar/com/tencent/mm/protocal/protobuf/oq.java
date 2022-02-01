package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oq
  extends com.tencent.mm.bw.a
{
  public int EeA;
  public LinkedList<op> EeB;
  public LinkedList<op> EeC;
  public int Eey;
  public int Eez;
  
  public oq()
  {
    AppMethodBeat.i(133159);
    this.EeB = new LinkedList();
    this.EeC = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eey);
      paramVarArgs.aR(2, this.Eez);
      paramVarArgs.aR(5, this.EeA);
      paramVarArgs.e(3, 8, this.EeB);
      paramVarArgs.e(4, 8, this.EeC);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Eey);
      i = f.a.a.b.b.a.bx(2, this.Eez);
      int j = f.a.a.b.b.a.bx(5, this.EeA);
      int k = f.a.a.a.c(3, 8, this.EeB);
      int m = f.a.a.a.c(4, 8, this.EeC);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EeB.clear();
      this.EeC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      oq localoq = (oq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localoq.Eey = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localoq.Eez = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localoq.EeA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new op();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((op)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoq.EeB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new op();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((op)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localoq.EeC.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    AppMethodBeat.o(133160);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oq
 * JD-Core Version:    0.7.0.1
 */