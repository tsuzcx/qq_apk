package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public int KAB;
  public int KAC;
  public o KAD;
  public o KAE;
  public int KAF;
  public int KAG;
  public int KAP;
  public o KAQ;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ret);
      paramVarArgs.aM(2, this.KAB);
      paramVarArgs.aM(3, this.KAC);
      paramVarArgs.aM(4, this.KAP);
      if (this.KAD != null)
      {
        paramVarArgs.ni(5, this.KAD.computeSize());
        this.KAD.writeFields(paramVarArgs);
      }
      if (this.KAE != null)
      {
        paramVarArgs.ni(6, this.KAE.computeSize());
        this.KAE.writeFields(paramVarArgs);
      }
      if (this.KAQ != null)
      {
        paramVarArgs.ni(7, this.KAQ.computeSize());
        this.KAQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.KAF);
      paramVarArgs.aM(9, this.KAG);
      AppMethodBeat.o(143946);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.ret) + 0 + g.a.a.b.b.a.bu(2, this.KAB) + g.a.a.b.b.a.bu(3, this.KAC) + g.a.a.b.b.a.bu(4, this.KAP);
      paramInt = i;
      if (this.KAD != null) {
        paramInt = i + g.a.a.a.nh(5, this.KAD.computeSize());
      }
      i = paramInt;
      if (this.KAE != null) {
        i = paramInt + g.a.a.a.nh(6, this.KAE.computeSize());
      }
      paramInt = i;
      if (this.KAQ != null) {
        paramInt = i + g.a.a.a.nh(7, this.KAQ.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.KAF);
      int j = g.a.a.b.b.a.bu(9, this.KAG);
      AppMethodBeat.o(143946);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143946);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143946);
        return -1;
      case 1: 
        localf.ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143946);
        return 0;
      case 2: 
        localf.KAB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143946);
        return 0;
      case 3: 
        localf.KAC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143946);
        return 0;
      case 4: 
        localf.KAP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143946);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localf.KAD = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localf.KAE = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localf.KAQ = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143946);
        return 0;
      case 8: 
        localf.KAF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143946);
        return 0;
      }
      localf.KAG = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(143946);
      return 0;
    }
    AppMethodBeat.o(143946);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.f
 * JD-Core Version:    0.7.0.1
 */