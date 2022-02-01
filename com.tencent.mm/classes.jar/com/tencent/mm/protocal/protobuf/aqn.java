package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqn
  extends com.tencent.mm.bx.a
{
  public aqm GoF;
  public LinkedList<aqo> GoG;
  public long slp;
  
  public aqn()
  {
    AppMethodBeat.i(184206);
    this.GoG = new LinkedList();
    AppMethodBeat.o(184206);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.slp);
      if (this.GoF != null)
      {
        paramVarArgs.lC(2, this.GoF.computeSize());
        this.GoF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GoG);
      AppMethodBeat.o(184207);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.slp) + 0;
      paramInt = i;
      if (this.GoF != null) {
        paramInt = i + f.a.a.a.lB(2, this.GoF.computeSize());
      }
      i = f.a.a.a.c(3, 8, this.GoG);
      AppMethodBeat.o(184207);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GoG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aqn localaqn = (aqn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184207);
        return -1;
      case 1: 
        localaqn.slp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(184207);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqn.GoF = ((aqm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aqo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aqo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaqn.GoG.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    AppMethodBeat.o(184207);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqn
 * JD-Core Version:    0.7.0.1
 */