package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uz
  extends com.tencent.mm.bx.a
{
  public int ZaX;
  public int ZaY;
  public String ZaZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91386);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZaX);
      paramVarArgs.bS(2, this.ZaY);
      if (this.ZaZ != null) {
        paramVarArgs.g(3, this.ZaZ);
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZaX) + 0 + i.a.a.b.b.a.cJ(2, this.ZaY);
      paramInt = i;
      if (this.ZaZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZaZ);
      }
      AppMethodBeat.o(91386);
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
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      uz localuz = (uz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91386);
        return -1;
      case 1: 
        localuz.ZaX = locala.ajGk.aar();
        AppMethodBeat.o(91386);
        return 0;
      case 2: 
        localuz.ZaY = locala.ajGk.aar();
        AppMethodBeat.o(91386);
        return 0;
      }
      localuz.ZaZ = locala.ajGk.readString();
      AppMethodBeat.o(91386);
      return 0;
    }
    AppMethodBeat.o(91386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uz
 * JD-Core Version:    0.7.0.1
 */