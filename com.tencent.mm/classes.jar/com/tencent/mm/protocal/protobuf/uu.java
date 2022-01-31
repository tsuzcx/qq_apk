package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uu
  extends com.tencent.mm.bv.a
{
  public long wMX;
  public yg wMY;
  public yj wMZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135597);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wMX);
      if (this.wMY != null)
      {
        paramVarArgs.iQ(2, this.wMY.computeSize());
        this.wMY.writeFields(paramVarArgs);
      }
      if (this.wMZ != null)
      {
        paramVarArgs.iQ(3, this.wMZ.computeSize());
        this.wMZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(135597);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.wMX) + 0;
      paramInt = i;
      if (this.wMY != null) {
        paramInt = i + e.a.a.a.iP(2, this.wMY.computeSize());
      }
      i = paramInt;
      if (this.wMZ != null) {
        i = paramInt + e.a.a.a.iP(3, this.wMZ.computeSize());
      }
      AppMethodBeat.o(135597);
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
      AppMethodBeat.o(135597);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      uu localuu = (uu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(135597);
        return -1;
      case 1: 
        localuu.wMX = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(135597);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localuu.wMY = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(135597);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yj();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((yj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localuu.wMZ = ((yj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(135597);
      return 0;
    }
    AppMethodBeat.o(135597);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */