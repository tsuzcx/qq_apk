package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zn
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public boolean wQA;
  public LinkedList<cnz> wQy;
  public int wQz;
  public int wsX;
  
  public zn()
  {
    AppMethodBeat.i(62527);
    this.wQy = new LinkedList();
    this.wQA = false;
    this.wsX = 0;
    AppMethodBeat.o(62527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62528);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wQy);
      paramVarArgs.aO(2, this.wQz);
      paramVarArgs.aS(3, this.wQA);
      paramVarArgs.aO(4, this.wsX);
      paramVarArgs.aO(5, this.Scene);
      AppMethodBeat.o(62528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.wQy);
      i = e.a.a.b.b.a.bl(2, this.wQz);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.bl(4, this.wsX);
      int m = e.a.a.b.b.a.bl(5, this.Scene);
      AppMethodBeat.o(62528);
      return paramInt + 0 + i + (j + 1) + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wQy.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      zn localzn = (zn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(62528);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cnz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzn.wQy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(62528);
        return 0;
      case 2: 
        localzn.wQz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62528);
        return 0;
      case 3: 
        localzn.wQA = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(62528);
        return 0;
      case 4: 
        localzn.wsX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62528);
        return 0;
      }
      localzn.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(62528);
      return 0;
    }
    AppMethodBeat.o(62528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zn
 * JD-Core Version:    0.7.0.1
 */