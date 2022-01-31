package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ags
  extends com.tencent.mm.bv.a
{
  public aw wDH;
  public String wIZ;
  public LinkedList<String> wZr;
  
  public ags()
  {
    AppMethodBeat.i(56807);
    this.wZr = new LinkedList();
    AppMethodBeat.o(56807);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56808);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.wZr);
      if (this.wDH != null)
      {
        paramVarArgs.iQ(2, this.wDH.computeSize());
        this.wDH.writeFields(paramVarArgs);
      }
      if (this.wIZ != null) {
        paramVarArgs.e(3, this.wIZ);
      }
      AppMethodBeat.o(56808);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 1, this.wZr) + 0;
      paramInt = i;
      if (this.wDH != null) {
        paramInt = i + e.a.a.a.iP(2, this.wDH.computeSize());
      }
      i = paramInt;
      if (this.wIZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wIZ);
      }
      AppMethodBeat.o(56808);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wZr.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56808);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ags localags = (ags)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56808);
        return -1;
      case 1: 
        localags.wZr.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(56808);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localags.wDH = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56808);
        return 0;
      }
      localags.wIZ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56808);
      return 0;
    }
    AppMethodBeat.o(56808);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ags
 * JD-Core Version:    0.7.0.1
 */