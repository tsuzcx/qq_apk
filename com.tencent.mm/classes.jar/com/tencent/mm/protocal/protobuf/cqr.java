package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqr
  extends com.tencent.mm.bx.a
{
  public cwt Hji;
  public cwt Hjj;
  public cwt Hjk;
  public cwt Hjl;
  public cwt Hjm;
  public cwt Hjn;
  public cwt Hjo;
  public cwt Hjp;
  public cwt Hjq;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjk == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjl == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjm == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjn == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjo == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjp == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.id);
      if (this.Hji != null)
      {
        paramVarArgs.lC(2, this.Hji.computeSize());
        this.Hji.writeFields(paramVarArgs);
      }
      if (this.Hjj != null)
      {
        paramVarArgs.lC(3, this.Hjj.computeSize());
        this.Hjj.writeFields(paramVarArgs);
      }
      if (this.Hjk != null)
      {
        paramVarArgs.lC(4, this.Hjk.computeSize());
        this.Hjk.writeFields(paramVarArgs);
      }
      if (this.Hjl != null)
      {
        paramVarArgs.lC(5, this.Hjl.computeSize());
        this.Hjl.writeFields(paramVarArgs);
      }
      if (this.Hjm != null)
      {
        paramVarArgs.lC(6, this.Hjm.computeSize());
        this.Hjm.writeFields(paramVarArgs);
      }
      if (this.Hjn != null)
      {
        paramVarArgs.lC(7, this.Hjn.computeSize());
        this.Hjn.writeFields(paramVarArgs);
      }
      if (this.Hjo != null)
      {
        paramVarArgs.lC(8, this.Hjo.computeSize());
        this.Hjo.writeFields(paramVarArgs);
      }
      if (this.Hjp != null)
      {
        paramVarArgs.lC(9, this.Hjp.computeSize());
        this.Hjp.writeFields(paramVarArgs);
      }
      if (this.Hjq != null)
      {
        paramVarArgs.lC(10, this.Hjq.computeSize());
        this.Hjq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.Hji != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hji.computeSize());
      }
      i = paramInt;
      if (this.Hjj != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hjj.computeSize());
      }
      paramInt = i;
      if (this.Hjk != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hjk.computeSize());
      }
      i = paramInt;
      if (this.Hjl != null) {
        i = paramInt + f.a.a.a.lB(5, this.Hjl.computeSize());
      }
      paramInt = i;
      if (this.Hjm != null) {
        paramInt = i + f.a.a.a.lB(6, this.Hjm.computeSize());
      }
      i = paramInt;
      if (this.Hjn != null) {
        i = paramInt + f.a.a.a.lB(7, this.Hjn.computeSize());
      }
      paramInt = i;
      if (this.Hjo != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hjo.computeSize());
      }
      i = paramInt;
      if (this.Hjp != null) {
        i = paramInt + f.a.a.a.lB(9, this.Hjp.computeSize());
      }
      paramInt = i;
      if (this.Hjq != null) {
        paramInt = i + f.a.a.a.lB(10, this.Hjq.computeSize());
      }
      AppMethodBeat.o(32402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Hjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjk == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjl == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjm == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjn == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjo == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Hjp == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqr localcqr = (cqr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localcqr.id = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hji = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjj = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjk = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjl = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjm = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjn = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjo = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.Hjp = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcqr.Hjq = ((cwt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqr
 * JD-Core Version:    0.7.0.1
 */