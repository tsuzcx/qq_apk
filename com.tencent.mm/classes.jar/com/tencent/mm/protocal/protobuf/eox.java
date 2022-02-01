package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eox
  extends com.tencent.mm.bw.a
{
  public ddj NmV;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56263);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NmV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(56263);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.NmV != null)
      {
        paramVarArgs.ni(2, this.NmV.computeSize());
        this.NmV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NmV != null) {
        i = paramInt + g.a.a.a.nh(2, this.NmV.computeSize());
      }
      AppMethodBeat.o(56263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NmV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(56263);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eox localeox = (eox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56263);
          return -1;
        case 1: 
          localeox.Username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56263);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ddj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeox.NmV = ((ddj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      AppMethodBeat.o(56263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eox
 * JD-Core Version:    0.7.0.1
 */