package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public int FHG;
  public int FHn;
  public int FHo;
  public o FHp;
  public o FHq;
  public int FHr;
  public int FHs;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ret);
      paramVarArgs.aS(2, this.FHn);
      paramVarArgs.aS(3, this.FHo);
      if (this.FHp != null)
      {
        paramVarArgs.lJ(4, this.FHp.computeSize());
        this.FHp.writeFields(paramVarArgs);
      }
      if (this.FHq != null)
      {
        paramVarArgs.lJ(5, this.FHq.computeSize());
        this.FHq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FHr);
      paramVarArgs.aS(7, this.FHG);
      paramVarArgs.aS(8, this.FHs);
      AppMethodBeat.o(143949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ret) + 0 + f.a.a.b.b.a.bz(2, this.FHn) + f.a.a.b.b.a.bz(3, this.FHo);
      paramInt = i;
      if (this.FHp != null) {
        paramInt = i + f.a.a.a.lI(4, this.FHp.computeSize());
      }
      i = paramInt;
      if (this.FHq != null) {
        i = paramInt + f.a.a.a.lI(5, this.FHq.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.FHr);
      int j = f.a.a.b.b.a.bz(7, this.FHG);
      int k = f.a.a.b.b.a.bz(8, this.FHs);
      AppMethodBeat.o(143949);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143949);
        return -1;
      case 1: 
        localh.ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143949);
        return 0;
      case 2: 
        localh.FHn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143949);
        return 0;
      case 3: 
        localh.FHo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.FHp = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.FHq = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 6: 
        localh.FHr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143949);
        return 0;
      case 7: 
        localh.FHG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143949);
        return 0;
      }
      localh.FHs = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(143949);
      return 0;
    }
    AppMethodBeat.o(143949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.h
 * JD-Core Version:    0.7.0.1
 */