package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agu
  extends com.tencent.mm.bw.a
{
  public long EyS;
  public long EyT;
  public LinkedList<dhf> EyU;
  
  public agu()
  {
    AppMethodBeat.i(125722);
    this.EyU = new LinkedList();
    AppMethodBeat.o(125722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EyS);
      paramVarArgs.aO(2, this.EyT);
      paramVarArgs.e(3, 8, this.EyU);
      AppMethodBeat.o(125723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.EyS);
      i = f.a.a.b.b.a.p(2, this.EyT);
      int j = f.a.a.a.c(3, 8, this.EyU);
      AppMethodBeat.o(125723);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EyU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      agu localagu = (agu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125723);
        return -1;
      case 1: 
        localagu.EyS = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125723);
        return 0;
      case 2: 
        localagu.EyT = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(125723);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dhf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dhf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localagu.EyU.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    AppMethodBeat.o(125723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agu
 * JD-Core Version:    0.7.0.1
 */