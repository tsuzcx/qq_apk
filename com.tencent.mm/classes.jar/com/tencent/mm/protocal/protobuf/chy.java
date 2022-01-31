package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chy
  extends com.tencent.mm.bv.a
{
  public long Id;
  public int jKs;
  public chz xSH;
  public chz xSI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56543);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xSH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(56543);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.Id);
      paramVarArgs.aO(2, this.jKs);
      if (this.xSH != null)
      {
        paramVarArgs.iQ(3, this.xSH.computeSize());
        this.xSH.writeFields(paramVarArgs);
      }
      if (this.xSI != null)
      {
        paramVarArgs.iQ(4, this.xSI.computeSize());
        this.xSI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0 + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.xSH != null) {
        paramInt = i + e.a.a.a.iP(3, this.xSH.computeSize());
      }
      i = paramInt;
      if (this.xSI != null) {
        i = paramInt + e.a.a.a.iP(4, this.xSI.computeSize());
      }
      AppMethodBeat.o(56543);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xSH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SyncMsgDetail");
        AppMethodBeat.o(56543);
        throw paramVarArgs;
      }
      AppMethodBeat.o(56543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      chy localchy = (chy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56543);
        return -1;
      case 1: 
        localchy.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56543);
        return 0;
      case 2: 
        localchy.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56543);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchy.xSH = ((chz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56543);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new chz();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((chz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localchy.xSI = ((chz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(56543);
      return 0;
    }
    AppMethodBeat.o(56543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chy
 * JD-Core Version:    0.7.0.1
 */