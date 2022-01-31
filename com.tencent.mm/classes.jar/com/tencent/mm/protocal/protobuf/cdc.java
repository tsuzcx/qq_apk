package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdc
  extends com.tencent.mm.bv.a
{
  public int pql;
  public String wDF;
  public LinkedList<bnt> xNE;
  public aan xNF;
  public LinkedList<bse> xNG;
  public int xNH;
  public cx xcr;
  
  public cdc()
  {
    AppMethodBeat.i(56975);
    this.xNE = new LinkedList();
    this.xNG = new LinkedList();
    AppMethodBeat.o(56975);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56976);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pql);
      paramVarArgs.e(2, 8, this.xNE);
      if (this.xNF != null)
      {
        paramVarArgs.iQ(3, this.xNF.computeSize());
        this.xNF.writeFields(paramVarArgs);
      }
      if (this.xcr != null)
      {
        paramVarArgs.iQ(4, this.xcr.computeSize());
        this.xcr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xNG);
      paramVarArgs.aO(6, this.xNH);
      if (this.wDF != null) {
        paramVarArgs.e(7, this.wDF);
      }
      AppMethodBeat.o(56976);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pql) + 0 + e.a.a.a.c(2, 8, this.xNE);
      paramInt = i;
      if (this.xNF != null) {
        paramInt = i + e.a.a.a.iP(3, this.xNF.computeSize());
      }
      i = paramInt;
      if (this.xcr != null) {
        i = paramInt + e.a.a.a.iP(4, this.xcr.computeSize());
      }
      i = i + e.a.a.a.c(5, 8, this.xNG) + e.a.a.b.b.a.bl(6, this.xNH);
      paramInt = i;
      if (this.wDF != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wDF);
      }
      AppMethodBeat.o(56976);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xNE.clear();
      this.xNG.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56976);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cdc localcdc = (cdc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56976);
        return -1;
      case 1: 
        localcdc.pql = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56976);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnt();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bnt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdc.xNE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56976);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aan();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aan)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdc.xNF = ((aan)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56976);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdc.xcr = ((cx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56976);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bse();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdc.xNG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56976);
        return 0;
      case 6: 
        localcdc.xNH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56976);
        return 0;
      }
      localcdc.wDF = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56976);
      return 0;
    }
    AppMethodBeat.o(56976);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdc
 * JD-Core Version:    0.7.0.1
 */