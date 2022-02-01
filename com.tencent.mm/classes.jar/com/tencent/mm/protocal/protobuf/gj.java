package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gj
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String SessionId;
  public String Url;
  public long YIa;
  public int YIb;
  public int YIc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      paramVarArgs.bv(2, this.YIa);
      paramVarArgs.bS(3, this.YIb);
      if (this.SessionId != null) {
        paramVarArgs.g(4, this.SessionId);
      }
      paramVarArgs.bS(5, this.IJG);
      paramVarArgs.bS(6, this.YIc);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YIa) + i.a.a.b.b.a.cJ(3, this.YIb);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.SessionId);
      }
      i = i.a.a.b.b.a.cJ(5, this.IJG);
      int j = i.a.a.b.b.a.cJ(6, this.YIc);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gj localgj = (gj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localgj.Url = locala.ajGk.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localgj.YIa = locala.ajGk.aaw();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localgj.YIb = locala.ajGk.aar();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localgj.SessionId = locala.ajGk.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localgj.IJG = locala.ajGk.aar();
          AppMethodBeat.o(6390);
          return 0;
        }
        localgj.YIc = locala.ajGk.aar();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gj
 * JD-Core Version:    0.7.0.1
 */