package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hl
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FSk;
  public SKBuiltinBuffer_t FSl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSk == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.FSl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.FSk != null)
      {
        paramVarArgs.lJ(1, this.FSk.computeSize());
        this.FSk.writeFields(paramVarArgs);
      }
      if (this.FSl != null)
      {
        paramVarArgs.lJ(2, this.FSl.computeSize());
        this.FSl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSk == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.FSk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FSl != null) {
        i = paramInt + f.a.a.a.lI(2, this.FSl.computeSize());
      }
      AppMethodBeat.o(133147);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FSk == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        if (this.FSl == null)
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
        hl localhl = (hl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133147);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhl.FSk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133147);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhl.FSl = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */