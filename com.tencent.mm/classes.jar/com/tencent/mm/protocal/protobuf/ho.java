package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ho
  extends com.tencent.mm.cd.a
{
  public eae RMQ;
  public eae RMR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133147);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RMQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: EncryptKey");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(133147);
        throw paramVarArgs;
      }
      if (this.RMQ != null)
      {
        paramVarArgs.oE(1, this.RMQ.computeSize());
        this.RMQ.writeFields(paramVarArgs);
      }
      if (this.RMR != null)
      {
        paramVarArgs.oE(2, this.RMR.computeSize());
        this.RMR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RMQ == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.oD(1, this.RMQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RMR != null) {
        i = paramInt + g.a.a.a.oD(2, this.RMR.computeSize());
      }
      AppMethodBeat.o(133147);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RMQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: EncryptKey");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        if (this.RMR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(133147);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eae localeae;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133147);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localho.RMQ = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(133147);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localho.RMR = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(133147);
        return 0;
      }
      AppMethodBeat.o(133147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ho
 * JD-Core Version:    0.7.0.1
 */