package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ge
  extends com.tencent.mm.bv.a
{
  public SKBuiltinBuffer_t wst;
  public SKBuiltinBuffer_t wsu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58888);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wst == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(58888);
        throw paramVarArgs;
      }
      if (this.wsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(58888);
        throw paramVarArgs;
      }
      if (this.wst != null)
      {
        paramVarArgs.iQ(1, this.wst.computeSize());
        this.wst.writeFields(paramVarArgs);
      }
      if (this.wsu != null)
      {
        paramVarArgs.iQ(2, this.wsu.computeSize());
        this.wsu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wst == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.a.iP(1, this.wst.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wsu != null) {
        i = paramInt + e.a.a.a.iP(2, this.wsu.computeSize());
      }
      AppMethodBeat.o(58888);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wst == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(58888);
          throw paramVarArgs;
        }
        if (this.wsu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(58888);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58888);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ge localge = (ge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58888);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localge.wst = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58888);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localge.wsu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58888);
        return 0;
      }
      AppMethodBeat.o(58888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ge
 * JD-Core Version:    0.7.0.1
 */