package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adq
  extends com.tencent.mm.bw.a
{
  public dqe KEP;
  public abm KZT;
  public dph Lpf;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.Lpf != null)
      {
        paramVarArgs.ni(2, this.Lpf.computeSize());
        this.Lpf.writeFields(paramVarArgs);
      }
      if (this.KEP != null)
      {
        paramVarArgs.ni(3, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      if (this.KZT != null)
      {
        paramVarArgs.ni(4, this.KZT.computeSize());
        this.KZT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.Lpf != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lpf.computeSize());
      }
      i = paramInt;
      if (this.KEP != null) {
        i = paramInt + g.a.a.a.nh(3, this.KEP.computeSize());
      }
      paramInt = i;
      if (this.KZT != null) {
        paramInt = i + g.a.a.a.nh(4, this.KZT.computeSize());
      }
      AppMethodBeat.o(91426);
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
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      adq localadq = (adq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localadq.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dph();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dph)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadq.Lpf = ((dph)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadq.KEP = ((dqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new abm();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((abm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localadq.KZT = ((abm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adq
 * JD-Core Version:    0.7.0.1
 */