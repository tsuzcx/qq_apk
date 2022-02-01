package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bgk
  extends com.tencent.mm.bw.a
{
  public bgd LQk;
  public LinkedList<String> LQl;
  
  public bgk()
  {
    AppMethodBeat.i(42644);
    this.LQl = new LinkedList();
    AppMethodBeat.o(42644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42645);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LQk == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(42645);
        throw paramVarArgs;
      }
      if (this.LQk != null)
      {
        paramVarArgs.ni(1, this.LQk.computeSize());
        this.LQk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.LQl);
      AppMethodBeat.o(42645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LQk == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.a.nh(1, this.LQk.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.LQl);
      AppMethodBeat.o(42645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LQl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LQk == null)
        {
          paramVarArgs = new b("Not all required fields were included: GameItem");
          AppMethodBeat.o(42645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgk localbgk = (bgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42645);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgk.LQk = ((bgd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42645);
          return 0;
        }
        localbgk.LQl.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(42645);
        return 0;
      }
      AppMethodBeat.o(42645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgk
 * JD-Core Version:    0.7.0.1
 */