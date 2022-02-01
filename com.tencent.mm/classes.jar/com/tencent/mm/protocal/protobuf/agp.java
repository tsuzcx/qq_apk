package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agp
  extends com.tencent.mm.bx.a
{
  public agq GeF;
  public ago GeG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GeF == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.GeG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(152539);
        throw paramVarArgs;
      }
      if (this.GeF != null)
      {
        paramVarArgs.lC(1, this.GeF.computeSize());
        this.GeF.writeFields(paramVarArgs);
      }
      if (this.GeG != null)
      {
        paramVarArgs.lC(2, this.GeG.computeSize());
        this.GeG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GeF == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lB(1, this.GeF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GeG != null) {
        i = paramInt + f.a.a.a.lB(2, this.GeG.computeSize());
      }
      AppMethodBeat.o(152539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GeF == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        if (this.GeG == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(152539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agp localagp = (agp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagp.GeF = ((agq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152539);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ago();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ago)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagp.GeG = ((ago)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152539);
        return 0;
      }
      AppMethodBeat.o(152539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agp
 * JD-Core Version:    0.7.0.1
 */