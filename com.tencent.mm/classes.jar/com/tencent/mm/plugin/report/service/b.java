package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int OzG;
  public int OzH;
  public boolean OzI;
  public int hjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143818);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hjP);
      paramVarArgs.bS(2, this.OzG);
      paramVarArgs.bS(3, this.OzH);
      paramVarArgs.di(4, this.OzI);
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.hjP);
      int i = i.a.a.b.b.a.cJ(2, this.OzG);
      int j = i.a.a.b.b.a.cJ(3, this.OzH);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(143818);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143818);
        return -1;
      case 1: 
        localb.hjP = locala.ajGk.aar();
        AppMethodBeat.o(143818);
        return 0;
      case 2: 
        localb.OzG = locala.ajGk.aar();
        AppMethodBeat.o(143818);
        return 0;
      case 3: 
        localb.OzH = locala.ajGk.aar();
        AppMethodBeat.o(143818);
        return 0;
      }
      localb.OzI = locala.ajGk.aai();
      AppMethodBeat.o(143818);
      return 0;
    }
    AppMethodBeat.o(143818);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.b
 * JD-Core Version:    0.7.0.1
 */