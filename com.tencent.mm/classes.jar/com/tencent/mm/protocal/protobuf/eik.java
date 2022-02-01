package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eik
  extends com.tencent.mm.bw.a
{
  public int KJS;
  public String LOr;
  public String MEq;
  public String MRt;
  public String Mba;
  public String Mbb;
  public String NhF;
  public String NhG;
  public int Scene;
  public String Title;
  public String iAc;
  public String pLq;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mba != null) {
        paramVarArgs.e(1, this.Mba);
      }
      if (this.MEq != null) {
        paramVarArgs.e(2, this.MEq);
      }
      if (this.iAc != null) {
        paramVarArgs.e(3, this.iAc);
      }
      if (this.NhF != null) {
        paramVarArgs.e(4, this.NhF);
      }
      if (this.NhG != null) {
        paramVarArgs.e(5, this.NhG);
      }
      if (this.LOr != null) {
        paramVarArgs.e(6, this.LOr);
      }
      if (this.Title != null) {
        paramVarArgs.e(7, this.Title);
      }
      if (this.Mbb != null) {
        paramVarArgs.e(8, this.Mbb);
      }
      paramVarArgs.aM(9, this.Scene);
      paramVarArgs.aM(10, this.KJS);
      if (this.MRt != null) {
        paramVarArgs.e(11, this.MRt);
      }
      if (this.pLq != null) {
        paramVarArgs.e(12, this.pLq);
      }
      paramVarArgs.aM(13, this.xub);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mba == null) {
        break label902;
      }
    }
    label902:
    for (int i = g.a.a.b.b.a.f(1, this.Mba) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MEq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MEq);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAc);
      }
      paramInt = i;
      if (this.NhF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NhF);
      }
      i = paramInt;
      if (this.NhG != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NhG);
      }
      paramInt = i;
      if (this.LOr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LOr);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Title);
      }
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mbb);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Scene) + g.a.a.b.b.a.bu(10, this.KJS);
      paramInt = i;
      if (this.MRt != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MRt);
      }
      i = paramInt;
      if (this.pLq != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.pLq);
      }
      paramInt = g.a.a.b.b.a.bu(13, this.xub);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eik localeik = (eik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localeik.Mba = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localeik.MEq = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localeik.iAc = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localeik.NhF = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localeik.NhG = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localeik.LOr = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localeik.Title = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localeik.Mbb = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localeik.Scene = locala.UbS.zi();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localeik.KJS = locala.UbS.zi();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localeik.MRt = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localeik.pLq = locala.UbS.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localeik.xub = locala.UbS.zi();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eik
 * JD-Core Version:    0.7.0.1
 */