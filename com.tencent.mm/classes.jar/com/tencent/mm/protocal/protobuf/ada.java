package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ada
  extends com.tencent.mm.bw.a
{
  public LinkedList<acz> KHx;
  public long Lnv;
  public long Lnw;
  public int Lom;
  public int Lon;
  
  public ada()
  {
    AppMethodBeat.i(90962);
    this.KHx = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnv);
      paramVarArgs.bb(2, this.Lnw);
      paramVarArgs.e(3, 8, this.KHx);
      paramVarArgs.aM(4, this.Lom);
      paramVarArgs.aM(5, this.Lon);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Lnv);
      i = g.a.a.b.b.a.r(2, this.Lnw);
      int j = g.a.a.a.c(3, 8, this.KHx);
      int k = g.a.a.b.b.a.bu(4, this.Lom);
      int m = g.a.a.b.b.a.bu(5, this.Lon);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j + k + m;
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
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ada localada = (ada)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localada.Lnv = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localada.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(90963);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localada.KHx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90963);
        return 0;
      case 4: 
        localada.Lom = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(90963);
        return 0;
      }
      localada.Lon = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ada
 * JD-Core Version:    0.7.0.1
 */