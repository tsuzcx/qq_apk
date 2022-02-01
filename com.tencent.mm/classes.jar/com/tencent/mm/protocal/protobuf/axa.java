package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axa
  extends com.tencent.mm.bw.a
{
  public long LHD;
  public int LHE;
  public avn uBm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209553);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uBm != null)
      {
        paramVarArgs.ni(1, this.uBm.computeSize());
        this.uBm.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LHD);
      paramVarArgs.aM(3, this.LHE);
      AppMethodBeat.o(209553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uBm == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.a.nh(1, this.uBm.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.LHD);
      int j = g.a.a.b.b.a.bu(3, this.LHE);
      AppMethodBeat.o(209553);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209553);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        axa localaxa = (axa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209553);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaxa.uBm = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209553);
          return 0;
        case 2: 
          localaxa.LHD = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209553);
          return 0;
        }
        localaxa.LHE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209553);
        return 0;
      }
      AppMethodBeat.o(209553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axa
 * JD-Core Version:    0.7.0.1
 */