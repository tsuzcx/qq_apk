package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fp
  extends com.tencent.mm.bv.a
{
  public bcs wrF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94511);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrF == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaObj");
        AppMethodBeat.o(94511);
        throw paramVarArgs;
      }
      if (this.wrF != null)
      {
        paramVarArgs.iQ(1, this.wrF.computeSize());
        this.wrF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wrF == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.a.iP(1, this.wrF.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(94511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wrF == null)
        {
          paramVarArgs = new b("Not all required fields were included: MediaObj");
          AppMethodBeat.o(94511);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fp localfp = (fp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94511);
          return -1;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bcs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localfp.wrF = ((bcs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94511);
        return 0;
      }
      AppMethodBeat.o(94511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fp
 * JD-Core Version:    0.7.0.1
 */