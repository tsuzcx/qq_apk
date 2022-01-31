package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdv
  extends com.tencent.mm.bv.a
{
  public yn xtJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60048);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xtJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DisturbSetting");
        AppMethodBeat.o(60048);
        throw paramVarArgs;
      }
      if (this.xtJ != null)
      {
        paramVarArgs.iQ(1, this.xtJ.computeSize());
        this.xtJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xtJ == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.a.iP(1, this.xtJ.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(60048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xtJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DisturbSetting");
          AppMethodBeat.o(60048);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdv localbdv = (bdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60048);
          return -1;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((yn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbdv.xtJ = ((yn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60048);
        return 0;
      }
      AppMethodBeat.o(60048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdv
 * JD-Core Version:    0.7.0.1
 */