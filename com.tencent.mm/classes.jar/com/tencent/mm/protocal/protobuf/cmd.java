package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmd
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public boolean Hfx;
  public deq Hfy;
  public deq Hfz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.Hfx);
      if (this.Hfy != null)
      {
        paramVarArgs.lC(2, this.Hfy.computeSize());
        this.Hfy.writeFields(paramVarArgs);
      }
      if (this.Hfz != null)
      {
        paramVarArgs.lC(3, this.Hfz.computeSize());
        this.Hfz.writeFields(paramVarArgs);
      }
      if (this.FBS != null) {
        paramVarArgs.d(4, this.FBS);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.Hfy != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hfy.computeSize());
      }
      i = paramInt;
      if (this.Hfz != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hfz.computeSize());
      }
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FBS);
      }
      AppMethodBeat.o(91632);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmd localcmd = (cmd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localcmd.Hfx = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new deq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((deq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmd.Hfy = ((deq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new deq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((deq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmd.Hfz = ((deq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localcmd.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmd
 * JD-Core Version:    0.7.0.1
 */