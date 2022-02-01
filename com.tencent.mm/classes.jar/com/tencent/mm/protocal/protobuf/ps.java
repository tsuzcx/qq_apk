package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ps
  extends com.tencent.mm.bw.a
{
  public dpe KWG;
  public String KWH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWG != null)
      {
        paramVarArgs.ni(1, this.KWG.computeSize());
        this.KWG.writeFields(paramVarArgs);
      }
      if (this.KWH != null) {
        paramVarArgs.e(2, this.KWH);
      }
      AppMethodBeat.o(117836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWG == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.a.nh(1, this.KWG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KWH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KWH);
      }
      AppMethodBeat.o(117836);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ps localps = (ps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117836);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dpe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localps.KWG = ((dpe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117836);
          return 0;
        }
        localps.KWH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117836);
        return 0;
      }
      AppMethodBeat.o(117836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */