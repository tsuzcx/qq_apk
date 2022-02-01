package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ees
  extends com.tencent.mm.bx.a
{
  public String URL;
  public int abkm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259862);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abkm);
      if (this.URL != null) {
        paramVarArgs.g(2, this.URL);
      }
      AppMethodBeat.o(259862);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abkm) + 0;
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.URL);
      }
      AppMethodBeat.o(259862);
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
      AppMethodBeat.o(259862);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ees localees = (ees)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259862);
        return -1;
      case 1: 
        localees.abkm = locala.ajGk.aar();
        AppMethodBeat.o(259862);
        return 0;
      }
      localees.URL = locala.ajGk.readString();
      AppMethodBeat.o(259862);
      return 0;
    }
    AppMethodBeat.o(259862);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ees
 * JD-Core Version:    0.7.0.1
 */