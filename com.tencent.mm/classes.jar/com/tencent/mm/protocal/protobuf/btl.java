package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btl
  extends com.tencent.mm.bx.a
{
  public LinkedList<qn> DaU;
  public int DaV;
  public int DaW;
  public long lastUpdateTime;
  public int version;
  
  public btl()
  {
    AppMethodBeat.i(32357);
    this.DaU = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DaU);
      paramVarArgs.aR(2, this.version);
      paramVarArgs.aR(3, this.DaV);
      paramVarArgs.aR(4, this.DaW);
      paramVarArgs.aG(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.DaU);
      i = f.a.a.b.b.a.bA(2, this.version);
      int j = f.a.a.b.b.a.bA(3, this.DaV);
      int k = f.a.a.b.b.a.bA(4, this.DaW);
      int m = f.a.a.b.b.a.q(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DaU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      btl localbtl = (btl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtl.DaU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localbtl.version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localbtl.DaV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localbtl.DaW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32358);
        return 0;
      }
      localbtl.lastUpdateTime = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btl
 * JD-Core Version:    0.7.0.1
 */