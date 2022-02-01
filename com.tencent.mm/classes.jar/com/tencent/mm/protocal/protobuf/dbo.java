package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbo
  extends com.tencent.mm.bw.a
{
  public LinkedList<pe> MGw;
  public LinkedList<String> MGx;
  public LinkedList<String> MGy;
  
  public dbo()
  {
    AppMethodBeat.i(212283);
    this.MGw = new LinkedList();
    this.MGx = new LinkedList();
    this.MGy = new LinkedList();
    AppMethodBeat.o(212283);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212284);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.MGw);
      paramVarArgs.e(2, 1, this.MGx);
      paramVarArgs.e(3, 1, this.MGy);
      AppMethodBeat.o(212284);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.MGw);
      i = g.a.a.a.c(2, 1, this.MGx);
      int j = g.a.a.a.c(3, 1, this.MGy);
      AppMethodBeat.o(212284);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MGw.clear();
      this.MGx.clear();
      this.MGy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212284);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dbo localdbo = (dbo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212284);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbo.MGw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212284);
        return 0;
      case 2: 
        localdbo.MGx.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(212284);
        return 0;
      }
      localdbo.MGy.add(((g.a.a.a.a)localObject1).UbS.readString());
      AppMethodBeat.o(212284);
      return 0;
    }
    AppMethodBeat.o(212284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */