package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgx
  extends com.tencent.mm.bx.a
{
  public double latitude;
  public double longitude;
  public String wws;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.latitude);
      paramVarArgs.d(2, this.longitude);
      if (this.wws != null) {
        paramVarArgs.g(3, this.wws);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 8 + 0 + (i.a.a.b.b.a.ko(2) + 8);
      paramInt = i;
      if (this.wws != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wws);
      }
      AppMethodBeat.o(93333);
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
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dgx localdgx = (dgx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localdgx.latitude = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localdgx.longitude = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(93333);
        return 0;
      }
      localdgx.wws = locala.ajGk.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgx
 * JD-Core Version:    0.7.0.1
 */