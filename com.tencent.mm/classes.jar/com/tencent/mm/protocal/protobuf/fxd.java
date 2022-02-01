package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxd
  extends com.tencent.mm.bx.a
{
  public boolean abUQ;
  public String abUR;
  public String abUS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258094);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.abUQ);
      if (this.abUR != null) {
        paramVarArgs.g(2, this.abUR);
      }
      if (this.abUS != null) {
        paramVarArgs.g(3, this.abUS);
      }
      AppMethodBeat.o(258094);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.abUR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abUR);
      }
      i = paramInt;
      if (this.abUS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abUS);
      }
      AppMethodBeat.o(258094);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258094);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fxd localfxd = (fxd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258094);
        return -1;
      case 1: 
        localfxd.abUQ = locala.ajGk.aai();
        AppMethodBeat.o(258094);
        return 0;
      case 2: 
        localfxd.abUR = locala.ajGk.readString();
        AppMethodBeat.o(258094);
        return 0;
      }
      localfxd.abUS = locala.ajGk.readString();
      AppMethodBeat.o(258094);
      return 0;
    }
    AppMethodBeat.o(258094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxd
 * JD-Core Version:    0.7.0.1
 */