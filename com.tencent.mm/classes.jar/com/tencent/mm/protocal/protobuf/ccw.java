package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccw
  extends com.tencent.mm.bx.a
{
  public LinkedList<cdf> DZm;
  public int DdZ;
  public long Dea;
  public int sBs;
  
  public ccw()
  {
    AppMethodBeat.i(32381);
    this.DZm = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DdZ);
      paramVarArgs.aG(2, this.Dea);
      paramVarArgs.e(3, 8, this.DZm);
      paramVarArgs.aR(4, this.sBs);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DdZ);
      i = f.a.a.b.b.a.q(2, this.Dea);
      int j = f.a.a.a.c(3, 8, this.DZm);
      int k = f.a.a.b.b.a.bA(4, this.sBs);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DZm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ccw localccw = (ccw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localccw.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localccw.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccw.DZm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localccw.sBs = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccw
 * JD-Core Version:    0.7.0.1
 */