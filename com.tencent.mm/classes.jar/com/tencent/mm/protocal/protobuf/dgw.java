package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgw
  extends com.tencent.mm.cd.a
{
  public abv TKA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TKA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(43118);
        throw paramVarArgs;
      }
      if (this.TKA != null)
      {
        paramVarArgs.oE(1, this.TKA.computeSize());
        this.TKA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TKA == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.a.oD(1, this.TKA.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43118);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TKA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(43118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43118);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          abv localabv = new abv();
          if ((localObject != null) && (localObject.length > 0)) {
            localabv.parseFrom((byte[])localObject);
          }
          localdgw.TKA = localabv;
          paramInt += 1;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      AppMethodBeat.o(43118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */