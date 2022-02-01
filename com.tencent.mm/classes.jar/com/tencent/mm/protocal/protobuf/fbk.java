package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbk
  extends com.tencent.mm.bw.a
{
  public LinkedList<fbh> NxE;
  public boolean NxF;
  
  public fbk()
  {
    AppMethodBeat.i(110861);
    this.NxE = new LinkedList();
    AppMethodBeat.o(110861);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110862);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.NxE);
      paramVarArgs.cc(2, this.NxF);
      AppMethodBeat.o(110862);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.NxE);
      i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(110862);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NxE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110862);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fbk localfbk = (fbk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110862);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fbh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfbk.NxE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110862);
        return 0;
      }
      localfbk.NxF = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(110862);
      return 0;
    }
    AppMethodBeat.o(110862);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbk
 * JD-Core Version:    0.7.0.1
 */