package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acw
  extends com.tencent.mm.bw.a
{
  public int EvB;
  public acx EvC;
  public int EvD;
  public acx EvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EvC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.EvE == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EvB);
      if (this.EvC != null)
      {
        paramVarArgs.ln(2, this.EvC.computeSize());
        this.EvC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EvD);
      if (this.EvE != null)
      {
        paramVarArgs.ln(4, this.EvE.computeSize());
        this.EvE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EvB) + 0;
      paramInt = i;
      if (this.EvC != null) {
        paramInt = i + f.a.a.a.lm(2, this.EvC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EvD);
      paramInt = i;
      if (this.EvE != null) {
        paramInt = i + f.a.a.a.lm(4, this.EvE.computeSize());
      }
      AppMethodBeat.o(43094);
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
      if (this.EvC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.EvE == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      acw localacw = (acw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localacw.EvB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacw.EvC = ((acx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localacw.EvD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((acx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localacw.EvE = ((acx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */