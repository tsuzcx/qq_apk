package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hm
  extends com.tencent.mm.bx.a
{
  public hn FzO;
  public hk FzP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133148);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzO == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.FzP == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.FzO != null)
      {
        paramVarArgs.lC(1, this.FzO.computeSize());
        this.FzO.writeFields(paramVarArgs);
      }
      if (this.FzP != null)
      {
        paramVarArgs.lC(2, this.FzP.computeSize());
        this.FzP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FzO == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lB(1, this.FzO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FzP != null) {
        i = paramInt + f.a.a.a.lB(2, this.FzP.computeSize());
      }
      AppMethodBeat.o(133148);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FzO == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        if (this.FzP == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hm localhm = (hm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133148);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhm.FzO = ((hn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133148);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhm.FzP = ((hk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      AppMethodBeat.o(133148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */