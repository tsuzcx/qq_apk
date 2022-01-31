package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adb
  extends com.tencent.mm.bv.a
{
  public int wVm;
  public LinkedList<ada> wVn;
  
  public adb()
  {
    AppMethodBeat.i(51417);
    this.wVn = new LinkedList();
    AppMethodBeat.o(51417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51418);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wVm);
      paramVarArgs.e(2, 8, this.wVn);
      AppMethodBeat.o(51418);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wVm);
      i = e.a.a.a.c(2, 8, this.wVn);
      AppMethodBeat.o(51418);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wVn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51418);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      adb localadb = (adb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(51418);
        return -1;
      case 1: 
        localadb.wVm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51418);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ada();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ada)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localadb.wVn.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(51418);
      return 0;
    }
    AppMethodBeat.o(51418);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adb
 * JD-Core Version:    0.7.0.1
 */