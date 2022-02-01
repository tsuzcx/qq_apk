package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkg
  extends com.tencent.mm.bx.a
{
  public int HyX;
  public int HyY;
  public LinkedList<ccq> HyZ;
  
  public dkg()
  {
    AppMethodBeat.i(143986);
    this.HyZ = new LinkedList();
    AppMethodBeat.o(143986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143987);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HyX);
      paramVarArgs.aS(2, this.HyY);
      paramVarArgs.e(3, 8, this.HyZ);
      AppMethodBeat.o(143987);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HyX);
      i = f.a.a.b.b.a.bz(2, this.HyY);
      int j = f.a.a.a.c(3, 8, this.HyZ);
      AppMethodBeat.o(143987);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HyZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkg localdkg = (dkg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143987);
        return -1;
      case 1: 
        localdkg.HyX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143987);
        return 0;
      case 2: 
        localdkg.HyY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143987);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ccq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdkg.HyZ.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    AppMethodBeat.o(143987);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */