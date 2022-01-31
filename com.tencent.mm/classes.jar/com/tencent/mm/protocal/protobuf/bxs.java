package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bxs
  extends com.tencent.mm.bv.a
{
  public long wBW;
  public int xKm;
  public LinkedList<cpj> xKn;
  public String xba;
  public azu xqU;
  
  public bxs()
  {
    AppMethodBeat.i(124353);
    this.xKn = new LinkedList();
    AppMethodBeat.o(124353);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124354);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xba == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(124354);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.wBW);
      if (this.xba != null) {
        paramVarArgs.e(2, this.xba);
      }
      if (this.xqU != null)
      {
        paramVarArgs.iQ(3, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xKm);
      paramVarArgs.e(5, 8, this.xKn);
      AppMethodBeat.o(124354);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.wBW) + 0;
      paramInt = i;
      if (this.xba != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xba);
      }
      i = paramInt;
      if (this.xqU != null) {
        i = paramInt + e.a.a.a.iP(3, this.xqU.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xKm);
      int j = e.a.a.a.c(5, 8, this.xKn);
      AppMethodBeat.o(124354);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xKn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xba == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(124354);
        throw paramVarArgs;
      }
      AppMethodBeat.o(124354);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bxs localbxs = (bxs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124354);
        return -1;
      case 1: 
        localbxs.wBW = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124354);
        return 0;
      case 2: 
        localbxs.xba = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124354);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbxs.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124354);
        return 0;
      case 4: 
        localbxs.xKm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124354);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cpj();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cpj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbxs.xKn.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124354);
      return 0;
    }
    AppMethodBeat.o(124354);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxs
 * JD-Core Version:    0.7.0.1
 */