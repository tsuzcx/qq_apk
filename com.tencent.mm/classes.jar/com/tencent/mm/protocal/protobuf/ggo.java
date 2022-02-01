package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggo
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b YID;
  public long YKx;
  public int acdf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YID == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.YKx);
      if (this.YID != null) {
        paramVarArgs.d(2, this.YID);
      }
      paramVarArgs.bS(3, this.acdf);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YKx) + 0;
      paramInt = i;
      if (this.YID != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YID);
      }
      i = i.a.a.b.b.a.cJ(3, this.acdf);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YID == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ggo localggo = (ggo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localggo.YKx = locala.ajGk.aaw();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localggo.YID = locala.ajGk.kFX();
        AppMethodBeat.o(32552);
        return 0;
      }
      localggo.acdf = locala.ajGk.aar();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggo
 * JD-Core Version:    0.7.0.1
 */