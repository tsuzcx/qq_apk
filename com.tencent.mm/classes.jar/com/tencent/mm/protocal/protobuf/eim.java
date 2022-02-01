package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eim
  extends com.tencent.mm.bw.a
{
  public int KJS;
  public String MEq;
  public String MRt;
  public String Mba;
  public String Mbb;
  public String NhH;
  public int Scene;
  public int him;
  public String iAc;
  public String pLq;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEq != null) {
        paramVarArgs.e(1, this.MEq);
      }
      if (this.NhH != null) {
        paramVarArgs.e(2, this.NhH);
      }
      paramVarArgs.aM(3, this.him);
      if (this.Mba != null) {
        paramVarArgs.e(4, this.Mba);
      }
      if (this.iAc != null) {
        paramVarArgs.e(5, this.iAc);
      }
      paramVarArgs.aM(6, this.Scene);
      if (this.Mbb != null) {
        paramVarArgs.e(7, this.Mbb);
      }
      paramVarArgs.aM(8, this.KJS);
      if (this.pLq != null) {
        paramVarArgs.e(9, this.pLq);
      }
      if (this.MRt != null) {
        paramVarArgs.e(10, this.MRt);
      }
      paramVarArgs.aM(11, this.xub);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEq == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = g.a.a.b.b.a.f(1, this.MEq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NhH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NhH);
      }
      i += g.a.a.b.b.a.bu(3, this.him);
      paramInt = i;
      if (this.Mba != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mba);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.iAc);
      }
      i += g.a.a.b.b.a.bu(6, this.Scene);
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mbb);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.KJS);
      paramInt = i;
      if (this.pLq != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.pLq);
      }
      i = paramInt;
      if (this.MRt != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MRt);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.xub);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eim localeim = (eim)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localeim.MEq = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localeim.NhH = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localeim.him = locala.UbS.zi();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localeim.Mba = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localeim.iAc = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localeim.Scene = locala.UbS.zi();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localeim.Mbb = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localeim.KJS = locala.UbS.zi();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localeim.pLq = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localeim.MRt = locala.UbS.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localeim.xub = locala.UbS.zi();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eim
 * JD-Core Version:    0.7.0.1
 */