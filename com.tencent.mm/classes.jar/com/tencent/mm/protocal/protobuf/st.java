package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class st
  extends com.tencent.mm.bw.a
{
  public boolean EHr;
  public LinkedList<su> LaK;
  
  public st()
  {
    AppMethodBeat.i(226014);
    this.LaK = new LinkedList();
    AppMethodBeat.o(226014);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226015);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LaK);
      paramVarArgs.cc(2, this.EHr);
      AppMethodBeat.o(226015);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.LaK);
      i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(226015);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LaK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(226015);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      st localst = (st)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(226015);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new su();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((su)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localst.LaK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(226015);
        return 0;
      }
      localst.EHr = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(226015);
      return 0;
    }
    AppMethodBeat.o(226015);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */