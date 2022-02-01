package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class px
  extends com.tencent.mm.bw.a
{
  public LinkedList<pw> GdA;
  public int Gdw;
  public int Gdx;
  public int Gdy;
  public LinkedList<pw> Gdz;
  
  public px()
  {
    AppMethodBeat.i(133159);
    this.Gdz = new LinkedList();
    this.GdA = new LinkedList();
    AppMethodBeat.o(133159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133160);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gdw);
      paramVarArgs.aS(2, this.Gdx);
      paramVarArgs.aS(5, this.Gdy);
      paramVarArgs.e(3, 8, this.Gdz);
      paramVarArgs.e(4, 8, this.GdA);
      AppMethodBeat.o(133160);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gdw);
      i = f.a.a.b.b.a.bz(2, this.Gdx);
      int j = f.a.a.b.b.a.bz(5, this.Gdy);
      int k = f.a.a.a.c(3, 8, this.Gdz);
      int m = f.a.a.a.c(4, 8, this.GdA);
      AppMethodBeat.o(133160);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gdz.clear();
      this.GdA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(133160);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      px localpx = (px)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133160);
        return -1;
      case 1: 
        localpx.Gdw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133160);
        return 0;
      case 2: 
        localpx.Gdx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133160);
        return 0;
      case 5: 
        localpx.Gdy = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133160);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpx.Gdz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133160);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pw();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localpx.GdA.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.px
 * JD-Core Version:    0.7.0.1
 */