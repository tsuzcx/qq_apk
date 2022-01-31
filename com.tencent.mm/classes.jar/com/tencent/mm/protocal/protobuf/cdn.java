package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cdn
  extends com.tencent.mm.bv.a
{
  public long Id;
  public String pIw;
  public long xOd;
  public cdm xOe;
  public cdm xOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94564);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xOe == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(94564);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.Id);
      paramVarArgs.am(2, this.xOd);
      if (this.xOe != null)
      {
        paramVarArgs.iQ(3, this.xOe.computeSize());
        this.xOe.writeFields(paramVarArgs);
      }
      if (this.xOf != null)
      {
        paramVarArgs.iQ(4, this.xOf.computeSize());
        this.xOf.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(5, this.pIw);
      }
      AppMethodBeat.o(94564);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0 + e.a.a.b.b.a.p(2, this.xOd);
      paramInt = i;
      if (this.xOe != null) {
        paramInt = i + e.a.a.a.iP(3, this.xOe.computeSize());
      }
      i = paramInt;
      if (this.xOf != null) {
        i = paramInt + e.a.a.a.iP(4, this.xOf.computeSize());
      }
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pIw);
      }
      AppMethodBeat.o(94564);
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
      if (this.xOe == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentAction");
        AppMethodBeat.o(94564);
        throw paramVarArgs;
      }
      AppMethodBeat.o(94564);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cdn localcdn = (cdn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94564);
        return -1;
      case 1: 
        localcdn.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94564);
        return 0;
      case 2: 
        localcdn.xOd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94564);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdn.xOe = ((cdm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94564);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdn.xOf = ((cdm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94564);
        return 0;
      }
      localcdn.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(94564);
      return 0;
    }
    AppMethodBeat.o(94564);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdn
 * JD-Core Version:    0.7.0.1
 */