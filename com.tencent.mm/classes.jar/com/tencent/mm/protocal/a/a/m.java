package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public int Fps;
  public int Fpt;
  public LinkedList<n> Fpu;
  
  public m()
  {
    AppMethodBeat.i(143956);
    this.Fpu = new LinkedList();
    AppMethodBeat.o(143956);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Fps);
      paramVarArgs.aS(2, this.Fpt);
      paramVarArgs.e(3, 8, this.Fpu);
      AppMethodBeat.o(143957);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Fps);
      i = f.a.a.b.b.a.bz(2, this.Fpt);
      int j = f.a.a.a.c(3, 8, this.Fpu);
      AppMethodBeat.o(143957);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fpu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143957);
        return -1;
      case 1: 
        localm.Fps = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143957);
        return 0;
      case 2: 
        localm.Fpt = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143957);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new n();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localm.Fpu.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    AppMethodBeat.o(143957);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.m
 * JD-Core Version:    0.7.0.1
 */