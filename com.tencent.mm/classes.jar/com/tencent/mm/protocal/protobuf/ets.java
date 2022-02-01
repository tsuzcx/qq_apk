package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ets
  extends com.tencent.mm.cd.a
{
  public eur UvB;
  public eto UvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UvB == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaEncryptData");
        AppMethodBeat.o(209722);
        throw paramVarArgs;
      }
      if (this.UvC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptData");
        AppMethodBeat.o(209722);
        throw paramVarArgs;
      }
      if (this.UvB != null)
      {
        paramVarArgs.oE(1, this.UvB.computeSize());
        this.UvB.writeFields(paramVarArgs);
      }
      if (this.UvC != null)
      {
        paramVarArgs.oE(2, this.UvC.computeSize());
        this.UvC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UvB == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.oD(1, this.UvB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UvC != null) {
        i = paramInt + g.a.a.a.oD(2, this.UvC.computeSize());
      }
      AppMethodBeat.o(209722);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UvB == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaEncryptData");
          AppMethodBeat.o(209722);
          throw paramVarArgs;
        }
        if (this.UvC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesEncryptData");
          AppMethodBeat.o(209722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ets localets = (ets)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209722);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eur)localObject2).parseFrom((byte[])localObject1);
            }
            localets.UvB = ((eur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209722);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eto();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eto)localObject2).parseFrom((byte[])localObject1);
          }
          localets.UvC = ((eto)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(209722);
        return 0;
      }
      AppMethodBeat.o(209722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ets
 * JD-Core Version:    0.7.0.1
 */