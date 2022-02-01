package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csg
  extends com.tencent.mm.bw.a
{
  public axy Aqo;
  public String MwX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwX != null) {
        paramVarArgs.e(1, this.MwX);
      }
      if (this.Aqo != null)
      {
        paramVarArgs.ni(2, this.Aqo.computeSize());
        this.Aqo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwX == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.MwX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Aqo != null) {
        i = paramInt + g.a.a.a.nh(2, this.Aqo.computeSize());
      }
      AppMethodBeat.o(256721);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csg localcsg = (csg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256721);
          return -1;
        case 1: 
          localcsg.MwX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256721);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((axy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsg.Aqo = ((axy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256721);
        return 0;
      }
      AppMethodBeat.o(256721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csg
 * JD-Core Version:    0.7.0.1
 */