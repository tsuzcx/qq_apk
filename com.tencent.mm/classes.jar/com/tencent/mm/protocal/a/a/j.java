package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public int DJI;
  public int DJJ;
  public o DJK;
  public o DJL;
  public int DJM;
  public int DJN;
  public int DJW;
  public o DJX;
  public int DKb;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ret);
      paramVarArgs.aR(2, this.DJI);
      paramVarArgs.aR(3, this.DJJ);
      paramVarArgs.aR(4, this.DJW);
      if (this.DJK != null)
      {
        paramVarArgs.ln(5, this.DJK.computeSize());
        this.DJK.writeFields(paramVarArgs);
      }
      if (this.DJL != null)
      {
        paramVarArgs.ln(6, this.DJL.computeSize());
        this.DJL.writeFields(paramVarArgs);
      }
      if (this.DJX != null)
      {
        paramVarArgs.ln(7, this.DJX.computeSize());
        this.DJX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DJM);
      paramVarArgs.aR(9, this.DKb);
      paramVarArgs.aR(10, this.DJN);
      AppMethodBeat.o(143952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ret) + 0 + f.a.a.b.b.a.bx(2, this.DJI) + f.a.a.b.b.a.bx(3, this.DJJ) + f.a.a.b.b.a.bx(4, this.DJW);
      paramInt = i;
      if (this.DJK != null) {
        paramInt = i + f.a.a.a.lm(5, this.DJK.computeSize());
      }
      i = paramInt;
      if (this.DJL != null) {
        i = paramInt + f.a.a.a.lm(6, this.DJL.computeSize());
      }
      paramInt = i;
      if (this.DJX != null) {
        paramInt = i + f.a.a.a.lm(7, this.DJX.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.DJM);
      int j = f.a.a.b.b.a.bx(9, this.DKb);
      int k = f.a.a.b.b.a.bx(10, this.DJN);
      AppMethodBeat.o(143952);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localj.ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      case 2: 
        localj.DJI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      case 3: 
        localj.DJJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      case 4: 
        localj.DJW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.DJK = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.DJL = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localj.DJX = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143952);
        return 0;
      case 8: 
        localj.DJM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      case 9: 
        localj.DKb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143952);
        return 0;
      }
      localj.DJN = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(143952);
      return 0;
    }
    AppMethodBeat.o(143952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.j
 * JD-Core Version:    0.7.0.1
 */