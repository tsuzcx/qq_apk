package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsn
  extends com.tencent.mm.bw.a
{
  public LinkedList<dqy> FYx;
  public int GaG;
  public int GaH;
  
  public dsn()
  {
    AppMethodBeat.i(115901);
    this.FYx = new LinkedList();
    AppMethodBeat.o(115901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.GaG);
      paramVarArgs.aR(2, this.GaH);
      paramVarArgs.e(3, 8, this.FYx);
      AppMethodBeat.o(115902);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.GaG);
      i = f.a.a.b.b.a.bx(2, this.GaH);
      int j = f.a.a.a.c(3, 8, this.FYx);
      AppMethodBeat.o(115902);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FYx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dsn localdsn = (dsn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115902);
        return -1;
      case 1: 
        localdsn.GaG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115902);
        return 0;
      case 2: 
        localdsn.GaH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115902);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdsn.FYx.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    AppMethodBeat.o(115902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsn
 * JD-Core Version:    0.7.0.1
 */