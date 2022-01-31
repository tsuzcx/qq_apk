package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public int nettype;
  public int uin;
  public int wjc;
  public LinkedList<a> wjd;
  
  public b()
  {
    AppMethodBeat.i(72816);
    this.wjd = new LinkedList();
    AppMethodBeat.o(72816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72817);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.uin);
      paramVarArgs.aO(2, this.wjc);
      paramVarArgs.e(3, 8, this.wjd);
      paramVarArgs.aO(4, this.nettype);
      AppMethodBeat.o(72817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.uin);
      i = e.a.a.b.b.a.bl(2, this.wjc);
      int j = e.a.a.a.c(3, 8, this.wjd);
      int k = e.a.a.b.b.a.bl(4, this.nettype);
      AppMethodBeat.o(72817);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wjd.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72817);
        return -1;
      case 1: 
        localb.uin = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72817);
        return 0;
      case 2: 
        localb.wjc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72817);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localb.wjd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72817);
        return 0;
      }
      localb.nettype = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72817);
      return 0;
    }
    AppMethodBeat.o(72817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.b
 * JD-Core Version:    0.7.0.1
 */