package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwx
  extends com.tencent.mm.bx.a
{
  public LinkedList<bvx> HoF;
  public boolean HoG;
  public boolean HoH;
  public boolean HoI;
  public boolean HoJ;
  public boolean HoK;
  
  public cwx()
  {
    AppMethodBeat.i(155454);
    this.HoF = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.HoF);
      paramVarArgs.bt(2, this.HoG);
      paramVarArgs.bt(3, this.HoH);
      paramVarArgs.bt(4, this.HoI);
      paramVarArgs.bt(5, this.HoJ);
      paramVarArgs.bt(6, this.HoK);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.HoF);
      i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.alV(5);
      int n = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HoF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwx localcwx = (cwx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bvx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwx.HoF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localcwx.HoG = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localcwx.HoH = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localcwx.HoI = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localcwx.HoJ = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(155455);
        return 0;
      }
      localcwx.HoK = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */