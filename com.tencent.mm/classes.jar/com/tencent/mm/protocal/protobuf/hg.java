package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hg
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DUw;
  public ado DUx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
        AppMethodBeat.o(133149);
        throw paramVarArgs;
      }
      if (this.DUw != null)
      {
        paramVarArgs.ln(2, this.DUw.computeSize());
        this.DUw.writeFields(paramVarArgs);
      }
      if (this.DUx != null)
      {
        paramVarArgs.ln(3, this.DUx.computeSize());
        this.DUx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUw == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lm(2, this.DUw.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DUx != null) {
        i = paramInt + f.a.a.a.lm(3, this.DUx.computeSize());
      }
      AppMethodBeat.o(133149);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DUw == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
          AppMethodBeat.o(133149);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hg localhg = (hg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133149);
          return -1;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhg.DUw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133149);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ado();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ado)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhg.DUx = ((ado)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133149);
        return 0;
      }
      AppMethodBeat.o(133149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hg
 * JD-Core Version:    0.7.0.1
 */