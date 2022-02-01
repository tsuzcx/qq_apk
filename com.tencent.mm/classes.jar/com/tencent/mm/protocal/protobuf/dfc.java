package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfc
  extends com.tencent.mm.cd.a
{
  public LinkedList<dff> RIQ;
  public int TMU;
  
  public dfc()
  {
    AppMethodBeat.i(152633);
    this.RIQ = new LinkedList();
    AppMethodBeat.o(152633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RIQ);
      paramVarArgs.aY(2, this.TMU);
      AppMethodBeat.o(152634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.RIQ);
      i = g.a.a.b.b.a.bM(2, this.TMU);
      AppMethodBeat.o(152634);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RIQ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dfc localdfc = (dfc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152634);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dff localdff = new dff();
          if ((localObject != null) && (localObject.length > 0)) {
            localdff.parseFrom((byte[])localObject);
          }
          localdfc.RIQ.add(localdff);
          paramInt += 1;
        }
        AppMethodBeat.o(152634);
        return 0;
      }
      localdfc.TMU = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(152634);
      return 0;
    }
    AppMethodBeat.o(152634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfc
 * JD-Core Version:    0.7.0.1
 */