package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ln
  extends com.tencent.mm.bw.a
{
  public int DYl;
  public long KPe = 0L;
  public long KPf = 0L;
  public long KPg = 0L;
  public long KPh = 0L;
  public int KPi;
  public int dNP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KPe);
      paramVarArgs.bb(2, this.KPf);
      paramVarArgs.bb(3, this.KPg);
      paramVarArgs.bb(4, this.KPh);
      paramVarArgs.aM(5, this.DYl);
      paramVarArgs.aM(6, this.dNP);
      paramVarArgs.aM(7, this.KPi);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.KPe);
      int i = g.a.a.b.b.a.r(2, this.KPf);
      int j = g.a.a.b.b.a.r(3, this.KPg);
      int k = g.a.a.b.b.a.r(4, this.KPh);
      int m = g.a.a.b.b.a.bu(5, this.DYl);
      int n = g.a.a.b.b.a.bu(6, this.dNP);
      int i1 = g.a.a.b.b.a.bu(7, this.KPi);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ln localln = (ln)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localln.KPe = locala.UbS.zl();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localln.KPf = locala.UbS.zl();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localln.KPg = locala.UbS.zl();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localln.KPh = locala.UbS.zl();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localln.DYl = locala.UbS.zi();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localln.dNP = locala.UbS.zi();
        AppMethodBeat.o(110886);
        return 0;
      }
      localln.KPi = locala.UbS.zi();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ln
 * JD-Core Version:    0.7.0.1
 */