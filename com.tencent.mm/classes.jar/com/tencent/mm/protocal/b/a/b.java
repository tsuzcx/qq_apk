package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public String bjm;
  public int id;
  public String title;
  public LinkedList<a> wjT;
  
  public b()
  {
    AppMethodBeat.i(105577);
    this.wjT = new LinkedList();
    AppMethodBeat.o(105577);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105578);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.bjm != null) {
        paramVarArgs.e(3, this.bjm);
      }
      paramVarArgs.e(4, 8, this.wjT);
      AppMethodBeat.o(105578);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.bjm != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.bjm);
      }
      paramInt = e.a.a.a.c(4, 8, this.wjT);
      AppMethodBeat.o(105578);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wjT.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(105578);
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
        AppMethodBeat.o(105578);
        return -1;
      case 1: 
        localb.id = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(105578);
        return 0;
      case 2: 
        localb.title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105578);
        return 0;
      case 3: 
        localb.bjm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105578);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localb.wjT.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(105578);
      return 0;
    }
    AppMethodBeat.o(105578);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */