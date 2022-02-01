package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cjb
  extends com.tencent.mm.bw.a
{
  public String MnL;
  public int Moj;
  public int Mok;
  public int Mol;
  public b Mom;
  public b Mon;
  public b Moo;
  public String Mop;
  public long Moq;
  public long Mor;
  public String Mos;
  public long hyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196382);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Moj);
      if (this.MnL != null) {
        paramVarArgs.e(2, this.MnL);
      }
      paramVarArgs.aM(3, this.Mok);
      paramVarArgs.aM(4, this.Mol);
      if (this.Mom != null) {
        paramVarArgs.c(5, this.Mom);
      }
      if (this.Mon != null) {
        paramVarArgs.c(6, this.Mon);
      }
      if (this.Moo != null) {
        paramVarArgs.c(7, this.Moo);
      }
      if (this.Mop != null) {
        paramVarArgs.e(8, this.Mop);
      }
      paramVarArgs.bb(9, this.Moq);
      paramVarArgs.bb(10, this.Mor);
      paramVarArgs.bb(11, this.hyH);
      if (this.Mos != null) {
        paramVarArgs.e(12, this.Mos);
      }
      AppMethodBeat.o(196382);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Moj) + 0;
      paramInt = i;
      if (this.MnL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MnL);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Mok) + g.a.a.b.b.a.bu(4, this.Mol);
      paramInt = i;
      if (this.Mom != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Mom);
      }
      i = paramInt;
      if (this.Mon != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.Mon);
      }
      paramInt = i;
      if (this.Moo != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.Moo);
      }
      i = paramInt;
      if (this.Mop != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mop);
      }
      i = i + g.a.a.b.b.a.r(9, this.Moq) + g.a.a.b.b.a.r(10, this.Mor) + g.a.a.b.b.a.r(11, this.hyH);
      paramInt = i;
      if (this.Mos != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Mos);
      }
      AppMethodBeat.o(196382);
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
      AppMethodBeat.o(196382);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cjb localcjb = (cjb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196382);
        return -1;
      case 1: 
        localcjb.Moj = locala.UbS.zi();
        AppMethodBeat.o(196382);
        return 0;
      case 2: 
        localcjb.MnL = locala.UbS.readString();
        AppMethodBeat.o(196382);
        return 0;
      case 3: 
        localcjb.Mok = locala.UbS.zi();
        AppMethodBeat.o(196382);
        return 0;
      case 4: 
        localcjb.Mol = locala.UbS.zi();
        AppMethodBeat.o(196382);
        return 0;
      case 5: 
        localcjb.Mom = locala.UbS.hPo();
        AppMethodBeat.o(196382);
        return 0;
      case 6: 
        localcjb.Mon = locala.UbS.hPo();
        AppMethodBeat.o(196382);
        return 0;
      case 7: 
        localcjb.Moo = locala.UbS.hPo();
        AppMethodBeat.o(196382);
        return 0;
      case 8: 
        localcjb.Mop = locala.UbS.readString();
        AppMethodBeat.o(196382);
        return 0;
      case 9: 
        localcjb.Moq = locala.UbS.zl();
        AppMethodBeat.o(196382);
        return 0;
      case 10: 
        localcjb.Mor = locala.UbS.zl();
        AppMethodBeat.o(196382);
        return 0;
      case 11: 
        localcjb.hyH = locala.UbS.zl();
        AppMethodBeat.o(196382);
        return 0;
      }
      localcjb.Mos = locala.UbS.readString();
      AppMethodBeat.o(196382);
      return 0;
    }
    AppMethodBeat.o(196382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjb
 * JD-Core Version:    0.7.0.1
 */