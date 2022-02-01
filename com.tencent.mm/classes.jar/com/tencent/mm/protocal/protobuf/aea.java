package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aea
  extends com.tencent.mm.bw.a
{
  public int DUZ;
  public LinkedList<dms> EwO;
  public int EwP;
  public boolean EwQ;
  public int Scene;
  
  public aea()
  {
    AppMethodBeat.i(104763);
    this.EwO = new LinkedList();
    this.EwQ = false;
    this.DUZ = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EwO);
      paramVarArgs.aR(2, this.EwP);
      paramVarArgs.bl(3, this.EwQ);
      paramVarArgs.aR(4, this.DUZ);
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.EwO);
      i = f.a.a.b.b.a.bx(2, this.EwP);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.bx(4, this.DUZ);
      int m = f.a.a.b.b.a.bx(5, this.Scene);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EwO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aea localaea = (aea)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dms();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dms)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaea.EwO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localaea.EwP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localaea.EwQ = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localaea.DUZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104764);
        return 0;
      }
      localaea.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aea
 * JD-Core Version:    0.7.0.1
 */