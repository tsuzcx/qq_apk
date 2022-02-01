package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajr
  extends com.tencent.mm.bw.a
{
  public FinderObject EEp;
  public int EEq;
  public aml EEr;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      paramVarArgs.aO(2, this.id);
      if (this.EEp != null)
      {
        paramVarArgs.ln(3, this.EEp.computeSize());
        this.EEp.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EEq);
      if (this.EEr != null)
      {
        paramVarArgs.ln(5, this.EEr.computeSize());
        this.EEr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0 + f.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.EEp != null) {
        paramInt = i + f.a.a.a.lm(3, this.EEp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EEq);
      paramInt = i;
      if (this.EEr != null) {
        paramInt = i + f.a.a.a.lm(5, this.EEr.computeSize());
      }
      AppMethodBeat.o(168953);
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
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ajr localajr = (ajr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localajr.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localajr.id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajr.EEp = ((FinderObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localajr.EEq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168953);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aml();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localajr.EEr = ((aml)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajr
 * JD-Core Version:    0.7.0.1
 */