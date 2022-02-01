package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkb
  extends com.tencent.mm.bw.a
{
  public fbt MNW;
  public fbs MNX;
  public fbs MNY;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196215);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.version);
      if (this.MNW != null)
      {
        paramVarArgs.ni(2, this.MNW.computeSize());
        this.MNW.writeFields(paramVarArgs);
      }
      if (this.MNX != null)
      {
        paramVarArgs.ni(3, this.MNX.computeSize());
        this.MNX.writeFields(paramVarArgs);
      }
      if (this.MNY != null)
      {
        paramVarArgs.ni(4, this.MNY.computeSize());
        this.MNY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(196215);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.version) + 0;
      paramInt = i;
      if (this.MNW != null) {
        paramInt = i + g.a.a.a.nh(2, this.MNW.computeSize());
      }
      i = paramInt;
      if (this.MNX != null) {
        i = paramInt + g.a.a.a.nh(3, this.MNX.computeSize());
      }
      paramInt = i;
      if (this.MNY != null) {
        paramInt = i + g.a.a.a.nh(4, this.MNY.computeSize());
      }
      AppMethodBeat.o(196215);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(196215);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dkb localdkb = (dkb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(196215);
        return -1;
      case 1: 
        localdkb.version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(196215);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdkb.MNW = ((fbt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196215);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdkb.MNX = ((fbs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196215);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fbs();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((fbs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdkb.MNY = ((fbs)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(196215);
      return 0;
    }
    AppMethodBeat.o(196215);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkb
 * JD-Core Version:    0.7.0.1
 */