package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmq
  extends com.tencent.mm.bw.a
{
  public cfl MQi;
  public cfl MQj;
  public String dQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72578);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      if (this.MQi != null)
      {
        paramVarArgs.ni(2, this.MQi.computeSize());
        this.MQi.writeFields(paramVarArgs);
      }
      if (this.MQj != null)
      {
        paramVarArgs.ni(3, this.MQj.computeSize());
        this.MQj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.b.b.a.f(1, this.dQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MQi != null) {
        paramInt = i + g.a.a.a.nh(2, this.MQi.computeSize());
      }
      i = paramInt;
      if (this.MQj != null) {
        i = paramInt + g.a.a.a.nh(3, this.MQj.computeSize());
      }
      AppMethodBeat.o(72578);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmq localdmq = (dmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72578);
          return -1;
        case 1: 
          localdmq.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72578);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmq.MQi = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72578);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmq.MQj = ((cfl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      AppMethodBeat.o(72578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmq
 * JD-Core Version:    0.7.0.1
 */