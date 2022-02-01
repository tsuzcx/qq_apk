package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkf
  extends com.tencent.mm.bx.a
{
  public int EzT;
  public rv EzU;
  public rv EzV;
  public int EzW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EzT);
      if (this.EzU != null)
      {
        paramVarArgs.kX(4, this.EzU.computeSize());
        this.EzU.writeFields(paramVarArgs);
      }
      if (this.EzV != null)
      {
        paramVarArgs.kX(5, this.EzV.computeSize());
        this.EzV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EzW);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.EzT) + 0;
      paramInt = i;
      if (this.EzU != null) {
        paramInt = i + f.a.a.a.kW(4, this.EzU.computeSize());
      }
      i = paramInt;
      if (this.EzV != null) {
        i = paramInt + f.a.a.a.kW(5, this.EzV.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.EzW);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkf localdkf = (dkf)paramVarArgs[1];
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
        localdkf.EzT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkf.EzU = ((rv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkf.EzV = ((rv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localdkf.EzW = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */