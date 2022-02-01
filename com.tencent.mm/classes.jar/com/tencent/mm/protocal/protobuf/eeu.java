package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eeu
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public float MpJ;
  public String abjs;
  public int abkq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259888);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.abjs != null) {
        paramVarArgs.g(2, this.abjs);
      }
      paramVarArgs.bS(3, this.abkq);
      paramVarArgs.l(4, this.MpJ);
      AppMethodBeat.o(259888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label361;
      }
    }
    label361:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abjs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abjs);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abkq);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259888);
      return i + paramInt + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259888);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eeu localeeu = (eeu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259888);
          return -1;
        case 1: 
          localeeu.IGU = locala.ajGk.readString();
          AppMethodBeat.o(259888);
          return 0;
        case 2: 
          localeeu.abjs = locala.ajGk.readString();
          AppMethodBeat.o(259888);
          return 0;
        case 3: 
          localeeu.abkq = locala.ajGk.aar();
          AppMethodBeat.o(259888);
          return 0;
        }
        localeeu.MpJ = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259888);
        return 0;
      }
      AppMethodBeat.o(259888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeu
 * JD-Core Version:    0.7.0.1
 */