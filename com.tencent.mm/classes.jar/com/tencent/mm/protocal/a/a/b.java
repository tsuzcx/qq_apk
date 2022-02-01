package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public LinkedList<a> KAA;
  public int KAz;
  public int nettype;
  public int uin;
  
  public b()
  {
    AppMethodBeat.i(143940);
    this.KAA = new LinkedList();
    AppMethodBeat.o(143940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143941);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uin);
      paramVarArgs.aM(2, this.KAz);
      paramVarArgs.e(3, 8, this.KAA);
      paramVarArgs.aM(4, this.nettype);
      AppMethodBeat.o(143941);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.uin);
      i = g.a.a.b.b.a.bu(2, this.KAz);
      int j = g.a.a.a.c(3, 8, this.KAA);
      int k = g.a.a.b.b.a.bu(4, this.nettype);
      AppMethodBeat.o(143941);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KAA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143941);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143941);
        return -1;
      case 1: 
        localb.uin = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143941);
        return 0;
      case 2: 
        localb.KAz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143941);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localb.KAA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143941);
        return 0;
      }
      localb.nettype = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(143941);
      return 0;
    }
    AppMethodBeat.o(143941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.b
 * JD-Core Version:    0.7.0.1
 */