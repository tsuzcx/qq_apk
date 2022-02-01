package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djj
  extends com.tencent.mm.bw.a
{
  public LinkedList<djk> MNv;
  public int count;
  public int qwL;
  
  public djj()
  {
    AppMethodBeat.i(32400);
    this.MNv = new LinkedList();
    AppMethodBeat.o(32400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32401);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.count);
      paramVarArgs.e(2, 8, this.MNv);
      paramVarArgs.aM(3, this.qwL);
      AppMethodBeat.o(32401);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.count);
      i = g.a.a.a.c(2, 8, this.MNv);
      int j = g.a.a.b.b.a.bu(3, this.qwL);
      AppMethodBeat.o(32401);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MNv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32401);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      djj localdjj = (djj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32401);
        return -1;
      case 1: 
        localdjj.count = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32401);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((djk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdjj.MNv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32401);
        return 0;
      }
      localdjj.qwL = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(32401);
      return 0;
    }
    AppMethodBeat.o(32401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djj
 * JD-Core Version:    0.7.0.1
 */