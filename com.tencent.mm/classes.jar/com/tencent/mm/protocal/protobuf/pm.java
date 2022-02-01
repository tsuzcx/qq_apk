package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pm
  extends com.tencent.mm.bx.a
{
  public pe CNP;
  public pd CNQ;
  public long CNR;
  public pk CNS;
  public po CNT;
  public pj CNU;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      if (this.CNP != null)
      {
        paramVarArgs.kX(2, this.CNP.computeSize());
        this.CNP.writeFields(paramVarArgs);
      }
      if (this.CNQ != null)
      {
        paramVarArgs.kX(3, this.CNQ.computeSize());
        this.CNQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(4, this.CNR);
      if (this.CNS != null)
      {
        paramVarArgs.kX(5, this.CNS.computeSize());
        this.CNS.writeFields(paramVarArgs);
      }
      if (this.CNT != null)
      {
        paramVarArgs.kX(6, this.CNT.computeSize());
        this.CNT.writeFields(paramVarArgs);
      }
      if (this.CNU != null)
      {
        paramVarArgs.kX(7, this.CNU.computeSize());
        this.CNU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.CNP != null) {
        paramInt = i + f.a.a.a.kW(2, this.CNP.computeSize());
      }
      i = paramInt;
      if (this.CNQ != null) {
        i = paramInt + f.a.a.a.kW(3, this.CNQ.computeSize());
      }
      i += f.a.a.b.b.a.q(4, this.CNR);
      paramInt = i;
      if (this.CNS != null) {
        paramInt = i + f.a.a.a.kW(5, this.CNS.computeSize());
      }
      i = paramInt;
      if (this.CNT != null) {
        i = paramInt + f.a.a.a.kW(6, this.CNT.computeSize());
      }
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + f.a.a.a.kW(7, this.CNU.computeSize());
      }
      AppMethodBeat.o(117850);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pm localpm = (pm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localpm.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpm.CNP = ((pe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpm.CNQ = ((pd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localpm.CNR = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpm.CNS = ((pk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new po();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((po)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpm.CNT = ((po)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localpm.CNU = ((pj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pm
 * JD-Core Version:    0.7.0.1
 */