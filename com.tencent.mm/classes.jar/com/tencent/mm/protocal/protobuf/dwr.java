package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwr
  extends com.tencent.mm.bw.a
{
  public bqe Grc;
  public long IbR;
  public double IbS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.IbR);
      paramVarArgs.e(2, this.IbS);
      if (this.Grc != null)
      {
        paramVarArgs.lJ(3, this.Grc.computeSize());
        this.Grc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.IbR) + 0 + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.Grc != null) {
        paramInt = i + f.a.a.a.lI(3, this.Grc.computeSize());
      }
      AppMethodBeat.o(110916);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwr localdwr = (dwr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localdwr.IbR = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localdwr.IbS = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bqe();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdwr.Grc = ((bqe)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwr
 * JD-Core Version:    0.7.0.1
 */