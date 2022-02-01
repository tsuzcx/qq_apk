package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int Cya;
  public int Cyb;
  public boolean Cyc;
  public int ID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ID);
      paramVarArgs.aM(2, this.Cya);
      paramVarArgs.aM(3, this.Cyb);
      paramVarArgs.cc(4, this.Cyc);
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.ID);
      int i = g.a.a.b.b.a.bu(2, this.Cya);
      int j = g.a.a.b.b.a.bu(3, this.Cyb);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(143818);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143818);
        return -1;
      case 1: 
        localb.ID = locala.UbS.zi();
        AppMethodBeat.o(143818);
        return 0;
      case 2: 
        localb.Cya = locala.UbS.zi();
        AppMethodBeat.o(143818);
        return 0;
      case 3: 
        localb.Cyb = locala.UbS.zi();
        AppMethodBeat.o(143818);
        return 0;
      }
      localb.Cyc = locala.UbS.yZ();
      AppMethodBeat.o(143818);
      return 0;
    }
    AppMethodBeat.o(143818);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.b
 * JD-Core Version:    0.7.0.1
 */