package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agj
  extends com.tencent.mm.bx.a
{
  public int FAu;
  public LinkedList<dsj> Ger;
  public int Ges;
  public boolean Get;
  public int Scene;
  
  public agj()
  {
    AppMethodBeat.i(104763);
    this.Ger = new LinkedList();
    this.Get = false;
    this.FAu = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ger);
      paramVarArgs.aS(2, this.Ges);
      paramVarArgs.bt(3, this.Get);
      paramVarArgs.aS(4, this.FAu);
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.Ger);
      i = f.a.a.b.b.a.bz(2, this.Ges);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.bz(4, this.FAu);
      int m = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ger.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      agj localagj = (agj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dsj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagj.Ger.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localagj.Ges = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localagj.Get = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localagj.FAu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104764);
        return 0;
      }
      localagj.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agj
 * JD-Core Version:    0.7.0.1
 */