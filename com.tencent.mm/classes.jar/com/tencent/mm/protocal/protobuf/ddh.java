package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddh
  extends com.tencent.mm.bw.a
{
  public adt MIr;
  public adt MIs;
  public adt MIt;
  public adt MIu;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.left);
      paramVarArgs.aM(2, this.top);
      paramVarArgs.aM(3, this.right);
      paramVarArgs.aM(4, this.bottom);
      if (this.MIr != null)
      {
        paramVarArgs.ni(5, this.MIr.computeSize());
        this.MIr.writeFields(paramVarArgs);
      }
      if (this.MIs != null)
      {
        paramVarArgs.ni(6, this.MIs.computeSize());
        this.MIs.writeFields(paramVarArgs);
      }
      if (this.MIt != null)
      {
        paramVarArgs.ni(7, this.MIt.computeSize());
        this.MIt.writeFields(paramVarArgs);
      }
      if (this.MIu != null)
      {
        paramVarArgs.ni(8, this.MIu.computeSize());
        this.MIu.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.left) + 0 + g.a.a.b.b.a.bu(2, this.top) + g.a.a.b.b.a.bu(3, this.right) + g.a.a.b.b.a.bu(4, this.bottom);
      paramInt = i;
      if (this.MIr != null) {
        paramInt = i + g.a.a.a.nh(5, this.MIr.computeSize());
      }
      i = paramInt;
      if (this.MIs != null) {
        i = paramInt + g.a.a.a.nh(6, this.MIs.computeSize());
      }
      paramInt = i;
      if (this.MIt != null) {
        paramInt = i + g.a.a.a.nh(7, this.MIt.computeSize());
      }
      i = paramInt;
      if (this.MIu != null) {
        i = paramInt + g.a.a.a.nh(8, this.MIu.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ddh localddh = (ddh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localddh.left = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localddh.top = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localddh.right = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localddh.bottom = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddh.MIr = ((adt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddh.MIs = ((adt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddh.MIt = ((adt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddh.MIu = ((adt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localddh.type = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddh
 * JD-Core Version:    0.7.0.1
 */