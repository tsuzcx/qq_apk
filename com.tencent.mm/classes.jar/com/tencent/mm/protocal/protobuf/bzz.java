package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzz
  extends com.tencent.mm.bv.a
{
  public boolean eht;
  public boolean mzI;
  public LinkedList<cab> xLA;
  public LinkedList<bzy> xLB;
  public caa xLC;
  public LinkedList<cad> xLD;
  
  public bzz()
  {
    AppMethodBeat.i(152455);
    this.eht = true;
    this.mzI = false;
    this.xLA = new LinkedList();
    this.xLB = new LinkedList();
    this.xLD = new LinkedList();
    AppMethodBeat.o(152455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152456);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.eht);
      paramVarArgs.aS(2, this.mzI);
      paramVarArgs.e(3, 8, this.xLA);
      paramVarArgs.e(4, 8, this.xLB);
      if (this.xLC != null)
      {
        paramVarArgs.iQ(5, this.xLC.computeSize());
        this.xLC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.xLD);
      AppMethodBeat.o(152456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.eW(1) + 1 + 0 + (e.a.a.b.b.a.eW(2) + 1) + e.a.a.a.c(3, 8, this.xLA) + e.a.a.a.c(4, 8, this.xLB);
      paramInt = i;
      if (this.xLC != null) {
        paramInt = i + e.a.a.a.iP(5, this.xLC.computeSize());
      }
      i = e.a.a.a.c(6, 8, this.xLD);
      AppMethodBeat.o(152456);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xLA.clear();
      this.xLB.clear();
      this.xLD.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(152456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bzz localbzz = (bzz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152456);
        return -1;
      case 1: 
        localbzz.eht = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(152456);
        return 0;
      case 2: 
        localbzz.mzI = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(152456);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cab();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cab)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzz.xLA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152456);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzz.xLB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152456);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new caa();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((caa)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzz.xLC = ((caa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152456);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cad();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cad)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbzz.xLD.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152456);
      return 0;
    }
    AppMethodBeat.o(152456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzz
 * JD-Core Version:    0.7.0.1
 */