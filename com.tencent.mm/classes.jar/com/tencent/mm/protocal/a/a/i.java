package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public int CrE;
  public int CrG;
  public LinkedList<e> CrH;
  public b CrI;
  public int Crq;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.CrH = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Crq);
      paramVarArgs.aR(2, this.CrG);
      paramVarArgs.aR(3, this.CrE);
      paramVarArgs.e(4, 8, this.CrH);
      if (this.CrI != null) {
        paramVarArgs.c(5, this.CrI);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Crq) + 0 + f.a.a.b.b.a.bA(2, this.CrG) + f.a.a.b.b.a.bA(3, this.CrE) + f.a.a.a.c(4, 8, this.CrH);
      paramInt = i;
      if (this.CrI != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.CrI);
      }
      AppMethodBeat.o(143951);
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
        locali.Crq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.CrG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.CrE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.CrH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.CrI = ((f.a.a.a.a)localObject1).KhF.fMu();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */