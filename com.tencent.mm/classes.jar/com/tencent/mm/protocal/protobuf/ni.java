package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ni
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public nb wCo;
  public na wCp;
  public long wCq;
  public nh wCr;
  public nk wCs;
  public ng wCt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124300);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      if (this.wCo != null)
      {
        paramVarArgs.iQ(2, this.wCo.computeSize());
        this.wCo.writeFields(paramVarArgs);
      }
      if (this.wCp != null)
      {
        paramVarArgs.iQ(3, this.wCp.computeSize());
        this.wCp.writeFields(paramVarArgs);
      }
      paramVarArgs.am(4, this.wCq);
      if (this.wCr != null)
      {
        paramVarArgs.iQ(5, this.wCr.computeSize());
        this.wCr.writeFields(paramVarArgs);
      }
      if (this.wCs != null)
      {
        paramVarArgs.iQ(6, this.wCs.computeSize());
        this.wCs.writeFields(paramVarArgs);
      }
      if (this.wCt != null)
      {
        paramVarArgs.iQ(7, this.wCt.computeSize());
        this.wCt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124300);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jKs) + 0;
      paramInt = i;
      if (this.wCo != null) {
        paramInt = i + e.a.a.a.iP(2, this.wCo.computeSize());
      }
      i = paramInt;
      if (this.wCp != null) {
        i = paramInt + e.a.a.a.iP(3, this.wCp.computeSize());
      }
      i += e.a.a.b.b.a.p(4, this.wCq);
      paramInt = i;
      if (this.wCr != null) {
        paramInt = i + e.a.a.a.iP(5, this.wCr.computeSize());
      }
      i = paramInt;
      if (this.wCs != null) {
        i = paramInt + e.a.a.a.iP(6, this.wCs.computeSize());
      }
      paramInt = i;
      if (this.wCt != null) {
        paramInt = i + e.a.a.a.iP(7, this.wCt.computeSize());
      }
      AppMethodBeat.o(124300);
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
      AppMethodBeat.o(124300);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ni localni = (ni)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124300);
        return -1;
      case 1: 
        localni.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124300);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localni.wCo = ((nb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124300);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new na();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((na)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localni.wCp = ((na)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124300);
        return 0;
      case 4: 
        localni.wCq = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124300);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localni.wCr = ((nh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124300);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localni.wCs = ((nk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124300);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ng();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ng)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localni.wCt = ((ng)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124300);
      return 0;
    }
    AppMethodBeat.o(124300);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ni
 * JD-Core Version:    0.7.0.1
 */