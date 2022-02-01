package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class xu
  extends com.tencent.mm.bw.a
{
  public int EdY;
  public b ErJ;
  public cff ErK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EdY);
      if (this.ErJ != null) {
        paramVarArgs.c(2, this.ErJ);
      }
      if (this.ErK != null)
      {
        paramVarArgs.ln(3, this.ErK.computeSize());
        this.ErK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EdY) + 0;
      paramInt = i;
      if (this.ErJ != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.ErJ);
      }
      i = paramInt;
      if (this.ErK != null) {
        i = paramInt + f.a.a.a.lm(3, this.ErK.computeSize());
      }
      AppMethodBeat.o(91422);
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
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xu localxu = (xu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localxu.EdY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localxu.ErJ = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cff();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cff)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localxu.ErK = ((cff)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    AppMethodBeat.o(91422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xu
 * JD-Core Version:    0.7.0.1
 */