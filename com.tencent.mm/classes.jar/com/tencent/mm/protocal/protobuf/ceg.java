package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ceg
  extends com.tencent.mm.bv.a
{
  public long Id;
  public int nrS;
  public SKBuiltinBuffer_t xyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94585);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.Id);
      paramVarArgs.aO(2, this.nrS);
      if (this.xyz != null)
      {
        paramVarArgs.iQ(3, this.xyz.computeSize());
        this.xyz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94585);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0 + e.a.a.b.b.a.bl(2, this.nrS);
      paramInt = i;
      if (this.xyz != null) {
        paramInt = i + e.a.a.a.iP(3, this.xyz.computeSize());
      }
      AppMethodBeat.o(94585);
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
      AppMethodBeat.o(94585);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ceg localceg = (ceg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94585);
        return -1;
      case 1: 
        localceg.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94585);
        return 0;
      case 2: 
        localceg.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94585);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localceg.xyz = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94585);
      return 0;
    }
    AppMethodBeat.o(94585);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceg
 * JD-Core Version:    0.7.0.1
 */