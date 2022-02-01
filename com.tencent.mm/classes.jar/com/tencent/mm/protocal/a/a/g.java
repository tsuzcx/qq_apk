package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public int FHD;
  public LinkedList<b> FHE;
  public com.tencent.mm.bw.b FHF;
  public int FHn;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.FHE = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHn);
      paramVarArgs.aS(2, this.FHD);
      paramVarArgs.e(3, 8, this.FHE);
      if (this.FHF != null) {
        paramVarArgs.c(4, this.FHF);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FHn) + 0 + f.a.a.b.b.a.bz(2, this.FHD) + f.a.a.a.c(3, 8, this.FHE);
      paramInt = i;
      if (this.FHF != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FHF);
      }
      AppMethodBeat.o(143948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localg.FHn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.FHD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localg.FHE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.FHF = ((f.a.a.a.a)localObject1).OmT.gCk();
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