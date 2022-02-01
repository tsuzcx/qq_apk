package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzf
  extends com.tencent.mm.bx.a
{
  public int NkO;
  public int abWD;
  public int abWE;
  public gol abWF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWF == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.NkO);
      paramVarArgs.bS(2, this.abWD);
      paramVarArgs.bS(3, this.abWE);
      if (this.abWF != null)
      {
        paramVarArgs.qD(4, this.abWF.computeSize());
        this.abWF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.NkO) + 0 + i.a.a.b.b.a.cJ(2, this.abWD) + i.a.a.b.b.a.cJ(3, this.abWE);
      paramInt = i;
      if (this.abWF != null) {
        paramInt = i + i.a.a.a.qC(4, this.abWF.computeSize());
      }
      AppMethodBeat.o(32499);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abWF == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fzf localfzf = (fzf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localfzf.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localfzf.abWD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localfzf.abWE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32499);
        return 0;
      }
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
        localfzf.abWF = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    AppMethodBeat.o(32499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzf
 * JD-Core Version:    0.7.0.1
 */