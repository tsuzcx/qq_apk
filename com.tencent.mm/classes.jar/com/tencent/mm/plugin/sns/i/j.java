package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public long zmu;
  public LinkedList<k> zqI;
  public long zqJ;
  
  public j()
  {
    AppMethodBeat.i(179119);
    this.zqI = new LinkedList();
    AppMethodBeat.o(179119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.zqI);
      paramVarArgs.aY(2, this.zqJ);
      paramVarArgs.aY(3, this.zmu);
      AppMethodBeat.o(179120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.zqI);
      i = f.a.a.b.b.a.p(2, this.zqJ);
      int j = f.a.a.b.b.a.p(3, this.zmu);
      AppMethodBeat.o(179120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zqI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(179120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(179120);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.zqI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(179120);
        return 0;
      case 2: 
        localj.zqJ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(179120);
        return 0;
      }
      localj.zmu = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(179120);
      return 0;
    }
    AppMethodBeat.o(179120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.j
 * JD-Core Version:    0.7.0.1
 */