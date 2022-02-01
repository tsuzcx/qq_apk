package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgy
  extends com.tencent.mm.bw.a
{
  public LinkedList<fbv> KKx;
  public int oTz;
  public String xLl;
  
  public cgy()
  {
    AppMethodBeat.i(197135);
    this.KKx = new LinkedList();
    AppMethodBeat.o(197135);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197136);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl != null) {
        paramVarArgs.e(1, this.xLl);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(3, 8, this.KKx);
      AppMethodBeat.o(197136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xLl == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.f(1, this.xLl) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTz);
      int j = g.a.a.a.c(3, 8, this.KKx);
      AppMethodBeat.o(197136);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KKx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(197136);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197136);
          return -1;
        case 1: 
          localcgy.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(197136);
          return 0;
        case 2: 
          localcgy.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(197136);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fbv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcgy.KKx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(197136);
        return 0;
      }
      AppMethodBeat.o(197136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */