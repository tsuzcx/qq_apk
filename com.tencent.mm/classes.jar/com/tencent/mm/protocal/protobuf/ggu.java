package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggu
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public com.tencent.mm.bx.b YID;
  public String abvu;
  public long acdg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32559);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.YID == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32559);
        throw paramVarArgs;
      }
      if (this.abvu != null) {
        paramVarArgs.g(1, this.abvu);
      }
      paramVarArgs.bv(2, this.acdg);
      if (this.YID != null) {
        paramVarArgs.d(3, this.YID);
      }
      paramVarArgs.bS(4, this.IJG);
      AppMethodBeat.o(32559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abvu == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = i.a.a.b.b.a.h(1, this.abvu) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.acdg);
      paramInt = i;
      if (this.YID != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YID);
      }
      i = i.a.a.b.b.a.cJ(4, this.IJG);
      AppMethodBeat.o(32559);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abvu == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        if (this.YID == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: VoiceData");
          AppMethodBeat.o(32559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32559);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggu localggu = (ggu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32559);
          return -1;
        case 1: 
          localggu.abvu = locala.ajGk.readString();
          AppMethodBeat.o(32559);
          return 0;
        case 2: 
          localggu.acdg = locala.ajGk.aaw();
          AppMethodBeat.o(32559);
          return 0;
        case 3: 
          localggu.YID = locala.ajGk.kFX();
          AppMethodBeat.o(32559);
          return 0;
        }
        localggu.IJG = locala.ajGk.aar();
        AppMethodBeat.o(32559);
        return 0;
      }
      AppMethodBeat.o(32559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggu
 * JD-Core Version:    0.7.0.1
 */