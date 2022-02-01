package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqo
  extends com.tencent.mm.bw.a
{
  public int MOQ;
  public eqs NnX;
  public eqq NnY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176153);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MOQ);
      if (this.NnX != null)
      {
        paramVarArgs.ni(2, this.NnX.computeSize());
        this.NnX.writeFields(paramVarArgs);
      }
      if (this.NnY != null)
      {
        paramVarArgs.ni(3, this.NnY.computeSize());
        this.NnY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MOQ) + 0;
      paramInt = i;
      if (this.NnX != null) {
        paramInt = i + g.a.a.a.nh(2, this.NnX.computeSize());
      }
      i = paramInt;
      if (this.NnY != null) {
        i = paramInt + g.a.a.a.nh(3, this.NnY.computeSize());
      }
      AppMethodBeat.o(176153);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eqo localeqo = (eqo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176153);
        return -1;
      case 1: 
        localeqo.MOQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(176153);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eqs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eqs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeqo.NnX = ((eqs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176153);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eqq();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eqq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeqo.NnY = ((eqq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    AppMethodBeat.o(176153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqo
 * JD-Core Version:    0.7.0.1
 */