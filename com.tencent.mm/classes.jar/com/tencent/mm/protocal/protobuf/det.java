package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class det
  extends com.tencent.mm.bw.a
{
  public int FOm;
  public int FOn;
  public LinkedList<bxz> FOo;
  
  public det()
  {
    AppMethodBeat.i(143986);
    this.FOo = new LinkedList();
    AppMethodBeat.o(143986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143987);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FOm);
      paramVarArgs.aR(2, this.FOn);
      paramVarArgs.e(3, 8, this.FOo);
      AppMethodBeat.o(143987);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FOm);
      i = f.a.a.b.b.a.bx(2, this.FOn);
      int j = f.a.a.a.c(3, 8, this.FOo);
      AppMethodBeat.o(143987);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FOo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      det localdet = (det)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143987);
        return -1;
      case 1: 
        localdet.FOm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143987);
        return 0;
      case 2: 
        localdet.FOn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143987);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bxz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bxz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdet.FOo.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    AppMethodBeat.o(143987);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.det
 * JD-Core Version:    0.7.0.1
 */