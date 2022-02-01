package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ach
  extends com.tencent.mm.bw.a
{
  public crq LmQ;
  public boolean LmR;
  public String sGQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208701);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LmQ != null)
      {
        paramVarArgs.ni(1, this.LmQ.computeSize());
        this.LmQ.writeFields(paramVarArgs);
      }
      if (this.sGQ != null) {
        paramVarArgs.e(2, this.sGQ);
      }
      paramVarArgs.cc(3, this.LmR);
      AppMethodBeat.o(208701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LmQ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.a.nh(1, this.LmQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sGQ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.sGQ);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(208701);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208701);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ach localach = (ach)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208701);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localach.LmQ = ((crq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208701);
          return 0;
        case 2: 
          localach.sGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208701);
          return 0;
        }
        localach.LmR = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(208701);
        return 0;
      }
      AppMethodBeat.o(208701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ach
 * JD-Core Version:    0.7.0.1
 */