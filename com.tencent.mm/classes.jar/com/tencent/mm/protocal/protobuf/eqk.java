package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqk
  extends com.tencent.mm.bw.a
{
  public String MiN;
  public String Mju;
  public String NnP;
  public String dNI;
  public String dmc;
  public String qcK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.dmc != null) {
        paramVarArgs.e(2, this.dmc);
      }
      if (this.Mju != null) {
        paramVarArgs.e(3, this.Mju);
      }
      if (this.NnP != null) {
        paramVarArgs.e(4, this.NnP);
      }
      if (this.qcK != null) {
        paramVarArgs.e(5, this.qcK);
      }
      if (this.MiN != null) {
        paramVarArgs.e(6, this.MiN);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dmc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dmc);
      }
      i = paramInt;
      if (this.Mju != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mju);
      }
      paramInt = i;
      if (this.NnP != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NnP);
      }
      i = paramInt;
      if (this.qcK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qcK);
      }
      paramInt = i;
      if (this.MiN != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MiN);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqk localeqk = (eqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localeqk.dNI = locala.UbS.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localeqk.dmc = locala.UbS.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localeqk.Mju = locala.UbS.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localeqk.NnP = locala.UbS.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localeqk.qcK = locala.UbS.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localeqk.MiN = locala.UbS.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqk
 * JD-Core Version:    0.7.0.1
 */