package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbh
  extends com.tencent.mm.bw.a
{
  public int LKI;
  public bbi LKJ;
  public LinkedList<bbi> LKK;
  
  public bbh()
  {
    AppMethodBeat.i(209648);
    this.LKK = new LinkedList();
    AppMethodBeat.o(209648);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169043);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LKI);
      if (this.LKJ != null)
      {
        paramVarArgs.ni(2, this.LKJ.computeSize());
        this.LKJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.LKK);
      AppMethodBeat.o(169043);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LKI) + 0;
      paramInt = i;
      if (this.LKJ != null) {
        paramInt = i + g.a.a.a.nh(2, this.LKJ.computeSize());
      }
      i = g.a.a.a.c(3, 8, this.LKK);
      AppMethodBeat.o(169043);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LKK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bbh localbbh = (bbh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169043);
        return -1;
      case 1: 
        localbbh.LKI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169043);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbbh.LKJ = ((bbi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169043);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bbi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbbh.LKK.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    AppMethodBeat.o(169043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbh
 * JD-Core Version:    0.7.0.1
 */