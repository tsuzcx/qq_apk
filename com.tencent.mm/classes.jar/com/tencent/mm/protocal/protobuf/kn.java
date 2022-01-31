package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kn
  extends com.tencent.mm.bv.a
{
  public String wwI;
  public LinkedList<km> wxU;
  public int wxV;
  
  public kn()
  {
    AppMethodBeat.i(151368);
    this.wxU = new LinkedList();
    AppMethodBeat.o(151368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151369);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wxU);
      paramVarArgs.aO(2, this.wxV);
      if (this.wwI != null) {
        paramVarArgs.e(3, this.wwI);
      }
      AppMethodBeat.o(151369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.wxU) + 0 + e.a.a.b.b.a.bl(2, this.wxV);
      paramInt = i;
      if (this.wwI != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wwI);
      }
      AppMethodBeat.o(151369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wxU.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      kn localkn = (kn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151369);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new km();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((km)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localkn.wxU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151369);
        return 0;
      case 2: 
        localkn.wxV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151369);
        return 0;
      }
      localkn.wwI = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(151369);
      return 0;
    }
    AppMethodBeat.o(151369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kn
 * JD-Core Version:    0.7.0.1
 */