package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public int FoP;
  public int Fpf;
  public LinkedList<b> Fpg;
  public com.tencent.mm.bx.b Fph;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.Fpg = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FoP);
      paramVarArgs.aS(2, this.Fpf);
      paramVarArgs.e(3, 8, this.Fpg);
      if (this.Fph != null) {
        paramVarArgs.c(4, this.Fph);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FoP) + 0 + f.a.a.b.b.a.bz(2, this.Fpf) + f.a.a.a.c(3, 8, this.Fpg);
      paramInt = i;
      if (this.Fph != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Fph);
      }
      AppMethodBeat.o(143948);
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
      AppMethodBeat.o(143948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143948);
        return -1;
      case 1: 
        localg.FoP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.Fpf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localg.Fpg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.Fph = ((f.a.a.a.a)localObject1).NPN.gxI();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */