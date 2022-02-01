package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bw.a
{
  public a gTO;
  public p gTP;
  public i gTQ;
  public b gTR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194684);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.gTO != null)
      {
        paramVarArgs.ni(1, this.gTO.computeSize());
        this.gTO.writeFields(paramVarArgs);
      }
      if (this.gTP != null)
      {
        paramVarArgs.ni(2, this.gTP.computeSize());
        this.gTP.writeFields(paramVarArgs);
      }
      if (this.gTQ != null)
      {
        paramVarArgs.ni(3, this.gTQ.computeSize());
        this.gTQ.writeFields(paramVarArgs);
      }
      if (this.gTR != null)
      {
        paramVarArgs.ni(4, this.gTR.computeSize());
        this.gTR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gTO == null) {
        break label774;
      }
    }
    label774:
    for (int i = g.a.a.a.nh(1, this.gTO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gTP != null) {
        paramInt = i + g.a.a.a.nh(2, this.gTP.computeSize());
      }
      i = paramInt;
      if (this.gTQ != null) {
        i = paramInt + g.a.a.a.nh(3, this.gTQ.computeSize());
      }
      paramInt = i;
      if (this.gTR != null) {
        paramInt = i + g.a.a.a.nh(4, this.gTR.computeSize());
      }
      AppMethodBeat.o(194684);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194684);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locall.gTO = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194684);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new p();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locall.gTP = ((p)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194684);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locall.gTQ = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194684);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locall.gTR = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194684);
        return 0;
      }
      AppMethodBeat.o(194684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.t.a.l
 * JD-Core Version:    0.7.0.1
 */