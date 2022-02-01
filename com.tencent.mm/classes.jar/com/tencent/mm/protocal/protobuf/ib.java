package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ib
  extends com.tencent.mm.bw.a
{
  public String Id;
  public String KLZ;
  public String KMa;
  public int KMb;
  public long KMc;
  public int KMd;
  public long KMe;
  public long KMf;
  public long KMg;
  public String KMh;
  public long KMi;
  public double KMj;
  public int KMk;
  public String KMl;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.KLZ != null) {
        paramVarArgs.e(2, this.KLZ);
      }
      if (this.KMa != null) {
        paramVarArgs.e(3, this.KMa);
      }
      paramVarArgs.aM(4, this.KMb);
      paramVarArgs.bb(5, this.KMc);
      paramVarArgs.aM(6, this.KMd);
      paramVarArgs.aM(7, this.oTW);
      paramVarArgs.bb(8, this.KMe);
      paramVarArgs.bb(9, this.KMf);
      paramVarArgs.bb(10, this.KMg);
      if (this.KMh != null) {
        paramVarArgs.e(11, this.KMh);
      }
      paramVarArgs.bb(12, this.KMi);
      paramVarArgs.e(13, this.KMj);
      paramVarArgs.aM(14, this.KMk);
      if (this.KMl != null) {
        paramVarArgs.e(15, this.KMl);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label901;
      }
    }
    label901:
    for (int i = g.a.a.b.b.a.f(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KLZ);
      }
      i = paramInt;
      if (this.KMa != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KMa);
      }
      i = i + g.a.a.b.b.a.bu(4, this.KMb) + g.a.a.b.b.a.r(5, this.KMc) + g.a.a.b.b.a.bu(6, this.KMd) + g.a.a.b.b.a.bu(7, this.oTW) + g.a.a.b.b.a.r(8, this.KMe) + g.a.a.b.b.a.r(9, this.KMf) + g.a.a.b.b.a.r(10, this.KMg);
      paramInt = i;
      if (this.KMh != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KMh);
      }
      i = paramInt + g.a.a.b.b.a.r(12, this.KMi) + (g.a.a.b.b.a.fS(13) + 8) + g.a.a.b.b.a.bu(14, this.KMk);
      paramInt = i;
      if (this.KMl != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KMl);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ib localib = (ib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localib.Id = locala.UbS.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localib.KLZ = locala.UbS.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localib.KMa = locala.UbS.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localib.KMb = locala.UbS.zi();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localib.KMc = locala.UbS.zl();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localib.KMd = locala.UbS.zi();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localib.oTW = locala.UbS.zi();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localib.KMe = locala.UbS.zl();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localib.KMf = locala.UbS.zl();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localib.KMg = locala.UbS.zl();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localib.KMh = locala.UbS.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localib.KMi = locala.UbS.zl();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localib.KMj = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localib.KMk = locala.UbS.zi();
          AppMethodBeat.o(87872);
          return 0;
        }
        localib.KMl = locala.UbS.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */