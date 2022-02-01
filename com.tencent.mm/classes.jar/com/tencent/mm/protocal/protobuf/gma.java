package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gma
  extends com.tencent.mm.bx.a
{
  public String aaWC;
  public String achp;
  public int achq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257355);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaWC != null) {
        paramVarArgs.g(1, this.aaWC);
      }
      if (this.achp != null) {
        paramVarArgs.g(2, this.achp);
      }
      paramVarArgs.bS(3, this.achq);
      AppMethodBeat.o(257355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaWC == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaWC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.achp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.achp);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.achq);
      AppMethodBeat.o(257355);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257355);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gma localgma = (gma)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257355);
          return -1;
        case 1: 
          localgma.aaWC = locala.ajGk.readString();
          AppMethodBeat.o(257355);
          return 0;
        case 2: 
          localgma.achp = locala.ajGk.readString();
          AppMethodBeat.o(257355);
          return 0;
        }
        localgma.achq = locala.ajGk.aar();
        AppMethodBeat.o(257355);
        return 0;
      }
      AppMethodBeat.o(257355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gma
 * JD-Core Version:    0.7.0.1
 */