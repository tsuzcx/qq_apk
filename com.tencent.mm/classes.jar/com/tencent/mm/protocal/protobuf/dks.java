package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dks
  extends com.tencent.mm.bw.a
{
  public aat MaO;
  public long clK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50102);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.clK);
      if (this.MaO != null)
      {
        paramVarArgs.ni(2, this.MaO.computeSize());
        this.MaO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.clK) + 0;
      paramInt = i;
      if (this.MaO != null) {
        paramInt = i + g.a.a.a.nh(2, this.MaO.computeSize());
      }
      AppMethodBeat.o(50102);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dks localdks = (dks)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50102);
        return -1;
      case 1: 
        localdks.clK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(50102);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aat();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdks.MaO = ((aat)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    AppMethodBeat.o(50102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dks
 * JD-Core Version:    0.7.0.1
 */