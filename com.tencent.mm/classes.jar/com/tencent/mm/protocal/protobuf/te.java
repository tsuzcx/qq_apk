package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class te
  extends com.tencent.mm.bw.a
{
  public LinkedList<tf> Gjn;
  
  public te()
  {
    AppMethodBeat.i(218609);
    this.Gjn = new LinkedList();
    AppMethodBeat.o(218609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218610);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).e(1, 8, this.Gjn);
      AppMethodBeat.o(218610);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.Gjn);
      AppMethodBeat.o(218610);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gjn.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(218610);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      te localte = (te)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(218610);
        return -1;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new tf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((tf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localte.Gjn.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(218610);
      return 0;
    }
    AppMethodBeat.o(218610);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.te
 * JD-Core Version:    0.7.0.1
 */