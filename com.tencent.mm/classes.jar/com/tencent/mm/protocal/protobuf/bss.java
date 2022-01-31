package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bss
  extends com.tencent.mm.bv.a
{
  public int type;
  public cjw wNE;
  public String xcz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48951);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.xcz != null) {
        paramVarArgs.e(2, this.xcz);
      }
      if (this.wNE != null)
      {
        paramVarArgs.iQ(3, this.wNE.computeSize());
        this.wNE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.xcz != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xcz);
      }
      i = paramInt;
      if (this.wNE != null) {
        i = paramInt + e.a.a.a.iP(3, this.wNE.computeSize());
      }
      AppMethodBeat.o(48951);
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
      AppMethodBeat.o(48951);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bss localbss = (bss)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48951);
        return -1;
      case 1: 
        localbss.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48951);
        return 0;
      case 2: 
        localbss.xcz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48951);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cjw();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbss.wNE = ((cjw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48951);
      return 0;
    }
    AppMethodBeat.o(48951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bss
 * JD-Core Version:    0.7.0.1
 */