package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcw
  extends com.tencent.mm.bx.a
{
  public boolean abCk = false;
  public boolean abCl = false;
  public String appId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147779);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.abCk);
      paramVarArgs.di(2, this.abCl);
      paramVarArgs.bS(3, this.scene);
      if (this.appId != null) {
        paramVarArgs.g(4, this.appId);
      }
      AppMethodBeat.o(147779);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appId);
      }
      AppMethodBeat.o(147779);
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
      AppMethodBeat.o(147779);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fcw localfcw = (fcw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147779);
        return -1;
      case 1: 
        localfcw.abCk = locala.ajGk.aai();
        AppMethodBeat.o(147779);
        return 0;
      case 2: 
        localfcw.abCl = locala.ajGk.aai();
        AppMethodBeat.o(147779);
        return 0;
      case 3: 
        localfcw.scene = locala.ajGk.aar();
        AppMethodBeat.o(147779);
        return 0;
      }
      localfcw.appId = locala.ajGk.readString();
      AppMethodBeat.o(147779);
      return 0;
    }
    AppMethodBeat.o(147779);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcw
 * JD-Core Version:    0.7.0.1
 */