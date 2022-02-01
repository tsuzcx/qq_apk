package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dkg
  extends com.tencent.mm.bw.a
{
  public eaq MOf;
  public dqi MOg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125759);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(125759);
        throw paramVarArgs;
      }
      if (this.MOf != null)
      {
        paramVarArgs.ni(1, this.MOf.computeSize());
        this.MOf.writeFields(paramVarArgs);
      }
      if (this.MOg != null)
      {
        paramVarArgs.ni(2, this.MOg.computeSize());
        this.MOg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOf == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.nh(1, this.MOf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MOg != null) {
        i = paramInt + g.a.a.a.nh(2, this.MOg.computeSize());
      }
      AppMethodBeat.o(125759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
          AppMethodBeat.o(125759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkg localdkg = (dkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125759);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdkg.MOf = ((eaq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125759);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdkg.MOg = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      AppMethodBeat.o(125759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */