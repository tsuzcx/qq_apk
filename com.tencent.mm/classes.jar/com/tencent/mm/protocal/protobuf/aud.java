package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aud
  extends com.tencent.mm.bw.a
{
  public anv LEP;
  public FinderObject tuO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tuO != null)
      {
        paramVarArgs.ni(1, this.tuO.computeSize());
        this.tuO.writeFields(paramVarArgs);
      }
      if (this.LEP != null)
      {
        paramVarArgs.ni(2, this.LEP.computeSize());
        this.LEP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tuO == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.nh(1, this.tuO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LEP != null) {
        i = paramInt + g.a.a.a.nh(2, this.LEP.computeSize());
      }
      AppMethodBeat.o(209467);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aud localaud = (aud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209467);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaud.tuO = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209467);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaud.LEP = ((anv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209467);
        return 0;
      }
      AppMethodBeat.o(209467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aud
 * JD-Core Version:    0.7.0.1
 */