package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zt
  extends com.tencent.mm.bv.a
{
  public zu wQM;
  public zs wQN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80051);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQM == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(80051);
        throw paramVarArgs;
      }
      if (this.wQN == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(80051);
        throw paramVarArgs;
      }
      if (this.wQM != null)
      {
        paramVarArgs.iQ(1, this.wQM.computeSize());
        this.wQM.writeFields(paramVarArgs);
      }
      if (this.wQN != null)
      {
        paramVarArgs.iQ(2, this.wQN.computeSize());
        this.wQN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQM == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.a.iP(1, this.wQM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQN != null) {
        i = paramInt + e.a.a.a.iP(2, this.wQN.computeSize());
      }
      AppMethodBeat.o(80051);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wQM == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(80051);
          throw paramVarArgs;
        }
        if (this.wQN == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(80051);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80051);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zt localzt = (zt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80051);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzt.wQM = ((zu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80051);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzt.wQN = ((zs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80051);
        return 0;
      }
      AppMethodBeat.o(80051);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zt
 * JD-Core Version:    0.7.0.1
 */