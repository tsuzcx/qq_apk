package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oj
  extends com.tencent.mm.bx.a
{
  public int CLW;
  public int CLX;
  public int CLY;
  public LinkedList<oi> CLZ;
  public LinkedList<oi> CMa;
  
  public oj()
  {
    AppMethodBeat.i(133159);
    this.CLZ = new LinkedList();
    this.CMa = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CLW);
      paramVarArgs.aR(2, this.CLX);
      paramVarArgs.aR(5, this.CLY);
      paramVarArgs.e(3, 8, this.CLZ);
      paramVarArgs.e(4, 8, this.CMa);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CLW);
      i = f.a.a.b.b.a.bA(2, this.CLX);
      int j = f.a.a.b.b.a.bA(5, this.CLY);
      int k = f.a.a.a.c(3, 8, this.CLZ);
      int m = f.a.a.a.c(4, 8, this.CMa);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CLZ.clear();
      this.CMa.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      oj localoj = (oj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localoj.CLW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localoj.CLX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localoj.CLY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoj.CLZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new oi();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localoj.CMa.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */