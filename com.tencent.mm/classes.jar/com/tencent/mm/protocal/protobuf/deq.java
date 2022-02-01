package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deq
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public boolean MJJ;
  public dyr MJK;
  public dyr MJL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.MJJ);
      if (this.MJK != null)
      {
        paramVarArgs.ni(2, this.MJK.computeSize());
        this.MJK.writeFields(paramVarArgs);
      }
      if (this.MJL != null)
      {
        paramVarArgs.ni(3, this.MJL.computeSize());
        this.MJL.writeFields(paramVarArgs);
      }
      if (this.KNW != null) {
        paramVarArgs.e(4, this.KNW);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.MJK != null) {
        paramInt = i + g.a.a.a.nh(2, this.MJK.computeSize());
      }
      i = paramInt;
      if (this.MJL != null) {
        i = paramInt + g.a.a.a.nh(3, this.MJL.computeSize());
      }
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KNW);
      }
      AppMethodBeat.o(91632);
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
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      deq localdeq = (deq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localdeq.MJJ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdeq.MJK = ((dyr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdeq.MJL = ((dyr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localdeq.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deq
 * JD-Core Version:    0.7.0.1
 */