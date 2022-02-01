package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eei
  extends com.tencent.mm.bx.a
{
  public String URL;
  public String Zpa;
  public String abjp;
  public String abjq;
  public String abjr;
  public String abjs;
  public String hAP;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259948);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(2, this.nUB);
      }
      if (this.abjp != null) {
        paramVarArgs.g(3, this.abjp);
      }
      if (this.abjq != null) {
        paramVarArgs.g(4, this.abjq);
      }
      if (this.abjr != null) {
        paramVarArgs.g(6, this.abjr);
      }
      if (this.Zpa != null) {
        paramVarArgs.g(7, this.Zpa);
      }
      if (this.URL != null) {
        paramVarArgs.g(8, this.URL);
      }
      if (this.abjs != null) {
        paramVarArgs.g(9, this.abjs);
      }
      AppMethodBeat.o(259948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nUB);
      }
      i = paramInt;
      if (this.abjp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abjp);
      }
      paramInt = i;
      if (this.abjq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abjq);
      }
      i = paramInt;
      if (this.abjr != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abjr);
      }
      paramInt = i;
      if (this.Zpa != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zpa);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.URL);
      }
      paramInt = i;
      if (this.abjs != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abjs);
      }
      AppMethodBeat.o(259948);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259948);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eei localeei = (eei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 5: 
        default: 
          AppMethodBeat.o(259948);
          return -1;
        case 1: 
          localeei.hAP = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 2: 
          localeei.nUB = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 3: 
          localeei.abjp = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 4: 
          localeei.abjq = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 6: 
          localeei.abjr = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 7: 
          localeei.Zpa = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        case 8: 
          localeei.URL = locala.ajGk.readString();
          AppMethodBeat.o(259948);
          return 0;
        }
        localeei.abjs = locala.ajGk.readString();
        AppMethodBeat.o(259948);
        return 0;
      }
      AppMethodBeat.o(259948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eei
 * JD-Core Version:    0.7.0.1
 */