package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public int DJI;
  public int DJY;
  public LinkedList<b> DJZ;
  public com.tencent.mm.bw.b DKa;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.DJZ = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJI);
      paramVarArgs.aR(2, this.DJY);
      paramVarArgs.e(3, 8, this.DJZ);
      if (this.DKa != null) {
        paramVarArgs.c(4, this.DKa);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.DJI) + 0 + f.a.a.b.b.a.bx(2, this.DJY) + f.a.a.a.c(3, 8, this.DJZ);
      paramInt = i;
      if (this.DKa != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DKa);
      }
      AppMethodBeat.o(143948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DJZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localg.DJI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.DJY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localg.DJZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.DKa = ((f.a.a.a.a)localObject1).LVo.gfk();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */