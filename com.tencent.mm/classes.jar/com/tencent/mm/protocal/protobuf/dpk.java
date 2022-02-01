package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpk
  extends com.tencent.mm.bx.a
{
  public dpm EFu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFu != null)
      {
        paramVarArgs.kX(1, this.EFu.computeSize());
        this.EFu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(191096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFu == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.kW(1, this.EFu.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(191096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(191096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpk localdpk = (dpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(191096);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpk.EFu = ((dpm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(191096);
        return 0;
      }
      AppMethodBeat.o(191096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpk
 * JD-Core Version:    0.7.0.1
 */