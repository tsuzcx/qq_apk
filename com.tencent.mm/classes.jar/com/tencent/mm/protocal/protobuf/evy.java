package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class evy
  extends com.tencent.mm.bx.a
{
  public String abyA;
  public int abyB;
  public String abyC;
  public String hRk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abyA != null) {
        paramVarArgs.g(1, this.abyA);
      }
      if (this.hRk != null) {
        paramVarArgs.g(2, this.hRk);
      }
      paramVarArgs.bS(3, this.abyB);
      if (this.abyC != null) {
        paramVarArgs.g(4, this.abyC);
      }
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abyA == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.abyA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hRk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hRk);
      }
      i += i.a.a.b.b.a.cJ(3, this.abyB);
      paramInt = i;
      if (this.abyC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abyC);
      }
      AppMethodBeat.o(152686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        evy localevy = (evy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localevy.abyA = locala.ajGk.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localevy.hRk = locala.ajGk.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 3: 
          localevy.abyB = locala.ajGk.aar();
          AppMethodBeat.o(152686);
          return 0;
        }
        localevy.abyC = locala.ajGk.readString();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evy
 * JD-Core Version:    0.7.0.1
 */