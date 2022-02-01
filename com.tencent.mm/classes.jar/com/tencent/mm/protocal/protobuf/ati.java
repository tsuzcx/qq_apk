package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ati
  extends com.tencent.mm.bx.a
{
  public String CVa;
  public String CVb;
  public String CVc;
  public long Grq;
  public int Grr;
  public double Grs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Grq);
      paramVarArgs.aS(2, this.Grr);
      paramVarArgs.e(3, this.Grs);
      if (this.CVa != null) {
        paramVarArgs.d(4, this.CVa);
      }
      if (this.CVb != null) {
        paramVarArgs.d(5, this.CVb);
      }
      if (this.CVc != null) {
        paramVarArgs.d(6, this.CVc);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Grq) + 0 + f.a.a.b.b.a.bz(2, this.Grr) + f.a.a.b.b.a.alT(3);
      paramInt = i;
      if (this.CVa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CVa);
      }
      i = paramInt;
      if (this.CVb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CVb);
      }
      paramInt = i;
      if (this.CVc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CVc);
      }
      AppMethodBeat.o(91470);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ati localati = (ati)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localati.Grq = locala.NPN.zd();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localati.Grr = locala.NPN.zc();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localati.Grs = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localati.CVa = locala.NPN.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localati.CVb = locala.NPN.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localati.CVc = locala.NPN.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ati
 * JD-Core Version:    0.7.0.1
 */