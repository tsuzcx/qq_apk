package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fer
  extends com.tencent.mm.bw.a
{
  public String NAe;
  public fem NzO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153343);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NzO != null)
      {
        paramVarArgs.ni(1, this.NzO.computeSize());
        this.NzO.writeFields(paramVarArgs);
      }
      if (this.NAe != null) {
        paramVarArgs.e(2, this.NAe);
      }
      AppMethodBeat.o(153343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NzO == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.a.nh(1, this.NzO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NAe != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NAe);
      }
      AppMethodBeat.o(153343);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153343);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fer localfer = (fer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153343);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fem();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fem)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfer.NzO = ((fem)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153343);
          return 0;
        }
        localfer.NAe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153343);
        return 0;
      }
      AppMethodBeat.o(153343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fer
 * JD-Core Version:    0.7.0.1
 */