package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahf
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahg> LpW;
  public String content;
  public String title;
  
  public ahf()
  {
    AppMethodBeat.i(91433);
    this.LpW = new LinkedList();
    AppMethodBeat.o(91433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LpW);
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.LpW) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.content);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      AppMethodBeat.o(91434);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LpW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91434);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahf localahf = (ahf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91434);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahf.LpW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91434);
        return 0;
      case 2: 
        localahf.content = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91434);
        return 0;
      }
      localahf.title = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91434);
      return 0;
    }
    AppMethodBeat.o(91434);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahf
 * JD-Core Version:    0.7.0.1
 */