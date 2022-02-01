package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmc
  extends com.tencent.mm.bx.a
{
  public int abMs;
  public int abMt;
  public LinkedList<fmd> nUC;
  
  public fmc()
  {
    AppMethodBeat.i(258759);
    this.nUC = new LinkedList();
    AppMethodBeat.o(258759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258764);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.nUC);
      paramVarArgs.bS(2, this.abMs);
      paramVarArgs.bS(3, this.abMt);
      AppMethodBeat.o(258764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.nUC);
      i = i.a.a.b.b.a.cJ(2, this.abMs);
      int j = i.a.a.b.b.a.cJ(3, this.abMt);
      AppMethodBeat.o(258764);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fmc localfmc = (fmc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258764);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fmd localfmd = new fmd();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmd.parseFrom((byte[])localObject);
          }
          localfmc.nUC.add(localfmd);
          paramInt += 1;
        }
        AppMethodBeat.o(258764);
        return 0;
      case 2: 
        localfmc.abMs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258764);
        return 0;
      }
      localfmc.abMt = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258764);
      return 0;
    }
    AppMethodBeat.o(258764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmc
 * JD-Core Version:    0.7.0.1
 */