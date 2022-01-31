package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zu
  extends com.tencent.mm.bv.a
{
  public SKBuiltinBuffer_t wvN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80052);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvN == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(80052);
        throw paramVarArgs;
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(1, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wvN == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = e.a.a.a.iP(1, this.wvN.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(80052);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvN == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(80052);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zu localzu = (zu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80052);
          return -1;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzu.wvN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80052);
        return 0;
      }
      AppMethodBeat.o(80052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zu
 * JD-Core Version:    0.7.0.1
 */