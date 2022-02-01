package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cis
  extends com.tencent.mm.bw.a
{
  public int ESB;
  public LinkedList<cir> FwN;
  public int ncL;
  
  public cis()
  {
    AppMethodBeat.i(155449);
    this.FwN = new LinkedList();
    AppMethodBeat.o(155449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ESB);
      paramVarArgs.aR(2, this.ncL);
      paramVarArgs.e(3, 8, this.FwN);
      AppMethodBeat.o(155450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ESB);
      i = f.a.a.b.b.a.bx(2, this.ncL);
      int j = f.a.a.a.c(3, 8, this.FwN);
      AppMethodBeat.o(155450);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FwN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cis localcis = (cis)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155450);
        return -1;
      case 1: 
        localcis.ESB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155450);
        return 0;
      case 2: 
        localcis.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155450);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cir();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcis.FwN.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    AppMethodBeat.o(155450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cis
 * JD-Core Version:    0.7.0.1
 */