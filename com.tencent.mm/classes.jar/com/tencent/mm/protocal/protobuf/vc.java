package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vc
  extends com.tencent.mm.bv.a
{
  public ciz wND;
  public cjw wNE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48825);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wND != null)
      {
        paramVarArgs.iQ(1, this.wND.computeSize());
        this.wND.writeFields(paramVarArgs);
      }
      if (this.wNE != null)
      {
        paramVarArgs.iQ(2, this.wNE.computeSize());
        this.wNE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wND == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.a.iP(1, this.wND.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wNE != null) {
        i = paramInt + e.a.a.a.iP(2, this.wNE.computeSize());
      }
      AppMethodBeat.o(48825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vc localvc = (vc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48825);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvc.wND = ((ciz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48825);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvc.wNE = ((cjw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48825);
        return 0;
      }
      AppMethodBeat.o(48825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vc
 * JD-Core Version:    0.7.0.1
 */