package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class afk
  extends com.tencent.mm.bw.a
{
  public long Brn;
  public dqi Lqk;
  public int Lqn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43091);
        throw paramVarArgs;
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(1, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Lqn);
      paramVarArgs.bb(3, this.Brn);
      AppMethodBeat.o(43091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqk == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = g.a.a.a.nh(1, this.Lqk.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Lqn);
      int j = g.a.a.b.b.a.r(3, this.Brn);
      AppMethodBeat.o(43091);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        afk localafk = (afk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43091);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localafk.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43091);
          return 0;
        case 2: 
          localafk.Lqn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(43091);
          return 0;
        }
        localafk.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(43091);
        return 0;
      }
      AppMethodBeat.o(43091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afk
 * JD-Core Version:    0.7.0.1
 */