package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjz
  extends com.tencent.mm.bw.a
{
  public double KUt;
  public double KUu;
  public String MpA;
  public String Mpy;
  public String Mpz;
  public String rBy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32338);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.KUu);
      paramVarArgs.e(2, this.KUt);
      if (this.rBy != null) {
        paramVarArgs.e(3, this.rBy);
      }
      if (this.Mpy != null) {
        paramVarArgs.e(4, this.Mpy);
      }
      if (this.Mpz != null) {
        paramVarArgs.e(5, this.Mpz);
      }
      if (this.MpA != null) {
        paramVarArgs.e(6, this.MpA);
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 8 + 0 + (g.a.a.b.b.a.fS(2) + 8);
      paramInt = i;
      if (this.rBy != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBy);
      }
      i = paramInt;
      if (this.Mpy != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Mpy);
      }
      paramInt = i;
      if (this.Mpz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mpz);
      }
      i = paramInt;
      if (this.MpA != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MpA);
      }
      AppMethodBeat.o(32338);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cjz localcjz = (cjz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32338);
        return -1;
      case 1: 
        localcjz.KUu = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(32338);
        return 0;
      case 2: 
        localcjz.KUt = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(32338);
        return 0;
      case 3: 
        localcjz.rBy = locala.UbS.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 4: 
        localcjz.Mpy = locala.UbS.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 5: 
        localcjz.Mpz = locala.UbS.readString();
        AppMethodBeat.o(32338);
        return 0;
      }
      localcjz.MpA = locala.UbS.readString();
      AppMethodBeat.o(32338);
      return 0;
    }
    AppMethodBeat.o(32338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjz
 * JD-Core Version:    0.7.0.1
 */