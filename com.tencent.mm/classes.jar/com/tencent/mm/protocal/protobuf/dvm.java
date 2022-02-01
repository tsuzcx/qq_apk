package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvm
  extends com.tencent.mm.bx.a
{
  public int HHR;
  public dvq HHS;
  public dvo HHT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176153);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HHR);
      if (this.HHS != null)
      {
        paramVarArgs.lC(2, this.HHS.computeSize());
        this.HHS.writeFields(paramVarArgs);
      }
      if (this.HHT != null)
      {
        paramVarArgs.lC(3, this.HHT.computeSize());
        this.HHT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HHR) + 0;
      paramInt = i;
      if (this.HHS != null) {
        paramInt = i + f.a.a.a.lB(2, this.HHS.computeSize());
      }
      i = paramInt;
      if (this.HHT != null) {
        i = paramInt + f.a.a.a.lB(3, this.HHT.computeSize());
      }
      AppMethodBeat.o(176153);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dvm localdvm = (dvm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176153);
        return -1;
      case 1: 
        localdvm.HHR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(176153);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvm.HHS = ((dvq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176153);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dvo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdvm.HHT = ((dvo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    AppMethodBeat.o(176153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvm
 * JD-Core Version:    0.7.0.1
 */