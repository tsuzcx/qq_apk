package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpv
  extends com.tencent.mm.cd.a
{
  public fpn UNq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153347);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153347);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(153347);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153347);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpv localfpv = (fpv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153347);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fpn localfpn = new fpn();
          if ((localObject != null) && (localObject.length > 0)) {
            localfpn.parseFrom((byte[])localObject);
          }
          localfpv.UNq = localfpn;
          paramInt += 1;
        }
        AppMethodBeat.o(153347);
        return 0;
      }
      AppMethodBeat.o(153347);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpv
 * JD-Core Version:    0.7.0.1
 */