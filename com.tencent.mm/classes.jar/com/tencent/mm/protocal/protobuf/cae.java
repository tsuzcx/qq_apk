package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cae
  extends com.tencent.mm.bw.a
{
  public ehf KEN;
  public LinkedList<dyr> KEQ;
  public String KNW;
  
  public cae()
  {
    AppMethodBeat.i(91514);
    this.KEQ = new LinkedList();
    AppMethodBeat.o(91514);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91515);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KEN != null)
      {
        paramVarArgs.ni(1, this.KEN.computeSize());
        this.KEN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KEQ);
      if (this.KNW != null) {
        paramVarArgs.e(3, this.KNW);
      }
      AppMethodBeat.o(91515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KEN == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.KEN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KEQ);
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KNW);
      }
      AppMethodBeat.o(91515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KEQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91515);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cae localcae = (cae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91515);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcae.KEN = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
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
            localcae.KEQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
          return 0;
        }
        localcae.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91515);
        return 0;
      }
      AppMethodBeat.o(91515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cae
 * JD-Core Version:    0.7.0.1
 */