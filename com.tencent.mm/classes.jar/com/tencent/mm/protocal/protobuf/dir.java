package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dir
  extends com.tencent.mm.bw.a
{
  public dqi KGR;
  public dqi Lqk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.KGR != null)
      {
        paramVarArgs.ni(1, this.KGR.computeSize());
        this.KGR.writeFields(paramVarArgs);
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(2, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGR == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.KGR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lqk != null) {
        i = paramInt + g.a.a.a.nh(2, this.Lqk.computeSize());
      }
      AppMethodBeat.o(101829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KGR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dir localdir = (dir)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101829);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdir.KGR = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101829);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdir.Lqk = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      AppMethodBeat.o(101829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dir
 * JD-Core Version:    0.7.0.1
 */