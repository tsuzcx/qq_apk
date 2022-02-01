package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpo
  extends com.tencent.mm.bw.a
{
  public dbn MSM;
  public equ MSN;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50111);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.MSM != null)
      {
        paramVarArgs.ni(2, this.MSM.computeSize());
        this.MSM.writeFields(paramVarArgs);
      }
      if (this.MSN != null)
      {
        paramVarArgs.ni(3, this.MSN.computeSize());
        this.MSN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50111);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.MSM != null) {
        paramInt = i + g.a.a.a.nh(2, this.MSM.computeSize());
      }
      i = paramInt;
      if (this.MSN != null) {
        i = paramInt + g.a.a.a.nh(3, this.MSN.computeSize());
      }
      AppMethodBeat.o(50111);
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
      AppMethodBeat.o(50111);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dpo localdpo = (dpo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50111);
        return -1;
      case 1: 
        localdpo.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(50111);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdpo.MSM = ((dbn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50111);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new equ();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((equ)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdpo.MSN = ((equ)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(50111);
      return 0;
    }
    AppMethodBeat.o(50111);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */