package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gg
  extends com.tencent.mm.bv.a
{
  public SKBuiltinBuffer_t wsx;
  public zd wsy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58890);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
        AppMethodBeat.o(58890);
        throw paramVarArgs;
      }
      if (this.wsx != null)
      {
        paramVarArgs.iQ(2, this.wsx.computeSize());
        this.wsx.writeFields(paramVarArgs);
      }
      if (this.wsy != null)
      {
        paramVarArgs.iQ(3, this.wsy.computeSize());
        this.wsy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58890);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wsx == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = e.a.a.a.iP(2, this.wsx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wsy != null) {
        i = paramInt + e.a.a.a.iP(3, this.wsy.computeSize());
      }
      AppMethodBeat.o(58890);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wsx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
          AppMethodBeat.o(58890);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58890);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        gg localgg = (gg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58890);
          return -1;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localgg.wsx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58890);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgg.wsy = ((zd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58890);
        return 0;
      }
      AppMethodBeat.o(58890);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */