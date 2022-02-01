package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flv
  extends com.tencent.mm.cd.a
{
  public LinkedList<fhc> UKI;
  public LinkedList<ers> UKJ;
  
  public flv()
  {
    AppMethodBeat.i(261630);
    this.UKI = new LinkedList();
    this.UKJ = new LinkedList();
    AppMethodBeat.o(261630);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UKI);
      paramVarArgs.e(2, 8, this.UKJ);
      AppMethodBeat.o(261633);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.UKI);
      i = g.a.a.a.c(2, 8, this.UKJ);
      AppMethodBeat.o(261633);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UKI.clear();
      this.UKJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(261633);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      flv localflv = (flv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(261633);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhc)localObject2).parseFrom((byte[])localObject1);
          }
          localflv.UKI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(261633);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ers();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ers)localObject2).parseFrom((byte[])localObject1);
        }
        localflv.UKJ.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(261633);
      return 0;
    }
    AppMethodBeat.o(261633);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flv
 * JD-Core Version:    0.7.0.1
 */