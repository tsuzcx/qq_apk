package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fba
  extends com.tencent.mm.cd.a
{
  public fbe UAU;
  public fbc UAV;
  public int UaP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176153);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UaP);
      if (this.UAU != null)
      {
        paramVarArgs.oE(2, this.UAU.computeSize());
        this.UAU.writeFields(paramVarArgs);
      }
      if (this.UAV != null)
      {
        paramVarArgs.oE(3, this.UAV.computeSize());
        this.UAV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UaP) + 0;
      paramInt = i;
      if (this.UAU != null) {
        paramInt = i + g.a.a.a.oD(2, this.UAU.computeSize());
      }
      i = paramInt;
      if (this.UAV != null) {
        i = paramInt + g.a.a.a.oD(3, this.UAV.computeSize());
      }
      AppMethodBeat.o(176153);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fba localfba = (fba)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176153);
        return -1;
      case 1: 
        localfba.UaP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(176153);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbe)localObject2).parseFrom((byte[])localObject1);
          }
          localfba.UAU = ((fbe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(176153);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fbc();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fbc)localObject2).parseFrom((byte[])localObject1);
        }
        localfba.UAV = ((fbc)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    AppMethodBeat.o(176153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fba
 * JD-Core Version:    0.7.0.1
 */