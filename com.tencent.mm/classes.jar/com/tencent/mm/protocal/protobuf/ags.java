package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ags
  extends com.tencent.mm.bw.a
{
  public LinkedList<dtg> GwY;
  public int GwZ;
  public boolean Gxa;
  public int Scene;
  public int uqG;
  
  public ags()
  {
    AppMethodBeat.i(104763);
    this.GwY = new LinkedList();
    this.Gxa = false;
    this.uqG = 0;
    AppMethodBeat.o(104763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GwY);
      paramVarArgs.aS(2, this.GwZ);
      paramVarArgs.bC(3, this.Gxa);
      paramVarArgs.aS(4, this.uqG);
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(104764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.GwY);
      i = f.a.a.b.b.a.bz(2, this.GwZ);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.bz(4, this.uqG);
      int m = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(104764);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GwY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ags localags = (ags)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104764);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localags.GwY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104764);
        return 0;
      case 2: 
        localags.GwZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104764);
        return 0;
      case 3: 
        localags.Gxa = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(104764);
        return 0;
      case 4: 
        localags.uqG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104764);
        return 0;
      }
      localags.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(104764);
      return 0;
    }
    AppMethodBeat.o(104764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ags
 * JD-Core Version:    0.7.0.1
 */