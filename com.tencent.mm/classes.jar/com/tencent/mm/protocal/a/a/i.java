package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public int DJI;
  public int DJW;
  public int DJY;
  public LinkedList<e> DJZ;
  public b DKa;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.DJZ = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJI);
      paramVarArgs.aR(2, this.DJY);
      paramVarArgs.aR(3, this.DJW);
      paramVarArgs.e(4, 8, this.DJZ);
      if (this.DKa != null) {
        paramVarArgs.c(5, this.DKa);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.DJI) + 0 + f.a.a.b.b.a.bx(2, this.DJY) + f.a.a.b.b.a.bx(3, this.DJW) + f.a.a.a.c(4, 8, this.DJZ);
      paramInt = i;
      if (this.DKa != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.DKa);
      }
      AppMethodBeat.o(143951);
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
        locali.DJI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.DJY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.DJW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.DJZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.DKa = ((f.a.a.a.a)localObject1).LVo.gfk();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */