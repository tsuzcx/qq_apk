package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public int CrG;
  public LinkedList<b> CrH;
  public com.tencent.mm.bx.b CrI;
  public int Crq;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.CrH = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Crq);
      paramVarArgs.aR(2, this.CrG);
      paramVarArgs.e(3, 8, this.CrH);
      if (this.CrI != null) {
        paramVarArgs.c(4, this.CrI);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Crq) + 0 + f.a.a.b.b.a.bA(2, this.CrG) + f.a.a.a.c(3, 8, this.CrH);
      paramInt = i;
      if (this.CrI != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.CrI);
      }
      AppMethodBeat.o(143948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CrH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localg.Crq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.CrG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localg.CrH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.CrI = ((f.a.a.a.a)localObject1).KhF.fMu();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */