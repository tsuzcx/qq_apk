package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int FHl;
  public LinkedList<a> FHm;
  public int nettype;
  public int uin;
  
  public b()
  {
    AppMethodBeat.i(143940);
    this.FHm = new LinkedList();
    AppMethodBeat.o(143940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143941);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.FHl);
      paramVarArgs.e(3, 8, this.FHm);
      paramVarArgs.aS(4, this.nettype);
      AppMethodBeat.o(143941);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.uin);
      i = f.a.a.b.b.a.bz(2, this.FHl);
      int j = f.a.a.a.c(3, 8, this.FHm);
      int k = f.a.a.b.b.a.bz(4, this.nettype);
      AppMethodBeat.o(143941);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143941);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143941);
        return -1;
      case 1: 
        localb.uin = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143941);
        return 0;
      case 2: 
        localb.FHl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143941);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localb.FHm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143941);
        return 0;
      }
      localb.nettype = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(143941);
      return 0;
    }
    AppMethodBeat.o(143941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.b
 * JD-Core Version:    0.7.0.1
 */