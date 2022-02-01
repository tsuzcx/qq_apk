package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyq
  extends com.tencent.mm.bw.a
{
  public LinkedList<eyp> oTA;
  
  public eyq()
  {
    AppMethodBeat.i(32528);
    this.oTA = new LinkedList();
    AppMethodBeat.o(32528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32529);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.oTA);
      AppMethodBeat.o(32529);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.oTA);
      AppMethodBeat.o(32529);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oTA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32529);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eyq localeyq = (eyq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32529);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eyp();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((eyp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeyq.oTA.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32529);
      return 0;
    }
    AppMethodBeat.o(32529);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyq
 * JD-Core Version:    0.7.0.1
 */