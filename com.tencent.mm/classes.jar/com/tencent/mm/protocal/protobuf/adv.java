package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class adv
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b Zma;
  public ede Zmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      if (this.Zma != null) {
        paramVarArgs.d(2, this.Zma);
      }
      if (this.Zmb != null)
      {
        paramVarArgs.qD(3, this.Zmb.computeSize());
        this.Zmb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Tps) + 0;
      paramInt = i;
      if (this.Zma != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Zma);
      }
      i = paramInt;
      if (this.Zmb != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zmb.computeSize());
      }
      AppMethodBeat.o(91422);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      adv localadv = (adv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localadv.Tps = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localadv.Zma = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ede localede = new ede();
        if ((localObject != null) && (localObject.length > 0)) {
          localede.parseFrom((byte[])localObject);
        }
        localadv.Zmb = localede;
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adv
 * JD-Core Version:    0.7.0.1
 */