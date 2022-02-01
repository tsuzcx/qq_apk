package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dos
  extends com.tencent.mm.bx.a
{
  public dnq EEM;
  public doj EEW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEM == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147815);
        throw paramVarArgs;
      }
      if (this.EEM != null)
      {
        paramVarArgs.kX(1, this.EEM.computeSize());
        this.EEM.writeFields(paramVarArgs);
      }
      if (this.EEW != null)
      {
        paramVarArgs.kX(2, this.EEW.computeSize());
        this.EEW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEM == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.kW(1, this.EEM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EEW != null) {
        i = paramInt + f.a.a.a.kW(2, this.EEW.computeSize());
      }
      AppMethodBeat.o(147815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EEM == null)
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
        dos localdos = (dos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdos.EEM = ((dnq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdos.EEW = ((doj)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dos
 * JD-Core Version:    0.7.0.1
 */