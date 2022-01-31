package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aet
  extends com.tencent.mm.bv.a
{
  public aem wXK;
  public LinkedList<String> wXL;
  
  public aet()
  {
    AppMethodBeat.i(112432);
    this.wXL = new LinkedList();
    AppMethodBeat.o(112432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112433);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wXK == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(112433);
        throw paramVarArgs;
      }
      if (this.wXK != null)
      {
        paramVarArgs.iQ(1, this.wXK.computeSize());
        this.wXK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.wXL);
      AppMethodBeat.o(112433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wXK == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.a.iP(1, this.wXK.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 1, this.wXL);
      AppMethodBeat.o(112433);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wXL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wXK == null)
        {
          paramVarArgs = new b("Not all required fields were included: GameItem");
          AppMethodBeat.o(112433);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aet localaet = (aet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112433);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aem();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aem)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaet.wXK = ((aem)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112433);
          return 0;
        }
        localaet.wXL.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(112433);
        return 0;
      }
      AppMethodBeat.o(112433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aet
 * JD-Core Version:    0.7.0.1
 */