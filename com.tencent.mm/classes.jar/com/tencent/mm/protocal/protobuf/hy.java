package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hy
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KLT;
  public SKBuiltinBuffer_t KLU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133147);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLT == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.KLT != null)
      {
        paramVarArgs.ni(1, this.KLT.computeSize());
        this.KLT.writeFields(paramVarArgs);
      }
      if (this.KLU != null)
      {
        paramVarArgs.ni(2, this.KLU.computeSize());
        this.KLU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLT == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.KLT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KLU != null) {
        i = paramInt + g.a.a.a.nh(2, this.KLU.computeSize());
      }
      AppMethodBeat.o(133147);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KLT == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        if (this.KLU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hy localhy = (hy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133147);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhy.KLT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133147);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhy.KLU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      AppMethodBeat.o(133147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hy
 * JD-Core Version:    0.7.0.1
 */