package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bej
  extends com.tencent.mm.bv.a
{
  public bmi xtE;
  public String xtI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28555);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xtI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(28555);
        throw paramVarArgs;
      }
      if (this.xtE == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
        AppMethodBeat.o(28555);
        throw paramVarArgs;
      }
      if (this.xtI != null) {
        paramVarArgs.e(1, this.xtI);
      }
      if (this.xtE != null)
      {
        paramVarArgs.iQ(2, this.xtE.computeSize());
        this.xtE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xtI == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = e.a.a.b.b.a.f(1, this.xtI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xtE != null) {
        i = paramInt + e.a.a.a.iP(2, this.xtE.computeSize());
      }
      AppMethodBeat.o(28555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xtI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(28555);
          throw paramVarArgs;
        }
        if (this.xtE == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
          AppMethodBeat.o(28555);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28555);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bej localbej = (bej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28555);
          return -1;
        case 1: 
          localbej.xtI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28555);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmi();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbej.xtE = ((bmi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28555);
        return 0;
      }
      AppMethodBeat.o(28555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bej
 * JD-Core Version:    0.7.0.1
 */