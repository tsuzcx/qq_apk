package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class feo
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int abDU;
  public etl abDV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125797);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abDU);
      if (this.abDV != null)
      {
        paramVarArgs.qD(2, this.abDV.computeSize());
        this.abDV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(125797);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abDU) + 0;
      paramInt = i;
      if (this.abDV != null) {
        paramInt = i + i.a.a.a.qC(2, this.abDV.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(125797);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125797);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      feo localfeo = (feo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125797);
        return -1;
      case 1: 
        localfeo.abDU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125797);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          etl localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localfeo.abDV = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(125797);
        return 0;
      }
      localfeo.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(125797);
      return 0;
    }
    AppMethodBeat.o(125797);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feo
 * JD-Core Version:    0.7.0.1
 */