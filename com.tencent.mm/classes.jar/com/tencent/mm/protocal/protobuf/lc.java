package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lc
  extends com.tencent.mm.bw.a
{
  public LinkedList<lb> KOT;
  public la KOU;
  public int KOV;
  
  public lc()
  {
    AppMethodBeat.i(82389);
    this.KOT = new LinkedList();
    AppMethodBeat.o(82389);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KOT);
      if (this.KOU != null)
      {
        paramVarArgs.ni(2, this.KOU.computeSize());
        this.KOU.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.KOV);
      AppMethodBeat.o(82390);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.KOT) + 0;
      paramInt = i;
      if (this.KOU != null) {
        paramInt = i + g.a.a.a.nh(2, this.KOU.computeSize());
      }
      i = g.a.a.b.b.a.bu(3, this.KOV);
      AppMethodBeat.o(82390);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KOT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(82390);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      lc locallc = (lc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82390);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locallc.KOT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new la();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((la)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locallc.KOU = ((la)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82390);
        return 0;
      }
      locallc.KOV = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(82390);
      return 0;
    }
    AppMethodBeat.o(82390);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lc
 * JD-Core Version:    0.7.0.1
 */