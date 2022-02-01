package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erg
  extends com.tencent.mm.bw.a
{
  public cyf MTe;
  public cml NoS;
  public int NoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MTe != null)
      {
        paramVarArgs.ni(1, this.MTe.computeSize());
        this.MTe.writeFields(paramVarArgs);
      }
      if (this.NoS != null)
      {
        paramVarArgs.ni(2, this.NoS.computeSize());
        this.NoS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.NoT);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MTe == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.MTe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NoS != null) {
        i = paramInt + g.a.a.a.nh(2, this.NoS.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.NoT);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        erg localerg = (erg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localerg.MTe = ((cyf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cml();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cml)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localerg.NoS = ((cml)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localerg.NoT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erg
 * JD-Core Version:    0.7.0.1
 */