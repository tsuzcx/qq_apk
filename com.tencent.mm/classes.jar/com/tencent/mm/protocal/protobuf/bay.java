package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bay
  extends com.tencent.mm.bv.a
{
  public cqz xpW;
  public LinkedList<baz> xqh;
  
  public bay()
  {
    AppMethodBeat.i(141957);
    this.xqh = new LinkedList();
    AppMethodBeat.o(141957);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141958);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xpW == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(141958);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.xqh);
      if (this.xpW != null)
      {
        paramVarArgs.iQ(2, this.xpW.computeSize());
        this.xpW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(141958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.xqh) + 0;
      paramInt = i;
      if (this.xpW != null) {
        paramInt = i + e.a.a.a.iP(2, this.xpW.computeSize());
      }
      AppMethodBeat.o(141958);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xqh.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xpW == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(141958);
        throw paramVarArgs;
      }
      AppMethodBeat.o(141958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bay localbay = (bay)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(141958);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((baz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbay.xqh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(141958);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cqz();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbay.xpW = ((cqz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(141958);
      return 0;
    }
    AppMethodBeat.o(141958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bay
 * JD-Core Version:    0.7.0.1
 */