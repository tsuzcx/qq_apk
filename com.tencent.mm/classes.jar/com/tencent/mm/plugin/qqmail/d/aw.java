package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bw.a
{
  public long uin;
  public an xtg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.uin);
      if (this.xtg != null)
      {
        paramVarArgs.lJ(2, this.xtg.computeSize());
        this.xtg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(217985);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.xtg != null) {
        paramInt = i + f.a.a.a.lI(2, this.xtg.computeSize());
      }
      AppMethodBeat.o(217985);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(217985);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aw localaw = (aw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(217985);
        return -1;
      case 1: 
        localaw.uin = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(217985);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new an();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((an)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaw.xtg = ((an)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(217985);
      return 0;
    }
    AppMethodBeat.o(217985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aw
 * JD-Core Version:    0.7.0.1
 */