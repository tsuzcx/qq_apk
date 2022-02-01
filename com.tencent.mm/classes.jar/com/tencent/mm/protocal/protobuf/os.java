package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class os
  extends com.tencent.mm.cd.a
{
  public ach RWQ;
  public boolean RWR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207311);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RWQ != null)
      {
        paramVarArgs.oE(1, this.RWQ.computeSize());
        this.RWQ.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.RWR);
      AppMethodBeat.o(207311);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RWQ == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = g.a.a.a.oD(1, this.RWQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(207311);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207311);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        os localos = (os)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207311);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ach localach = new ach();
            if ((localObject != null) && (localObject.length > 0)) {
              localach.parseFrom((byte[])localObject);
            }
            localos.RWQ = localach;
            paramInt += 1;
          }
          AppMethodBeat.o(207311);
          return 0;
        }
        localos.RWR = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(207311);
        return 0;
      }
      AppMethodBeat.o(207311);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.os
 * JD-Core Version:    0.7.0.1
 */