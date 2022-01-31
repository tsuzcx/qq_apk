package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czy
  extends com.tencent.mm.bv.a
{
  public LinkedList<pk> wOF;
  public int wwX;
  public int ygF;
  public String ygG;
  public String ygH;
  public int ygI;
  public ew ygJ;
  
  public czy()
  {
    AppMethodBeat.i(96331);
    this.wOF = new LinkedList();
    AppMethodBeat.o(96331);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96332);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wwX);
      paramVarArgs.aO(2, this.ygF);
      if (this.ygG != null) {
        paramVarArgs.e(3, this.ygG);
      }
      if (this.ygH != null) {
        paramVarArgs.e(4, this.ygH);
      }
      paramVarArgs.aO(5, this.ygI);
      paramVarArgs.e(6, 8, this.wOF);
      if (this.ygJ != null)
      {
        paramVarArgs.iQ(7, this.ygJ.computeSize());
        this.ygJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96332);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wwX) + 0 + e.a.a.b.b.a.bl(2, this.ygF);
      paramInt = i;
      if (this.ygG != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ygG);
      }
      i = paramInt;
      if (this.ygH != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ygH);
      }
      i = i + e.a.a.b.b.a.bl(5, this.ygI) + e.a.a.a.c(6, 8, this.wOF);
      paramInt = i;
      if (this.ygJ != null) {
        paramInt = i + e.a.a.a.iP(7, this.ygJ.computeSize());
      }
      AppMethodBeat.o(96332);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wOF.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96332);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      czy localczy = (czy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96332);
        return -1;
      case 1: 
        localczy.wwX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96332);
        return 0;
      case 2: 
        localczy.ygF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96332);
        return 0;
      case 3: 
        localczy.ygG = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96332);
        return 0;
      case 4: 
        localczy.ygH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96332);
        return 0;
      case 5: 
        localczy.ygI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96332);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localczy.wOF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96332);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ew();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ew)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localczy.ygJ = ((ew)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(96332);
      return 0;
    }
    AppMethodBeat.o(96332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czy
 * JD-Core Version:    0.7.0.1
 */