package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpq
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public int ID;
  public SKBuiltinBuffer_t xYA;
  public SKBuiltinBuffer_t xYB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28695);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xYA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(28695);
        throw paramVarArgs;
      }
      if (this.xYB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(28695);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.ID);
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.xYA != null)
      {
        paramVarArgs.iQ(3, this.xYA.computeSize());
        this.xYA.writeFields(paramVarArgs);
      }
      if (this.xYB != null)
      {
        paramVarArgs.iQ(4, this.xYB.computeSize());
        this.xYB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.ID) + 0;
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.xYA != null) {
        i = paramInt + e.a.a.a.iP(3, this.xYA.computeSize());
      }
      paramInt = i;
      if (this.xYB != null) {
        paramInt = i + e.a.a.a.iP(4, this.xYB.computeSize());
      }
      AppMethodBeat.o(28695);
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
      if (this.xYA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(28695);
        throw paramVarArgs;
      }
      if (this.xYB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(28695);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cpq localcpq = (cpq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28695);
        return -1;
      case 1: 
        localcpq.ID = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28695);
        return 0;
      case 2: 
        localcpq.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28695);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcpq.xYA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28695);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcpq.xYB = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28695);
      return 0;
    }
    AppMethodBeat.o(28695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpq
 * JD-Core Version:    0.7.0.1
 */