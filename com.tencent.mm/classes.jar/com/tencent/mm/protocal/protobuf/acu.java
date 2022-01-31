package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acu
  extends com.tencent.mm.bv.a
{
  public int nrS;
  public LinkedList<aco> wVg;
  public aco wVh;
  public String wxW;
  
  public acu()
  {
    AppMethodBeat.i(51409);
    this.wVg = new LinkedList();
    AppMethodBeat.o(51409);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51410);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nrS);
      if (this.wxW != null) {
        paramVarArgs.e(2, this.wxW);
      }
      paramVarArgs.e(3, 8, this.wVg);
      if (this.wVh != null)
      {
        paramVarArgs.iQ(4, this.wVh.computeSize());
        this.wVh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(51410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.nrS) + 0;
      paramInt = i;
      if (this.wxW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wxW);
      }
      i = paramInt + e.a.a.a.c(3, 8, this.wVg);
      paramInt = i;
      if (this.wVh != null) {
        paramInt = i + e.a.a.a.iP(4, this.wVh.computeSize());
      }
      AppMethodBeat.o(51410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wVg.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      acu localacu = (acu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(51410);
        return -1;
      case 1: 
        localacu.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51410);
        return 0;
      case 2: 
        localacu.wxW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51410);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localacu.wVg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51410);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aco();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localacu.wVh = ((aco)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(51410);
      return 0;
    }
    AppMethodBeat.o(51410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acu
 * JD-Core Version:    0.7.0.1
 */