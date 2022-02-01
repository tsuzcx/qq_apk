package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egb
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public String KQY;
  public String NfV;
  public String UserName;
  public String keb;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      paramVarArgs.aM(3, this.KHa);
      if (this.NfV != null) {
        paramVarArgs.e(4, this.NfV);
      }
      if (this.keb != null) {
        paramVarArgs.e(5, this.keb);
      }
      if (this.KQY != null) {
        paramVarArgs.e(6, this.KQY);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i += g.a.a.b.b.a.bu(3, this.KHa);
      paramInt = i;
      if (this.NfV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NfV);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.keb);
      }
      paramInt = i;
      if (this.KQY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KQY);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        egb localegb = (egb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localegb.UserName = locala.UbS.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localegb.oUJ = locala.UbS.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localegb.KHa = locala.UbS.zi();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localegb.NfV = locala.UbS.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localegb.keb = locala.UbS.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localegb.KQY = locala.UbS.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egb
 * JD-Core Version:    0.7.0.1
 */