package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public int FileSize;
  public int nDG;
  public int xbr;
  public String xbs;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xbr);
      if (this.xbs != null) {
        paramVarArgs.d(2, this.xbs);
      }
      paramVarArgs.aS(3, this.nDG);
      paramVarArgs.aS(4, this.FileSize);
      paramVarArgs.aY(5, this.xbt);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.xbr) + 0;
      paramInt = i;
      if (this.xbs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xbs);
      }
      i = f.a.a.b.b.a.bz(3, this.nDG);
      int j = f.a.a.b.b.a.bz(4, this.FileSize);
      int k = f.a.a.b.b.a.p(5, this.xbt);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        localf.xbr = locala.NPN.zc();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localf.xbs = locala.NPN.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localf.nDG = locala.NPN.zc();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localf.FileSize = locala.NPN.zc();
        AppMethodBeat.o(122660);
        return 0;
      }
      localf.xbt = locala.NPN.zd();
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