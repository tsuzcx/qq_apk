package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmf
  extends com.tencent.mm.bx.a
{
  public gol aajK;
  public int aajL;
  public int abMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258814);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abMB);
      if (this.aajK != null)
      {
        paramVarArgs.qD(2, this.aajK.computeSize());
        this.aajK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aajL);
      AppMethodBeat.o(258814);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abMB) + 0;
      paramInt = i;
      if (this.aajK != null) {
        paramInt = i + i.a.a.a.qC(2, this.aajK.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.aajL);
      AppMethodBeat.o(258814);
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
      AppMethodBeat.o(258814);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fmf localfmf = (fmf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258814);
        return -1;
      case 1: 
        localfmf.abMB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258814);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localfmf.aajK = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(258814);
        return 0;
      }
      localfmf.aajL = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258814);
      return 0;
    }
    AppMethodBeat.o(258814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmf
 * JD-Core Version:    0.7.0.1
 */