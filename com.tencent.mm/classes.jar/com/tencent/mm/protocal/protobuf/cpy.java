package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpy
  extends com.tencent.mm.bw.a
{
  public cvt MvS;
  public String jHa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jHa != null) {
        paramVarArgs.e(1, this.jHa);
      }
      if (this.MvS != null)
      {
        paramVarArgs.ni(2, this.MvS.computeSize());
        this.MvS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jHa == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.jHa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MvS != null) {
        i = paramInt + g.a.a.a.nh(2, this.MvS.computeSize());
      }
      AppMethodBeat.o(152628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpy localcpy = (cpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152628);
          return -1;
        case 1: 
          localcpy.jHa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152628);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cvt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcpy.MvS = ((cvt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      AppMethodBeat.o(152628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpy
 * JD-Core Version:    0.7.0.1
 */