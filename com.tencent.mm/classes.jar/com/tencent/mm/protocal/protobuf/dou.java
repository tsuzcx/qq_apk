package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dou
  extends com.tencent.mm.bw.a
{
  public String LiG;
  public String MRZ;
  public long MSa;
  public int MSb;
  public int MSc;
  public int MSd;
  public int MSe;
  public int MSf;
  public int MSg;
  public float MSh;
  public float MSi;
  public float MSj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LiG != null) {
        paramVarArgs.e(1, this.LiG);
      }
      if (this.MRZ != null) {
        paramVarArgs.e(2, this.MRZ);
      }
      paramVarArgs.bb(3, this.MSa);
      paramVarArgs.aM(4, this.MSb);
      paramVarArgs.aM(5, this.MSc);
      paramVarArgs.aM(6, this.MSd);
      paramVarArgs.aM(7, this.MSe);
      paramVarArgs.aM(8, this.MSf);
      paramVarArgs.aM(9, this.MSg);
      paramVarArgs.E(10, this.MSh);
      paramVarArgs.E(11, this.MSi);
      paramVarArgs.E(12, this.MSj);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LiG == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = g.a.a.b.b.a.f(1, this.LiG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MRZ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MRZ);
      }
      paramInt = g.a.a.b.b.a.r(3, this.MSa);
      int j = g.a.a.b.b.a.bu(4, this.MSb);
      int k = g.a.a.b.b.a.bu(5, this.MSc);
      int m = g.a.a.b.b.a.bu(6, this.MSd);
      int n = g.a.a.b.b.a.bu(7, this.MSe);
      int i1 = g.a.a.b.b.a.bu(8, this.MSf);
      int i2 = g.a.a.b.b.a.bu(9, this.MSg);
      int i3 = g.a.a.b.b.a.fS(10);
      int i4 = g.a.a.b.b.a.fS(11);
      int i5 = g.a.a.b.b.a.fS(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dou localdou = (dou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localdou.LiG = locala.UbS.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localdou.MRZ = locala.UbS.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localdou.MSa = locala.UbS.zl();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localdou.MSb = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localdou.MSc = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localdou.MSd = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localdou.MSe = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localdou.MSf = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localdou.MSg = locala.UbS.zi();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localdou.MSh = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localdou.MSi = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(87875);
          return 0;
        }
        localdou.MSj = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dou
 * JD-Core Version:    0.7.0.1
 */