package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epa
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String KLO;
  public String Lox;
  public String MEP;
  public String MfZ;
  public long NmW;
  public String oTI;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lox != null) {
        paramVarArgs.e(1, this.Lox);
      }
      if (this.KLO != null) {
        paramVarArgs.e(2, this.KLO);
      }
      if (this.MEP != null) {
        paramVarArgs.e(3, this.MEP);
      }
      if (this.xMq != null) {
        paramVarArgs.e(4, this.xMq);
      }
      if (this.oTI != null) {
        paramVarArgs.e(5, this.oTI);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(6, this.IconUrl);
      }
      if (this.MfZ != null) {
        paramVarArgs.e(7, this.MfZ);
      }
      paramVarArgs.bb(8, this.NmW);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lox == null) {
        break label640;
      }
    }
    label640:
    for (int i = g.a.a.b.b.a.f(1, this.Lox) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KLO);
      }
      i = paramInt;
      if (this.MEP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MEP);
      }
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xMq);
      }
      i = paramInt;
      if (this.oTI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.oTI);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.IconUrl);
      }
      i = paramInt;
      if (this.MfZ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MfZ);
      }
      paramInt = g.a.a.b.b.a.r(8, this.NmW);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        epa localepa = (epa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localepa.Lox = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localepa.KLO = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localepa.MEP = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localepa.xMq = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localepa.oTI = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localepa.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localepa.MfZ = locala.UbS.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localepa.NmW = locala.UbS.zl();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epa
 * JD-Core Version:    0.7.0.1
 */