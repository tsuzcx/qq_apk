package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ewd
  extends com.tencent.mm.bw.a
{
  public int NtL;
  public int NtM;
  public euy Nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nty == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147817);
        throw paramVarArgs;
      }
      if (this.Nty != null)
      {
        paramVarArgs.ni(1, this.Nty.computeSize());
        this.Nty.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NtL);
      paramVarArgs.aM(3, this.NtM);
      AppMethodBeat.o(147817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nty == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = g.a.a.a.nh(1, this.Nty.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.NtL);
      int j = g.a.a.b.b.a.bu(3, this.NtM);
      AppMethodBeat.o(147817);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nty == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147817);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ewd localewd = (ewd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147817);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((euy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localewd.Nty = ((euy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147817);
          return 0;
        case 2: 
          localewd.NtL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147817);
          return 0;
        }
        localewd.NtM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147817);
        return 0;
      }
      AppMethodBeat.o(147817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewd
 * JD-Core Version:    0.7.0.1
 */