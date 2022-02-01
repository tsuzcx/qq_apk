package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eev
  extends com.tencent.mm.bx.a
{
  public String URL;
  public int abkr;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259877);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.URL != null) {
        paramVarArgs.g(2, this.URL);
      }
      paramVarArgs.bS(3, this.abkr);
      AppMethodBeat.o(259877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.URL);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abkr);
      AppMethodBeat.o(259877);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259877);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eev localeev = (eev)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259877);
          return -1;
        case 1: 
          localeev.hAP = locala.ajGk.readString();
          AppMethodBeat.o(259877);
          return 0;
        case 2: 
          localeev.URL = locala.ajGk.readString();
          AppMethodBeat.o(259877);
          return 0;
        }
        localeev.abkr = locala.ajGk.aar();
        AppMethodBeat.o(259877);
        return 0;
      }
      AppMethodBeat.o(259877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eev
 * JD-Core Version:    0.7.0.1
 */