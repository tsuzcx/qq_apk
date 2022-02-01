package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fck
  extends com.tencent.mm.bx.a
{
  public int abBY;
  public LinkedList<fjq> abBZ;
  
  public fck()
  {
    AppMethodBeat.i(133195);
    this.abBZ = new LinkedList();
    AppMethodBeat.o(133195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133196);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abBY);
      paramVarArgs.e(2, 8, this.abBZ);
      AppMethodBeat.o(133196);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abBY);
      i = i.a.a.a.c(2, 8, this.abBZ);
      AppMethodBeat.o(133196);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abBZ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133196);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fck localfck = (fck)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133196);
        return -1;
      case 1: 
        localfck.abBY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133196);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fjq localfjq = new fjq();
        if ((localObject != null) && (localObject.length > 0)) {
          localfjq.parseFrom((byte[])localObject);
        }
        localfck.abBZ.add(localfjq);
        paramInt += 1;
      }
      AppMethodBeat.o(133196);
      return 0;
    }
    AppMethodBeat.o(133196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fck
 * JD-Core Version:    0.7.0.1
 */