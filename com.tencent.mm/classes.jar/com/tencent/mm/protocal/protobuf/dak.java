package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dak
  extends com.tencent.mm.bx.a
{
  public String aaFW;
  public String aaFX;
  public int aaFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaFW != null) {
        paramVarArgs.g(1, this.aaFW);
      }
      if (this.aaFX != null) {
        paramVarArgs.g(2, this.aaFX);
      }
      paramVarArgs.bS(3, this.aaFY);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaFW == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaFW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaFX != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaFX);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaFY);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dak localdak = (dak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localdak.aaFW = locala.ajGk.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localdak.aaFX = locala.ajGk.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localdak.aaFY = locala.ajGk.aar();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dak
 * JD-Core Version:    0.7.0.1
 */