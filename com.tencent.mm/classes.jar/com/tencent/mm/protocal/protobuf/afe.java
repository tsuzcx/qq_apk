package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afe
  extends com.tencent.mm.bw.a
{
  public int GvC;
  public LinkedList<afd> GvD;
  
  public afe()
  {
    AppMethodBeat.i(115837);
    this.GvD = new LinkedList();
    AppMethodBeat.o(115837);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GvC);
      paramVarArgs.e(2, 8, this.GvD);
      AppMethodBeat.o(115838);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GvC);
      i = f.a.a.a.c(2, 8, this.GvD);
      AppMethodBeat.o(115838);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GvD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afe localafe = (afe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115838);
        return -1;
      case 1: 
        localafe.GvC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115838);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afd();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((afd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localafe.GvD.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    AppMethodBeat.o(115838);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afe
 * JD-Core Version:    0.7.0.1
 */