package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czg
  extends com.tencent.mm.bw.a
{
  public LinkedList<czf> nIE;
  
  public czg()
  {
    AppMethodBeat.i(117912);
    this.nIE = new LinkedList();
    AppMethodBeat.o(117912);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117913);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).e(1, 8, this.nIE);
      AppMethodBeat.o(117913);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.nIE);
      AppMethodBeat.o(117913);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nIE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117913);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      czg localczg = (czg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117913);
        return -1;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new czf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((czf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localczg.nIE.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117913);
      return 0;
    }
    AppMethodBeat.o(117913);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czg
 * JD-Core Version:    0.7.0.1
 */