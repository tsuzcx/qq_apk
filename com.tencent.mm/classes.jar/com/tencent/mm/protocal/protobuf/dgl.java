package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgl
  extends com.tencent.mm.bw.a
{
  public int LPy;
  public LinkedList<dgk> MLd;
  public int oTz;
  
  public dgl()
  {
    AppMethodBeat.i(155449);
    this.MLd = new LinkedList();
    AppMethodBeat.o(155449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LPy);
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(3, 8, this.MLd);
      AppMethodBeat.o(155450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LPy);
      i = g.a.a.b.b.a.bu(2, this.oTz);
      int j = g.a.a.a.c(3, 8, this.MLd);
      AppMethodBeat.o(155450);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MLd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dgl localdgl = (dgl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155450);
        return -1;
      case 1: 
        localdgl.LPy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155450);
        return 0;
      case 2: 
        localdgl.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155450);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dgk();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dgk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdgl.MLd.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    AppMethodBeat.o(155450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgl
 * JD-Core Version:    0.7.0.1
 */