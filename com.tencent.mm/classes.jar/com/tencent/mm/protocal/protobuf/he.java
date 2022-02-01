package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class he
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DUs;
  public SKBuiltinBuffer_t DUt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUs == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.DUt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.DUs != null)
      {
        paramVarArgs.ln(1, this.DUs.computeSize());
        this.DUs.writeFields(paramVarArgs);
      }
      if (this.DUt != null)
      {
        paramVarArgs.ln(2, this.DUt.computeSize());
        this.DUt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUs == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.DUs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DUt != null) {
        i = paramInt + f.a.a.a.lm(2, this.DUt.computeSize());
      }
      AppMethodBeat.o(133147);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DUs == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        if (this.DUt == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        he localhe = (he)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133147);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhe.DUs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133147);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhe.DUt = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */