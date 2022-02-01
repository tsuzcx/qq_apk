package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public String KEo;
  public LinkedList<cws> KEp;
  public LinkedList<cwr> duo;
  
  public bb()
  {
    AppMethodBeat.i(152476);
    this.KEp = new LinkedList();
    this.duo = new LinkedList();
    AppMethodBeat.o(152476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152477);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KEo != null) {
        paramVarArgs.e(1, this.KEo);
      }
      paramVarArgs.e(2, 8, this.KEp);
      paramVarArgs.e(3, 8, this.duo);
      AppMethodBeat.o(152477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KEo == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.b.b.a.f(1, this.KEo) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KEp);
      int j = g.a.a.a.c(3, 8, this.duo);
      AppMethodBeat.o(152477);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KEp.clear();
        this.duo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152477);
          return -1;
        case 1: 
          localbb.KEo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152477);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cws();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cws)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.KEp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152477);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbb.duo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      AppMethodBeat.o(152477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */