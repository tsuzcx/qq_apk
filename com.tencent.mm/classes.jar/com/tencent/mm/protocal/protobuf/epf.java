package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epf
  extends com.tencent.mm.bw.a
{
  public int ElR;
  public int Nnc;
  public long Nnd;
  public long Nne;
  public long Nnf;
  public long Nng;
  public long Nnh;
  public int Nni;
  public long iJF;
  public long sGB;
  public long vgi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nnc);
      paramVarArgs.aM(2, this.ElR);
      paramVarArgs.bb(3, this.sGB);
      paramVarArgs.bb(4, this.Nnd);
      paramVarArgs.bb(5, this.Nne);
      paramVarArgs.bb(6, this.Nnf);
      paramVarArgs.bb(7, this.iJF);
      paramVarArgs.bb(8, this.Nng);
      paramVarArgs.bb(9, this.vgi);
      paramVarArgs.bb(10, this.Nnh);
      paramVarArgs.aM(11, this.Nni);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Nnc);
      int i = g.a.a.b.b.a.bu(2, this.ElR);
      int j = g.a.a.b.b.a.r(3, this.sGB);
      int k = g.a.a.b.b.a.r(4, this.Nnd);
      int m = g.a.a.b.b.a.r(5, this.Nne);
      int n = g.a.a.b.b.a.r(6, this.Nnf);
      int i1 = g.a.a.b.b.a.r(7, this.iJF);
      int i2 = g.a.a.b.b.a.r(8, this.Nng);
      int i3 = g.a.a.b.b.a.r(9, this.vgi);
      int i4 = g.a.a.b.b.a.r(10, this.Nnh);
      int i5 = g.a.a.b.b.a.bu(11, this.Nni);
      AppMethodBeat.o(169092);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epf localepf = (epf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localepf.Nnc = locala.UbS.zi();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localepf.ElR = locala.UbS.zi();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localepf.sGB = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localepf.Nnd = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 5: 
        localepf.Nne = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 6: 
        localepf.Nnf = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 7: 
        localepf.iJF = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 8: 
        localepf.Nng = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 9: 
        localepf.vgi = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      case 10: 
        localepf.Nnh = locala.UbS.zl();
        AppMethodBeat.o(169092);
        return 0;
      }
      localepf.Nni = locala.UbS.zi();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epf
 * JD-Core Version:    0.7.0.1
 */