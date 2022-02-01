package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class civ
  extends com.tencent.mm.bw.a
{
  public bja FwQ;
  public zl FwR;
  public ok FwS;
  public int nWg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194020);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.nWg);
      if (this.FwQ != null)
      {
        paramVarArgs.ln(2, this.FwQ.computeSize());
        this.FwQ.writeFields(paramVarArgs);
      }
      if (this.FwR != null)
      {
        paramVarArgs.ln(3, this.FwR.computeSize());
        this.FwR.writeFields(paramVarArgs);
      }
      if (this.FwS != null)
      {
        paramVarArgs.ln(4, this.FwS.computeSize());
        this.FwS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194020);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.nWg) + 0;
      paramInt = i;
      if (this.FwQ != null) {
        paramInt = i + f.a.a.a.lm(2, this.FwQ.computeSize());
      }
      i = paramInt;
      if (this.FwR != null) {
        i = paramInt + f.a.a.a.lm(3, this.FwR.computeSize());
      }
      paramInt = i;
      if (this.FwS != null) {
        paramInt = i + f.a.a.a.lm(4, this.FwS.computeSize());
      }
      AppMethodBeat.o(194020);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(194020);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      civ localciv = (civ)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194020);
        return -1;
      case 1: 
        localciv.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194020);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bja();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciv.FwQ = ((bja)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194020);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciv.FwR = ((zl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194020);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ok();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localciv.FwS = ((ok)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(194020);
      return 0;
    }
    AppMethodBeat.o(194020);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.civ
 * JD-Core Version:    0.7.0.1
 */