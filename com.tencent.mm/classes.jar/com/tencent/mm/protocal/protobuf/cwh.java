package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cwh
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public LinkedList<adp> yev;
  public String yew;
  
  public cwh()
  {
    AppMethodBeat.i(63691);
    this.yev = new LinkedList();
    AppMethodBeat.o(63691);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63692);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yew == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(63692);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.yev);
      if (this.yew != null) {
        paramVarArgs.e(2, this.yew);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      AppMethodBeat.o(63692);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.yev) + 0;
      paramInt = i;
      if (this.yew != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yew);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Desc);
      }
      AppMethodBeat.o(63692);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yev.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.yew == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(63692);
        throw paramVarArgs;
      }
      AppMethodBeat.o(63692);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cwh localcwh = (cwh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(63692);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((adp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcwh.yev.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63692);
        return 0;
      case 2: 
        localcwh.yew = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(63692);
        return 0;
      }
      localcwh.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(63692);
      return 0;
    }
    AppMethodBeat.o(63692);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwh
 * JD-Core Version:    0.7.0.1
 */