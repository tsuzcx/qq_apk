package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cra
  extends com.tencent.mm.bv.a
{
  public bkd xJu;
  public bck xZE;
  public int xZF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48987);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xJu != null)
      {
        paramVarArgs.iQ(1, this.xJu.computeSize());
        this.xJu.writeFields(paramVarArgs);
      }
      if (this.xZE != null)
      {
        paramVarArgs.iQ(2, this.xZE.computeSize());
        this.xZE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xZF);
      AppMethodBeat.o(48987);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJu == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = e.a.a.a.iP(1, this.xJu.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xZE != null) {
        i = paramInt + e.a.a.a.iP(2, this.xZE.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xZF);
      AppMethodBeat.o(48987);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48987);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cra localcra = (cra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48987);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcra.xJu = ((bkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48987);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bck();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bck)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcra.xZE = ((bck)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48987);
          return 0;
        }
        localcra.xZF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48987);
        return 0;
      }
      AppMethodBeat.o(48987);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cra
 * JD-Core Version:    0.7.0.1
 */