package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avj
  extends com.tencent.mm.bw.a
{
  public vh LFZ;
  public int LGa;
  public String uUI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209502);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LFZ != null)
      {
        paramVarArgs.ni(1, this.LFZ.computeSize());
        this.LFZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LGa);
      if (this.uUI != null) {
        paramVarArgs.e(3, this.uUI);
      }
      AppMethodBeat.o(209502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LFZ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.a.nh(1, this.LFZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LGa);
      paramInt = i;
      if (this.uUI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.uUI);
      }
      AppMethodBeat.o(209502);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avj localavj = (avj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209502);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((vh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavj.LFZ = ((vh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209502);
          return 0;
        case 2: 
          localavj.LGa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209502);
          return 0;
        }
        localavj.uUI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209502);
        return 0;
      }
      AppMethodBeat.o(209502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avj
 * JD-Core Version:    0.7.0.1
 */