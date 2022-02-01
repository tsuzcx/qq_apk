package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpi
  extends com.tencent.mm.bw.a
{
  public int FeJ = 0;
  public bxp FeK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FeJ);
      if (this.FeK != null)
      {
        paramVarArgs.ln(2, this.FeK.computeSize());
        this.FeK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194016);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FeJ) + 0;
      paramInt = i;
      if (this.FeK != null) {
        paramInt = i + f.a.a.a.lm(2, this.FeK.computeSize());
      }
      AppMethodBeat.o(194016);
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
      AppMethodBeat.o(194016);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpi localbpi = (bpi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194016);
        return -1;
      case 1: 
        localbpi.FeJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194016);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bxp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbpi.FeK = ((bxp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(194016);
      return 0;
    }
    AppMethodBeat.o(194016);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpi
 * JD-Core Version:    0.7.0.1
 */