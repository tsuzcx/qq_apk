package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjf
  extends com.tencent.mm.bx.a
{
  public int acfw;
  public int acfx;
  public int acfy;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258282);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.version);
      paramVarArgs.bS(2, this.acfw);
      paramVarArgs.bS(3, this.acfx);
      paramVarArgs.bS(4, this.acfy);
      AppMethodBeat.o(258282);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.version);
      int i = i.a.a.b.b.a.cJ(2, this.acfw);
      int j = i.a.a.b.b.a.cJ(3, this.acfx);
      int k = i.a.a.b.b.a.cJ(4, this.acfy);
      AppMethodBeat.o(258282);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258282);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gjf localgjf = (gjf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258282);
        return -1;
      case 1: 
        localgjf.version = locala.ajGk.aar();
        AppMethodBeat.o(258282);
        return 0;
      case 2: 
        localgjf.acfw = locala.ajGk.aar();
        AppMethodBeat.o(258282);
        return 0;
      case 3: 
        localgjf.acfx = locala.ajGk.aar();
        AppMethodBeat.o(258282);
        return 0;
      }
      localgjf.acfy = locala.ajGk.aar();
      AppMethodBeat.o(258282);
      return 0;
    }
    AppMethodBeat.o(258282);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjf
 * JD-Core Version:    0.7.0.1
 */