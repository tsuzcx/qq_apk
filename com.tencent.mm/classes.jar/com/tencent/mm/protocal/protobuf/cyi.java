package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyi
  extends com.tencent.mm.bv.a
{
  public long yfs;
  public mc yft;
  public int yfu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124382);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.yfs);
      if (this.yft != null)
      {
        paramVarArgs.iQ(2, this.yft.computeSize());
        this.yft.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.yfu);
      AppMethodBeat.o(124382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.yfs) + 0;
      paramInt = i;
      if (this.yft != null) {
        paramInt = i + e.a.a.a.iP(2, this.yft.computeSize());
      }
      i = e.a.a.b.b.a.bl(3, this.yfu);
      AppMethodBeat.o(124382);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cyi localcyi = (cyi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124382);
        return -1;
      case 1: 
        localcyi.yfs = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124382);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((mc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyi.yft = ((mc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124382);
        return 0;
      }
      localcyi.yfu = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(124382);
      return 0;
    }
    AppMethodBeat.o(124382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyi
 * JD-Core Version:    0.7.0.1
 */