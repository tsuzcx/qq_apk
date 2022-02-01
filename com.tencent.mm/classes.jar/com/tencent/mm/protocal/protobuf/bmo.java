package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmo
  extends com.tencent.mm.bx.a
{
  public double CJD;
  public double CJE;
  public String DKc;
  public String DKd;
  public String DKe;
  public String oXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.CJE);
      paramVarArgs.e(2, this.CJD);
      if (this.oXi != null) {
        paramVarArgs.d(3, this.oXi);
      }
      if (this.DKc != null) {
        paramVarArgs.d(4, this.DKc);
      }
      if (this.DKd != null) {
        paramVarArgs.d(5, this.DKd);
      }
      if (this.DKe != null) {
        paramVarArgs.d(6, this.DKe);
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 8 + 0 + (f.a.a.b.b.a.fY(2) + 8);
      paramInt = i;
      if (this.oXi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXi);
      }
      i = paramInt;
      if (this.DKc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DKc);
      }
      paramInt = i;
      if (this.DKd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKd);
      }
      i = paramInt;
      if (this.DKe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DKe);
      }
      AppMethodBeat.o(32338);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bmo localbmo = (bmo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32338);
        return -1;
      case 1: 
        localbmo.CJE = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(32338);
        return 0;
      case 2: 
        localbmo.CJD = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(32338);
        return 0;
      case 3: 
        localbmo.oXi = locala.KhF.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 4: 
        localbmo.DKc = locala.KhF.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 5: 
        localbmo.DKd = locala.KhF.readString();
        AppMethodBeat.o(32338);
        return 0;
      }
      localbmo.DKe = locala.KhF.readString();
      AppMethodBeat.o(32338);
      return 0;
    }
    AppMethodBeat.o(32338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmo
 * JD-Core Version:    0.7.0.1
 */