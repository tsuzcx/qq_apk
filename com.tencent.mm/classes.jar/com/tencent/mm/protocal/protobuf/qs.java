package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qs
  extends com.tencent.mm.bw.a
{
  public String KXy;
  public LinkedList<dgp> KXz;
  
  public qs()
  {
    AppMethodBeat.i(200187);
    this.KXz = new LinkedList();
    AppMethodBeat.o(200187);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200188);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXy != null) {
        paramVarArgs.e(1, this.KXy);
      }
      paramVarArgs.e(2, 8, this.KXz);
      AppMethodBeat.o(200188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXy == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.b.b.a.f(1, this.KXy) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KXz);
      AppMethodBeat.o(200188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KXz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200188);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qs localqs = (qs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200188);
          return -1;
        case 1: 
          localqs.KXy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200188);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dgp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localqs.KXz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200188);
        return 0;
      }
      AppMethodBeat.o(200188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qs
 * JD-Core Version:    0.7.0.1
 */