package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public g Baa;
  public int cSx;
  public String nnB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91276);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.cSx);
      if (this.Baa != null)
      {
        paramVarArgs.ni(2, this.Baa.computeSize());
        this.Baa.writeFields(paramVarArgs);
      }
      if (this.nnB != null) {
        paramVarArgs.e(3, this.nnB);
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.cSx) + 0;
      paramInt = i;
      if (this.Baa != null) {
        paramInt = i + g.a.a.a.nh(2, this.Baa.computeSize());
      }
      i = paramInt;
      if (this.nnB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nnB);
      }
      AppMethodBeat.o(91276);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91276);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91276);
        return -1;
      case 1: 
        localj.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91276);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localj.Baa = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91276);
        return 0;
      }
      localj.nnB = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91276);
      return 0;
    }
    AppMethodBeat.o(91276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.j
 * JD-Core Version:    0.7.0.1
 */