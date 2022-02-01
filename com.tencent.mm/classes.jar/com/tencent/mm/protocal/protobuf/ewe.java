package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ewe
  extends com.tencent.mm.bw.a
{
  public euz NtA;
  public int NtN;
  public LinkedList<evg> Ntp;
  
  public ewe()
  {
    AppMethodBeat.i(147818);
    this.Ntp = new LinkedList();
    AppMethodBeat.o(147818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147819);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147819);
        throw paramVarArgs;
      }
      if (this.NtA != null)
      {
        paramVarArgs.ni(1, this.NtA.computeSize());
        this.NtA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Ntp);
      paramVarArgs.aM(3, this.NtN);
      AppMethodBeat.o(147819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NtA == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.nh(1, this.NtA.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Ntp);
      int j = g.a.a.b.b.a.bu(3, this.NtN);
      AppMethodBeat.o(147819);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ntp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NtA == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147819);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ewe localewe = (ewe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147819);
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
            localewe.NtA = ((euz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new evg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((evg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localewe.Ntp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        }
        localewe.NtN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147819);
        return 0;
      }
      AppMethodBeat.o(147819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewe
 * JD-Core Version:    0.7.0.1
 */