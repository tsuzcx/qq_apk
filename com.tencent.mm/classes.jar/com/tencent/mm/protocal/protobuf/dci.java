package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dci
  extends com.tencent.mm.bw.a
{
  public float LbC;
  public float LbD;
  public String MHg;
  public String MHh;
  public long MHi;
  public String Mil;
  public String kea;
  public String keh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MHg != null) {
        paramVarArgs.e(1, this.MHg);
      }
      if (this.keh != null) {
        paramVarArgs.e(2, this.keh);
      }
      if (this.kea != null) {
        paramVarArgs.e(3, this.kea);
      }
      if (this.Mil != null) {
        paramVarArgs.e(4, this.Mil);
      }
      paramVarArgs.E(5, this.LbD);
      paramVarArgs.E(6, this.LbC);
      if (this.MHh != null) {
        paramVarArgs.e(7, this.MHh);
      }
      paramVarArgs.bb(8, this.MHi);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MHg == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.f(1, this.MHg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.keh);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kea);
      }
      paramInt = i;
      if (this.Mil != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mil);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 4) + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.MHh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MHh);
      }
      i = g.a.a.b.b.a.r(8, this.MHi);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dci localdci = (dci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localdci.MHg = locala.UbS.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localdci.keh = locala.UbS.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localdci.kea = locala.UbS.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localdci.Mil = locala.UbS.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localdci.LbD = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localdci.LbC = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localdci.MHh = locala.UbS.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localdci.MHi = locala.UbS.zl();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dci
 * JD-Core Version:    0.7.0.1
 */