package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class no
  extends com.tencent.mm.bv.a
{
  public vc wCE;
  public nn wCF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48785);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCE != null)
      {
        paramVarArgs.iQ(1, this.wCE.computeSize());
        this.wCE.writeFields(paramVarArgs);
      }
      if (this.wCF != null)
      {
        paramVarArgs.iQ(2, this.wCF.computeSize());
        this.wCF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wCE == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.a.iP(1, this.wCE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wCF != null) {
        i = paramInt + e.a.a.a.iP(2, this.wCF.computeSize());
      }
      AppMethodBeat.o(48785);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48785);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        no localno = (no)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48785);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localno.wCE = ((vc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48785);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localno.wCF = ((nn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48785);
        return 0;
      }
      AppMethodBeat.o(48785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */