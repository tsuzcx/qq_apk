package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgc
  extends com.tencent.mm.bw.a
{
  public int Ful;
  public LinkedList<dfl> Fum;
  public int fZz;
  
  public cgc()
  {
    AppMethodBeat.i(152661);
    this.Fum = new LinkedList();
    AppMethodBeat.o(152661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fZz);
      paramVarArgs.aR(2, this.Ful);
      paramVarArgs.e(3, 8, this.Fum);
      AppMethodBeat.o(152662);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.fZz);
      i = f.a.a.b.b.a.bx(2, this.Ful);
      int j = f.a.a.a.c(3, 8, this.Fum);
      AppMethodBeat.o(152662);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fum.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cgc localcgc = (cgc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152662);
        return -1;
      case 1: 
        localcgc.fZz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152662);
        return 0;
      case 2: 
        localcgc.Ful = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152662);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dfl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dfl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcgc.Fum.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    AppMethodBeat.o(152662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgc
 * JD-Core Version:    0.7.0.1
 */