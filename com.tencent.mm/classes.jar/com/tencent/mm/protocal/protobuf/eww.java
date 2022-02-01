package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eww
  extends com.tencent.mm.bw.a
{
  public ewx Nup;
  public ewy Nuq;
  public int vjQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212319);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.vjQ);
      if (this.Nup != null)
      {
        paramVarArgs.ni(2, this.Nup.computeSize());
        this.Nup.writeFields(paramVarArgs);
      }
      if (this.Nuq != null)
      {
        paramVarArgs.ni(3, this.Nuq.computeSize());
        this.Nuq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212319);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.vjQ) + 0;
      paramInt = i;
      if (this.Nup != null) {
        paramInt = i + g.a.a.a.nh(2, this.Nup.computeSize());
      }
      i = paramInt;
      if (this.Nuq != null) {
        i = paramInt + g.a.a.a.nh(3, this.Nuq.computeSize());
      }
      AppMethodBeat.o(212319);
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
      AppMethodBeat.o(212319);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eww localeww = (eww)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212319);
        return -1;
      case 1: 
        localeww.vjQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212319);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ewx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ewx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeww.Nup = ((ewx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212319);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ewy();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ewy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeww.Nuq = ((ewy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(212319);
      return 0;
    }
    AppMethodBeat.o(212319);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eww
 * JD-Core Version:    0.7.0.1
 */