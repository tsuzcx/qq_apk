package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdu
  extends com.tencent.mm.bw.a
{
  public String LNA;
  public bds dMU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dMU != null)
      {
        paramVarArgs.ni(1, this.dMU.computeSize());
        this.dMU.writeFields(paramVarArgs);
      }
      if (this.LNA != null) {
        paramVarArgs.e(2, this.LNA);
      }
      AppMethodBeat.o(209707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dMU == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.a.nh(1, this.dMU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LNA != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LNA);
      }
      AppMethodBeat.o(209707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdu localbdu = (bdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209707);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdu.dMU = ((bds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209707);
          return 0;
        }
        localbdu.LNA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209707);
        return 0;
      }
      AppMethodBeat.o(209707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdu
 * JD-Core Version:    0.7.0.1
 */