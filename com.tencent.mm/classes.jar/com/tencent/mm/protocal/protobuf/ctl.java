package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctl
  extends com.tencent.mm.bw.a
{
  public String KPz;
  public String LoI;
  public int Ltr;
  public int Mjk;
  public String Myn;
  public String UserName;
  public String oUJ;
  public int rBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.rBx);
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.KPz != null) {
        paramVarArgs.e(3, this.KPz);
      }
      if (this.LoI != null) {
        paramVarArgs.e(4, this.LoI);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      paramVarArgs.aM(6, this.Mjk);
      paramVarArgs.aM(7, this.Ltr);
      if (this.Myn != null) {
        paramVarArgs.e(8, this.Myn);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.rBx) + 0;
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.KPz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPz);
      }
      paramInt = i;
      if (this.LoI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LoI);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bu(6, this.Mjk) + g.a.a.b.b.a.bu(7, this.Ltr);
      paramInt = i;
      if (this.Myn != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Myn);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ctl localctl = (ctl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localctl.rBx = locala.UbS.zi();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localctl.oUJ = locala.UbS.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localctl.KPz = locala.UbS.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localctl.LoI = locala.UbS.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localctl.UserName = locala.UbS.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localctl.Mjk = locala.UbS.zi();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localctl.Ltr = locala.UbS.zi();
        AppMethodBeat.o(155445);
        return 0;
      }
      localctl.Myn = locala.UbS.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctl
 * JD-Core Version:    0.7.0.1
 */