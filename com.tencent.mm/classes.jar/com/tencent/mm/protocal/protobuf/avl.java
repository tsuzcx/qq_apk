package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avl
  extends com.tencent.mm.bx.a
{
  public int Gur;
  public LinkedList<ahg> Gus;
  public int Gut;
  public int dDp;
  
  public avl()
  {
    AppMethodBeat.i(153145);
    this.Gus = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gur);
      paramVarArgs.e(2, 8, this.Gus);
      paramVarArgs.aS(3, this.Gut);
      paramVarArgs.aS(4, this.dDp);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gur);
      i = f.a.a.a.c(2, 8, this.Gus);
      int j = f.a.a.b.b.a.bz(3, this.Gut);
      int k = f.a.a.b.b.a.bz(4, this.dDp);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gus.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avl localavl = (avl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localavl.Gur = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavl.Gus.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localavl.Gut = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153146);
        return 0;
      }
      localavl.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avl
 * JD-Core Version:    0.7.0.1
 */