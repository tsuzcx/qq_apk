package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public long zDJ;
  public LinkedList<k> zHX;
  public long zHY;
  
  public j()
  {
    AppMethodBeat.i(179119);
    this.zHX = new LinkedList();
    AppMethodBeat.o(179119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.zHX);
      paramVarArgs.aZ(2, this.zHY);
      paramVarArgs.aZ(3, this.zDJ);
      AppMethodBeat.o(179120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.zHX);
      i = f.a.a.b.b.a.p(2, this.zHY);
      int j = f.a.a.b.b.a.p(3, this.zDJ);
      AppMethodBeat.o(179120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zHX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.zHX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(179120);
        return 0;
      case 2: 
        localj.zHY = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(179120);
        return 0;
      }
      localj.zDJ = ((f.a.a.a.a)localObject1).OmT.zd();
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