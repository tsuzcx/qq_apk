package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amh
  extends com.tencent.mm.bw.a
{
  public ctg LuY;
  public int LuZ;
  public int Lva;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200198);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LuY != null)
      {
        paramVarArgs.ni(1, this.LuY.computeSize());
        this.LuY.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LuZ);
      paramVarArgs.aM(3, this.Lva);
      AppMethodBeat.o(200198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LuY == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.a.nh(1, this.LuY.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LuZ);
      int j = g.a.a.b.b.a.bu(3, this.Lva);
      AppMethodBeat.o(200198);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amh localamh = (amh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200198);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localamh.LuY = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200198);
          return 0;
        case 2: 
          localamh.LuZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200198);
          return 0;
        }
        localamh.Lva = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200198);
        return 0;
      }
      AppMethodBeat.o(200198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amh
 * JD-Core Version:    0.7.0.1
 */