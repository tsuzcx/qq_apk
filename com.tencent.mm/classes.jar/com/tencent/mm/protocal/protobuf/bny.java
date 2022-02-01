package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bny
  extends com.tencent.mm.bx.a
{
  public int GIv;
  public LinkedList<cbh> GIw;
  public int GIx;
  
  public bny()
  {
    AppMethodBeat.i(143977);
    this.GIw = new LinkedList();
    AppMethodBeat.o(143977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143978);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GIv);
      paramVarArgs.e(2, 8, this.GIw);
      paramVarArgs.aS(3, this.GIx);
      AppMethodBeat.o(143978);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GIv);
      i = f.a.a.a.c(2, 8, this.GIw);
      int j = f.a.a.b.b.a.bz(3, this.GIx);
      AppMethodBeat.o(143978);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GIw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143978);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bny localbny = (bny)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143978);
        return -1;
      case 1: 
        localbny.GIv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143978);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cbh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbny.GIw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143978);
        return 0;
      }
      localbny.GIx = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(143978);
      return 0;
    }
    AppMethodBeat.o(143978);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bny
 * JD-Core Version:    0.7.0.1
 */