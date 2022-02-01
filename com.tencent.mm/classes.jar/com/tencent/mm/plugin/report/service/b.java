package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int ID;
  public int wTD;
  public int wTE;
  public boolean wTF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ID);
      paramVarArgs.aR(2, this.wTD);
      paramVarArgs.aR(3, this.wTE);
      paramVarArgs.bl(4, this.wTF);
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ID);
      int i = f.a.a.b.b.a.bx(2, this.wTD);
      int j = f.a.a.b.b.a.bx(3, this.wTE);
      int k = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(143818);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localb.ID = locala.LVo.xF();
        AppMethodBeat.o(143818);
        return 0;
      case 2: 
        localb.wTD = locala.LVo.xF();
        AppMethodBeat.o(143818);
        return 0;
      case 3: 
        localb.wTE = locala.LVo.xF();
        AppMethodBeat.o(143818);
        return 0;
      }
      localb.wTF = locala.LVo.fZX();
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