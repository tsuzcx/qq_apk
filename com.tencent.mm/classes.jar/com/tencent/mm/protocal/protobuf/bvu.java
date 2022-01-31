package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvu
  extends com.tencent.mm.bv.a
{
  public int type;
  public bmk xJp;
  public cqu xJq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134446);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.xJp != null)
      {
        paramVarArgs.iQ(2, this.xJp.computeSize());
        this.xJp.writeFields(paramVarArgs);
      }
      if (this.xJq != null)
      {
        paramVarArgs.iQ(3, this.xJq.computeSize());
        this.xJq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134446);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.xJp != null) {
        paramInt = i + e.a.a.a.iP(2, this.xJp.computeSize());
      }
      i = paramInt;
      if (this.xJq != null) {
        i = paramInt + e.a.a.a.iP(3, this.xJq.computeSize());
      }
      AppMethodBeat.o(134446);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(134446);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bvu localbvu = (bvu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134446);
        return -1;
      case 1: 
        localbvu.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134446);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvu.xJp = ((bmk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134446);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cqu();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cqu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbvu.xJq = ((cqu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(134446);
      return 0;
    }
    AppMethodBeat.o(134446);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvu
 * JD-Core Version:    0.7.0.1
 */