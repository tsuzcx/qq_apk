package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int PzZ;
  public int YyQ;
  public com.tencent.mm.bx.b YyZ;
  public int Yza;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YyZ == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.YyQ);
      if (this.YyZ != null) {
        paramVarArgs.d(2, this.YyZ);
      }
      paramVarArgs.bS(3, this.Yza);
      paramVarArgs.bS(4, this.PzZ);
      paramVarArgs.bS(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YyQ) + 0;
      paramInt = i;
      if (this.YyZ != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YyZ);
      }
      i = i.a.a.b.b.a.cJ(3, this.Yza);
      int j = i.a.a.b.b.a.cJ(4, this.PzZ);
      int k = i.a.a.b.b.a.cJ(5, this.count);
      AppMethodBeat.o(143943);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YyZ == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.YyQ = locala.ajGk.aar();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.YyZ = locala.ajGk.kFX();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.Yza = locala.ajGk.aar();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.PzZ = locala.ajGk.aar();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.ajGk.aar();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */