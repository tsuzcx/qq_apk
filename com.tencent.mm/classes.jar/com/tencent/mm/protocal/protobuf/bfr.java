package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfr
  extends com.tencent.mm.bw.a
{
  public int KCz;
  public String KGX;
  public String KPJ;
  public String LPm;
  public String LPn;
  public String LPo;
  public String Lkr;
  public String UserName;
  public String oUJ;
  public String xJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32218);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGX != null) {
        paramVarArgs.e(1, this.KGX);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      if (this.xJE != null) {
        paramVarArgs.e(4, this.xJE);
      }
      if (this.LPm != null) {
        paramVarArgs.e(5, this.LPm);
      }
      if (this.LPn != null) {
        paramVarArgs.e(6, this.LPn);
      }
      if (this.KPJ != null) {
        paramVarArgs.e(7, this.KPJ);
      }
      if (this.Lkr != null) {
        paramVarArgs.e(8, this.Lkr);
      }
      if (this.LPo != null) {
        paramVarArgs.e(9, this.LPo);
      }
      paramVarArgs.aM(10, this.KCz);
      AppMethodBeat.o(32218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGX == null) {
        break label766;
      }
    }
    label766:
    for (int i = g.a.a.b.b.a.f(1, this.KGX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      paramInt = i;
      if (this.xJE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJE);
      }
      i = paramInt;
      if (this.LPm != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LPm);
      }
      paramInt = i;
      if (this.LPn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LPn);
      }
      i = paramInt;
      if (this.KPJ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KPJ);
      }
      paramInt = i;
      if (this.Lkr != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lkr);
      }
      i = paramInt;
      if (this.LPo != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LPo);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KCz);
      AppMethodBeat.o(32218);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32218);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfr localbfr = (bfr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32218);
          return -1;
        case 1: 
          localbfr.KGX = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 2: 
          localbfr.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 3: 
          localbfr.UserName = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 4: 
          localbfr.xJE = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 5: 
          localbfr.LPm = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 6: 
          localbfr.LPn = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 7: 
          localbfr.KPJ = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 8: 
          localbfr.Lkr = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 9: 
          localbfr.LPo = locala.UbS.readString();
          AppMethodBeat.o(32218);
          return 0;
        }
        localbfr.KCz = locala.UbS.zi();
        AppMethodBeat.o(32218);
        return 0;
      }
      AppMethodBeat.o(32218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfr
 * JD-Core Version:    0.7.0.1
 */