package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csm
  extends com.tencent.mm.bw.a
{
  public axy MwY;
  public csk Mxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256727);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mxx != null)
      {
        paramVarArgs.ni(1, this.Mxx.computeSize());
        this.Mxx.writeFields(paramVarArgs);
      }
      if (this.MwY != null)
      {
        paramVarArgs.ni(2, this.MwY.computeSize());
        this.MwY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mxx == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.nh(1, this.Mxx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MwY != null) {
        i = paramInt + g.a.a.a.nh(2, this.MwY.computeSize());
      }
      AppMethodBeat.o(256727);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csm localcsm = (csm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256727);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsm.Mxx = ((csk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256727);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsm.MwY = ((axy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256727);
        return 0;
      }
      AppMethodBeat.o(256727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */