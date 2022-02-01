package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class egt
  extends com.tencent.mm.bw.a
{
  public int MlF;
  public dqi NgE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NgE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MlF);
      if (this.NgE != null)
      {
        paramVarArgs.ni(2, this.NgE.computeSize());
        this.NgE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MlF) + 0;
      paramInt = i;
      if (this.NgE != null) {
        paramInt = i + g.a.a.a.nh(2, this.NgE.computeSize());
      }
      AppMethodBeat.o(32467);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.NgE == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      egt localegt = (egt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32467);
        return -1;
      case 1: 
        localegt.MlF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32467);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localegt.NgE = ((dqi)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    AppMethodBeat.o(32467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egt
 * JD-Core Version:    0.7.0.1
 */