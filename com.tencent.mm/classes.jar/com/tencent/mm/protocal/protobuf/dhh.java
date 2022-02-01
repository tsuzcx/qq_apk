package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhh
  extends com.tencent.mm.bw.a
{
  public SnsObject HMY;
  public cxn HOs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125809);
        throw paramVarArgs;
      }
      if (this.HMY != null)
      {
        paramVarArgs.lJ(1, this.HMY.computeSize());
        this.HMY.writeFields(paramVarArgs);
      }
      if (this.HOs != null)
      {
        paramVarArgs.lJ(2, this.HOs.computeSize());
        this.HOs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMY == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.HMY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HOs != null) {
        i = paramInt + f.a.a.a.lI(2, this.HOs.computeSize());
      }
      AppMethodBeat.o(125809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HMY == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhh localdhh = (dhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhh.HMY = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125809);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhh.HOs = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      AppMethodBeat.o(125809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhh
 * JD-Core Version:    0.7.0.1
 */