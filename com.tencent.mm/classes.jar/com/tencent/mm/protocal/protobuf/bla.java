package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bla
  extends com.tencent.mm.bw.a
{
  public int KHs;
  public dqi LTV;
  public int LTW;
  public int LTX;
  public int LTY = 1;
  public int LTZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LTV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.LTV != null)
      {
        paramVarArgs.ni(1, this.LTV.computeSize());
        this.LTV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KHs);
      paramVarArgs.aM(3, this.LTW);
      paramVarArgs.aM(4, this.LTX);
      paramVarArgs.aM(5, this.LTY);
      paramVarArgs.aM(6, this.LTZ);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LTV == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = g.a.a.a.nh(1, this.LTV.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KHs);
      int j = g.a.a.b.b.a.bu(3, this.LTW);
      int k = g.a.a.b.b.a.bu(4, this.LTX);
      int m = g.a.a.b.b.a.bu(5, this.LTY);
      int n = g.a.a.b.b.a.bu(6, this.LTZ);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LTV == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bla localbla = (bla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
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
            localbla.LTV = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localbla.KHs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localbla.LTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localbla.LTX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localbla.LTY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101809);
          return 0;
        }
        localbla.LTZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */