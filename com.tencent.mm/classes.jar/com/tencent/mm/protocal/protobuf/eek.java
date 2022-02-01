package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eek
  extends com.tencent.mm.bx.a
{
  public String URL;
  public String abjs;
  public float abjw;
  public float abjx;
  public String crB;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259982);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.crB != null) {
        paramVarArgs.g(2, this.crB);
      }
      paramVarArgs.l(3, this.abjw);
      paramVarArgs.l(4, this.abjx);
      if (this.URL != null) {
        paramVarArgs.g(5, this.URL);
      }
      if (this.abjs != null) {
        paramVarArgs.g(6, this.abjs);
      }
      AppMethodBeat.o(259982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.crB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.crB);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.URL);
      }
      i = paramInt;
      if (this.abjs != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abjs);
      }
      AppMethodBeat.o(259982);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259982);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eek localeek = (eek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259982);
          return -1;
        case 1: 
          localeek.hAP = locala.ajGk.readString();
          AppMethodBeat.o(259982);
          return 0;
        case 2: 
          localeek.crB = locala.ajGk.readString();
          AppMethodBeat.o(259982);
          return 0;
        case 3: 
          localeek.abjw = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(259982);
          return 0;
        case 4: 
          localeek.abjx = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(259982);
          return 0;
        case 5: 
          localeek.URL = locala.ajGk.readString();
          AppMethodBeat.o(259982);
          return 0;
        }
        localeek.abjs = locala.ajGk.readString();
        AppMethodBeat.o(259982);
        return 0;
      }
      AppMethodBeat.o(259982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eek
 * JD-Core Version:    0.7.0.1
 */