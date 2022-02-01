package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arl
  extends com.tencent.mm.bw.a
{
  public LinkedList<aqq> gCs;
  public long iVn;
  public String username;
  
  public arl()
  {
    AppMethodBeat.i(168968);
    this.gCs = new LinkedList();
    AppMethodBeat.o(168968);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168969);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.gCs);
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.bb(3, this.iVn);
      AppMethodBeat.o(168969);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.gCs) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = g.a.a.b.b.a.r(3, this.iVn);
      AppMethodBeat.o(168969);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.gCs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168969);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      arl localarl = (arl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168969);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aqq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localarl.gCs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168969);
        return 0;
      case 2: 
        localarl.username = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(168969);
        return 0;
      }
      localarl.iVn = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(168969);
      return 0;
    }
    AppMethodBeat.o(168969);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */