package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uk
  extends com.tencent.mm.bv.a
{
  public String ohe;
  public long timestamp;
  public String wMH;
  public ug wMI;
  public String wqH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124309);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.timestamp);
      if (this.wMH != null) {
        paramVarArgs.e(2, this.wMH);
      }
      if (this.wqH != null) {
        paramVarArgs.e(3, this.wqH);
      }
      if (this.ohe != null) {
        paramVarArgs.e(4, this.ohe);
      }
      if (this.wMI != null)
      {
        paramVarArgs.iQ(5, this.wMI.computeSize());
        this.wMI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124309);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.timestamp) + 0;
      paramInt = i;
      if (this.wMH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wMH);
      }
      i = paramInt;
      if (this.wqH != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wqH);
      }
      paramInt = i;
      if (this.ohe != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ohe);
      }
      i = paramInt;
      if (this.wMI != null) {
        i = paramInt + e.a.a.a.iP(5, this.wMI.computeSize());
      }
      AppMethodBeat.o(124309);
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
      AppMethodBeat.o(124309);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      uk localuk = (uk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124309);
        return -1;
      case 1: 
        localuk.timestamp = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124309);
        return 0;
      case 2: 
        localuk.wMH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124309);
        return 0;
      case 3: 
        localuk.wqH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124309);
        return 0;
      case 4: 
        localuk.ohe = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124309);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ug();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ug)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localuk.wMI = ((ug)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124309);
      return 0;
    }
    AppMethodBeat.o(124309);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uk
 * JD-Core Version:    0.7.0.1
 */