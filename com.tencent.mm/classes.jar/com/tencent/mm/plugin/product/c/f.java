package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public j AZY;
  public String AZZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91272);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AZY != null)
      {
        paramVarArgs.ni(1, this.AZY.computeSize());
        this.AZY.writeFields(paramVarArgs);
      }
      if (this.AZZ != null) {
        paramVarArgs.e(2, this.AZZ);
      }
      AppMethodBeat.o(91272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AZY == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.a.nh(1, this.AZY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AZZ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.AZZ);
      }
      AppMethodBeat.o(91272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91272);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localf.AZY = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91272);
          return 0;
        }
        localf.AZZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91272);
        return 0;
      }
      AppMethodBeat.o(91272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.f
 * JD-Core Version:    0.7.0.1
 */