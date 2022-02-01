package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gt
  extends com.tencent.mm.cd.a
{
  public cvt RLH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLH == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaObj");
        AppMethodBeat.o(125713);
        throw paramVarArgs;
      }
      if (this.RLH != null)
      {
        paramVarArgs.oE(1, this.RLH.computeSize());
        this.RLH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RLH == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.a.oD(1, this.RLH.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125713);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLH == null)
        {
          paramVarArgs = new b("Not all required fields were included: MediaObj");
          AppMethodBeat.o(125713);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gt localgt = (gt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125713);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cvt localcvt = new cvt();
          if ((localObject != null) && (localObject.length > 0)) {
            localcvt.parseFrom((byte[])localObject);
          }
          localgt.RLH = localcvt;
          paramInt += 1;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      AppMethodBeat.o(125713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gt
 * JD-Core Version:    0.7.0.1
 */