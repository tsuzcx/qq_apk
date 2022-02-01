package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxe
  extends com.tencent.mm.bx.a
{
  public LinkedList<dxh> YFR;
  public int abdl;
  
  public dxe()
  {
    AppMethodBeat.i(152633);
    this.YFR = new LinkedList();
    AppMethodBeat.o(152633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152634);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YFR);
      paramVarArgs.bS(2, this.abdl);
      AppMethodBeat.o(152634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.YFR);
      i = i.a.a.b.b.a.cJ(2, this.abdl);
      AppMethodBeat.o(152634);
      return paramInt + 0 + i;
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
      AppMethodBeat.o(152634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dxe localdxe = (dxe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152634);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dxh localdxh = new dxh();
          if ((localObject != null) && (localObject.length > 0)) {
            localdxh.parseFrom((byte[])localObject);
          }
          localdxe.YFR.add(localdxh);
          paramInt += 1;
        }
        AppMethodBeat.o(152634);
        return 0;
      }
      localdxe.abdl = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(152634);
      return 0;
    }
    AppMethodBeat.o(152634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */