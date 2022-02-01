package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int ID;
  public int vJA;
  public boolean vJB;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ID);
      paramVarArgs.aR(2, this.vJz);
      paramVarArgs.aR(3, this.vJA);
      paramVarArgs.bg(4, this.vJB);
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.ID);
      int i = f.a.a.b.b.a.bA(2, this.vJz);
      int j = f.a.a.b.b.a.bA(3, this.vJA);
      int k = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(143818);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143818);
        return -1;
      case 1: 
        localb.ID = locala.KhF.xS();
        AppMethodBeat.o(143818);
        return 0;
      case 2: 
        localb.vJz = locala.KhF.xS();
        AppMethodBeat.o(143818);
        return 0;
      case 3: 
        localb.vJA = locala.KhF.xS();
        AppMethodBeat.o(143818);
        return 0;
      }
      localb.vJB = locala.KhF.fHu();
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