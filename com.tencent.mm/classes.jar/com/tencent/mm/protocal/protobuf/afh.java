package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afh
  extends com.tencent.mm.bx.a
{
  public LinkedList<afg> YFR;
  public long ZnD;
  public long ZnE;
  
  public afh()
  {
    AppMethodBeat.i(184493);
    this.YFR = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnD);
      paramVarArgs.bv(2, this.ZnE);
      paramVarArgs.e(3, 8, this.YFR);
      AppMethodBeat.o(184494);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.ZnD);
      i = i.a.a.b.b.a.q(2, this.ZnE);
      int j = i.a.a.a.c(3, 8, this.YFR);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YFR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      afh localafh = (afh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localafh.ZnD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localafh.ZnE = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(184494);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        afg localafg = new afg();
        if ((localObject != null) && (localObject.length > 0)) {
          localafg.parseFrom((byte[])localObject);
        }
        localafh.YFR.add(localafg);
        paramInt += 1;
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afh
 * JD-Core Version:    0.7.0.1
 */