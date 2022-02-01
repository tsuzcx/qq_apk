package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hn
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t FzQ;
  public afp FzR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
        AppMethodBeat.o(133149);
        throw paramVarArgs;
      }
      if (this.FzQ != null)
      {
        paramVarArgs.lC(2, this.FzQ.computeSize());
        this.FzQ.writeFields(paramVarArgs);
      }
      if (this.FzR != null)
      {
        paramVarArgs.lC(3, this.FzR.computeSize());
        this.FzR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FzQ == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lB(2, this.FzQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FzR != null) {
        i = paramInt + f.a.a.a.lB(3, this.FzR.computeSize());
      }
      AppMethodBeat.o(133149);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FzQ == null)
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
        hn localhn = (hn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133149);
          return -1;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhn.FzQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133149);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhn.FzR = ((afp)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */