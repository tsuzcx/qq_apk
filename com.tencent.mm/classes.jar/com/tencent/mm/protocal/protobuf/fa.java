package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fa
  extends com.tencent.mm.bv.a
{
  public int OpCode;
  public String fKw;
  public int wrf;
  public int wrg;
  public ff wrh;
  public ez wri;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28314);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(28314);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.OpCode);
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.aO(3, this.wrf);
      paramVarArgs.aO(4, this.wrg);
      if (this.wrh != null)
      {
        paramVarArgs.iQ(5, this.wrh.computeSize());
        this.wrh.writeFields(paramVarArgs);
      }
      if (this.wri != null)
      {
        paramVarArgs.iQ(6, this.wri.computeSize());
        this.wri.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28314);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.OpCode) + 0;
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wrf) + e.a.a.b.b.a.bl(4, this.wrg);
      paramInt = i;
      if (this.wrh != null) {
        paramInt = i + e.a.a.a.iP(5, this.wrh.computeSize());
      }
      i = paramInt;
      if (this.wri != null) {
        i = paramInt + e.a.a.a.iP(6, this.wri.computeSize());
      }
      AppMethodBeat.o(28314);
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
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(28314);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28314);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      fa localfa = (fa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28314);
        return -1;
      case 1: 
        localfa.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28314);
        return 0;
      case 2: 
        localfa.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28314);
        return 0;
      case 3: 
        localfa.wrf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28314);
        return 0;
      case 4: 
        localfa.wrg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28314);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ff();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ff)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localfa.wrh = ((ff)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28314);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ez();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ez)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localfa.wri = ((ez)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28314);
      return 0;
    }
    AppMethodBeat.o(28314);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */