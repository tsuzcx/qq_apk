package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnq
  extends com.tencent.mm.bv.a
{
  public String wug;
  public boolean xBR;
  public ccx xBS;
  public ccx xBT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48926);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xBR);
      if (this.xBS != null)
      {
        paramVarArgs.iQ(2, this.xBS.computeSize());
        this.xBS.writeFields(paramVarArgs);
      }
      if (this.xBT != null)
      {
        paramVarArgs.iQ(3, this.xBT.computeSize());
        this.xBT.writeFields(paramVarArgs);
      }
      if (this.wug != null) {
        paramVarArgs.e(4, this.wug);
      }
      AppMethodBeat.o(48926);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.eW(1) + 1 + 0;
      paramInt = i;
      if (this.xBS != null) {
        paramInt = i + e.a.a.a.iP(2, this.xBS.computeSize());
      }
      i = paramInt;
      if (this.xBT != null) {
        i = paramInt + e.a.a.a.iP(3, this.xBT.computeSize());
      }
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wug);
      }
      AppMethodBeat.o(48926);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48926);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bnq localbnq = (bnq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48926);
        return -1;
      case 1: 
        localbnq.xBR = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(48926);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbnq.xBS = ((ccx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48926);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbnq.xBT = ((ccx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48926);
        return 0;
      }
      localbnq.wug = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(48926);
      return 0;
    }
    AppMethodBeat.o(48926);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnq
 * JD-Core Version:    0.7.0.1
 */