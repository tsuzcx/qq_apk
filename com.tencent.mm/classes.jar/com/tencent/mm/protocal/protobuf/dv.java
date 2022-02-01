package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dv
  extends com.tencent.mm.bw.a
{
  public String KHR;
  public LinkedList<ecv> KHS;
  public String title;
  
  public dv()
  {
    AppMethodBeat.i(32112);
    this.KHS = new LinkedList();
    AppMethodBeat.o(32112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHR != null) {
        paramVarArgs.e(1, this.KHR);
      }
      paramVarArgs.e(2, 8, this.KHS);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      AppMethodBeat.o(32113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHR == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = g.a.a.b.b.a.f(1, this.KHR) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KHS);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.title);
      }
      AppMethodBeat.o(32113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KHS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32113);
          return -1;
        case 1: 
          localdv.KHR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32113);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ecv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdv.KHS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32113);
          return 0;
        }
        localdv.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32113);
        return 0;
      }
      AppMethodBeat.o(32113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */