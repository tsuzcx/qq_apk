package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ewb
  extends com.tencent.mm.bw.a
{
  public euz NtA;
  public evs NtK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147815);
        throw paramVarArgs;
      }
      if (this.NtA != null)
      {
        paramVarArgs.ni(1, this.NtA.computeSize());
        this.NtA.writeFields(paramVarArgs);
      }
      if (this.NtK != null)
      {
        paramVarArgs.ni(2, this.NtK.computeSize());
        this.NtK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NtA == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.nh(1, this.NtA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NtK != null) {
        i = paramInt + g.a.a.a.nh(2, this.NtK.computeSize());
      }
      AppMethodBeat.o(147815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NtA == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ewb localewb = (ewb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147815);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localewb.NtA = ((euz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147815);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new evs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((evs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localewb.NtK = ((evs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      AppMethodBeat.o(147815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewb
 * JD-Core Version:    0.7.0.1
 */