package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class alc
  extends com.tencent.mm.bv.a
{
  public auh wva;
  public int xbZ;
  public int xca;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10176);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wva == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(10176);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xbZ);
      paramVarArgs.aO(2, this.xca);
      if (this.wva != null)
      {
        paramVarArgs.iQ(3, this.wva.computeSize());
        this.wva.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(10176);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xbZ) + 0 + e.a.a.b.b.a.bl(2, this.xca);
      paramInt = i;
      if (this.wva != null) {
        paramInt = i + e.a.a.a.iP(3, this.wva.computeSize());
      }
      AppMethodBeat.o(10176);
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
      if (this.wva == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(10176);
        throw paramVarArgs;
      }
      AppMethodBeat.o(10176);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      alc localalc = (alc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(10176);
        return -1;
      case 1: 
        localalc.xbZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10176);
        return 0;
      case 2: 
        localalc.xca = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10176);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new auh();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localalc.wva = ((auh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(10176);
      return 0;
    }
    AppMethodBeat.o(10176);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alc
 * JD-Core Version:    0.7.0.1
 */