package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgo
  extends com.tencent.mm.bw.a
{
  public cas MLg;
  public adw MLh;
  public qs MLi;
  public int pTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200222);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.pTI);
      if (this.MLg != null)
      {
        paramVarArgs.ni(2, this.MLg.computeSize());
        this.MLg.writeFields(paramVarArgs);
      }
      if (this.MLh != null)
      {
        paramVarArgs.ni(3, this.MLh.computeSize());
        this.MLh.writeFields(paramVarArgs);
      }
      if (this.MLi != null)
      {
        paramVarArgs.ni(4, this.MLi.computeSize());
        this.MLi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200222);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.pTI) + 0;
      paramInt = i;
      if (this.MLg != null) {
        paramInt = i + g.a.a.a.nh(2, this.MLg.computeSize());
      }
      i = paramInt;
      if (this.MLh != null) {
        i = paramInt + g.a.a.a.nh(3, this.MLh.computeSize());
      }
      paramInt = i;
      if (this.MLi != null) {
        paramInt = i + g.a.a.a.nh(4, this.MLi.computeSize());
      }
      AppMethodBeat.o(200222);
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
      AppMethodBeat.o(200222);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dgo localdgo = (dgo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200222);
        return -1;
      case 1: 
        localdgo.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200222);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cas();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cas)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgo.MLg = ((cas)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200222);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgo.MLh = ((adw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200222);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new qs();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((qs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdgo.MLi = ((qs)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(200222);
      return 0;
    }
    AppMethodBeat.o(200222);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgo
 * JD-Core Version:    0.7.0.1
 */