package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eur
  extends com.tencent.mm.cd.a
{
  public eae Uwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212034);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uwn == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryptKey");
        AppMethodBeat.o(212034);
        throw paramVarArgs;
      }
      if (this.Uwn != null)
      {
        paramVarArgs.oE(1, this.Uwn.computeSize());
        this.Uwn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uwn == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.a.oD(1, this.Uwn.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(212034);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uwn == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryptKey");
          AppMethodBeat.o(212034);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eur localeur = (eur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212034);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localeur.Uwn = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(212034);
        return 0;
      }
      AppMethodBeat.o(212034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eur
 * JD-Core Version:    0.7.0.1
 */