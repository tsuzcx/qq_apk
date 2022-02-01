package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqn
  extends com.tencent.mm.bw.a
{
  public int NnT;
  public vg NnU;
  public vg NnV;
  public int NnW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NnT);
      if (this.NnU != null)
      {
        paramVarArgs.ni(4, this.NnU.computeSize());
        this.NnU.writeFields(paramVarArgs);
      }
      if (this.NnV != null)
      {
        paramVarArgs.ni(5, this.NnV.computeSize());
        this.NnV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NnW);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.NnT) + 0;
      paramInt = i;
      if (this.NnU != null) {
        paramInt = i + g.a.a.a.nh(4, this.NnU.computeSize());
      }
      i = paramInt;
      if (this.NnV != null) {
        i = paramInt + g.a.a.a.nh(5, this.NnV.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(6, this.NnW);
      AppMethodBeat.o(117940);
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
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eqn localeqn = (eqn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localeqn.NnT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeqn.NnU = ((vg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeqn.NnV = ((vg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localeqn.NnW = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqn
 * JD-Core Version:    0.7.0.1
 */