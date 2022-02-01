package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beq
  extends com.tencent.mm.bx.a
{
  public long DVk;
  public bzc ZLN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258747);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DVk);
      if (this.ZLN != null)
      {
        paramVarArgs.qD(2, this.ZLN.computeSize());
        this.ZLN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258747);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.DVk) + 0;
      paramInt = i;
      if (this.ZLN != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZLN.computeSize());
      }
      AppMethodBeat.o(258747);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258747);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      beq localbeq = (beq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258747);
        return -1;
      case 1: 
        localbeq.DVk = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258747);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bzc localbzc = new bzc();
        if ((localObject != null) && (localObject.length > 0)) {
          localbzc.parseFrom((byte[])localObject);
        }
        localbeq.ZLN = localbzc;
        paramInt += 1;
      }
      AppMethodBeat.o(258747);
      return 0;
    }
    AppMethodBeat.o(258747);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beq
 * JD-Core Version:    0.7.0.1
 */