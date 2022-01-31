package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aul
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int jKs;
  public SKBuiltinBuffer_t wtq;
  public long xjA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28520);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(28520);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.xjA);
      paramVarArgs.aO(2, this.CreateTime);
      if (this.wtq != null)
      {
        paramVarArgs.iQ(3, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.jKs);
      AppMethodBeat.o(28520);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.xjA) + 0 + e.a.a.b.b.a.bl(2, this.CreateTime);
      paramInt = i;
      if (this.wtq != null) {
        paramInt = i + e.a.a.a.iP(3, this.wtq.computeSize());
      }
      i = e.a.a.b.b.a.bl(4, this.jKs);
      AppMethodBeat.o(28520);
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
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(28520);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28520);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      aul localaul = (aul)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28520);
        return -1;
      case 1: 
        localaul.xjA = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28520);
        return 0;
      case 2: 
        localaul.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28520);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaul.wtq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28520);
        return 0;
      }
      localaul.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(28520);
      return 0;
    }
    AppMethodBeat.o(28520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aul
 * JD-Core Version:    0.7.0.1
 */