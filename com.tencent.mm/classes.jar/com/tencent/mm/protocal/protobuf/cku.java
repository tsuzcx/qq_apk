package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cku
  extends com.tencent.mm.bx.a
{
  public LinkedList<ckt> aasU;
  public cks aasV;
  
  public cku()
  {
    AppMethodBeat.i(82411);
    this.aasU = new LinkedList();
    AppMethodBeat.o(82411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aasU);
      if (this.aasV != null)
      {
        paramVarArgs.qD(2, this.aasV.computeSize());
        this.aasV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aasU) + 0;
      paramInt = i;
      if (this.aasV != null) {
        paramInt = i + i.a.a.a.qC(2, this.aasV.computeSize());
      }
      AppMethodBeat.o(82412);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aasU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cku localcku = (cku)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82412);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckt)localObject2).parseFrom((byte[])localObject1);
          }
          localcku.aasU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82412);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cks();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cks)localObject2).parseFrom((byte[])localObject1);
        }
        localcku.aasV = ((cks)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(82412);
      return 0;
    }
    AppMethodBeat.o(82412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cku
 * JD-Core Version:    0.7.0.1
 */