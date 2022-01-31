package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lg
  extends com.tencent.mm.bv.a
{
  public String wwI;
  public int wxV;
  public LinkedList<lf> wzA;
  public lh wzB;
  
  public lg()
  {
    AppMethodBeat.i(151373);
    this.wzA = new LinkedList();
    AppMethodBeat.o(151373);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151374);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wzA);
      paramVarArgs.aO(3, this.wxV);
      if (this.wwI != null) {
        paramVarArgs.e(4, this.wwI);
      }
      if (this.wzB != null)
      {
        paramVarArgs.iQ(5, this.wzB.computeSize());
        this.wzB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151374);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.wzA) + 0 + e.a.a.b.b.a.bl(3, this.wxV);
      paramInt = i;
      if (this.wwI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wwI);
      }
      i = paramInt;
      if (this.wzB != null) {
        i = paramInt + e.a.a.a.iP(5, this.wzB.computeSize());
      }
      AppMethodBeat.o(151374);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wzA.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151374);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      lg locallg = (lg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(151374);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallg.wzA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151374);
        return 0;
      case 3: 
        locallg.wxV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151374);
        return 0;
      case 4: 
        locallg.wwI = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151374);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new lh();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((lh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        locallg.wzB = ((lh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151374);
      return 0;
    }
    AppMethodBeat.o(151374);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lg
 * JD-Core Version:    0.7.0.1
 */