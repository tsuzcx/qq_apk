package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epi
  extends com.tencent.mm.cd.a
{
  public String Usf;
  public String Usg;
  public String mon;
  public String moo;
  public String mop;
  public String moq;
  public String mor;
  public String mos;
  public String mot;
  public String mou;
  public String mov;
  public String mow;
  public String mox;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mon != null) {
        paramVarArgs.f(1, this.mon);
      }
      if (this.moo != null) {
        paramVarArgs.f(2, this.moo);
      }
      if (this.mop != null) {
        paramVarArgs.f(3, this.mop);
      }
      if (this.moq != null) {
        paramVarArgs.f(4, this.moq);
      }
      if (this.mor != null) {
        paramVarArgs.f(5, this.mor);
      }
      if (this.mos != null) {
        paramVarArgs.f(6, this.mos);
      }
      if (this.mot != null) {
        paramVarArgs.f(7, this.mot);
      }
      if (this.mou != null) {
        paramVarArgs.f(8, this.mou);
      }
      if (this.mov != null) {
        paramVarArgs.f(9, this.mov);
      }
      if (this.mow != null) {
        paramVarArgs.f(10, this.mow);
      }
      if (this.mox != null) {
        paramVarArgs.f(11, this.mox);
      }
      if (this.Usf != null) {
        paramVarArgs.f(12, this.Usf);
      }
      if (this.Usg != null) {
        paramVarArgs.f(13, this.Usg);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mon == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.b.b.a.g(1, this.mon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.moo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.moo);
      }
      i = paramInt;
      if (this.mop != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mop);
      }
      paramInt = i;
      if (this.moq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.moq);
      }
      i = paramInt;
      if (this.mor != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mor);
      }
      paramInt = i;
      if (this.mos != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mos);
      }
      i = paramInt;
      if (this.mot != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mot);
      }
      paramInt = i;
      if (this.mou != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mou);
      }
      i = paramInt;
      if (this.mov != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.mov);
      }
      paramInt = i;
      if (this.mow != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.mow);
      }
      i = paramInt;
      if (this.mox != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.mox);
      }
      paramInt = i;
      if (this.Usf != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Usf);
      }
      i = paramInt;
      if (this.Usg != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.Usg);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        epi localepi = (epi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localepi.mon = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localepi.moo = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localepi.mop = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localepi.moq = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localepi.mor = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localepi.mos = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localepi.mot = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localepi.mou = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localepi.mov = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localepi.mow = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localepi.mox = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localepi.Usf = locala.abFh.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localepi.Usg = locala.abFh.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epi
 * JD-Core Version:    0.7.0.1
 */