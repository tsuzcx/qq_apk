package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class brp
  extends com.tencent.mm.bv.a
{
  public int id;
  public bwc xFj;
  public bwc xFk;
  public bwc xFl;
  public bwc xFm;
  public bwc xFn;
  public bwc xFo;
  public bwc xFp;
  public bwc xFq;
  public bwc xFr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28605);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFl == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFm == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFn == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFo == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFp == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFq == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.id);
      if (this.xFj != null)
      {
        paramVarArgs.iQ(2, this.xFj.computeSize());
        this.xFj.writeFields(paramVarArgs);
      }
      if (this.xFk != null)
      {
        paramVarArgs.iQ(3, this.xFk.computeSize());
        this.xFk.writeFields(paramVarArgs);
      }
      if (this.xFl != null)
      {
        paramVarArgs.iQ(4, this.xFl.computeSize());
        this.xFl.writeFields(paramVarArgs);
      }
      if (this.xFm != null)
      {
        paramVarArgs.iQ(5, this.xFm.computeSize());
        this.xFm.writeFields(paramVarArgs);
      }
      if (this.xFn != null)
      {
        paramVarArgs.iQ(6, this.xFn.computeSize());
        this.xFn.writeFields(paramVarArgs);
      }
      if (this.xFo != null)
      {
        paramVarArgs.iQ(7, this.xFo.computeSize());
        this.xFo.writeFields(paramVarArgs);
      }
      if (this.xFp != null)
      {
        paramVarArgs.iQ(8, this.xFp.computeSize());
        this.xFp.writeFields(paramVarArgs);
      }
      if (this.xFq != null)
      {
        paramVarArgs.iQ(9, this.xFq.computeSize());
        this.xFq.writeFields(paramVarArgs);
      }
      if (this.xFr != null)
      {
        paramVarArgs.iQ(10, this.xFr.computeSize());
        this.xFr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28605);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.xFj != null) {
        paramInt = i + e.a.a.a.iP(2, this.xFj.computeSize());
      }
      i = paramInt;
      if (this.xFk != null) {
        i = paramInt + e.a.a.a.iP(3, this.xFk.computeSize());
      }
      paramInt = i;
      if (this.xFl != null) {
        paramInt = i + e.a.a.a.iP(4, this.xFl.computeSize());
      }
      i = paramInt;
      if (this.xFm != null) {
        i = paramInt + e.a.a.a.iP(5, this.xFm.computeSize());
      }
      paramInt = i;
      if (this.xFn != null) {
        paramInt = i + e.a.a.a.iP(6, this.xFn.computeSize());
      }
      i = paramInt;
      if (this.xFo != null) {
        i = paramInt + e.a.a.a.iP(7, this.xFo.computeSize());
      }
      paramInt = i;
      if (this.xFp != null) {
        paramInt = i + e.a.a.a.iP(8, this.xFp.computeSize());
      }
      i = paramInt;
      if (this.xFq != null) {
        i = paramInt + e.a.a.a.iP(9, this.xFq.computeSize());
      }
      paramInt = i;
      if (this.xFr != null) {
        paramInt = i + e.a.a.a.iP(10, this.xFr.computeSize());
      }
      AppMethodBeat.o(28605);
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
      if (this.xFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFl == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFm == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFn == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFo == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFp == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      if (this.xFq == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(28605);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28605);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      brp localbrp = (brp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28605);
        return -1;
      case 1: 
        localbrp.id = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28605);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFj = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFk = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFl = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFm = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFn = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFo = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFp = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbrp.xFq = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28605);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbrp.xFr = ((bwc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28605);
      return 0;
    }
    AppMethodBeat.o(28605);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brp
 * JD-Core Version:    0.7.0.1
 */