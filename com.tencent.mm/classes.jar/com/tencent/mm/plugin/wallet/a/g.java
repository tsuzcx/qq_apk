package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bv.a
{
  public m tTN;
  public String tTP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56648);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.tTN != null)
      {
        paramVarArgs.iQ(1, this.tTN.computeSize());
        this.tTN.writeFields(paramVarArgs);
      }
      if (this.tTP != null) {
        paramVarArgs.e(2, this.tTP);
      }
      AppMethodBeat.o(56648);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tTN == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.a.iP(1, this.tTN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tTP != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.tTP);
      }
      AppMethodBeat.o(56648);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56648);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56648);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localg.tTN = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56648);
          return 0;
        }
        localg.tTP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56648);
        return 0;
      }
      AppMethodBeat.o(56648);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.g
 * JD-Core Version:    0.7.0.1
 */