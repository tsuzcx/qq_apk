package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public int nJb;
  public int xri;
  public String xrj;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xri);
      if (this.xrj != null) {
        paramVarArgs.d(2, this.xrj);
      }
      paramVarArgs.aS(3, this.nJb);
      paramVarArgs.aS(4, this.FileSize);
      paramVarArgs.aZ(5, this.xrk);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.xri) + 0;
      paramInt = i;
      if (this.xrj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xrj);
      }
      i = f.a.a.b.b.a.bz(3, this.nJb);
      int j = f.a.a.b.b.a.bz(4, this.FileSize);
      int k = f.a.a.b.b.a.p(5, this.xrk);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localf.xri = locala.OmT.zc();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localf.xrj = locala.OmT.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localf.nJb = locala.OmT.zc();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localf.FileSize = locala.OmT.zc();
        AppMethodBeat.o(122660);
        return 0;
      }
      localf.xrk = locala.OmT.zd();
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