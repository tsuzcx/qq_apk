package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gme
  extends com.tencent.mm.bx.a
{
  public b ZqH;
  public String appid;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50124);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.ZqH != null) {
        paramVarArgs.d(2, this.ZqH);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.ZqH != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZqH);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      AppMethodBeat.o(50124);
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
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gme localgme = (gme)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50124);
        return -1;
      case 1: 
        localgme.type = locala.ajGk.aar();
        AppMethodBeat.o(50124);
        return 0;
      case 2: 
        localgme.ZqH = locala.ajGk.kFX();
        AppMethodBeat.o(50124);
        return 0;
      }
      localgme.appid = locala.ajGk.readString();
      AppMethodBeat.o(50124);
      return 0;
    }
    AppMethodBeat.o(50124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gme
 * JD-Core Version:    0.7.0.1
 */