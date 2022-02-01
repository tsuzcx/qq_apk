package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cpj
  extends com.tencent.mm.bw.a
{
  public dqi KGR;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101827);
        throw paramVarArgs;
      }
      if (this.KGR != null)
      {
        paramVarArgs.ni(1, this.KGR.computeSize());
        this.KGR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTW);
      AppMethodBeat.o(101827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGR == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.a.nh(1, this.KGR.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTW);
      AppMethodBeat.o(101827);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KGR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpj localcpj = (cpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101827);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpj.KGR = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101827);
          return 0;
        }
        localcpj.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101827);
        return 0;
      }
      AppMethodBeat.o(101827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpj
 * JD-Core Version:    0.7.0.1
 */