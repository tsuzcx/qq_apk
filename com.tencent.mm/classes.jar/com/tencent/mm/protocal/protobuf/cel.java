package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cel
  extends com.tencent.mm.bv.a
{
  public int xOL;
  public cfn xOM;
  public bqt xON;
  public xn xOO;
  public bnn xOP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94592);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xOL);
      if (this.xOM != null)
      {
        paramVarArgs.iQ(2, this.xOM.computeSize());
        this.xOM.writeFields(paramVarArgs);
      }
      if (this.xON != null)
      {
        paramVarArgs.iQ(3, this.xON.computeSize());
        this.xON.writeFields(paramVarArgs);
      }
      if (this.xOO != null)
      {
        paramVarArgs.iQ(4, this.xOO.computeSize());
        this.xOO.writeFields(paramVarArgs);
      }
      if (this.xOP != null)
      {
        paramVarArgs.iQ(5, this.xOP.computeSize());
        this.xOP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94592);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xOL) + 0;
      paramInt = i;
      if (this.xOM != null) {
        paramInt = i + e.a.a.a.iP(2, this.xOM.computeSize());
      }
      i = paramInt;
      if (this.xON != null) {
        i = paramInt + e.a.a.a.iP(3, this.xON.computeSize());
      }
      paramInt = i;
      if (this.xOO != null) {
        paramInt = i + e.a.a.a.iP(4, this.xOO.computeSize());
      }
      i = paramInt;
      if (this.xOP != null) {
        i = paramInt + e.a.a.a.iP(5, this.xOP.computeSize());
      }
      AppMethodBeat.o(94592);
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
      AppMethodBeat.o(94592);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cel localcel = (cel)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94592);
        return -1;
      case 1: 
        localcel.xOL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94592);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcel.xOM = ((cfn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94592);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqt();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcel.xON = ((bqt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94592);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcel.xOO = ((xn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94592);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bnn();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcel.xOP = ((bnn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94592);
      return 0;
    }
    AppMethodBeat.o(94592);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cel
 * JD-Core Version:    0.7.0.1
 */