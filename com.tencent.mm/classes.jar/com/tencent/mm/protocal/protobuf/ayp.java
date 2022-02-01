package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayp
  extends com.tencent.mm.bw.a
{
  public String LIQ;
  public azk musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LIQ != null) {
        paramVarArgs.e(1, this.LIQ);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.ni(2, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LIQ == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.LIQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.musicInfo != null) {
        i = paramInt + g.a.a.a.nh(2, this.musicInfo.computeSize());
      }
      AppMethodBeat.o(209597);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ayp localayp = (ayp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209597);
          return -1;
        case 1: 
          localayp.LIQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209597);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localayp.musicInfo = ((azk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209597);
        return 0;
      }
      AppMethodBeat.o(209597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayp
 * JD-Core Version:    0.7.0.1
 */