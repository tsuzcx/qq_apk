package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vm
  extends com.tencent.mm.bv.a
{
  public int state;
  public LinkedList<cjw> wFB;
  public LinkedList<cjw> wOl;
  public String wOm;
  public cjw wmY;
  public String wug;
  
  public vm()
  {
    AppMethodBeat.i(48826);
    this.wFB = new LinkedList();
    this.wOl = new LinkedList();
    AppMethodBeat.o(48826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48827);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.state);
      if (this.wmY != null)
      {
        paramVarArgs.iQ(2, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.wFB);
      paramVarArgs.e(4, 8, this.wOl);
      if (this.wOm != null) {
        paramVarArgs.e(5, this.wOm);
      }
      if (this.wug != null) {
        paramVarArgs.e(6, this.wug);
      }
      AppMethodBeat.o(48827);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.state) + 0;
      paramInt = i;
      if (this.wmY != null) {
        paramInt = i + e.a.a.a.iP(2, this.wmY.computeSize());
      }
      i = paramInt + e.a.a.a.c(3, 8, this.wFB) + e.a.a.a.c(4, 8, this.wOl);
      paramInt = i;
      if (this.wOm != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wOm);
      }
      i = paramInt;
      if (this.wug != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wug);
      }
      AppMethodBeat.o(48827);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wFB.clear();
      this.wOl.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48827);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      vm localvm = (vm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48827);
        return -1;
      case 1: 
        localvm.state = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48827);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvm.wmY = ((cjw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48827);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvm.wFB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48827);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvm.wOl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48827);
        return 0;
      case 5: 
        localvm.wOm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48827);
        return 0;
      }
      localvm.wug = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(48827);
      return 0;
    }
    AppMethodBeat.o(48827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vm
 * JD-Core Version:    0.7.0.1
 */