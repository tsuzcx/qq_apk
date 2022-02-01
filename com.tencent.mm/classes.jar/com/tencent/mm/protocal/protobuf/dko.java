package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dko
  extends com.tencent.mm.bx.a
{
  public bhk CYJ;
  public long EAc;
  public double EAd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.EAc);
      paramVarArgs.e(2, this.EAd);
      if (this.CYJ != null)
      {
        paramVarArgs.kX(3, this.CYJ.computeSize());
        this.CYJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.EAc) + 0 + (f.a.a.b.b.a.fY(2) + 8);
      paramInt = i;
      if (this.CYJ != null) {
        paramInt = i + f.a.a.a.kW(3, this.CYJ.computeSize());
      }
      AppMethodBeat.o(110916);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dko localdko = (dko)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localdko.EAc = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localdko.EAd = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bhk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdko.CYJ = ((bhk)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dko
 * JD-Core Version:    0.7.0.1
 */