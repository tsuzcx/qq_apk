package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmz
  extends com.tencent.mm.bx.a
{
  public int GeI;
  public long GeJ;
  public LinkedList<cni> Hgo;
  public int uLN;
  
  public cmz()
  {
    AppMethodBeat.i(32381);
    this.Hgo = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeI);
      paramVarArgs.aY(2, this.GeJ);
      paramVarArgs.e(3, 8, this.Hgo);
      paramVarArgs.aS(4, this.uLN);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GeI);
      i = f.a.a.b.b.a.p(2, this.GeJ);
      int j = f.a.a.a.c(3, 8, this.Hgo);
      int k = f.a.a.b.b.a.bz(4, this.uLN);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hgo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmz localcmz = (cmz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localcmz.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localcmz.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cni();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmz.Hgo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localcmz.uLN = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmz
 * JD-Core Version:    0.7.0.1
 */