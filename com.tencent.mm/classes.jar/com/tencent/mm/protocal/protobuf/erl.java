package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class erl
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String Url;
  public int YHC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6427);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      paramVarArgs.bS(2, this.YHC);
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(6427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label311;
      }
    }
    label311:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YHC);
      int j = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(6427);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6427);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        erl localerl = (erl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6427);
          return -1;
        case 1: 
          localerl.Url = locala.ajGk.readString();
          AppMethodBeat.o(6427);
          return 0;
        case 2: 
          localerl.YHC = locala.ajGk.aar();
          AppMethodBeat.o(6427);
          return 0;
        }
        localerl.IJG = locala.ajGk.aar();
        AppMethodBeat.o(6427);
        return 0;
      }
      AppMethodBeat.o(6427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erl
 * JD-Core Version:    0.7.0.1
 */