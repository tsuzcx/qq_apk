package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqx
  extends com.tencent.mm.bw.a
{
  public ccw LlY;
  public long Nop;
  public double Noq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Nop);
      paramVarArgs.e(2, this.Noq);
      if (this.LlY != null)
      {
        paramVarArgs.ni(3, this.LlY.computeSize());
        this.LlY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Nop) + 0 + (g.a.a.b.b.a.fS(2) + 8);
      paramInt = i;
      if (this.LlY != null) {
        paramInt = i + g.a.a.a.nh(3, this.LlY.computeSize());
      }
      AppMethodBeat.o(110916);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eqx localeqx = (eqx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localeqx.Nop = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localeqx.Noq = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ccw();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeqx.LlY = ((ccw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqx
 * JD-Core Version:    0.7.0.1
 */