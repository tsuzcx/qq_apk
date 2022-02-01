package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ue
  extends com.tencent.mm.cd.a
{
  public LinkedList<dby> RKA;
  public int fwq;
  
  public ue()
  {
    AppMethodBeat.i(207255);
    this.RKA = new LinkedList();
    AppMethodBeat.o(207255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207256);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RKA);
      paramVarArgs.aY(2, this.fwq);
      AppMethodBeat.o(207256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.RKA);
      i = g.a.a.b.b.a.bM(2, this.fwq);
      AppMethodBeat.o(207256);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RKA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ue localue = (ue)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207256);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dby localdby = new dby();
          if ((localObject != null) && (localObject.length > 0)) {
            localdby.parseFrom((byte[])localObject);
          }
          localue.RKA.add(localdby);
          paramInt += 1;
        }
        AppMethodBeat.o(207256);
        return 0;
      }
      localue.fwq = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(207256);
      return 0;
    }
    AppMethodBeat.o(207256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ue
 * JD-Core Version:    0.7.0.1
 */