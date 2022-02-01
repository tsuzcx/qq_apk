package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int ID;
  public int yhn;
  public int yho;
  public boolean yhp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ID);
      paramVarArgs.aS(2, this.yhn);
      paramVarArgs.aS(3, this.yho);
      paramVarArgs.bt(4, this.yhp);
      AppMethodBeat.o(143818);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.ID);
      int i = f.a.a.b.b.a.bz(2, this.yhn);
      int j = f.a.a.b.b.a.bz(3, this.yho);
      int k = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(143818);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localb.ID = locala.NPN.zc();
        AppMethodBeat.o(143818);
        return 0;
      case 2: 
        localb.yhn = locala.NPN.zc();
        AppMethodBeat.o(143818);
        return 0;
      case 3: 
        localb.yho = locala.NPN.zc();
        AppMethodBeat.o(143818);
        return 0;
      }
      localb.yhp = locala.NPN.grw();
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