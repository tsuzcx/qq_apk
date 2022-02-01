package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhh
  extends com.tencent.mm.bx.a
{
  public String ZQE;
  public boolean enable;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.enable);
      if (this.ZQE != null) {
        paramVarArgs.g(2, this.ZQE);
      }
      AppMethodBeat.o(257520);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.ZQE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZQE);
      }
      AppMethodBeat.o(257520);
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
      AppMethodBeat.o(257520);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fhh localfhh = (fhh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257520);
        return -1;
      case 1: 
        localfhh.enable = locala.ajGk.aai();
        AppMethodBeat.o(257520);
        return 0;
      }
      localfhh.ZQE = locala.ajGk.readString();
      AppMethodBeat.o(257520);
      return 0;
    }
    AppMethodBeat.o(257520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhh
 * JD-Core Version:    0.7.0.1
 */