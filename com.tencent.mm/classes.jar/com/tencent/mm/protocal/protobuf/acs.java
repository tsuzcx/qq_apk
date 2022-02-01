package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acs
  extends com.tencent.mm.bw.a
{
  public long Lnw;
  public aha Lnx;
  public ahe Lny;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnw);
      if (this.Lnx != null)
      {
        paramVarArgs.ni(2, this.Lnx.computeSize());
        this.Lnx.writeFields(paramVarArgs);
      }
      if (this.Lny != null)
      {
        paramVarArgs.ni(3, this.Lny.computeSize());
        this.Lny.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Lnw) + 0;
      paramInt = i;
      if (this.Lnx != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lnx.computeSize());
      }
      i = paramInt;
      if (this.Lny != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lny.computeSize());
      }
      AppMethodBeat.o(90958);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      acs localacs = (acs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localacs.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aha();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aha)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacs.Lnx = ((aha)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahe();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localacs.Lny = ((ahe)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acs
 * JD-Core Version:    0.7.0.1
 */