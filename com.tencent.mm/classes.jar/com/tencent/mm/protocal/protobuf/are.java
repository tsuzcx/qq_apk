package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class are
  extends com.tencent.mm.bw.a
{
  public long DXN;
  public String DXO;
  public LinkedList<dqm> EKi;
  
  public are()
  {
    AppMethodBeat.i(110898);
    this.EKi = new LinkedList();
    AppMethodBeat.o(110898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110899);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXN);
      paramVarArgs.e(2, 8, this.EKi);
      if (this.DXO != null) {
        paramVarArgs.d(3, this.DXO);
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.DXN) + 0 + f.a.a.a.c(2, 8, this.EKi);
      paramInt = i;
      if (this.DXO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DXO);
      }
      AppMethodBeat.o(110899);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EKi.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      are localare = (are)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110899);
        return -1;
      case 1: 
        localare.DXN = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110899);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localare.EKi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110899);
        return 0;
      }
      localare.DXO = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(110899);
      return 0;
    }
    AppMethodBeat.o(110899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.are
 * JD-Core Version:    0.7.0.1
 */