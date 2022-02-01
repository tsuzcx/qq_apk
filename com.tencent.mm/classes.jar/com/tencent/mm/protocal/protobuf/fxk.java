package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxk
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public int Zms;
  public String abaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zms);
      if (this.ADE != null) {
        paramVarArgs.g(2, this.ADE);
      }
      if (this.abaK != null) {
        paramVarArgs.g(3, this.abaK);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zms) + 0;
      paramInt = i;
      if (this.ADE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ADE);
      }
      i = paramInt;
      if (this.abaK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abaK);
      }
      AppMethodBeat.o(176156);
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
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fxk localfxk = (fxk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localfxk.Zms = locala.ajGk.aar();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localfxk.ADE = locala.ajGk.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localfxk.abaK = locala.ajGk.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxk
 * JD-Core Version:    0.7.0.1
 */