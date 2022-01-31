package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bvx
  extends com.tencent.mm.bv.a
{
  public bwc wOT;
  public bwc xmi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60065);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(60065);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(60065);
        throw paramVarArgs;
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(1, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(2, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60065);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = e.a.a.a.iP(1, this.wOT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmi != null) {
        i = paramInt + e.a.a.a.iP(2, this.xmi.computeSize());
      }
      AppMethodBeat.o(60065);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(60065);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(60065);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60065);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bvx localbvx = (bvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60065);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbvx.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60065);
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
          localbvx.xmi = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60065);
        return 0;
      }
      AppMethodBeat.o(60065);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvx
 * JD-Core Version:    0.7.0.1
 */