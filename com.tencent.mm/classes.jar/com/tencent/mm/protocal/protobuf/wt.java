package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class wt
  extends com.tencent.mm.bw.a
{
  public int EqT;
  public int EqU;
  public int EqV;
  public LinkedList<ws> EqW;
  public b EqX;
  public bjp EqY;
  
  public wt()
  {
    AppMethodBeat.i(143967);
    this.EqW = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EqT);
      paramVarArgs.aR(2, this.EqU);
      paramVarArgs.aR(3, this.EqV);
      paramVarArgs.e(4, 8, this.EqW);
      if (this.EqX != null) {
        paramVarArgs.c(5, this.EqX);
      }
      if (this.EqY != null)
      {
        paramVarArgs.ln(6, this.EqY.computeSize());
        this.EqY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EqT) + 0 + f.a.a.b.b.a.bx(2, this.EqU) + f.a.a.b.b.a.bx(3, this.EqV) + f.a.a.a.c(4, 8, this.EqW);
      paramInt = i;
      if (this.EqX != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.EqX);
      }
      i = paramInt;
      if (this.EqY != null) {
        i = paramInt + f.a.a.a.lm(6, this.EqY.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EqW.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      wt localwt = (wt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localwt.EqT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localwt.EqU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localwt.EqV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ws();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwt.EqW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localwt.EqX = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bjp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localwt.EqY = ((bjp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wt
 * JD-Core Version:    0.7.0.1
 */