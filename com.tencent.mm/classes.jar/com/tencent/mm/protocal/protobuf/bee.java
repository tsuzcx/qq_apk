package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bee
  extends com.tencent.mm.bv.a
{
  public String gfM;
  public bia xtU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80122);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfM != null) {
        paramVarArgs.e(1, this.gfM);
      }
      if (this.xtU != null)
      {
        paramVarArgs.iQ(2, this.xtU.computeSize());
        this.xtU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfM == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xtU != null) {
        i = paramInt + e.a.a.a.iP(2, this.xtU.computeSize());
      }
      AppMethodBeat.o(80122);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80122);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bee localbee = (bee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80122);
          return -1;
        case 1: 
          localbee.gfM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80122);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bia();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bia)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbee.xtU = ((bia)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80122);
        return 0;
      }
      AppMethodBeat.o(80122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bee
 * JD-Core Version:    0.7.0.1
 */