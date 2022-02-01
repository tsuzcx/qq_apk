package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bga
  extends com.tencent.mm.bw.a
{
  public long LPF;
  public LinkedList<cbn> LPG;
  public LinkedList<erd> LPH;
  public String name;
  public long startTime;
  
  public bga()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.LPF = 0L;
    this.LPG = new LinkedList();
    this.LPH = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.bb(2, this.startTime);
      paramVarArgs.bb(3, this.LPF);
      paramVarArgs.e(4, 8, this.LPG);
      paramVarArgs.e(5, 8, this.LPH);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = g.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.startTime);
      int j = g.a.a.b.b.a.r(3, this.LPF);
      int k = g.a.a.a.c(4, 8, this.LPG);
      int m = g.a.a.a.c(5, 8, this.LPH);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LPG.clear();
        this.LPH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bga localbga = (bga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localbga.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localbga.startTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localbga.LPF = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122500);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbga.LPG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new erd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((erd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbga.LPH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      AppMethodBeat.o(122500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bga
 * JD-Core Version:    0.7.0.1
 */