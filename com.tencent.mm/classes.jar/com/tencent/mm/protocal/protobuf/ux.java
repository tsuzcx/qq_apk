package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ux
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahd> Epb;
  public ahq Epc;
  public int Scene;
  
  public ux()
  {
    AppMethodBeat.i(127449);
    this.Epb = new LinkedList();
    AppMethodBeat.o(127449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Epb);
      paramVarArgs.aR(2, this.Scene);
      if (this.Epc != null)
      {
        paramVarArgs.ln(3, this.Epc.computeSize());
        this.Epc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Epb) + 0 + f.a.a.b.b.a.bx(2, this.Scene);
      paramInt = i;
      if (this.Epc != null) {
        paramInt = i + f.a.a.a.lm(3, this.Epc.computeSize());
      }
      AppMethodBeat.o(127450);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Epb.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ux localux = (ux)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127450);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localux.Epb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127450);
        return 0;
      case 2: 
        localux.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127450);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localux.Epc = ((ahq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127450);
      return 0;
    }
    AppMethodBeat.o(127450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ux
 * JD-Core Version:    0.7.0.1
 */