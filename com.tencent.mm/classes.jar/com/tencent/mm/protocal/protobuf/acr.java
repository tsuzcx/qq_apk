package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acr
  extends com.tencent.mm.bw.a
{
  public LinkedList<acq> KHx;
  public long Lnv;
  public long Lnw;
  
  public acr()
  {
    AppMethodBeat.i(184493);
    this.KHx = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnv);
      paramVarArgs.bb(2, this.Lnw);
      paramVarArgs.e(3, 8, this.KHx);
      AppMethodBeat.o(184494);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Lnv);
      i = g.a.a.b.b.a.r(2, this.Lnw);
      int j = g.a.a.a.c(3, 8, this.KHx);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KHx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      acr localacr = (acr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localacr.Lnv = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localacr.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(184494);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acq();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((acq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localacr.KHx.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */