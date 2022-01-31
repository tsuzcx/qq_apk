package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bv.a
{
  public int ID;
  public int qsk;
  public int qsl;
  public boolean qsm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ID);
      paramVarArgs.aO(2, this.qsk);
      paramVarArgs.aO(3, this.qsl);
      paramVarArgs.aS(4, this.qsm);
      AppMethodBeat.o(72702);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.ID);
      int i = e.a.a.b.b.a.bl(2, this.qsk);
      int j = e.a.a.b.b.a.bl(3, this.qsl);
      int k = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(72702);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72702);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72702);
        return -1;
      case 1: 
        localb.ID = locala.CLY.sl();
        AppMethodBeat.o(72702);
        return 0;
      case 2: 
        localb.qsk = locala.CLY.sl();
        AppMethodBeat.o(72702);
        return 0;
      case 3: 
        localb.qsl = locala.CLY.sl();
        AppMethodBeat.o(72702);
        return 0;
      }
      localb.qsm = locala.CLY.emu();
      AppMethodBeat.o(72702);
      return 0;
    }
    AppMethodBeat.o(72702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.b
 * JD-Core Version:    0.7.0.1
 */