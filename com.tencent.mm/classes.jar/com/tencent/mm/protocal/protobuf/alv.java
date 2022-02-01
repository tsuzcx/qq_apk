package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alv
  extends com.tencent.mm.bw.a
{
  public efk Lux;
  public int xuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117867);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lux != null)
      {
        paramVarArgs.ni(1, this.Lux.computeSize());
        this.Lux.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xuA);
      AppMethodBeat.o(117867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lux == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.a.nh(1, this.Lux.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.xuA);
      AppMethodBeat.o(117867);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alv localalv = (alv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117867);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((efk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localalv.Lux = ((efk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117867);
          return 0;
        }
        localalv.xuA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117867);
        return 0;
      }
      AppMethodBeat.o(117867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alv
 * JD-Core Version:    0.7.0.1
 */