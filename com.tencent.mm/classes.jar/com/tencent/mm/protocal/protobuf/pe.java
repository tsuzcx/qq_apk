package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pe
  extends com.tencent.mm.bx.a
{
  public LinkedList<dtq> YHU;
  public String YRs;
  
  public pe()
  {
    AppMethodBeat.i(258431);
    this.YHU = new LinkedList();
    AppMethodBeat.o(258431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YHU);
      if (this.YRs != null) {
        paramVarArgs.g(2, this.YRs);
      }
      AppMethodBeat.o(258434);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YHU) + 0;
      paramInt = i;
      if (this.YRs != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YRs);
      }
      AppMethodBeat.o(258434);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YHU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258434);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      pe localpe = (pe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258434);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dtq localdtq = new dtq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdtq.parseFrom((byte[])localObject);
          }
          localpe.YHU.add(localdtq);
          paramInt += 1;
        }
        AppMethodBeat.o(258434);
        return 0;
      }
      localpe.YRs = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258434);
      return 0;
    }
    AppMethodBeat.o(258434);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pe
 * JD-Core Version:    0.7.0.1
 */