package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czi
  extends com.tencent.mm.bw.a
{
  public long MED;
  public czh MEE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MED);
      if (this.MEE != null)
      {
        paramVarArgs.ni(2, this.MEE.computeSize());
        this.MEE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207013);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.MED) + 0;
      paramInt = i;
      if (this.MEE != null) {
        paramInt = i + g.a.a.a.nh(2, this.MEE.computeSize());
      }
      AppMethodBeat.o(207013);
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
      AppMethodBeat.o(207013);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      czi localczi = (czi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207013);
        return -1;
      case 1: 
        localczi.MED = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(207013);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new czh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((czh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localczi.MEE = ((czh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(207013);
      return 0;
    }
    AppMethodBeat.o(207013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czi
 * JD-Core Version:    0.7.0.1
 */