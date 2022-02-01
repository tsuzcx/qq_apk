package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmo
  extends com.tencent.mm.bw.a
{
  public ccq FzN;
  public ee FzO;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.FzN != null)
      {
        paramVarArgs.ln(2, this.FzN.computeSize());
        this.FzN.writeFields(paramVarArgs);
      }
      if (this.FzO != null)
      {
        paramVarArgs.ln(3, this.FzO.computeSize());
        this.FzO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.FzN != null) {
        paramInt = i + f.a.a.a.lm(2, this.FzN.computeSize());
      }
      i = paramInt;
      if (this.FzO != null) {
        i = paramInt + f.a.a.a.lm(3, this.FzO.computeSize());
      }
      AppMethodBeat.o(50100);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmo localcmo = (cmo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50100);
        return -1;
      case 1: 
        localcmo.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(50100);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmo.FzN = ((ccq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50100);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ee();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ee)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcmo.FzO = ((ee)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(50100);
      return 0;
    }
    AppMethodBeat.o(50100);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmo
 * JD-Core Version:    0.7.0.1
 */