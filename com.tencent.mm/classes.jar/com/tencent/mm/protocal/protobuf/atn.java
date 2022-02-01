package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atn
  extends com.tencent.mm.bw.a
{
  public String LEo;
  public ecq tVf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LEo != null) {
        paramVarArgs.e(1, this.LEo);
      }
      if (this.tVf != null)
      {
        paramVarArgs.ni(2, this.tVf.computeSize());
        this.tVf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LEo == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.LEo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tVf != null) {
        i = paramInt + g.a.a.a.nh(2, this.tVf.computeSize());
      }
      AppMethodBeat.o(209451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atn localatn = (atn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209451);
          return -1;
        case 1: 
          localatn.LEo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209451);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localatn.tVf = ((ecq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209451);
        return 0;
      }
      AppMethodBeat.o(209451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atn
 * JD-Core Version:    0.7.0.1
 */