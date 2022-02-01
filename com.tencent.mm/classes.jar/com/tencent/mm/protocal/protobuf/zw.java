package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class zw
  extends com.tencent.mm.bw.a
{
  public int GcW;
  public b Grs;
  public cky Grt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GcW);
      if (this.Grs != null) {
        paramVarArgs.c(2, this.Grs);
      }
      if (this.Grt != null)
      {
        paramVarArgs.lJ(3, this.Grt.computeSize());
        this.Grt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GcW) + 0;
      paramInt = i;
      if (this.Grs != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Grs);
      }
      i = paramInt;
      if (this.Grt != null) {
        i = paramInt + f.a.a.a.lI(3, this.Grt.computeSize());
      }
      AppMethodBeat.o(91422);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      zw localzw = (zw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localzw.GcW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localzw.Grs = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cky();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localzw.Grt = ((cky)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    AppMethodBeat.o(91422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zw
 * JD-Core Version:    0.7.0.1
 */