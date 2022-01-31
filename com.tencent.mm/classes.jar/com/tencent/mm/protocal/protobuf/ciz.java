package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciz
  extends com.tencent.mm.bv.a
{
  public String wug;
  public int xED;
  public int xTi;
  public yl xTj;
  public yl xTk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48964);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xED);
      paramVarArgs.aO(2, this.xTi);
      if (this.wug != null) {
        paramVarArgs.e(3, this.wug);
      }
      if (this.xTj != null)
      {
        paramVarArgs.iQ(4, this.xTj.computeSize());
        this.xTj.writeFields(paramVarArgs);
      }
      if (this.xTk != null)
      {
        paramVarArgs.iQ(5, this.xTk.computeSize());
        this.xTk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xED) + 0 + e.a.a.b.b.a.bl(2, this.xTi);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wug);
      }
      i = paramInt;
      if (this.xTj != null) {
        i = paramInt + e.a.a.a.iP(4, this.xTj.computeSize());
      }
      paramInt = i;
      if (this.xTk != null) {
        paramInt = i + e.a.a.a.iP(5, this.xTk.computeSize());
      }
      AppMethodBeat.o(48964);
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
      AppMethodBeat.o(48964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ciz localciz = (ciz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48964);
        return -1;
      case 1: 
        localciz.xED = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48964);
        return 0;
      case 2: 
        localciz.xTi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48964);
        return 0;
      case 3: 
        localciz.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48964);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localciz.xTj = ((yl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48964);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yl();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((yl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localciz.xTk = ((yl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48964);
      return 0;
    }
    AppMethodBeat.o(48964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciz
 * JD-Core Version:    0.7.0.1
 */