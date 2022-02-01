package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public String Brm;
  public long Brn;
  public int FileSize;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Brl);
      if (this.Brm != null) {
        paramVarArgs.e(2, this.Brm);
      }
      paramVarArgs.aM(3, this.oTW);
      paramVarArgs.aM(4, this.FileSize);
      paramVarArgs.bb(5, this.Brn);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Brl) + 0;
      paramInt = i;
      if (this.Brm != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Brm);
      }
      i = g.a.a.b.b.a.bu(3, this.oTW);
      int j = g.a.a.b.b.a.bu(4, this.FileSize);
      int k = g.a.a.b.b.a.r(5, this.Brn);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        localf.Brl = locala.UbS.zi();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localf.Brm = locala.UbS.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localf.oTW = locala.UbS.zi();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localf.FileSize = locala.UbS.zi();
        AppMethodBeat.o(122660);
        return 0;
      }
      localf.Brn = locala.UbS.zl();
      AppMethodBeat.o(122660);
      return 0;
    }
    AppMethodBeat.o(122660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.f
 * JD-Core Version:    0.7.0.1
 */