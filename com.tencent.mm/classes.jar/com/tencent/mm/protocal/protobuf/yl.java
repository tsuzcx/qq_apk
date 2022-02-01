package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yl
  extends com.tencent.mm.bx.a
{
  public xc COe;
  public cmc Cvq;
  public clh DaI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.DaI != null)
      {
        paramVarArgs.kX(2, this.DaI.computeSize());
        this.DaI.writeFields(paramVarArgs);
      }
      if (this.Cvq != null)
      {
        paramVarArgs.kX(3, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      if (this.COe != null)
      {
        paramVarArgs.kX(4, this.COe.computeSize());
        this.COe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.DaI != null) {
        paramInt = i + f.a.a.a.kW(2, this.DaI.computeSize());
      }
      i = paramInt;
      if (this.Cvq != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cvq.computeSize());
      }
      paramInt = i;
      if (this.COe != null) {
        paramInt = i + f.a.a.a.kW(4, this.COe.computeSize());
      }
      AppMethodBeat.o(91426);
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
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yl localyl = (yl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localyl.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyl.DaI = ((clh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyl.Cvq = ((cmc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((xc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyl.COe = ((xc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yl
 * JD-Core Version:    0.7.0.1
 */