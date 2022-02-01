package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cct
  extends com.tencent.mm.bx.a
{
  public LinkedList<sq> Gbj;
  public int Gbk;
  public int Gbl;
  public long lastUpdateTime;
  public int version;
  
  public cct()
  {
    AppMethodBeat.i(32357);
    this.Gbj = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Gbj);
      paramVarArgs.aS(2, this.version);
      paramVarArgs.aS(3, this.Gbk);
      paramVarArgs.aS(4, this.Gbl);
      paramVarArgs.aY(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.Gbj);
      i = f.a.a.b.b.a.bz(2, this.version);
      int j = f.a.a.b.b.a.bz(3, this.Gbk);
      int k = f.a.a.b.b.a.bz(4, this.Gbl);
      int m = f.a.a.b.b.a.p(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gbj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cct localcct = (cct)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((sq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcct.Gbj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localcct.version = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localcct.Gbk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localcct.Gbl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32358);
        return 0;
      }
      localcct.lastUpdateTime = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cct
 * JD-Core Version:    0.7.0.1
 */