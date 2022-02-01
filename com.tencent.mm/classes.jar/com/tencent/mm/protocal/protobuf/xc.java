package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class xc
  extends com.tencent.mm.bx.a
{
  public int CLv;
  public b CYW;
  public cah CYX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CLv);
      if (this.CYW != null) {
        paramVarArgs.c(2, this.CYW);
      }
      if (this.CYX != null)
      {
        paramVarArgs.kX(3, this.CYX.computeSize());
        this.CYX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CLv) + 0;
      paramInt = i;
      if (this.CYW != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CYW);
      }
      i = paramInt;
      if (this.CYX != null) {
        i = paramInt + f.a.a.a.kW(3, this.CYX.computeSize());
      }
      AppMethodBeat.o(91422);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xc localxc = (xc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localxc.CLv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localxc.CYW = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cah();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localxc.CYX = ((cah)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    AppMethodBeat.o(91422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xc
 * JD-Core Version:    0.7.0.1
 */