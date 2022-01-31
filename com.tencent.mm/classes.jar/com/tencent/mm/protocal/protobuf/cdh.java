package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cdh
  extends com.tencent.mm.bv.a
{
  public SnsObject xNM;
  public bwc xNN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94558);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(94558);
        throw paramVarArgs;
      }
      if (this.xNM != null)
      {
        paramVarArgs.iQ(1, this.xNM.computeSize());
        this.xNM.writeFields(paramVarArgs);
      }
      if (this.xNN != null)
      {
        paramVarArgs.iQ(2, this.xNN.computeSize());
        this.xNN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNM == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = e.a.a.a.iP(1, this.xNM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNN != null) {
        i = paramInt + e.a.a.a.iP(2, this.xNN.computeSize());
      }
      AppMethodBeat.o(94558);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(94558);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdh localcdh = (cdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94558);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdh.xNM = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94558);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdh.xNN = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94558);
        return 0;
      }
      AppMethodBeat.o(94558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */