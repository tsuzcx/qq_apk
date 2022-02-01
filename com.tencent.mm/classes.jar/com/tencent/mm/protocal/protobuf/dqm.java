package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqm
  extends com.tencent.mm.bw.a
{
  public LinkedList<ckf> MTs;
  public boolean MTt;
  public boolean MTu;
  public boolean MTv;
  public boolean MTw;
  public boolean MTx;
  
  public dqm()
  {
    AppMethodBeat.i(155454);
    this.MTs = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.MTs);
      paramVarArgs.cc(2, this.MTt);
      paramVarArgs.cc(3, this.MTu);
      paramVarArgs.cc(4, this.MTv);
      paramVarArgs.cc(5, this.MTw);
      paramVarArgs.cc(6, this.MTx);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.MTs);
      i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MTs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dqm localdqm = (dqm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ckf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdqm.MTs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localdqm.MTt = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localdqm.MTu = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localdqm.MTv = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localdqm.MTw = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(155455);
        return 0;
      }
      localdqm.MTx = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqm
 * JD-Core Version:    0.7.0.1
 */