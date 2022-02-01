package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkh
  extends com.tencent.mm.bx.a
{
  public String abLi;
  public String abLj;
  public String pie;
  public String pif;
  public String pig;
  public String pih;
  public String pii;
  public String pij;
  public String pik;
  public String pil;
  public String pim;
  public String pio;
  public String pip;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pie != null) {
        paramVarArgs.g(1, this.pie);
      }
      if (this.pif != null) {
        paramVarArgs.g(2, this.pif);
      }
      if (this.pig != null) {
        paramVarArgs.g(3, this.pig);
      }
      if (this.pih != null) {
        paramVarArgs.g(4, this.pih);
      }
      if (this.pii != null) {
        paramVarArgs.g(5, this.pii);
      }
      if (this.pij != null) {
        paramVarArgs.g(6, this.pij);
      }
      if (this.pik != null) {
        paramVarArgs.g(7, this.pik);
      }
      if (this.pil != null) {
        paramVarArgs.g(8, this.pil);
      }
      if (this.pim != null) {
        paramVarArgs.g(9, this.pim);
      }
      if (this.pio != null) {
        paramVarArgs.g(10, this.pio);
      }
      if (this.pip != null) {
        paramVarArgs.g(11, this.pip);
      }
      if (this.abLi != null) {
        paramVarArgs.g(12, this.abLi);
      }
      if (this.abLj != null) {
        paramVarArgs.g(13, this.abLj);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pie == null) {
        break label946;
      }
    }
    label946:
    for (int i = i.a.a.b.b.a.h(1, this.pie) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pif != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pif);
      }
      i = paramInt;
      if (this.pig != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pig);
      }
      paramInt = i;
      if (this.pih != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pih);
      }
      i = paramInt;
      if (this.pii != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pii);
      }
      paramInt = i;
      if (this.pij != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pij);
      }
      i = paramInt;
      if (this.pik != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pik);
      }
      paramInt = i;
      if (this.pil != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.pil);
      }
      i = paramInt;
      if (this.pim != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.pim);
      }
      paramInt = i;
      if (this.pio != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.pio);
      }
      i = paramInt;
      if (this.pip != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.pip);
      }
      paramInt = i;
      if (this.abLi != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abLi);
      }
      i = paramInt;
      if (this.abLj != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abLj);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fkh localfkh = (fkh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localfkh.pie = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localfkh.pif = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localfkh.pig = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localfkh.pih = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localfkh.pii = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localfkh.pij = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localfkh.pik = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localfkh.pil = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localfkh.pim = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localfkh.pio = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localfkh.pip = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localfkh.abLi = locala.ajGk.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localfkh.abLj = locala.ajGk.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkh
 * JD-Core Version:    0.7.0.1
 */