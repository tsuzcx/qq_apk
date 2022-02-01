package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbr
  extends com.tencent.mm.bw.a
{
  public dda NxO;
  public dda NxP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NxO != null)
      {
        paramVarArgs.ni(1, this.NxO.computeSize());
        this.NxO.writeFields(paramVarArgs);
      }
      if (this.NxP != null)
      {
        paramVarArgs.ni(2, this.NxP.computeSize());
        this.NxP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NxO == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.nh(1, this.NxO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NxP != null) {
        i = paramInt + g.a.a.a.nh(2, this.NxP.computeSize());
      }
      AppMethodBeat.o(110919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbr localfbr = (fbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110919);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dda();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dda)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfbr.NxO = ((dda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110919);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dda();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dda)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfbr.NxP = ((dda)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      AppMethodBeat.o(110919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbr
 * JD-Core Version:    0.7.0.1
 */