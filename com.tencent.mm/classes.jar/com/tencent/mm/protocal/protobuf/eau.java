package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class eau
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int Nju;
  public int YIE;
  public String abgg;
  public int abgh;
  public String abgi;
  public String abgj;
  public String abgk;
  public String abgl;
  public String abgm;
  public int abgn;
  public String abgo;
  public String abgp;
  public String pSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258408);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abgg == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(258408);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.IJG);
      paramVarArgs.bS(2, this.YIE);
      paramVarArgs.bS(3, this.Nju);
      if (this.abgg != null) {
        paramVarArgs.g(4, this.abgg);
      }
      paramVarArgs.bS(5, this.abgh);
      if (this.abgi != null) {
        paramVarArgs.g(6, this.abgi);
      }
      if (this.abgj != null) {
        paramVarArgs.g(7, this.abgj);
      }
      if (this.abgk != null) {
        paramVarArgs.g(8, this.abgk);
      }
      if (this.abgl != null) {
        paramVarArgs.g(10, this.abgl);
      }
      if (this.abgm != null) {
        paramVarArgs.g(11, this.abgm);
      }
      paramVarArgs.bS(12, this.abgn);
      if (this.pSi != null) {
        paramVarArgs.g(13, this.pSi);
      }
      if (this.abgo != null) {
        paramVarArgs.g(14, this.abgo);
      }
      if (this.abgp != null) {
        paramVarArgs.g(15, this.abgp);
      }
      AppMethodBeat.o(258408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0 + i.a.a.b.b.a.cJ(2, this.YIE) + i.a.a.b.b.a.cJ(3, this.Nju);
      paramInt = i;
      if (this.abgg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abgg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abgh);
      paramInt = i;
      if (this.abgi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abgi);
      }
      i = paramInt;
      if (this.abgj != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abgj);
      }
      paramInt = i;
      if (this.abgk != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abgk);
      }
      i = paramInt;
      if (this.abgl != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abgl);
      }
      paramInt = i;
      if (this.abgm != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abgm);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.abgn);
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.pSi);
      }
      i = paramInt;
      if (this.abgo != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abgo);
      }
      paramInt = i;
      if (this.abgp != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abgp);
      }
      AppMethodBeat.o(258408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abgg == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(258408);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258408);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eau localeau = (eau)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(258408);
        return -1;
      case 1: 
        localeau.IJG = locala.ajGk.aar();
        AppMethodBeat.o(258408);
        return 0;
      case 2: 
        localeau.YIE = locala.ajGk.aar();
        AppMethodBeat.o(258408);
        return 0;
      case 3: 
        localeau.Nju = locala.ajGk.aar();
        AppMethodBeat.o(258408);
        return 0;
      case 4: 
        localeau.abgg = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 5: 
        localeau.abgh = locala.ajGk.aar();
        AppMethodBeat.o(258408);
        return 0;
      case 6: 
        localeau.abgi = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 7: 
        localeau.abgj = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 8: 
        localeau.abgk = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 10: 
        localeau.abgl = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 11: 
        localeau.abgm = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 12: 
        localeau.abgn = locala.ajGk.aar();
        AppMethodBeat.o(258408);
        return 0;
      case 13: 
        localeau.pSi = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      case 14: 
        localeau.abgo = locala.ajGk.readString();
        AppMethodBeat.o(258408);
        return 0;
      }
      localeau.abgp = locala.ajGk.readString();
      AppMethodBeat.o(258408);
      return 0;
    }
    AppMethodBeat.o(258408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eau
 * JD-Core Version:    0.7.0.1
 */