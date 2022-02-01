package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwi
  extends com.tencent.mm.bw.a
{
  public int IbA;
  public ub IbB;
  public ub IbC;
  public int IbD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IbA);
      if (this.IbB != null)
      {
        paramVarArgs.lJ(4, this.IbB.computeSize());
        this.IbB.writeFields(paramVarArgs);
      }
      if (this.IbC != null)
      {
        paramVarArgs.lJ(5, this.IbC.computeSize());
        this.IbC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.IbD);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.IbA) + 0;
      paramInt = i;
      if (this.IbB != null) {
        paramInt = i + f.a.a.a.lI(4, this.IbB.computeSize());
      }
      i = paramInt;
      if (this.IbC != null) {
        i = paramInt + f.a.a.a.lI(5, this.IbC.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.IbD);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwi localdwi = (dwi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localdwi.IbA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ub();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwi.IbB = ((ub)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ub();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwi.IbC = ((ub)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localdwi.IbD = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */