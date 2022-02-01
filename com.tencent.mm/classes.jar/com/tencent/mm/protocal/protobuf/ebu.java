package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ebu
  extends com.tencent.mm.bw.a
{
  public eas Ihc;
  public ebl Ihm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ihc == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147815);
        throw paramVarArgs;
      }
      if (this.Ihc != null)
      {
        paramVarArgs.lJ(1, this.Ihc.computeSize());
        this.Ihc.writeFields(paramVarArgs);
      }
      if (this.Ihm != null)
      {
        paramVarArgs.lJ(2, this.Ihm.computeSize());
        this.Ihm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ihc == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.Ihc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ihm != null) {
        i = paramInt + f.a.a.a.lI(2, this.Ihm.computeSize());
      }
      AppMethodBeat.o(147815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Ihc == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebu localebu = (ebu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eas();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebu.Ihc = ((eas)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localebu.Ihm = ((ebl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      AppMethodBeat.o(147815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebu
 * JD-Core Version:    0.7.0.1
 */