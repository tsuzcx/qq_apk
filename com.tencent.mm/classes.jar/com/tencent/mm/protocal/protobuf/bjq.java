package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjq
  extends com.tencent.mm.bw.a
{
  public int EYZ;
  public LinkedList<bwr> EZa;
  public int EZb;
  
  public bjq()
  {
    AppMethodBeat.i(143977);
    this.EZa = new LinkedList();
    AppMethodBeat.o(143977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143978);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EYZ);
      paramVarArgs.e(2, 8, this.EZa);
      paramVarArgs.aR(3, this.EZb);
      AppMethodBeat.o(143978);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EYZ);
      i = f.a.a.a.c(2, 8, this.EZa);
      int j = f.a.a.b.b.a.bx(3, this.EZb);
      AppMethodBeat.o(143978);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EZa.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143978);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bjq localbjq = (bjq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143978);
        return -1;
      case 1: 
        localbjq.EYZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143978);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjq.EZa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143978);
        return 0;
      }
      localbjq.EZb = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(143978);
      return 0;
    }
    AppMethodBeat.o(143978);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjq
 * JD-Core Version:    0.7.0.1
 */