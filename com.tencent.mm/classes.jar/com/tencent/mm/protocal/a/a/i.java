package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public int FoP;
  public int Fpd;
  public int Fpf;
  public LinkedList<e> Fpg;
  public b Fph;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.Fpg = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FoP);
      paramVarArgs.aS(2, this.Fpf);
      paramVarArgs.aS(3, this.Fpd);
      paramVarArgs.e(4, 8, this.Fpg);
      if (this.Fph != null) {
        paramVarArgs.c(5, this.Fph);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FoP) + 0 + f.a.a.b.b.a.bz(2, this.Fpf) + f.a.a.b.b.a.bz(3, this.Fpd) + f.a.a.a.c(4, 8, this.Fpg);
      paramInt = i;
      if (this.Fph != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Fph);
      }
      AppMethodBeat.o(143951);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fpg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143951);
        return -1;
      case 1: 
        locali.FoP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.Fpf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.Fpd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.Fpg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.Fph = ((f.a.a.a.a)localObject1).NPN.gxI();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */