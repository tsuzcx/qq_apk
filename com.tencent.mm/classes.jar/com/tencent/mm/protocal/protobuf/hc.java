package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hc
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CBZ;
  public acp CCa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
        AppMethodBeat.o(133149);
        throw paramVarArgs;
      }
      if (this.CBZ != null)
      {
        paramVarArgs.kX(2, this.CBZ.computeSize());
        this.CBZ.writeFields(paramVarArgs);
      }
      if (this.CCa != null)
      {
        paramVarArgs.kX(3, this.CCa.computeSize());
        this.CCa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBZ == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.kW(2, this.CBZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CCa != null) {
        i = paramInt + f.a.a.a.kW(3, this.CCa.computeSize());
      }
      AppMethodBeat.o(133149);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CBZ == null)
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
        hc localhc = (hc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133149);
          return -1;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.CBZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133149);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhc.CCa = ((acp)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */