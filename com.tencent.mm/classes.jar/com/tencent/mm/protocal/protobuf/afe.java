package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afe
  extends com.tencent.mm.bx.a
{
  public int Zny;
  public String Znz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259964);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zny);
      if (this.Znz != null) {
        paramVarArgs.g(2, this.Znz);
      }
      AppMethodBeat.o(259964);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zny) + 0;
      paramInt = i;
      if (this.Znz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Znz);
      }
      AppMethodBeat.o(259964);
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
      AppMethodBeat.o(259964);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afe localafe = (afe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259964);
        return -1;
      case 1: 
        localafe.Zny = locala.ajGk.aar();
        AppMethodBeat.o(259964);
        return 0;
      }
      localafe.Znz = locala.ajGk.readString();
      AppMethodBeat.o(259964);
      return 0;
    }
    AppMethodBeat.o(259964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afe
 * JD-Core Version:    0.7.0.1
 */