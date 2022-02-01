package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpm
  extends com.tencent.mm.bx.a
{
  public dpn EFv;
  public dpo EFw;
  public int xnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191098);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.xnE);
      if (this.EFv != null)
      {
        paramVarArgs.kX(2, this.EFv.computeSize());
        this.EFv.writeFields(paramVarArgs);
      }
      if (this.EFw != null)
      {
        paramVarArgs.kX(3, this.EFw.computeSize());
        this.EFw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(191098);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.xnE) + 0;
      paramInt = i;
      if (this.EFv != null) {
        paramInt = i + f.a.a.a.kW(2, this.EFv.computeSize());
      }
      i = paramInt;
      if (this.EFw != null) {
        i = paramInt + f.a.a.a.kW(3, this.EFw.computeSize());
      }
      AppMethodBeat.o(191098);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(191098);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpm localdpm = (dpm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(191098);
        return -1;
      case 1: 
        localdpm.xnE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(191098);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpm.EFv = ((dpn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(191098);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dpo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dpo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdpm.EFw = ((dpo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(191098);
      return 0;
    }
    AppMethodBeat.o(191098);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpm
 * JD-Core Version:    0.7.0.1
 */