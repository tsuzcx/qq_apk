package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxr
  extends com.tencent.mm.bx.a
{
  public int FKZ;
  public LinkedList<dxq> HKf;
  public int nDi;
  
  public dxr()
  {
    AppMethodBeat.i(115874);
    this.HKf = new LinkedList();
    AppMethodBeat.o(115874);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nDi);
      paramVarArgs.e(2, 8, this.HKf);
      paramVarArgs.aS(3, this.FKZ);
      AppMethodBeat.o(115875);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nDi);
      i = f.a.a.a.c(2, 8, this.HKf);
      int j = f.a.a.b.b.a.bz(3, this.FKZ);
      AppMethodBeat.o(115875);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HKf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(115875);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxr localdxr = (dxr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115875);
        return -1;
      case 1: 
        localdxr.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115875);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxr.HKf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115875);
        return 0;
      }
      localdxr.FKZ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(115875);
      return 0;
    }
    AppMethodBeat.o(115875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxr
 * JD-Core Version:    0.7.0.1
 */