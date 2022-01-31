package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bsc
  extends com.tencent.mm.bv.a
{
  public cer xFA;
  public bwc xFB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94552);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xFA == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(94552);
        throw paramVarArgs;
      }
      if (this.xFA != null)
      {
        paramVarArgs.iQ(1, this.xFA.computeSize());
        this.xFA.writeFields(paramVarArgs);
      }
      if (this.xFB != null)
      {
        paramVarArgs.iQ(2, this.xFB.computeSize());
        this.xFB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xFA == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = e.a.a.a.iP(1, this.xFA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xFB != null) {
        i = paramInt + e.a.a.a.iP(2, this.xFB.computeSize());
      }
      AppMethodBeat.o(94552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xFA == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
          AppMethodBeat.o(94552);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsc localbsc = (bsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94552);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cer();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cer)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbsc.xFA = ((cer)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94552);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbsc.xFB = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94552);
        return 0;
      }
      AppMethodBeat.o(94552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsc
 * JD-Core Version:    0.7.0.1
 */