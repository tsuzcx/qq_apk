package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fps
  extends com.tencent.mm.cd.a
{
  public String UNG;
  public fpn UNq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153343);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      if (this.UNG != null) {
        paramVarArgs.f(2, this.UNG);
      }
      AppMethodBeat.o(153343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UNG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UNG);
      }
      AppMethodBeat.o(153343);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153343);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fps localfps = (fps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153343);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpn localfpn = new fpn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpn.parseFrom((byte[])localObject);
            }
            localfps.UNq = localfpn;
            paramInt += 1;
          }
          AppMethodBeat.o(153343);
          return 0;
        }
        localfps.UNG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153343);
        return 0;
      }
      AppMethodBeat.o(153343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fps
 * JD-Core Version:    0.7.0.1
 */