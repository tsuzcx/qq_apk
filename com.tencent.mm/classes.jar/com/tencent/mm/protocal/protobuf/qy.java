package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qy
  extends com.tencent.mm.bw.a
{
  public int KXN;
  public int KXO;
  public int KXP;
  public LinkedList<qx> KXQ;
  public LinkedList<qx> KXR;
  
  public qy()
  {
    AppMethodBeat.i(133159);
    this.KXQ = new LinkedList();
    this.KXR = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXN);
      paramVarArgs.aM(2, this.KXO);
      paramVarArgs.aM(5, this.KXP);
      paramVarArgs.e(3, 8, this.KXQ);
      paramVarArgs.e(4, 8, this.KXR);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KXN);
      i = g.a.a.b.b.a.bu(2, this.KXO);
      int j = g.a.a.b.b.a.bu(5, this.KXP);
      int k = g.a.a.a.c(3, 8, this.KXQ);
      int m = g.a.a.a.c(4, 8, this.KXR);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KXQ.clear();
      this.KXR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      qy localqy = (qy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localqy.KXN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localqy.KXO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localqy.KXP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localqy.KXQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new qx();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localqy.KXR.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    AppMethodBeat.o(133160);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qy
 * JD-Core Version:    0.7.0.1
 */