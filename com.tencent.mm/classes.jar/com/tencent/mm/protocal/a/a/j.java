package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public int FHB;
  public o FHC;
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
    AppMethodBeat.i(143952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ret);
      paramVarArgs.aS(2, this.FHn);
      paramVarArgs.aS(3, this.FHo);
      paramVarArgs.aS(4, this.FHB);
      if (this.FHp != null)
      {
        paramVarArgs.lJ(5, this.FHp.computeSize());
        this.FHp.writeFields(paramVarArgs);
      }
      if (this.FHq != null)
      {
        paramVarArgs.lJ(6, this.FHq.computeSize());
        this.FHq.writeFields(paramVarArgs);
      }
      if (this.FHC != null)
      {
        paramVarArgs.lJ(7, this.FHC.computeSize());
        this.FHC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FHr);
      paramVarArgs.aS(9, this.FHG);
      paramVarArgs.aS(10, this.FHs);
      AppMethodBeat.o(143952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ret) + 0 + f.a.a.b.b.a.bz(2, this.FHn) + f.a.a.b.b.a.bz(3, this.FHo) + f.a.a.b.b.a.bz(4, this.FHB);
      paramInt = i;
      if (this.FHp != null) {
        paramInt = i + f.a.a.a.lI(5, this.FHp.computeSize());
      }
      i = paramInt;
      if (this.FHq != null) {
        i = paramInt + f.a.a.a.lI(6, this.FHq.computeSize());
      }
      paramInt = i;
      if (this.FHC != null) {
        paramInt = i + f.a.a.a.lI(7, this.FHC.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.FHr);
      int j = f.a.a.b.b.a.bz(9, this.FHG);
      int k = f.a.a.b.b.a.bz(10, this.FHs);
      AppMethodBeat.o(143952);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143952);
        return -1;
      case 1: 
        localj.ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
        return 0;
      case 2: 
        localj.FHn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
        return 0;
      case 3: 
        localj.FHo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
        return 0;
      case 4: 
        localj.FHB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
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
          localj.FHp = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.FHq = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.FHC = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 8: 
        localj.FHr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
        return 0;
      case 9: 
        localj.FHG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143952);
        return 0;
      }
      localj.FHs = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(143952);
      return 0;
    }
    AppMethodBeat.o(143952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.j
 * JD-Core Version:    0.7.0.1
 */